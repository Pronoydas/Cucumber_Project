package Test_Runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
glue = {"Step_Defination"},
dryRun = false,
plugin = {"pretty","json:CucumberTest/Reports/cucumber.json"},
monochrome = true,
snippets = SnippetType.CAMELCASE

		)

public class Cucumber_TestRunner {


}
