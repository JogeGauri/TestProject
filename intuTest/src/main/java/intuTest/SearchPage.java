package intuTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Tushar & Gauri on 23/04/2017.
 */
public class SearchPage extends BaseMain {

    @FindBy(css = "ul[class*='js-product-grid product-grid'] h6 a[href]")
    private List<WebElement> productList;

    @FindBy(css = "input[class='facet__search facet__search--brands facet__contents'][placeholder='Search Brand']")
    private WebElement searchFieldInBrandFilter;

    public void goToUrl() {
        driver.get("http://intu.co.uk/shop/category/women");
    }

    public boolean productListOnLandingPage(String nameOfBrand) throws InterruptedException {
        boolean namesSeen = false;
        Thread.sleep(2000);
        for (WebElement retailerName : productList) {
            String names = retailerName.getText().trim();
            if (names.equalsIgnoreCase(nameOfBrand)) {
                namesSeen = true;
                System.out.println("The Product named " + names + " is present on this page");
                continue;
            }
        }
        return namesSeen;
    }

    public void clickFilterCategory(String categoryName) {
        List<WebElement> categoryNames = driver.findElements(By.cssSelector("div[class*='facet-lists loaded'] div h4"));
        for (WebElement names : categoryNames) {
            if (names.getText().trim().equalsIgnoreCase(categoryName)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", names);
                names.click();
                break;
            }
        }
    }

    public void enterSearchCriteria(String criteria) {
        searchFieldInBrandFilter.sendKeys(criteria);
    }



    //The below method should pass if the searched brand name appears. If the brand name does not appear then this
    //method should fail the test. In testing it is ideal to fail the test if the actual criteria fails to
    // expected criteria
    // You can try entering another brand instead of Related .. Try with Forever21 and the Test will pass as the brand appears in the list

    public boolean searchResult(String searchOutcome) {
        boolean outcome = false;
        List<WebElement> namesPresentInList = driver.findElements(By.cssSelector("[class=\"facet__body\"] ul[class*='facet__options'] li[class] a[href]"));
        for (WebElement nameToappear : namesPresentInList) {
            if (nameToappear.getText().trim().equalsIgnoreCase(searchOutcome)) {
                outcome = true;
                System.out.println("The name appeared here is --> " + nameToappear);
                break;
            }
        }
        return outcome;
    }
}
