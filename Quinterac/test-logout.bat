::run LogoutTest
:LogoutTest
ECHO LogoutTest#testAppR2T1
CALL mvn clean -Dtest=LogoutTest#testAppR2T1 -q test
ECHO LogoutTest#testAppR2T2
CALL mvn clean -Dtest=LogoutTest#testAppR2T2 -q test
ECHO LogoutTest#testAppR2T3
CALL mvn clean -Dtest=LogoutTest#testAppR2T3 -q test
ECHO LogoutTest#testAppR2T4
CALL mvn clean -Dtest=LogoutTest#testAppR2T4 -q test
ECHO LogoutTest#testAppR2T5
CALL mvn clean -Dtest=LogoutTest#testAppR2T5 -q test
ECHO LogoutTest#testAppR2T6
CALL mvn clean -Dtest=LogoutTest#testAppR2T6 -q test
ECHO LogoutTest#testAppR2T7
CALL mvn clean -Dtest=LogoutTest#testAppR2T7 -q test