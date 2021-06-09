package entity;

import exception.DocumentWithoutDirectoryException;

import java.util.Set;

public class Document implements Entity {

    private String name;
    private final String creationDate;
    private final String writerName;
    private String content;
    private final Set<Directory> documentLocations;

    private static final String DOCUMENT_WITHOUT_DIRECTORY = "entity.Document without initial directory";

    public Document(String name, String creationDate, String writerName, String content, Set<Directory> documentLocations)
            throws DocumentWithoutDirectoryException {
        this.name = name;
        this.creationDate = creationDate;
        this.writerName = writerName;
        this.content = content;

        if (!documentLocations.isEmpty()) {
            this.documentLocations = documentLocations;
        } else {
            throw new DocumentWithoutDirectoryException(DOCUMENT_WITHOUT_DIRECTORY);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Set<Directory> getDocumentLocations() {
        return documentLocations;
    }
}
