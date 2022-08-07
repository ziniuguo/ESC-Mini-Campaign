import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class Fuzzed_input_generator {

    public static ArrayList<String> generate_fuzzed_input() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        ArrayList<String> output = new ArrayList<>();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        output.add("\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"");
//        output.add(generatedString);
        System.out.println(output);
        return output;
    }


    public static void main(String[] args) throws IOException {
        generate_fuzzed_input();
        File_Writer.write_file(generate_fuzzed_input(), "fuzzed_csv.csv");
    }

}
