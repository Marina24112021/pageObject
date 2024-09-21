package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
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

    public RegistrationPage SetFirstName(String name){
        firstNameInput.setValue(name);
        return  this;
    }
    public RegistrationPage SetLastName(String lastname){
        lastNameInput.setValue(lastname);
        return  this;
    }
    public RegistrationPage SetUseEmail(String email){
        emailInput.setValue(email);
        return  this;
    }
    public RegistrationPage SetUserGender(String gender){
        genderInput.$(byText(gender)).click();
        return  this;
    }
    public RegistrationPage SetUserPhoneNumber(String phoneNum){
        phoneNumberInput.setValue(phoneNum);
        return  this;
    }
    public RegistrationPage SetDateOfBirth(String day, String month, String year){
        calendarInout.click();
        calendarComponent.setDate(day, month, year);
        return  this;
    }
    public RegistrationPage SetUserSubjects(String subject){
        subjectInput.setValue(subject).pressEnter();
        return  this;
    }
    public RegistrationPage SetUserHobbies(String hobbies){
        hobbiesInput.$(byText(hobbies)).click();
        return  this;
    }
}
