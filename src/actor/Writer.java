package actor;

import controller.CatalogDatabaseModel;
import controller.WriterController;
import entity.Catalog;
import entity.Document;
import exception.DocumentWithoutCatalogException;

import java.util.HashSet;
import java.util.Set;

public class Writer implements WriterController {

    private final String name;
    private final CatalogDatabaseModel directoryDatabase;

    private static final String CURRENT_DATE = "Don't really know how to implement that, so that is a Mock for Date";

    public Writer(String name, CatalogDatabaseModel directoryDatabase) {
        this.name = name;
        this.directoryDatabase = directoryDatabase;
    }

    public String getName() {
        return name;
    }

    @Override
    public Document createDocument(String name, String content, Catalog catalog) throws DocumentWithoutCatalogException {
        Set<Catalog> documentLocations = new HashSet<>();
        documentLocations.add(catalog);

        return new Document(name, CURRENT_DATE, name, content, documentLocations);
    }

    @Override
    public void updateDocumentName(Document document, String documentName) {
        document.setName(documentName);
    }

    @Override
    public void updateDocumentContent(Document document, String documentContent) {
        document.setContent(documentContent);
    }
}
