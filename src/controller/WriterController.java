package controller;

import entity.Catalog;
import entity.Document;
import exception.DocumentWithoutCatalogException;

public interface WriterController {

    Document createDocument(String name, String content, Catalog catalog) throws DocumentWithoutCatalogException;
    void updateDocumentName(Document document, String documentName);
    void updateDocumentContent(Document document, String documentContent);
}
