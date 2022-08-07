import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Fuzzed_input_generator {

    public static void generate_fuzzed_input() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
    }

    public void write_fuzzed_CSV() {

    }

    public static void main(String[] args) {
        generate_fuzzed_input();
    }

}
