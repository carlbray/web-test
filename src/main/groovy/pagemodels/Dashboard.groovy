package pagemodels

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

class Dashboard extends PageObjectModel implements DashboardModel {

    Dashboard(WebDriver driver) {
        super(driver)
        PageFactory.initElements(driver, this)
    }

    BankAccountsModel selectBankAccounts() {

        driver.get("https://go.xero.com/Bank/BankAccounts.aspx")
        return new BankAccounts(driver)
    }
}
