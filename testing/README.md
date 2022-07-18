# testing plan

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
