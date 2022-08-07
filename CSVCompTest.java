import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVCompTest {

    // test_1: file existence
    List<Integer> combination = new ArrayList<>() {
        {
            add(1);
            add(2);
        }
    };

    @Test
    public void testRead() throws IOException {
        CSV_Comp testClass = new CSV_Comp("no_file_1.csv", "no_file_2.csv", combination);
        testClass.read();
    }

    @Test
    public void testRead2() throws IOException {
        CSV_Comp testClass = new CSV_Comp("sample_file_1.csv", "no_file_2.csv", combination);
        testClass.read();
    }

    @Test
    public void testRead3() throws IOException {
        CSV_Comp testClass = new CSV_Comp("sample_file_1.csv", "sample_file_2.csv", combination);
        testClass.read();
    }

    // test_2: no. of entries (rows)
    @Test
    public void testEntries1() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_2_1.csv", "test_2_2.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                Arrays.asList(
                        "\"ID1\",\"BOS963211\",\"USD\",\"SAVINGS\",\"962510\"",
                        "\"ID2\",\"BOS85992\",\"AUD\",\"CURRENT\",\"989898\"",
                        "\"ID3\",\"BOS656613\",\"USD\",\"CURRENT\",\"595290\"",
                        "\"ID4\",\"BOS14824\",\"INR\",\"SAVINGS\",\"772578\""
                )
        );
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }

    @Test
    public void testEntries2() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_2_1.csv", "test_2_3.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                List.of("\"ID2\",\"BOS85992\",\"AUD\",\"CURRENT\",\"989898\""));
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }

    // test_3: no. of columns
    @Test
    public void testColumns1() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_3_1.csv", "test_3_3.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                List.of(
                        "\"ID1\",\"BOS963211\",\"USD\",\"SAVINGS\",\"962510\""
                )
        );
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }

    @Test
    public void testColumns2() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_3_1.csv", "test_3_2.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                Arrays.asList(
                        "\"ID1\",\"BOS963211\",\"USD\",\"SAVINGS\",\"962510\"",
                        "\"ID1\",\"USD\",\"SAVINGS\",\"962510\""
                )
        );
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }

    // test_4: order of index
    @Test
    public void testOrder1() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_4_1.csv", "test_4_1.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                List.of()
        );
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }

    @Test
    public void testOrder2() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_4_1.csv", "test_4_2.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                Arrays.asList("\"ID2\",\"BOS85992\",\"AUD\",\"CURRENT\",\"989898\"",
                        "\"ID2\",\"BOS85992\",\"USD\",\"CURRENT\",\"989898\"")
        );
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }

    @Test
    public void testOrder3() throws IOException {
        CSV_Comp testClass = new CSV_Comp("test_4_1.csv", "test_4_3.csv", combination);
        testClass.read();
        ArrayList<String> correctOutput = new ArrayList<>(
                Arrays.asList(
                        "\"ID2\",\"BOS85992\",\"USD\",\"CURRENT\",\"989898\"",
                        "\"ID2\",\"BOS85992\",\"AUD\",\"CURRENT\",\"989898\""
                        )
        );
        assertEquals(new HashSet<>(testClass.compare()), new HashSet<>(correctOutput));
    }
}