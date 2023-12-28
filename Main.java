public class Main {
    public static void main(String[] args) {
        UserDataValidator validator = new DefaultUserDataValidator();
        InputProcessor inputProcessor = new InputProcessor();
        UserFileWriter fileWriter = new UserFileWriter(validator);
        UserDataProcessor processor = new UserDataProcessor(inputProcessor, fileWriter);

        processor.processUserData();
    }
}
