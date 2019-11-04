::compile mvn
CALL mvn compile

::to go to a test directly
::goto:DeleteAccTest

::run LoginTest
:LoginTest
CALL test-login

::run CreateAccTest
:CreateAccTest
CALL test-createacc

::run DeleteAccTest
:DeleteAccTest
CALL test-deleteacc

::run TransferTest
:TransferTest
CALL test-transfer

PAUSE
