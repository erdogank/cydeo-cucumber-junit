package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "junit:target/cucumber-report.xml",
                "rerun:target/rerun.txt"

        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false,
        tags = "@smoke",
        publish = true     //when this is true, it will publish a report that will be valid for 24 hours



)
public class CukesRunner {

}
