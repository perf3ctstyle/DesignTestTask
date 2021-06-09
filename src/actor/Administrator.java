package actor;

import controller.AdministratorController;
import controller.DirectoryDatabaseModel;
import entity.Directory;
import entity.Document;
import exception.EntityWithSuchNameAlreadyExistsException;

import java.util.Set;

public class Administrator implements AdministratorController {

    private final DirectoryDatabaseModel directoryDatabase;

    private static final String DOCUMENT_EXISTS = "Unfortunately, document with such name already exists in directory ";
    private static final String DIRECTORY_EXISTS = "Unfortunately, directory with such name already exists in directory ";

    public Administrator(DirectoryDatabaseModel directoryDatabase) {
        this.directoryDatabase = directoryDatabase;
    }

    @Override
    public void deleteDocumentInDirectory(Document document, Directory directory) {
        synchronized (directoryDatabase) {
            directory.removeDocument(document);
        }
    }

    @Override
    public void createDirectoryInDirectory(String directoryName, Set<Document> documents, Set<Directory> directories,
                                           Directory locationToCreateDirectory) {
        Directory createdDirectory = new Directory(directoryName, documents, directories);
        synchronized (directoryDatabase) {
            try {
                locationToCreateDirectory.addDirectory(createdDirectory);
            } catch (EntityWithSuchNameAlreadyExistsException e) {
                String locationName = locationToCreateDirectory.getName();
                System.out.println(DIRECTORY_EXISTS + locationName);
            }
        }
    }

    @Override
    public void moveDocument(Document documentToMove, Directory fromDirectory, Directory toDirectory) {
        synchronized (directoryDatabase) {
            try {
                toDirectory.addDocument(documentToMove);
            } catch (EntityWithSuchNameAlreadyExistsException e) {
                String locationName = toDirectory.getName();
                System.out.println(DOCUMENT_EXISTS + locationName);
                return;
            }

            fromDirectory.removeDocument(documentToMove);
        }
    }
}
