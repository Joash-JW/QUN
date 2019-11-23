::compile mvn
CALL mvn compile

::to go to a test directly
::goto:WithdrawBackendTest

::run WithdrawBackendTest
:WithdrawBackendTest
CALL test-withdrawBackend

::run CreateAccBackendTest
:CreateAccBackendTest
CALL test-createAccBackend
