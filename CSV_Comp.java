import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSV_Comp {


    public static void main(String[] args) throws IOException {
        List<String[]> output = new ArrayList<>();
        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("sample_file_1.csv"));
        Scanner sc2 = new Scanner(new File("sample_file_3.csv"));
        sc.useDelimiter("[\n]");   //sets the delimiter pattern
        sc2.useDelimiter("[\n]");   //sets the delimiter pattern

        while (sc.hasNext() && sc2.hasNext()) { //returns a boolean value

            String val1 = sc.next();
            String val2 = sc2.next();
            if (!Objects.equals(val1, val2)) {
                String[] str1 = val1.split(",");
                System.out.println(Arrays.toString(str1));
                String[] str2 = val2.split(",");
                System.out.println(Arrays.toString(str2));
                output.add(str1);
                output.add(str2);
            }
        }
        sc.close();
        sc2.close();
        System.out.println();
        System.out.println(output);

        File csvFile = new File("output.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        //write header line here if you need.

        for (String[] data : output) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
//                line.append("\"");
                line.append(data[i]
//                        .replaceAll("\"","\"\"")
                );
//                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();

    }
}
