package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistrationPage {
    public final SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderInput = $("#genterWrapper"),
                            phoneNumberInput = $("#userNumber"),
                            calendarInout = $("#dateOfBirthInput"),
                            subjectInput = $("#subjectsInput"),
                            hobbiesInput = $("#hobbiesWrapper");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return  this;
    }
    public RegistrationPage setLastName(String lastname){
        lastNameInput.setValue(lastname);
        return  this;
    }
    public RegistrationPage setUseEmail(String email){
        emailInput.setValue(email);
        return  this;
    }
    public RegistrationPage setUserGender(String gender){
        genderInput.$(byText(gender)).click();
        return  this;
    }
    public RegistrationPage setUserPhoneNumber(String phoneNum){
        phoneNumberInput.setValue(phoneNum);
        return  this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInout.click();
        calendarComponent.setDate(day, month, year);
        return  this;
    }
    public RegistrationPage setUserSubjects(String subject){
        subjectInput.setValue(subject).pressEnter();
        return  this;
    }
    public RegistrationPage setUserHobbies(String hobbies){
        hobbiesInput.$(byText(hobbies)).click();
        return  this;
    }
}
