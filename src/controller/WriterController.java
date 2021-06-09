package controller;

import entity.Directory;
import entity.Document;
import exception.DocumentWithoutDirectoryException;

public interface WriterController {

    Document createDocument(String name, String content, Directory directory) throws DocumentWithoutDirectoryException;
    void updateDocumentName(Document document, String documentName);
    void updateDocumentContent(Document document, String documentContent);
}
