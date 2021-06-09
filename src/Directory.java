import java.util.Set;

public class Directory implements Entity {

    private String name;
    private final Set<Document> documents;
    private final Set<Directory> directories;

    private static final String DOCUMENT_EXISTS = "Document with such name already exists in this directory";
    private static final String DIRECTORY_EXISTS = "Directory with such name already exists in this directory";

    public Directory(String name, Set<Document> documents, Set<Directory> directories) {
        this.name = name;
        this.documents = documents;
        this.directories = directories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public Set<Directory> getDirectories() {
        return directories;
    }

    public synchronized void addDocument(Document document) throws EntityWithSuchNameAlreadyExistsException {
        if (!DirectoryLogic.entityWithSameNameExists(document, documents)) {
            documents.add(document);
        } else {
            throw new EntityWithSuchNameAlreadyExistsException(DOCUMENT_EXISTS);
        }
    }

    public synchronized void removeDocument(Document document) {
        documents.remove(document);
    }

    public synchronized void addDirectory(Directory directory) throws EntityWithSuchNameAlreadyExistsException {
        if (!DirectoryLogic.entityWithSameNameExists(directory, directories)) {
            directories.add(directory);
        } else {
            throw new EntityWithSuchNameAlreadyExistsException(DIRECTORY_EXISTS);
        }
    }

    public synchronized void removeDirectory(Directory directory) {
        directories.remove(directory);
    }
}
