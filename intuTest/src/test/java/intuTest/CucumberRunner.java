package intuTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Tushar & Gauri on 22/04/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features=".", tags="@test", dryRun=false)
public class CucumberRunner {
}
