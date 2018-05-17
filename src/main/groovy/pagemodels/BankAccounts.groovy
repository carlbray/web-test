package pagemodels

import js.JSHelper
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class BankAccounts extends PageObjectModel implements BankAccountsModel {

    @FindBy(css="span[data-automationid='Add Bank Account-button']")
    WebElement addAccountButton

    @FindBy(xpath="//input[@placeholder='Search for your bank...']")
    WebElement popularBanksList

    @FindBy(xpath="//div[@data-automationid='searchBanksList']/ul/li")
    WebElement bankListFirstItem

    @FindBy(xpath="//input[@placeholder='e.g Business Account']")
    WebElement accountNameBox

    @FindBy(xpath="//input[@placeholder='Please select one']")
    WebElement accountTypeCombo

    @FindBy(className="message")
    WebElement message

    @FindBy(xpath="//a[@data-automationid='continueButton']")
    WebElement continueButton

    BankAccounts(WebDriver driver) {
        super(driver)
        PageFactory.initElements(driver, this)
    }

    void addBankAccount(String bank, String accountName, String accountType, String accountNumber) {
        selectBank(bank)
        enterAccountName(accountName)
        selectAccountType(accountType)
        enterAccountNumber(accountNumber)
        pressContinueButton()
    }

    void enterAccountNumber(String accountNumber) {

        String result = JSHelper.executeScript(jse, "return Ext.ComponentQuery.query('accountnumber')[3].id")

        driver.findElement(By.id(result + "-inputEl")).sendKeys(accountNumber)
    }

    void pressContinueButton() {
        continueButton.click()
    }

    void selectAccountType(String accountType) {
        accountTypeCombo.click()
        driver.findElement(By.xpath("//li[@class='ba-combo-list-item'][contains(text(), '$accountType')]")).click()
    }

    void enterAccountName(String accountName) {
        accountNameBox.sendKeys(accountName)
    }

    void selectBank(String bank) {
        addAccountButton.click()
        popularBanksList.sendKeys(bank)
        bankListFirstItem.click()
    }

    String getMessage() {
        return message.getText()
    }
}
