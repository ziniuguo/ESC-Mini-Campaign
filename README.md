# testing plan

## how to run

```
List<Integer> combination = new ArrayList<>() {
    {
    add(1);
    add(2);
    }
};
// combination is given by index no.

CSV_Comp testClass = new CSV_Comp("your_file_1_name.csv", "your_file_2_name.csv", combination);
ArrayList<String> result = testClass.compare();
File_Writer.write_file(result, "result.csv");
```

## test

### test_1: file existence

partition:

- two file do not exist

partition:

- one file does not exist

partition:

- two file exist

### test_2: no. of entries (rows)

partition:

- one file has 0 entry

partition:

- two file have different no. of entries

partition:

- one file has 0 entry

### test_3: no. of columns

partition:

- one file has 0/1 column

partition:

- two file have different no. of columns

partition:

- one file has 0/1 column

### test_4: order of index

partition:

- two files' ids are ordered

partition:

- the two files' ids are randomly ordered

partition:

- one file's ids are reversed, while one remains unchanged

###  
