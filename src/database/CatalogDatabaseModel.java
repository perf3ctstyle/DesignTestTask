package database;

import entity.Catalog;

import java.util.List;

public interface CatalogDatabaseModel {

    Catalog getRootCatalog();
    List<Catalog> getListOfAllCatalogs();
}
