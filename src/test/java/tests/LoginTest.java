package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import support.BaseTest;

public class LoginTest extends BaseTest {
    LoginPage page = new LoginPage(core);

    @Test
    public void RegisterAndLogin() {
        String[] user = new String[]{"jessica", "jessica6@test.com", "12345"};
        page.changeTabAndFillNewUser(user);
        page.login(user[1], user[2]);
    }
}
