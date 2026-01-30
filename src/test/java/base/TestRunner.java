package base;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "",
    glue = "",
    plugin = {"pretty","html:reports/Extentreports.html","rerun:target/failed_testscenarios.txt"},
    monochrome = true
)

public class TestRunner {

}
