package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class UserAddress {
    private SelenideElement currentAddressInput = $("#currentAddress"),
                            stateInput = $("#react-select-3-input"),
                            cityInput = $("#react-select-4-input");
    public UserAddress setUserAddress (String currentAddress, String stateValue, String cityValue){
        currentAddressInput.setValue(currentAddress);
        stateInput.setValue(stateValue).pressEnter();
        cityInput.setValue(cityValue).pressEnter();
        return this;
    }
}
