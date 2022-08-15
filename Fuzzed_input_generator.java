import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fuzzed_input_generator {

    public static ArrayList<ArrayList<String>> generate_fuzzed_input() {
        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> output2 = new ArrayList<>();
        output.add("\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"");
        output2.add("\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"");

        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        for (int it = 0; it < 50; it++) {
            List<String> rowStringList = new ArrayList<>();
            for (int l = 0; l < 5; l++) {
                String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                generatedString = '\"' + generatedString + '\"';
                rowStringList.add(generatedString);
            }
            String rowString = String.join(",", rowStringList);

            // Mutation for rowString below
            char[] rowString2Chars = rowString.toCharArray();
            int l = rowString2Chars.length;
            Random r_index = new Random();
            Random r_char = new Random();
            String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

            // for the rowString, there is a 15% probability of mutation
            Random r_mutate = new Random();
            if (r_mutate.nextInt(100) < 15) {
                boolean replaced = false;
                while (!replaced) {
                    int index_to_replace = r_index.nextInt(l);
                    if (rowString2Chars[index_to_replace] != '\"' && rowString2Chars[index_to_replace] != ',') {
                        rowString2Chars[index_to_replace] = abc.charAt(r_char.nextInt(abc.length()));
                        replaced = true;
                    }
                }
            }
            String rowString2 = String.valueOf(rowString2Chars);

            output.add(rowString);
            output2.add(rowString2);
        }


        ArrayList<ArrayList<String>> finalOutput = new ArrayList<>();
        finalOutput.add(output);
        finalOutput.add(output2);
        return finalOutput;
    }


    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<String>> input = generate_fuzzed_input();
        File_Writer.write_file(input.get(0), "chunjie/test_csv_1.csv");
        File_Writer.write_file(input.get(1), "chunjie/test_csv_2.csv");
    }

}
