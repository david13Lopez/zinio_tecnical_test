package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

class IsCorrectLogin {
    static String isCorrectLogin(String user,String password) {

        String response = null;
        if("testmail@test.com".equals(user) && "password".equals(password) ){
            return "Login successfully";
        }
        if(!"testmail@test.com".equals(user) && !"password".equals(password) ){
            return "Incorrect user and password";
        }
        if(!"testmail@test.com".equals(user)){
            return  "Incorrect user";
        }
        if(!"password".equals(password) ){
            return "Incorrect password";
        }
        return response;
    }
}

public class StepsDefinition {
    private String user;
    private String password;
    private String correctLogin;

    @Given("Correct user and password")
    public void all_data_correct() {
        user = "testmail@test.com";
        password = "password";
    }

    @Given("Correct user and incorrect password")
    public void user_data_correct() {
        user = "testmail@test.com";
        password = "wrongPassword";
    }

    @Given("Correct password and incorrect user")
    public void password_data_correct() {
        user = "incorrectMail@test.com";
        password = "password";
    }

    @Given("Incorrect user and password")
    public void all_data_incorrect() {
        user = "incorrectMail@test.com";
        password = "wrongPassword";
    }
    @When("I want to login with correct data")
    public void i_want_to_login_with_correct_data() {
        correctLogin = IsCorrectLogin.isCorrectLogin(user,password);
    }

    @When("I want to login with correct user")
    public void i_want_to_login_with_correct_user() {
        correctLogin = IsCorrectLogin.isCorrectLogin(user,password);
    }

    @When("I want to login with correct password")
    public void i_want_to_login_with_correct_password() {
        correctLogin = IsCorrectLogin.isCorrectLogin(user,password);
    }

    @When("I want to login with incorrect data")
    public void i_want_to_login_with_incorrect_data() {
        correctLogin = IsCorrectLogin.isCorrectLogin(user,password);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, correctLogin);
    }
}