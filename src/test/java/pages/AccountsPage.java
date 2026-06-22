package pages;

import org.openqa.selenium.By;
import support.Core;

public class AccountsPage {
    private final Core core;

    public AccountsPage(Core core) {
        this.core = core;
    }

    //locators
    private static final By locator_account_menu = By.xpath("//a[@class=\"dropdown-toggle\"]");

    //actions
    public void addAccount() {
        core.selectOptionCombo(locator_account_menu, "Adicionar");
    }


}
