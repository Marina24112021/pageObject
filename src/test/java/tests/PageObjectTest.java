package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import pages.components.*;

public class PageObjectTest extends TestBase {

    @Test
    void positiveFullFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        UploadFile uploadFile = new UploadFile();
        UserAddress userAddress = new UserAddress();
        SubmitForm submitForm = new SubmitForm();
        ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUseEmail("IvanIvanov@test.ru")
                .setUserGender("Male")
                .setUserPhoneNumber("0123456789")
                .setDateOfBirth("001","11","2000")
                .setUserSubjects("Math")
                .setUserHobbies("Sports");
        uploadFile.uploadFileMethod("pic.png");
        userAddress.setUserAddress("Current address is Colombia")
                    .setUserAddressStateCity("Haryana", "Karnal");
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkRegistrationForm("Student Name", "Ivan "+"Ivanov")
                .checkRegistrationForm("Student Email", "IvanIvanov@test.ru")
                .checkRegistrationForm("Gender", "Male")
                .checkRegistrationForm("Mobile", "0123456789")
                .checkRegistrationForm("Date of Birth", "01 December,2000")
                .checkRegistrationForm("Subjects", "Math")
                .checkRegistrationForm("Hobbies", "Sports")
                .checkRegistrationForm("Picture", "pic.png")
                .checkRegistrationForm("Address", "Current address is Colombia")
                .checkRegistrationForm("State and City", "Haryana Karnal");

    }
    @Test
    void positiveRequiredFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        SubmitForm submitForm = new SubmitForm();
        ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();
        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Petrova")
                .setUserGender("Female")
                .setUserPhoneNumber("9876543210")
                .setDateOfBirth("028","1","1999");
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkRegistrationForm("Student Name","Ann Petrova")
                .checkRegistrationForm("Gender","Female")
                .checkRegistrationForm("Mobile","9876543210")
                .checkRegistrationForm("Date of Birth","28 February,1999");
    }
    @Test
    void negativeMobilePhoneTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        SubmitForm submitForm = new SubmitForm();
        ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();
        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Petrova")
                .setUserGender("Female")
                .setUserPhoneNumber("111");
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkLongOfMobileInput();
    }
}

