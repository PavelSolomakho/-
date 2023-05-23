import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserInputParser {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;

    public UserInputParser(String userInput) throws IllegalArgumentException {
        String[] parts = userInput.split("\\s+");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Неверное количество полей данных.");
        }

        this.lastName = parts[0];
        this.firstName = parts[1];
        this.middleName = parts[2];

        try {
            this.birthDate = LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неправильный формат даты рождения.", e);
        }

        try {
            this.phoneNumber = Long.parseLong(parts[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Номер телефона не является действительным.", e);
        }

        if (parts[5].length() != 1 || (!parts[5].equalsIgnoreCase("f") && !parts[5].equalsIgnoreCase("m"))) {
            throw new IllegalArgumentException("Пол должен быть 'ж' или 'м'.");
        }
        this.gender = parts[5].charAt(0);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}
