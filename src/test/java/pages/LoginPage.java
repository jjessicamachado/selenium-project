package pages;

import org.openqa.selenium.By;
import support.Core;

public class LoginPage {
    private final Core core;

    public LoginPage(Core core) {
        this.core = core;
    }

    //locators
    private static final By locator_title = By.xpath("//a[contains(text(), \"Seu Barriga\")]");
    private static final By locator_new_user_username = By.id("nome");
    private static final By locator_email = By.id("email");
    private static final By locator_password = By.id("senha");
    private static final By locator_new_user_success_message = By.xpath("//div[contains(text(), \"Usuário inserido com sucesso\")]");
    private static final By locator_success_logged_user = By.xpath("//div[contains(text(), \"Bem vindo, jessica!\")]]");

    //actions
    public void changeTabAndFillNewUser(String[] user){
        core.clickOnLink("Novo usuário?");
        core.sendKeys(locator_new_user_username, user[0]);
        core.sendKeys(locator_email, user[1]);
        core.sendKeys(locator_password, user[2]);
        core.clickSubmitButton();
        core.elementIsVisible(locator_new_user_success_message);
    }

    public void login(String user, String password) {
        core.clickOnLink("Login");
        core.sendKeys(locator_email, user);
        core.sendKeys(locator_password, password);
        core.clickSubmitButton();
    }

}
