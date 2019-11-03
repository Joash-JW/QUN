::compile mvn
CALL mvn compile

::run LoginTest
ECHO LoginTest#testAppR1T1
CALL mvn clean -Dtest=LoginTest#testAppR1T1 -q test
ECHO LoginTest#testAppR1T2
CALL mvn clean -Dtest=LoginTest#testAppR1T2 -q test
ECHO LoginTest#testAppR1T6
CALL mvn clean -Dtest=LoginTest#testAppR1T6 -q test
ECHO LoginTest#testAppR1T10
CALL mvn clean -Dtest=LoginTest#testAppR1T10 -q test

::run CreateAccTest
ECHO CreateAccTest#testAppR3T1
CALL mvn clean -Dtest=CreateAccTest#testAppR3T1 -q test
ECHO CreateAccTest#testAppR3T2
CALL mvn clean -Dtest=CreateAccTest#testAppR3T2 -q test
ECHO CreateAccTest#testAppR3T3
CALL mvn clean -Dtest=CreateAccTest#testAppR3T3 -q test
ECHO CreateAccTest#testAppR3T4
CALL mvn clean -Dtest=CreateAccTest#testAppR3T4 -q test
ECHO CreateAccTest#testAppR3T5
CALL mvn clean -Dtest=CreateAccTest#testAppR3T5 -q test
ECHO CreateAccTest#testAppR3T6
CALL mvn clean -Dtest=CreateAccTest#testAppR3T6 -q test
ECHO CreateAccTest#testAppR3T7
CALL mvn clean -Dtest=CreateAccTest#testAppR3T7 -q test
ECHO CreateAccTest#testAppR3T8
CALL mvn clean -Dtest=CreateAccTest#testAppR3T8 -q test
ECHO CreateAccTest#testAppR3T9
CALL mvn clean -Dtest=CreateAccTest#testAppR3T9 -q test
ECHO CreateAccTest#testAppR3T10
CALL mvn clean -Dtest=CreateAccTest#testAppR3T11 -q test
ECHO CreateAccTest#testAppR3T12
CALL mvn clean -Dtest=CreateAccTest#testAppR3T12 -q test
ECHO CreateAccTest#testAppR3T13
CALL mvn clean -Dtest=CreateAccTest#testAppR3T13 -q test
ECHO CreateAccTest#testAppR3T14
CALL mvn clean -Dtest=CreateAccTest#testAppR3T14 -q test
ECHO CreateAccTest#testAppR3T15
CALL mvn clean -Dtest=CreateAccTest#testAppR3T15 -q test
ECHO CreateAccTest#testAppR3T16
CALL mvn clean -Dtest=CreateAccTest#testAppR3T16 -q test
ECHO CreateAccTest#testAppR3T17
CALL mvn clean -Dtest=CreateAccTest#testAppR3T17 -q test

::run TransferTest
ECHO TransferTest#testAppR7T1
CALL mvn clean -Dtest=TransferTest#testAppR7T1 -q test
ECHO TransferTest#testAppR7T2
CALL mvn clean -Dtest=TransferTest#testAppR7T2 -q test
ECHO TransferTest#testAppR7T3
CALL mvn clean -Dtest=TransferTest#testAppR7T3 -q test
ECHO TransferTest#testAppR7T4
CALL mvn clean -Dtest=TransferTest#testAppR7T4 -q test
ECHO TransferTest#testAppR7T5
CALL mvn clean -Dtest=TransferTest#testAppR7T5 -q test
ECHO TransferTest#testAppR7T6
CALL mvn clean -Dtest=TransferTest#testAppR7T6 -q test
ECHO TransferTest#testAppR7T7
CALL mvn clean -Dtest=TransferTest#testAppR7T7 -q test
ECHO TransferTest#testAppR7T8
CALL mvn clean -Dtest=TransferTest#testAppR7T8 -q test
ECHO TransferTest#testAppR7T9
CALL mvn clean -Dtest=TransferTest#testAppR7T9 -q test
ECHO TransferTest#testAppR7T10
CALL mvn clean -Dtest=TransferTest#testAppR7T10 -q test
ECHO TransferTest#testAppR7T11
CALL mvn clean -Dtest=TransferTest#testAppR7T11 -q test

PAUSE
