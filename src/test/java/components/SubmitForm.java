package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class SubmitForm {
    public final SelenideElement submitInput = $("#submit");
    public SubmitForm clickOnSubmit(){
        submitInput.click();
        return this;
    }
}
