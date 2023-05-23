import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataWriter {
    private static final String DATA_DIR = "./data/";
    private static final String FILE_EXTENSION = ".txt";

    public void writeUserData(UserInputParser userData) throws IOException {
        File file = new File(DATA_DIR + userData.getLastName() + FILE_EXTENSION);
        BufferedWriter writer = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(userData.getLastName() + userData.getFirstName() + userData.getMiddleName());
            writer.write(userData.getBirthDate().toString() + " ");
            writer.write(Long.toString(userData.getPhoneNumber()) + userData.getGender() + "\n");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
