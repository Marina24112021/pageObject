package components;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class UploadFile {
    private final SelenideElement fileInput = $("#uploadPicture");

    public UploadFile uploadFileMethod(String pathToFile) {
        if (!Objects.equals(Configuration.browser, "firefox")) {
            fileInput.uploadFromClasspath(pathToFile);
        }
        return this;
    }
}
