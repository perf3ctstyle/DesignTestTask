package controller;

import entity.Catalog;
import entity.Document;

public interface SecretaryController {

    void addDocumentToCatalog(Document document, Catalog catalog);
    Document findDocumentByWriterName(String writerName);
    Document findDocumentByName(String documentName);
}
