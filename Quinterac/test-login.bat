::run LoginTest
:LoginTest
ECHO LoginTest#testAppR1T1
CALL mvn clean -Dtest=LoginTest#testAppR1T1 -q test
ECHO LoginTest#testAppR1T2
CALL mvn clean -Dtest=LoginTest#testAppR1T2 -q test
ECHO LoginTest#testAppR1T6
CALL mvn clean -Dtest=LoginTest#testAppR1T6 -q test
ECHO LoginTest#testAppR1T10
CALL mvn clean -Dtest=LoginTest#testAppR1T10 -q test