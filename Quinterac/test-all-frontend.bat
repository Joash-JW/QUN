::compile mvn
CALL mvn compile

::to go to a test directly
::goto:DeleteAccTest

::run LoginTest
:LoginTest
CALL test-login

::run LogoutTest
:LogoutTest
CALL test-logout

::run CreateAccTest
:CreateAccTest
CALL test-createacc

::run DeleteAccTest
:DeleteAccTest
CALL test-deleteacc

::run DepositTest
:DepositTest
CALL test-deposit

::run WithdrawTest
:WithdrawTest
CALL test-withdraw

::run TransferTest
:TransferTest
CALL test-transfer

PAUSE
