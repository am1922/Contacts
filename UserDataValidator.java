public interface UserDataValidator {
    void validate(User user) throws UserDataFormatException;
}
