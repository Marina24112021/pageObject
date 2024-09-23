package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxRegistrationPage {
    private final SelenideElement fullNameInput = $("#userName"),
                            namePageInput = $(".text-center");

    public TextBoxRegistrationPage openPage() {
        open("/text-box");
        namePageInput.shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public TextBoxRegistrationPage setFullName(String fullName){
        fullNameInput.setValue(fullName);
        return  this;
    }
}
