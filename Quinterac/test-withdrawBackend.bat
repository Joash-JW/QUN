::run WithdrawBackendTest
:WithdrawBackendTest
ECHO WithdrawBackendTest#withdrawTest1
CALL mvn clean -Dtest=WithdrawBackendTest#withdrawTest1 -q test
ECHO WithdrawBackendTest#withdrawTest2
CALL mvn clean -Dtest=WithdrawBackendTest#withdrawTest2 -q test