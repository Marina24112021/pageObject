package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest extends TestBase{

    @Test
    void fillFormTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();
        UserAddress userAddress = new UserAddress();
        SubmitForm submitForm = new SubmitForm();
        ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();

        textBoxRegistrationPage.openPage()
                .SetFullName("Ivan Ivanov");
        registrationPage.SetUseEmail("fff@ddd.dd");
        userAddress.setUserAddress("Uzbekistan")
                .setUserPermanentAddress("USA");
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkTextBox("#output #name", "Ivan Ivanov")
                .checkTextBox("#output #email", "fff@ddd.dd")
                .checkTextBox("#output #currentAddress", "Uzbekistan")
                .checkTextBox("#output #permanentAddress","USA");
    }
}
