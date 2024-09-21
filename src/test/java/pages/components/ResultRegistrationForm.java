package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultRegistrationForm {
    private SelenideElement tableResponsive = $(".table-responsive"),
                    userMobileNumber = $("#userNumber");
    public ResultRegistrationForm checkRegistrationForm(String key, String value){
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
    public ResultRegistrationForm checkLongOfMobileInput (){
        userMobileNumber.shouldHave(attribute("required"));
        return this;
    }
}