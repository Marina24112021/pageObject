package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement yearInput = $(".react-datepicker__year-select"),
                            monthInput = $(".react-datepicker__month-select");
    public CalendarComponent setDate( String day, String month, String year){
       yearInput.$("option[value=\'"+year+"\']").click();
       monthInput.$("option[value=\'"+month+"\']").click();
       $(".react-datepicker__day--" + day).click();
       return this;
    }
}
