package pagemodels

interface LoginModel {

    void doLogin(String username, String password)
    void setUsername(String username)
    void setPassword(String password)
    void pressLoginButton()
}
