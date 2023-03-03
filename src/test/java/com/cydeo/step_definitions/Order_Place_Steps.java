package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoWebTable_BasePage;
import com.cydeo.pages.CydeoWebTable_Login;
import com.cydeo.pages.CydeoWebTable_MakeAnOrder;
import com.cydeo.pages.CydeoWebTable_Orders;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Order_Place_Steps {

    CydeoWebTable_Login cydeoWebTableLogin = new CydeoWebTable_Login();
    CydeoWebTable_BasePage cydeoWebTableBasePage = new CydeoWebTable_BasePage();
    CydeoWebTable_MakeAnOrder makeAnOrder = new CydeoWebTable_MakeAnOrder();
    CydeoWebTable_Orders cydeoWebTableOrders = new CydeoWebTable_Orders();

    @Given("user is logged in to web table app with the user name and password")
    public void user_is_logged_in_to_web_table_app_with_the_user_name_and_password() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        cydeoWebTableLogin.nameInput.sendKeys(ConfigurationReader.getProperty("usr_name"));
        cydeoWebTableLogin.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        cydeoWebTableLogin.loginButton.click();

    }
    @When("user enters Order page")
    public void user_enters_order_page() {

        cydeoWebTableBasePage.orderLink.click();

    }
    @When("user selects {string} from Product dropdown menu")
    public void user_selects_from_product_dropdown_menu(String productType) throws InterruptedException {
        Select selectProduct = new Select(makeAnOrder.productDropDown);
        selectProduct.selectByVisibleText(productType);





    }
    @When("user enters {string} as quantity")
    public void user_enters_as_quantity(String quantity) {
        makeAnOrder.quantity.clear();
        makeAnOrder.quantity.sendKeys(quantity);
    }
    @When("user types {string} as Customer name")
    public void user_types_as_customer_name(String name) {
        makeAnOrder.customerName.sendKeys(name);

    }
    @When("user enter {string} to the Street field")
    public void user_enter_to_the_street_field(String street) {
        makeAnOrder.street.sendKeys(street);
    }
    @When("user enter {string} as City name")
    public void user_enter_as_city_name(String city) {

        makeAnOrder.city.sendKeys(city);

    }
    @When("user enters {string} as State name")
    public void user_enters_as_state_name(String state) {
        makeAnOrder.state.sendKeys(state);
    }
    @When("user enters {string} as Zip code")
    public void user_enters_as_zip_code(String zip) {
       makeAnOrder.zip.sendKeys(zip);
    }
    @When("user selects card type as {string}")
    public void user_selects_card_type_as(String cardType) {
        for (WebElement type : makeAnOrder.cardTypes) {
            if(type.getAttribute("value").equalsIgnoreCase(cardType)){
                type.click();
                break;
            }

        }

    }

    @When("user enters Expire Date {string}")
    public void user_enters_expire_date(String expireDate) {
        makeAnOrder.expireDate.sendKeys(expireDate);

    }
    @When("user clicks Process Order")
    public void user_clicks_process_order() {
        makeAnOrder.processOrderButton.click();
    }


    @And("user enters Card number Card Number")
    public void userEntersCardNumberCardNumber() {
        Faker faker = new Faker();

        makeAnOrder.cardNumber.sendKeys(faker.numerify("#############"));
    }

    @Then("user should see new order in the table on View all orders page {string}")
    public void userShouldSeeNewOrderInTheTableOnViewAllOrdersPage(String name) {
        Assert.assertEquals(name,cydeoWebTableOrders.orderListFirstRowName.getText());
    }


}
