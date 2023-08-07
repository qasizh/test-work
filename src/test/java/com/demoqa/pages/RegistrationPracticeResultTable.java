package com.demoqa.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPracticeResultTable {
    private final static String TITLE = "Thanks for submitting the form";
    public String getValue(String titleOfLabel){
        return $x("//div[@class='modal-content']//tbody//td[text()='"+titleOfLabel+"']/../td[2]").getText();
    }
    public void checkFormSubmissionSuccess() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
