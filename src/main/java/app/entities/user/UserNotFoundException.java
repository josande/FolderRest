package app.entities.user;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(Long id) {
        super("Could not find user with id: " + id);
    }
}
