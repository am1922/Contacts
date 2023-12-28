import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserFileWriter {
    private final UserDataValidator userDataValidator;

    public UserFileWriter(UserDataValidator userDataValidator) {
        this.userDataValidator = userDataValidator;
    }

    public void writeToFile(User user) throws IOException, UserDataFormatException {
        userDataValidator.validate(user);

        String fileName = user.getLastName() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(user.getLastName() + " " + user.getFirstName() + " " + user.getMiddleName() +
                    " " + user.getBirthDate() + " " + user.getPhoneNumber() + " " + user.getGender());
            writer.newLine();
        }
    }
}
