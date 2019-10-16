public class LogoutMgr {
    public static void logout() {
        try {
            if (LoginMgr.isLoggedIn()) {
                LoginMgr.resetLogin();
                System.out.println("You have logged out.");
            }
            else throw new NotLoggedInException();
        } catch (NotLoggedInException e) { System.out.println(e.getMessage()); }
    }
}
