import exceptions.NotLoggedInException;

public class LogoutMgr {
    public static void logout(String transactionSummaryFile) {
        try {
            if (LoginMgr.isLoggedIn()) {
                LoginMgr.resetLogin();
                TransactionFileMgr.writeToTransactionFile(transactionSummaryFile);
                TransactionFileMgr.resetTransactionList();
                AccMgr.resetDailyAccMap();
                System.out.println("You have logged out.");
            }
            else throw new NotLoggedInException();
        } catch (NotLoggedInException e) { System.out.println(e.getMessage()); }
    }
}
