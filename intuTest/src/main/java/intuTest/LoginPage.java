package intuTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Tushar & Gauri on 23/04/2017.
 */
public class LoginPage extends BaseMain {

    @FindBy(css = "div[class='page-header__title'] h1")
    private WebElement loginPageStatus;

    @FindBy(css = "input[name='login[username]")
    private WebElement emailField;

    @FindBy(css = "input[name='login[password]")
    private WebElement passwordField;

    @FindBy(css = "button[name='send'] span span")
    private WebElement loginButton;

    @FindBy(css = "div[class='welcome-msg'] strong")
    private WebElement loginMessage;

    @FindBy(css = "li[class=\"js-logout\"] a")
    private WebElement logOutButton;

    @FindBy(css = "div[class='page-header__title'] h1")
    private WebElement messageOnDashBoard;

    @FindBy(css = "div[class='alert-box__message'] h4")
    private WebElement alertNotification;

    @FindBy(css = "div[class='small-12 columns text-right'] a")
    private WebElement forgetPassword;

    @FindBy(css = "div[class='page-header__title'] h1")
    private WebElement forgetPwdMsg;

    @FindBy(css = "button[type='submit'] span span")
    private WebElement submitBtn;

    @FindBy(css = "input[name='email']")
    private WebElement reEnterEmailId;

    @FindBy(css = "div[class='alert-box__message'] h4")
    private WebElement resetNotification;


    public boolean checkOnLoginPage(String pageName) {
        boolean pageStatus = false;

        if (loginPageStatus.getText().contains(pageName)) {
            pageStatus = true;
            System.out.println("The text seen on the landing Page is --> " + loginPageStatus.getText());
        }
        return pageStatus;
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean loginStatus(String successMsg) {
        boolean messageStatus = false;
        if (loginMessage.getText().equalsIgnoreCase(successMsg)) {
            messageStatus = true;
            System.out.println("The Message Seen is " + loginMessage.getText());
        }
        return messageStatus;
    }

    public void logOutBtn() {
        logOutButton.click();
    }

    public boolean dashBoardMessage(String message) {
        boolean msg = false;
        if (messageOnDashBoard.getText().equalsIgnoreCase(message)) {
            msg = true;
        }
        return msg;
    }

    public boolean alertMessageSeen(String alertMessage) {
        boolean msgSeen = false;
        if (alertNotification.getText().equalsIgnoreCase(alertMessage)) {
            msgSeen = true;
        }
        return msgSeen;
    }

    public void forgetPwdLink() {
        forgetPassword.click();
    }

    public boolean forgetPwdNotification(String msg) {
        boolean pwdNotification = false;
        if (forgetPwdMsg.getText().equalsIgnoreCase(msg)) {
            pwdNotification = true;
            System.out.println("The Message Seen is " + forgetPwdMsg.getText());
        }
        return pwdNotification;
    }

    public void reEnterEmail(String email) {
        reEnterEmailId.sendKeys(email);
    }

    public void submitButton() {
        submitBtn.click();
    }

    public boolean resetEmail(String textMsg) {
        boolean resetMsg = false;
        if (resetNotification.getText().contains(textMsg)) {
            resetMsg = true;
            System.out.println("The Message Seen is " + resetNotification.getText());
        }
        return resetMsg;
    }
}
