import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        ReadFile readFile = new ReadFile("src/main/resources/minidico.txt");
        //System.out.println(readFile.read());

        System.out.println(EditDistance.distanceBetween("mottest", "testmot"));

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
