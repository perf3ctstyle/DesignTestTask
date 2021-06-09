package entity;

import exception.EntityWithSuchNameAlreadyExistsException;
import logic.CatalogLogic;

import java.util.Set;

public class Catalog implements Entity {

    private String name;
    private final Set<Document> documents;
    private final Set<Catalog> catalogs;

    private static final String DOCUMENT_EXISTS = "Document with such name already exists in this catalog";
    private static final String DIRECTORY_EXISTS = "Catalog with such name already exists in this catalog";

    public Catalog(String name, Set<Document> documents, Set<Catalog> catalogs) {
        this.name = name;
        this.documents = documents;
        this.catalogs = catalogs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public Set<Catalog> getCatalogs() {
        return catalogs;
    }

    public synchronized void addDocument(Document document) throws EntityWithSuchNameAlreadyExistsException {
        if (!CatalogLogic.entityWithSameNameExists(document, documents)) {
            documents.add(document);
        } else {
            throw new EntityWithSuchNameAlreadyExistsException(DOCUMENT_EXISTS);
        }
    }

    public synchronized void removeDocument(Document document) {
        documents.remove(document);
    }

    public synchronized void addCatalog(Catalog catalog) throws EntityWithSuchNameAlreadyExistsException {
        if (!CatalogLogic.entityWithSameNameExists(catalog, catalogs)) {
            catalogs.add(catalog);
        } else {
            throw new EntityWithSuchNameAlreadyExistsException(DIRECTORY_EXISTS);
        }
    }

    public synchronized void removeCatalog(Catalog catalog) {
        catalogs.remove(catalog);
    }
}
