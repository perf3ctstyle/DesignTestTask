package controller;

import entity.Catalog;
import entity.Document;
import exception.EntityWithSuchNameAlreadyExistsException;

import java.util.Set;

public interface AdministratorController {

    void deleteDocumentInCatalog(Document document, Catalog catalog);
    void createCatalogInCatalog(String directoryName, Set<Document> documents, Set<Catalog> directories,
                                Catalog locationToCreateCatalog);
    void moveDocument(Document document, Catalog fromCatalog, Catalog toCatalog) throws EntityWithSuchNameAlreadyExistsException;
}
