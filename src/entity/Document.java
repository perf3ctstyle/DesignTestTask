package entity;

import exception.DocumentWithoutCatalogException;

import java.util.Set;

public class Document implements Entity {

    private String name;
    private final String creationDate;
    private final String writerName;
    private String content;
    private final Set<Catalog> documentLocations;

    private static final String DOCUMENT_WITHOUT_CATALOG = "Document without initial catalog";

    public Document(String name, String creationDate, String writerName, String content, Set<Catalog> documentLocations)
            throws DocumentWithoutCatalogException {
        this.name = name;
        this.creationDate = creationDate;
        this.writerName = writerName;
        this.content = content;

        if (!documentLocations.isEmpty()) {
            this.documentLocations = documentLocations;
        } else {
            throw new DocumentWithoutCatalogException(DOCUMENT_WITHOUT_CATALOG);
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

    public Set<Catalog> getDocumentLocations() {
        return documentLocations;
    }
}
