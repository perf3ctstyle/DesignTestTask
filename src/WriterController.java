public interface WriterController {

    Document createDocument(String name, String content);
    void updateDocumentName(Document document, String documentName);
    void updateDocumentContent(Document document, String documentContent);
}
