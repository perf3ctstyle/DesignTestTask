public interface SecretaryController {

    void addDocumentToDirectory(Document document, Directory directory);
    Document findDocumentByAuthorName(String authorName);
    Document findDocumentByName(String name);
}
