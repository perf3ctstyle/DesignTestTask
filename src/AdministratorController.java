public interface AdministratorController {

    void deleteDocumentInDirectory(Document document, Directory directory);
    void createDirectoryInDirectory(String directoryName, Directory locationToCreate);
    void moveDocument(Document document, Directory fromDirectory, Directory toDirectory);
}
