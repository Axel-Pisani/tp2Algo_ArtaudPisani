import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    private String filename;

    public ReadFile(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> read() throws IOException {
        ArrayList<String> dico = new ArrayList<>();
        Scanner scanner = new Scanner(new FileReader(filename));
        while (scanner.hasNextLine())
            dico.add(scanner.nextLine());
        return dico;
    }
}
