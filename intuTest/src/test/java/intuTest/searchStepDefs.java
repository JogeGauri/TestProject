package intuTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Tushar & Gauri on 23/04/2017.
 */
public class searchStepDefs {
    BaseMain baseMain = new BaseMain();
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();

    @Given("^I am on landing page which shows \"([^\"]*)\"$")
    public void iAmOnLandingPageWhichShows(String successMsg) throws Throwable {
        searchPage.goToUrl();
        Assert.assertTrue(loginPage.dashBoardMessage(successMsg));

    }

    @And("^I view the products from brand named \"([^\"]*)\"$")
    public void iViewTheProductsFromBrandNamed(String nameSearched) throws Throwable {
    Assert.assertTrue(searchPage.productListOnLandingPage(nameSearched));
    }

    @And("^I click filter option \"([^\"]*)\"$")
    public void iClickFilterOption(String categoryName) throws Throwable {
        searchPage.clickFilterCategory("Category");
        searchPage.clickFilterCategory("Retailer");
        Thread.sleep(2000);
        searchPage.clickFilterCategory(categoryName);
    }

    @When("^I search for brand named \"([^\"]*)\"$")
    public void iSearchForBrandNamed(String criteria) throws Throwable {
        searchPage.enterSearchCriteria(criteria);
    }

    @Then("^I should see brand named \"([^\"]*)\" in search list$")
    public void iShouldSeeBrandNamedInSearchList(String outComeMessage) throws Throwable {
     Assert.assertTrue(searchPage.searchResult(outComeMessage));
    }
}
