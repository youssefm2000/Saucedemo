package Runners;
import EjadaTest.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="C:\\Users\\yelshemy\\Desktop\\EjadaTask\\EJADATASK\\src\\test\\java\\features"
        ,glue = "steps",tags = "@e2eTest", plugin = {"pretty" , "html:target/cucumber-html-report"})
public class TestRunner extends TestBase {
}