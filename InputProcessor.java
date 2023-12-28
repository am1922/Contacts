public class InputProcessor {
    public User processInput(String input) {
        String[] userData = input.split("\\s+");
        return new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5]);
    }
}
