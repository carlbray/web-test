package js

import org.openqa.selenium.JavascriptExecutor

class JSHelper {

    /**
     * Execute a Javascript
     * @param jse
     * @param query
     * @return string of result
     */
    static String executeScript(JavascriptExecutor jse, String query) {
        return (String) jse.executeScript(query)
    }
}

