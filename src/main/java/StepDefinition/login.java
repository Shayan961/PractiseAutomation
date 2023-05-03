package StepDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class login {

    private WebDriver driver;


    private static  String  schedule_css = " #app > div > div > div.Banner-sc-1p31lg7-0.iBPHCr div";
    private static String Firstname_css = "div label:nth-child(4) div input";
    private static String LastName_css = " div label:nth-child(5) div input";
    private static String Email_css = " div label:nth-child(6) div input";
    private static String phone_css = " div label:nth-child(7) div input";
    private static String date_time_css = "/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div[1]/div/input";
    private static String month_xpath = "/html/body/div/div/div /div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]";
    private static String fwd_button = "/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/button";
    private static String Submit_xpath = "/html/body/div/div/div/div[2]/div/div/div[4]/div[2]/div";

    @Given("URL should open successfully")

    public void URL_should_open_successfully() throws Exception {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\shayan.shahid\\driver\\Newfolder\\chromedriver.exe");




        driver = new ChromeDriver();
        driver.get("https://drape.com.pk/"); // open url

        Thread.sleep(9000);
        driver.manage().window().maximize(); // maximize window

    }


    @When("user click on walk_through button")

    public void user_click_on_walk_through_button() throws Exception
    {
        Thread.sleep(9000);
        driver.findElement(By.cssSelector(schedule_css)).click();
    }

    @When("user enter first name")

    public void user_enter_first_name() throws Exception
    {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(Firstname_css)).sendKeys("Fizza");
    }

    @When("user enter last name")

    public void user_enter_last_name()
    {
        driver.findElement(By.cssSelector(LastName_css)).sendKeys("Jawed");
    }

    @When("user enter email address")

    public void user_enter_email_address()
    {
        driver.findElement(By.cssSelector(Email_css)).sendKeys("fizzashaikh34@gmail.com");
    }

    @When("user enter phone number")

    public void user_enter_phone_number()
    {
        driver.findElement(By.cssSelector(phone_css)).sendKeys("03310000920");
    }

//    @When("user enter valid date time")
//
//    public void user_enter_valid_date_time() throws Exception
//    {
//        driver.findElement(By.xpath(date_time_css)).click(); // open a calender for selecting date and time
//        Thread.sleep(2000);
//        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]")).click();
//    }

    @When("user enter valid date")

    public void user_enter_valid_date() throws Exception {

        driver.findElement(By.xpath(date_time_css)).click(); // open a calender for selecting date and time
        Thread.sleep(2000);

        String month = "November 2021";
        //driver.findElement(By.xpath(date_time_css)).click();
        Thread.sleep(1000);
        //driver.findElement(By.cssSelector("button.react-datepicker__navigation.react-datepicker__navigation--next--with-time")).click();


        while (true) {
            Thread.sleep(1000);
            String text = driver.findElement(By.cssSelector(" div.react-datepicker__current-month")).getText(); // getting current month text from calender
            System.out.println(text); // for testing purpose

            if (text.equals(month)) {
                break;
            } else {
                // Assert.assertEquals(Expected, Actual);
                //Thread.sleep(4000);
                driver.findElement(By.cssSelector("button.react-datepicker__navigation.react-datepicker__navigation--next--with-time")).click();
                // if condition is false then move forward
            }
        }
//


        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]")).click(); // selecting date
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li[19]")).click(); // selecting time

        //cancel button
        //driver.findElement(By.cssSelector("#schedule-popup-cancel")).click();


    }
    @Then("user click on submit button")

    public void form_submisson()
    {
        driver.findElement(By.xpath(Submit_xpath)).click(); // submit button click
    }


    @Then("form should be submitted successfully '([^']*)'")
    public void form_submit_successfully(String Expected) throws Exception
    {
        Thread.sleep(3000);
        String Actual= driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h2/p")).getText();
        Assert.assertEquals(Expected,Actual);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#swal2-content div.Button-sc-1fkoyq4-0")).click(); // OK BUTTON

    }

    @Then("user should get an error '([^']*)'")
    public void error(String Expected) throws Exception
    {
        Thread.sleep(3000);
        String Actual= driver.findElement(By.cssSelector("#swal2-title p")).getText();
        //String Expected="Your bill created successfully";
        Assert.assertEquals(Expected,Actual);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#swal2-content div.Button-sc-1fkoyq4-0")).click();

    }

}


