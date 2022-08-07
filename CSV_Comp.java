import java.io.*;
import java.util.*;

public class CSV_Comp {

    private final String path1;
    private final String path2;
    private final List<Integer> combination;


    public CSV_Comp (String path1, String path2, List<Integer> combination) {
        this.path1 = path1;
        this.path2 = path2;
        this.combination = combination;
    }

    public ArrayList<ArrayList<String>> read() throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path1));
        Scanner sc2 = new Scanner(new File(path2));
        sc.useDelimiter("\n");   //sets the delimiter pattern
        ArrayList<String> str_arr1 = new ArrayList<>();
        while (sc.hasNext()) {
            str_arr1.add(sc.next());
        }
        sc2.useDelimiter("\n");   //sets the delimiter pattern
        ArrayList<String> str_arr2 = new ArrayList<>();
        while (sc2.hasNext()) {
            str_arr2.add(sc2.next());
        }
        sc.close();
        sc2.close();
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        output.add(str_arr1);
        output.add(str_arr2);
        return output;
    }

    public ArrayList<String> compare() throws FileNotFoundException {
        ArrayList<String> csv1 = read().get(0);
        ArrayList<String> csv2 = read().get(1);
        ArrayList<String> output = new ArrayList<>();
        for (String s1 : csv1) {
            String[] val1 = s1.split(",");
            String s1_matched = "";
            boolean found = false;
            for (String s2 : csv2) {
                String[] val2 = s2.split(",");
                boolean matched = true;
                for (int i : combination) {
                    if (!Objects.equals(val1[i], val2[i])) {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    found = true;
                    s1_matched = s2;
                    break;
                }
            }
            if (!found) {
                output.add(s1);
            } else {
                if (!Objects.equals(s1, s1_matched)) {
                    output.add(s1);
                    output.add(s1_matched);
                }
                csv2.remove(s1_matched);
            }
        }
        output.addAll(csv2);
        return output;
    }
}