public interface SecretaryController {

    void addDocumentToDirectory(Document document, Directory directory);
    Document findDocumentByWriterName(String writerName);
    Document findDocumentByName(String name);
}
