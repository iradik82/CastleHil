package Runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "Steps",

        dryRun = false,

        tags = "@smoke",

        monochrome = true,

        strict = true,

        plugin = {"pretty","html:target/cucumber","json:target/cucumber.json",
                "rerun:target/failed.txt"}
)

public class Smoke {

}
