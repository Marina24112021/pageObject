package tests;

import components.ResultRegistrationForm;
import components.SubmitForm;
import components.UploadFile;
import components.UserAddress;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomDataUtils;

import static io.qameta.allure.Allure.step;

public class PageObjectTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomDataUtils randomUtils = new RandomDataUtils();
    private final String firstName = randomUtils.setFirstName(),
            lastName = randomUtils.setLastName(),
            email = randomUtils.setEmail(),
            gender = randomUtils.setGender(),
            phoneNum = randomUtils.setPhoneNum(),
            incorrectPhoneNum = randomUtils.setIncorrectPhoneNum(),
            dayOfBirth = randomUtils.setDayOfBirth(),
            monthOfBirth = randomUtils.setMonthOfBirth(),
            yearOfBirth = randomUtils.setYearOfBirth(),
            subject = randomUtils.setSubject(),
            hobby = randomUtils.setHobby(),
            picture = randomUtils.getRandomFile(),
            address = randomUtils.setAddress(),
            state = randomUtils.setState(),
            city = randomUtils.setCity(state);
    UploadFile uploadFile = new UploadFile();
    UserAddress userAddress = new UserAddress();
    SubmitForm submitForm = new SubmitForm();
    ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();


    @Tag("positive-simple")
    @Feature("Feature lable")
    @Story("Check full filled inputs with result table ")
    @Owner("Chen.Marina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "automation-practice-form", url = "https://demoqa.com")
    @DisplayName("Test filled full inputs of for registration, using allure report")
    @Test
    void positiveFullFormTest() {
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Fill form of registration", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUseEmail(email)
                    .setUserGender(gender)
                    .setUserPhoneNumber(phoneNum)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setUserSubjects(subject)
                    .setUserHobbies(hobby);
            uploadFile.uploadFileMethod(picture);
            userAddress.setUserAddress(address)
                    .setUserAddressStateCity(state, city);
        });
        step("Submit form", () -> {
            submitForm.clickOnSubmit();
        });
        step("Result table", () -> {
            resultRegistrationForm.checkRegistrationForm("Student Name", firstName + " " + lastName)
                    .checkRegistrationForm("Student Email", email)
                    .checkRegistrationForm("Gender", gender)
                    .checkRegistrationForm("Mobile", phoneNum)
                    .checkRegistrationForm("Date of Birth", dayOfBirth + " " + randomUtils.monthName + "," + yearOfBirth)
                    .checkRegistrationForm("Subjects", subject)
                    .checkRegistrationForm("Hobbies", hobby)
                    .checkRegistrationForm("Picture", picture)
                    .checkRegistrationForm("Address", address)
                    .checkRegistrationForm("State and City", state + " " + city);
        });
    }

    @Tag("positive-simple")
    @Feature("Feature lable")
    @Story("Check required input and compare with result table ")
    @Owner("Ivan.Ivanov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "automation-practice-form", url = "https://demoqa.com")
    @DisplayName("Test fill just required inputs using allure report")
    @Test
    void positiveRequiredFormTest() {
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Fill form of registration", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserGender(gender)
                    .setUserPhoneNumber(phoneNum)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        });
        step("Submit form", () -> {
            submitForm.clickOnSubmit();
        });
        step("Result table", () -> {
            resultRegistrationForm.checkRegistrationForm("Student Name", firstName + " " + lastName)
                    .checkRegistrationForm("Gender", gender)
                    .checkRegistrationForm("Mobile", phoneNum)
                    .checkRegistrationForm("Date of Birth", dayOfBirth + " " + randomUtils.monthName + "," + yearOfBirth);
        });
    }

    @Tag("positive-simple")
    @Feature("Feature lable")
    @Story("Negative test check incorrect phone number ")
    @Owner("Vasya.Vasechkin")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "automation-practice-form", url = "https://demoqa.com")
    @DisplayName("Test set incorrect telephone number using allure report")
    @Test
    void negativeMobilePhoneTest() {
        step("Open page", () -> {
            registrationPage.openPage();
        });
        step("Fill form of registration", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserGender(gender)
                    .setUserPhoneNumber(incorrectPhoneNum);
        });
        step("Submit form", () -> {
            submitForm.clickOnSubmit();
        });
        step("Result table", () -> {
            resultRegistrationForm.checkLongOfMobileInput();
        });
    }
}

