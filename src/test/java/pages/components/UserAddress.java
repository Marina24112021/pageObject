package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class UserAddress {
    private SelenideElement currentAddressInput = $("#currentAddress"),
                            stateInput = $("#react-select-3-input"),
                            cityInput = $("#react-select-4-input"),
                            permanentAddressInput = $("#permanentAddress");

    public UserAddress setUserAddress (String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    public UserAddress setUserAddressStateCity (String stateValue, String cityValue){
        stateInput.setValue(stateValue).pressEnter();
        cityInput.setValue(cityValue).pressEnter();
        return this;
    }
    public UserAddress setUserPermanentAddress (String permanentAddress){
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

}
