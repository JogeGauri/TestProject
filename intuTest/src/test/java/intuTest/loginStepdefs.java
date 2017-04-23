package intuTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Tushar & Gauri on 23/04/2017.
 */
public class loginStepdefs {
    LoginPage loginPage = new LoginPage();
    BaseMain baseMain = new BaseMain();

   /* public loginStepdefs(LoginPage loginPage, BaseMain baseMain) {
        this.loginPage = loginPage;
        this.baseMain = baseMain;
    }*/


    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() throws Throwable {
        Assert.assertTrue(loginPage.checkOnLoginPage("Login"));
    }

    @When("^I want to login as a Registered Customer$")
    public void iWantToLoginAsARegisteredCustomer() throws Throwable {

    }

    @And("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\" to login successfully$")
    public void iEnterValidAndValidToLoginSuccessfully(String email, String password) throws Throwable {
        loginPage.login("test1234@test.com", "test1234test");
    }


    @Then("^I should be able to see a success message \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeASuccess(String successMsg) throws Throwable {
        Assert.assertTrue(loginPage.dashBoardMessage(successMsg));
    }

    @When("^I enter invalid \"([^\"]*)\", \"([^\"]*)\" and click login$")
    public void iEnterInvalidAnd(String loginEmail, String password) throws Throwable {
        loginPage.login(loginEmail, password);
    }

    @And("^I logout$")
    public void iLogout() throws Throwable {
        loginPage.logOutBtn();
    }

    @And("^I see user wished \"([^\"]*)\" on logged in page$")
    public void iSeeUserWishedOnLoggedInPage(String successMsg) throws Throwable {
        Assert.assertTrue(loginPage.loginStatus(successMsg));
    }

    @Then("^I should be able to see and error message \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeAndErrorMessage(String alertMessage) throws Throwable {
        Assert.assertTrue(loginPage.alertMessageSeen(alertMessage));
    }

    @And("^As Registered Customer I click on the \"([^\"]*)\" tab$")
    public void asRegisteredCustomerIClickOnTheTab(String arg0) throws Throwable {
        loginPage.forgetPwdLink();
    }

    @Then("^I should be able to see message \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeMessage(String message) throws Throwable {
       Assert.assertTrue(loginPage.forgetPwdNotification(message));

    }

    @And("^I re-enter the \"([^\"]*)\"$")
    public void iReEnterThe(String email) throws Throwable {
        loginPage.reEnterEmail("test1234@test.com");

    }

    @Then("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        loginPage.submitButton();
    }

    @And("^Then I should be able to see message \"([^\"]*)\"$")
    public void thenIShouldBeAbleToSeeMessage(String testMsg) throws Throwable {
       Assert.assertTrue(loginPage.resetEmail(testMsg));
    }

}