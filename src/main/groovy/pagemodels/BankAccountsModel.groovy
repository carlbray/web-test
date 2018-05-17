package pagemodels

interface BankAccountsModel {

    void addBankAccount(String bank, String accountName, String accountType, String accountNumber)
    void enterAccountNumber(String accountNumber)
    void selectAccountType(String accountType)
    void enterAccountName(String accountName)
    void selectBank(String bank)
    void pressContinueButton()
    String getMessage()
}