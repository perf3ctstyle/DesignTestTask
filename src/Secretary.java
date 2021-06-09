import java.util.Set;

public class Secretary implements SecretaryController {

    private final DirectoryDatabaseModel directoryDatabase;

    public Secretary(DirectoryDatabaseModel directoryDatabase) {
        this.directoryDatabase = directoryDatabase;
    }

    private static final String DOCUMENT_EXISTS = "Unfortunately, document with such name already exists in directory ";

    @Override
    public void addDocumentToDirectory(Document document, Directory directory) {
        try {
            directory.addDocument(document);
        } catch (EntityWithSuchNameAlreadyExistsException e) {
            String directoryName = directory.getName();
            System.out.println(DOCUMENT_EXISTS + directoryName);
        }
    }

    @Override
    public Document findDocumentByWriterName(String writerName) {
        return null;
    }

    @Override
    public Document findDocumentByName(String documentName) {
        Directory rootDirectory = directoryDatabase.getRootDirectory();
        Set<Document> rootDirectoryDocuments = rootDirectory.getDocuments();
        for (Document document : rootDirectoryDocuments) {
            String currentDocumentName = document.getName();
            if (currentDocumentName.equals(documentName)) {
                return document;
            }
        }

        Set<Directory> directoriesInRoot = rootDirectory.getDirectories();
        for (Directory directory : directoriesInRoot) {

        }
        return null;
    }
}
