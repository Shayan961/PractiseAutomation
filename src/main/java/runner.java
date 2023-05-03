import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;







    @RunWith(Cucumber.class)
    @CucumberOptions(

            features = {"src/main/java/Feature/login.feature"},

//        plugin = { "pretty", "html:target/cucumber-html-reports",
//              "json:target/cucumber-html-reports/cucumber.json","rerun:target/failed_scenarios.txt" },
           // tags = {"@WalkThrough,"},
            junit={"--step-notifications"}

    )

    public class runner {



    }



