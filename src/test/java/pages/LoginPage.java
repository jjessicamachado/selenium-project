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
    private static final By locator_new_user_email = By.id("email");
    private static final By locator_new_user_password = By.id("senha");
    private static final By locator_new_user_submit = By.xpath("//input[@type=\"submit\"]");
    private static final By locator_new_user_success_message = By.xpath("//div[contains(text(), \"Usuário inserido com sucesso\")]");

    //actions
    public void changeTabAndFillNewUser(String[] user){
        core.clickOnLink("Novo usuário?");
        core.sendKeys(locator_new_user_username, user[0]);
        core.sendKeys(locator_new_user_email, user[1]);
        core.sendKeys(locator_new_user_password, user[2]);
        core.clickButton(locator_new_user_submit);
        core.elementIsVisible(locator_new_user_success_message);
    }

}
