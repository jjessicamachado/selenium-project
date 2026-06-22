package tests;

import org.junit.jupiter.api.Test;
import pages.AccountsPage;
import pages.LoginPage;
import support.BaseTest;
import support.ConfigLoader;

public class AccountsTest extends BaseTest {
    AccountsPage accountsPage = new AccountsPage(core);
    LoginPage loginPage = new LoginPage(core);

    @Test
    public void AddAccount() {
        String user = ConfigLoader.getProperty("USERNAME");
        String password = ConfigLoader.getProperty("PASSWORD");

        loginPage.login(user, password);
        accountsPage.addAccount();
    }

}
