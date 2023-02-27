import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("helloworld.txt"));
            String line;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------------");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("helloworld.txt"));
            String line;
            for(int i = 0; i < 2; i++) {
                line = reader.readLine();
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("vgsales.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(records.get(5));

    }


}