package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadFile {
    private final SelenideElement fileInput = $("#uploadPicture");

    public UploadFile uploadFileMethod(String pathToFile) {
        fileInput.uploadFromClasspath(pathToFile);
        return this;
    }
}
