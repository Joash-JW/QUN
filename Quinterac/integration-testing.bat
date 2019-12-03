::run Quinterac
CALL mvn compile
CALL cd target/classes
CALL java main/Quinterac frontend ../../ValidAccList.txt 123