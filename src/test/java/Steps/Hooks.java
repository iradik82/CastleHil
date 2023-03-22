package Steps;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {


    @Before
    public void preCondition(){ openBrowser();}


    @After
    public void postCondition(Scenario scenario){
        byte[]pic;
        if(scenario.isFailed()){
            pic = takeScreenshot("failed/" + scenario.getName());
        }else{
            pic = takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(pic,"image/png",scenario.getName());

        closeBrowser();
    }
}
