package pagemodels

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class Login extends PageObjectModel implements LoginModel {

    @FindBy(id="email")
    WebElement emailBox

    @FindBy(id="password")
    WebElement passwordBox

    @FindBy(id="submitButton")
    WebElement submitButton

    Login(WebDriver driver) {
        super(driver)
        PageFactory.initElements(driver, this)
    }

    void doLogin(String username, String password) {
        setUsername(username)
        setPassword(password)
        pressLoginButton()
    }

    void setUsername(String username) {
        emailBox.sendKeys(username)
    }

    void setPassword(String password) {
        passwordBox.sendKeys(password)
    }

    void pressLoginButton() {
        submitButton.click()
    }
}
