package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	
		features = { "src/test/resource/Flipkart.feature" }, 	glue = { "stepDefinition" }, tags = {"@LocusAssignment" }, 
		plugin = { "pretty","html:target/cucumber" }, dryRun = false, monochrome = true, strict = false)
public class RunnerClass {

}
