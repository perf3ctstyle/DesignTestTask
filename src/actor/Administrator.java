package actor;

import controller.AdministratorController;
import database.CatalogDatabaseModel;
import entity.Catalog;
import entity.Document;
import exception.EntityWithSuchNameAlreadyExistsException;

import java.util.Set;

public class Administrator implements AdministratorController {

    private final CatalogDatabaseModel catalogDatabase;

    private static final String DOCUMENT_EXISTS = "Unfortunately, document with such name already exists in catalog ";
    private static final String CATALOG_EXISTS = "Unfortunately, catalog with such name already exists in catalog ";

    public Administrator(CatalogDatabaseModel catalogDatabase) {
        this.catalogDatabase = catalogDatabase;
    }

    @Override
    public void deleteDocumentInCatalog(Document document, Catalog catalog) {
        synchronized (catalogDatabase) {
            catalog.removeDocument(document);
        }
    }

    @Override
    public void createCatalogInCatalog(String catalogName, Set<Document> documents, Set<Catalog> catalogs,
                                       Catalog locationToCreateCatalog) {
        Catalog createdCatalog = new Catalog(catalogName, documents, catalogs);
        synchronized (catalogDatabase) {
            try {
                locationToCreateCatalog.addCatalog(createdCatalog);
            } catch (EntityWithSuchNameAlreadyExistsException e) {
                String locationName = locationToCreateCatalog.getName();
                System.out.println(CATALOG_EXISTS + locationName);
            }
        }
    }

    @Override
    public void moveDocument(Document documentToMove, Catalog fromCatalog, Catalog toCatalog) {
        synchronized (catalogDatabase) {
            try {
                toCatalog.addDocument(documentToMove);
            } catch (EntityWithSuchNameAlreadyExistsException e) {
                String locationName = toCatalog.getName();
                System.out.println(DOCUMENT_EXISTS + locationName);
                return;
            }

            fromCatalog.removeDocument(documentToMove);
        }
    }
}
