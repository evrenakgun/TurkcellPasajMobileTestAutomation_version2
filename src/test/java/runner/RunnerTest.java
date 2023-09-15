package runner;

import io.cucumber.testng.*;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/features"},
        glue = {"steps"},
        publish = true,
        plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunnerTest extends AbstractTestNGCucumberTests{

}
