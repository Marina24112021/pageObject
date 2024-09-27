package tests;

import components.ResultRegistrationForm;
import components.SubmitForm;
import components.UploadFile;
import components.UserAddress;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.RandomDataUtils;

public class PageObjectTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomDataUtils randomUtils = new RandomDataUtils();
    UploadFile uploadFile = new UploadFile();
    UserAddress userAddress = new UserAddress();
    SubmitForm submitForm = new SubmitForm();
    ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();

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
            picture = "pic.png",
            address = randomUtils.setAddress(),
            state = randomUtils.setState(),
            city = randomUtils.setCity(state);


    @Test
    void positiveFullFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
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
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkRegistrationForm("Student Name", firstName + " " + lastName)
                .checkRegistrationForm("Student Email", email)
                .checkRegistrationForm("Gender", gender)
                .checkRegistrationForm("Mobile", phoneNum)
                .checkRegistrationForm("Date of Birth", dayOfBirth + " " + randomUtils.getNameOfMonth() + "," + yearOfBirth)
                .checkRegistrationForm("Subjects", subject)
                .checkRegistrationForm("Hobbies", hobby)
                .checkRegistrationForm("Picture", picture)
                .checkRegistrationForm("Address", address)
                .checkRegistrationForm("State and City", state + " " + city);

    }
    @Test
    void positiveRequiredFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserGender(gender)
                .setUserPhoneNumber(phoneNum)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkRegistrationForm("Student Name", firstName + " " + lastName)
                .checkRegistrationForm("Gender", gender)
                .checkRegistrationForm("Mobile", phoneNum)
                .checkRegistrationForm("Date of Birth", dayOfBirth + " " + randomUtils.getNameOfMonth() + "," + yearOfBirth);
    }
    @Test
    void negativeMobilePhoneTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserGender(gender)
                .setUserPhoneNumber(incorrectPhoneNum);
        submitForm.clickOnSubmit();
        resultRegistrationForm.checkLongOfMobileInput();
    }
}

