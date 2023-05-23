import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDataWriter dataWriter = new UserDataWriter();

        System.out.println("Введите данные пользователя: [Фамилия] [Имя] [Отчество] [Дата рождения (dd.MM.yyyy)] [Номер телефона] [Пол]");
        String userInput = scanner.nextLine().trim();

        try {
            UserInputParser userData = new UserInputParser(userInput);
            dataWriter.writeUserData(userData);
            System.out.println("Данные были успешно сохранены.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}