::run DeleteAccTest
:DeleteAccTest
ECHO DeleteAccTest#testAppR4T1
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T1 -q test
ECHO DeleteAccTest#testAppR4T2
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T2 -q test
ECHO DeleteAccTest#testAppR4T3
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T3 -q test
ECHO DeleteAccTest#testAppR4T4
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T4 -q test
ECHO DeleteAccTest#testAppR4T5
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T5 -q test
ECHO DeleteAccTest#testAppR4T6
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T6 -q test
ECHO DeleteAccTest#testAppR4T7
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T7 -q test
ECHO DeleteAccTest#testAppR4T8
CALL mvn clean -Dtest=DeleteAccTest#testAppR4T8 -q test