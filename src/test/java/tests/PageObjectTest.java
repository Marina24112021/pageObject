package tests;

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
                .SetFirstName("Ivan")
                .SetLastName("Ivanov")
                .SetUseEmail("IvanIvanov@test.ru")
                .SetUserGender("Male")
                .SetUserPhoneNumber("0123456789")
                .SetDateOfBirth("001","11","2000")
                .SetUserSubjects("Math")
                .SetUserHobbies("Sports");
        uploadFile.uploadFileMethod("pic.png");
        userAddress.setUserAddress("Current address is Colombia", "Haryana", "Karnal");
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
                .SetFirstName("Ann")
                .SetLastName("Petrova")
                .SetUserGender("Female")
                .SetUserPhoneNumber("9876543210")
                .SetDateOfBirth("028","1","1999");
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkRegistrationForm("Student Name","Ann Petrova")
                .checkRegistrationForm("Gender","Female")
                .checkRegistrationForm("Mobile","9876543210")
                .checkRegistrationForm("Date of Birth","28 February,1999");
    }
    @Test
    void negativeLongOfMobilePhoneTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        SubmitForm submitForm = new SubmitForm();
        ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();
        registrationPage.openPage()
                .SetFirstName("Ann")
                .SetLastName("Petrova")
                .SetUserGender("Female")
                .SetUserPhoneNumber("111");
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkLongOfMobileInput();
    }
}

