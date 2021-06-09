import java.util.HashSet;
import java.util.Set;

public class Writer implements WriterController {

    private final String name;
    private final DirectoryDatabaseModel directoryDatabase;

    private static final String CURRENT_DATE = "Don't really know how to implement that, so that is a Mock for Date";

    public Writer(String name, DirectoryDatabaseModel directoryDatabase) {
        this.name = name;
        this.directoryDatabase = directoryDatabase;
    }

    public String getName() {
        return name;
    }

    @Override
    public Document createDocument(String name, String content, Directory directory) throws DocumentWithoutDirectoryException {
        Set<Directory> documentLocations = new HashSet<>();
        documentLocations.add(directory);

        return new Document(name, CURRENT_DATE, name, content, documentLocations);
    }

    @Override
    public void updateDocumentName(Document document, String documentName) {
        document.setName(documentName);
    }

    @Override
    public void updateDocumentContent(Document document, String documentContent) {
        document.setContent(documentContent);
    }
}
