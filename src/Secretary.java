public class Secretary implements SecretaryController {

    private DirectoryDatabaseModel directoryDatabase;

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
        Directory rootDirectory = directoryDatabase.getRootDirectory();
        return null;
    }

    @Override
    public Document findDocumentByName(String name) {
        return null;
    }
}
