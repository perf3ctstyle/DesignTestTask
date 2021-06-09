package exception;

public class EntityWithSuchNameAlreadyExistsException extends Exception {

    public EntityWithSuchNameAlreadyExistsException(String message) {
        super(message);
    }
}
