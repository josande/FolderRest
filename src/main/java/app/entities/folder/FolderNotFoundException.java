package app.entities.folder;

public class FolderNotFoundException extends RuntimeException {
    FolderNotFoundException(Long id) {
        super("Could not find folder with id: " + id);
    }
}
