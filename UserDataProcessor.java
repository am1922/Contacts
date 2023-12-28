import java.io.IOException;
import java.util.Scanner;

public class UserDataProcessor {
    private final InputProcessor inputProcessor;
    private final UserFileWriter fileWriter;

    public UserDataProcessor(InputProcessor inputProcessor, UserFileWriter fileWriter) {
        this.inputProcessor = inputProcessor;
        this.fileWriter = fileWriter;
    }

    public void processUserData() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите данные (Фамилия, Имя, Отчество, дата рождения, номер телефона, пол):");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("выход")) {
                System.out.println("Выход из программы.");
                break;
            }

            try {
                User user = inputProcessor.processInput(input);
                fileWriter.writeToFile(user);
                System.out.println("Данные успешно обработаны и записаны.");
            } catch (UserDataFormatException | IOException e) {
                System.err.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
