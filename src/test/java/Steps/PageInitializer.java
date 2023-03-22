package Steps;

import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage login;



    public static void initializePageObjects() {
        login = new LoginPage();


    }
}
