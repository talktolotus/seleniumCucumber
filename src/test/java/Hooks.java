import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.CommonLibrary;

//now hook to stepdefination class
public class Hooks extends CommonLibrary {

    @Before//import from io.cucumber not from Junit
    public void beforeMethod() {
        openBrowser();
    }

    @After//same as above
    public void afterMethod() {

        closeBrowser();
    }
}
