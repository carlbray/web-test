# web-test
This IntelliJ / Gradle project is an example of testing a web UI.
## Installation
You will need Git and Gradle installed

1. Clone the repository
```
clone https://github.com/carlbray/web-test.git
```

2. Download the chrome driver from http://chromedriver.chromium.org/downloads
Unzip it
Open the web-test/build.gradle file
Set the driver property to the executable
```
    systemProperty 'webdriver.chrome.driver', 'D:\\selenium\\chromedriver.exe'
```

3. Run the test
```
gradle
```

## You can view the test report in
web-test/build/reports/tests/test/index.html
