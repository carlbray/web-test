import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.openqa.selenium.WebDriver
import pagemodels.BankAccountsModel
import pagemodels.Dashboard
import pagemodels.Login
import selenium.Driver

class TestRunner {

    private static WebDriver driver

    @BeforeClass
    static void setUpClass() {
        driver = Driver.CHROME.getDriver()

        // Shortcut to accounts to speed up tests
        driver.get("https://go.xero.com/Bank/BankAccounts.aspx")

        new Login(driver).doLogin("carlbray+xero@gmail.com", "EMyawegOsInMoi3")
    }

    /**
     * In order to manage my business successfully,
     * I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation.
     */
    @Test
    void addingBankAccountTest() {

        String accountName = UUID.randomUUID().toString()

        BankAccountsModel bankAccounts = new Dashboard(driver).selectBankAccounts()
        bankAccounts.addBankAccount("ANZ (NZ)", accountName, "Loan", "123456")

        // BUG: Account name gets truncated
        Assert.assertEquals(accountName + " has been added.", bankAccounts.getMessage())
    }

    @AfterClass
    static void tearDownClass() {
        driver.close()
    }
}
