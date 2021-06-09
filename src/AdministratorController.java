import java.util.Set;

public interface AdministratorController {

    void deleteDocumentInDirectory(Document document, Directory directory);
    void createDirectoryInDirectory(String directoryName, Set<Document> documents, Set<Directory> directories,
                                    Directory locationToCreateDirectory);
    void moveDocument(Document document, Directory fromDirectory, Directory toDirectory) throws EntityWithSuchNameAlreadyExistsException;
}
