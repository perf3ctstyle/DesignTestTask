package actor;

import controller.CatalogDatabaseModel;
import controller.SecretaryController;
import entity.Catalog;
import entity.Document;
import exception.EntityWithSuchNameAlreadyExistsException;

import java.util.Set;

public class Secretary implements SecretaryController {

    private final CatalogDatabaseModel directoryDatabase;

    public Secretary(CatalogDatabaseModel directoryDatabase) {
        this.directoryDatabase = directoryDatabase;
    }

    private static final String DOCUMENT_EXISTS = "Unfortunately, document with such name already exists in directory ";

    @Override
    public void addDocumentToCatalog(Document document, Catalog catalog) {
        synchronized (directoryDatabase) {
            try {
                catalog.addDocument(document);
            } catch (EntityWithSuchNameAlreadyExistsException e) {
                String directoryName = catalog.getName();
                System.out.println(DOCUMENT_EXISTS + directoryName);
            }
        }
    }

    @Override
    public Document findDocumentByWriterName(String writerName) {
        return null;
    }

    @Override
    public Document findDocumentByName(String documentName) {
        Catalog rootCatalog = directoryDatabase.getRootCatalog();
        Set<Document> rootDirectoryDocuments = rootCatalog.getDocuments();
        for (Document document : rootDirectoryDocuments) {
            String currentDocumentName = document.getName();
            if (currentDocumentName.equals(documentName)) {
                return document;
            }
        }

        Set<Catalog> directoriesInRoot = rootCatalog.getCatalogs();
        for (Catalog catalog : directoriesInRoot) {

        }
        return null;
    }
}
