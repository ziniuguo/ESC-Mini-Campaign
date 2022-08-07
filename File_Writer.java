import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class File_Writer {
    public static void write_file(ArrayList<String> input, String fileName) throws IOException {
        ArrayList<String[]> formatted = new ArrayList<>();
        for (String line : input) {
            String[] newLine = line.split(",");
            formatted.add(newLine);
        }

        File csvFile = new File(fileName);
        FileWriter fileWriter = new FileWriter(csvFile);

        //write header line here if you need.
        for (String[] data : formatted) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append(data[i]
                );
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
