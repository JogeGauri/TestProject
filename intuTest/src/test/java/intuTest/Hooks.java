package intuTest;

import cucumber.api.java.Before;

import java.io.IOException;

/**
 * Created by Tushar & Gauri on 22/04/2017.
 */
public class Hooks {
    BaseMain baseMain = new BaseMain();

    @Before
    public void setUp() throws IOException {
        baseMain.openBrowser();
    }

    /*@After
    public void tearDown(){
        baseMain.closeBrowser();
    }*/
}
