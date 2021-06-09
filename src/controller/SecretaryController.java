package controller;

import entity.Directory;
import entity.Document;

public interface SecretaryController {

    void addDocumentToDirectory(Document document, Directory directory);
    Document findDocumentByWriterName(String writerName);
    Document findDocumentByName(String documentName);
}
