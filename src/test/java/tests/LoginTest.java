package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import support.BaseTest;

public class LoginTest extends BaseTest {
    LoginPage page = new LoginPage(core);

    @Test
    public void Login() {
        String[] user = new String[]{"jessica", "jessica4@test.com", "12345"};
        page.changeTabAndFillNewUser(user);
    }
}
