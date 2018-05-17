package pagemodels

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

class PageObjectModel {

    protected WebDriver driver
    protected JavascriptExecutor jse

    PageObjectModel(WebDriver driver) {
        this.driver = driver
        this.jse = (JavascriptExecutor) driver
    }
}
