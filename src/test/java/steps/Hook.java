package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by Karthik on 31/01/2019.
 */

public class Hook extends BaseUtil{


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    
    @Before
    public void beforeScenarioStart(Scenario scenario)
    {
        System.out.println("-----------------Start of Scenario-----------------");
        
         System.out.println("Opening the browser : Chrome");




        //Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("disable-extensions");
        opt.addArguments("--start-maximized");
        base.Driver = new ChromeDriver(opt);
        
        scenarioDef = base.features.createNode(scenario.getName());

       
        base.Driver.get("http://www.executeautomation.com/demosite/Login.html");
    } 

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
    }

}
