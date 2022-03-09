package stepdefinitions.apisteps;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.Appointment;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.WriteToTxt.saveAppointData;
import static Hooks.Hooks.spec;

public class CreateAppointmentSteps{

    Appointment appointment= new Appointment();

    Faker faker = new Faker();

    Response response;

    @Given("user sets the path params")
    public void user_sets_the_path_params() {
        spec.pathParams("first", "api", "second", "appointments","third","request");


    }
    @Given("user sets the expected data {string},{string} {string} {string} {string} and {string}")
    public void user_sets_the_expected_data_and(String firstname, String lastname, String ssn, String email, String phone, String date) {
//
//        firstname = faker.name().firstName();
//        lastname  = faker.name().lastName();
//        ssn       = faker.idNumber().ssnValid();
//        email     = faker.internet().emailAddress();
//        phone     = faker.phoneNumber().cellPhone();
////        date      = faker.date().future(


        appointment.setFirstName(firstname);
        appointment.setLastName(lastname);
        appointment.setSsn(ssn);
        appointment.setEmail(email);
        appointment.setPhone(phone);
        appointment.setDate(date);

    }
    @Given("user sends the request and gets the response")
    public void user_sends_the_request_and_gets_the_response() {


        response = given().spec(spec).contentType(ContentType.JSON).body(appointment).when().post("/{first}/{second}/{third}");
    }
    @When("user saves the api records to correspondent files")
    public void user_saves_the_api_records_to_correspondent_files() {

        saveAppointData(appointment);
    }
    @Then("user validates api records")
    public void user_validates_api_records() {
        response.then().statusCode(201);
        response.prettyPrint();


        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(appointment.getFirstName(),((Map)actualData.get("patient")).get("firstName"));
        assertEquals(appointment.getSsn(),((Map)((Map)actualData.get("patient")).get("user")).get("ssn"));

    }



}
