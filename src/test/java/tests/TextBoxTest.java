package tests;

import components.ResultRegistrationForm;
import components.SubmitForm;
import components.UserAddress;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxRegistrationPage;
import utils.RandomDataUtils;

public class TextBoxTest extends TestBase {
    RandomDataUtils randomUtils = new RandomDataUtils();
    private final String firstName = randomUtils.setFirstName(),
            lastName = randomUtils.setLastName(),
            email = randomUtils.setEmail(),
            currentAddress = randomUtils.setAddress(),
            permanentAddress = randomUtils.setAddress();
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxRegistrationPage textBoxRegistrationPage = new TextBoxRegistrationPage();
    UserAddress userAddress = new UserAddress();
    SubmitForm submitForm = new SubmitForm();
    ResultRegistrationForm resultRegistrationForm = new ResultRegistrationForm();

    @Test
    void fillFormTest() {
        textBoxRegistrationPage.openPage()
                .setFullName(firstName + " " + lastName);
        registrationPage.setUseEmail(email);
        userAddress.setUserAddress(currentAddress)
                .setUserPermanentAddress(permanentAddress);
        submitForm.clickOnSubmit();

        resultRegistrationForm.checkTextBox("#output #name", firstName + " " + lastName)
                .checkTextBox("#output #email", email)
                .checkTextBox("#output #currentAddress", currentAddress)
                .checkTextBox("#output #permanentAddress", permanentAddress);
    }
}
