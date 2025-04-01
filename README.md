## HIQ Code Test: Robot simulator

# Test:
mvn clean compile
mvn test

# Run:
mvn clean compile
mvn exec:java -Dexec.args="testfile.txt"

# Expected output:
# test.txt: 
Invalid Position: 2,2,hej
Output:2,2,EAST

# test1.txt:
Output:0,1,NORTH

# test2.txt:
Output:0,0,WEST

# test3.txt:
Output:3,3,NORTH
