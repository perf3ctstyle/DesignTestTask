package actor;

import database.CatalogDatabaseModel;
import controller.SecretaryController;
import entity.Catalog;
import entity.Document;
import exception.EntityWithSuchNameAlreadyExistsException;

import java.util.List;
import java.util.Set;

public class Secretary implements SecretaryController {

    private final CatalogDatabaseModel directoryDatabase;

    public Secretary(CatalogDatabaseModel directoryDatabase) {
        this.directoryDatabase = directoryDatabase;
    }

    private static final String DOCUMENT_EXISTS = "Unfortunately, document with such name already exists in catalog ";

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
        synchronized (directoryDatabase) {
            List<Catalog> catalogs = directoryDatabase.getListOfAllCatalogs();

            for (Catalog catalog : catalogs) {
                Set<Document> documents = catalog.getDocuments();

                for (Document document : documents) {
                    String currentDocumentWriterName = document.getWriterName();
                    if (currentDocumentWriterName.equals(writerName)) {
                        return document;
                    }
                }
            }

            return null;
        }
    }

    @Override
    public Document findDocumentByName(String documentName) {
        synchronized (directoryDatabase) {
            List<Catalog> catalogs = directoryDatabase.getListOfAllCatalogs();

            for (Catalog catalog : catalogs) {
                Set<Document> documents = catalog.getDocuments();

                for (Document document : documents) {
                    String currentDocumentName = document.getName();
                    if (currentDocumentName.equals(documentName)) {
                        return document;
                    }
                }
            }

            return null;
        }
    }
}
