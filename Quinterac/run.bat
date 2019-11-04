::run Quinterac
CALL mvn compile
CALL cd target/classes
CALL java main/Quinterac frontend ../../src/ValidAccList.txt 123