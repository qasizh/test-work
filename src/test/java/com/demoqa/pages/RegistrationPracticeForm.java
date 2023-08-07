package com.demoqa.pages;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class RegistrationPracticeForm {
    private final static String TITLE = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            currentAddressInput = $("#currentAddress"),
            submitButton = $("button#submit"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            uploadPictureInput=$("#uploadPicture");
    public RegistrationPracticeForm openPage(){
        open("/automation-practice-form");
        deleteFooterAndFixedban();
        $(".practice-form-wrapper").shouldHave(text(TITLE));
        return this;
    }
    public RegistrationPracticeForm setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPracticeForm setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPracticeForm setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPracticeForm setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPracticeForm setNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPracticeForm setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
    public RegistrationPracticeForm setSubject(String value) {
        subjectsInput.setValue(value);
        $("#react-select-2-option-0").click();
        return this;
    }
    public RegistrationPracticeForm selectHobbies(String hobbie1, String hobbie2, String hobbie3) {
        $x(String.format("//label[text()='%s']",hobbie1)).click();
        $x(String.format("//label[text()='%s']",hobbie2)).click();
        $x(String.format("//label[text()='%s']",hobbie3)).click();
        return this;
    }
    public RegistrationPracticeForm selectHobbies(String hobbie1, String hobbie2) {
        $x(String.format("//label[text()='%s']",hobbie1)).click();
        $x(String.format("//label[text()='%s']",hobbie2)).click();
        return this;
    }
    public RegistrationPracticeForm selectHobbies(String hobbie) {
        $x(String.format("//label[text()='%s']",hobbie)).click();
        return this;
    }
    public RegistrationPracticeForm selectPicture(String fileName) {
        File file = new File("src//test//resources//"+fileName);
        uploadPictureInput.uploadFile(file);
        return this;
    }
    public RegistrationPracticeForm setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPracticeForm selectState(String state) {
        stateInput.click();
        $x("//div[contains(@id,'option')][text()='"+state+"']").click();
        return this;
    }
    public RegistrationPracticeForm selectCity(String city) {
        cityInput.click();
        $x("//div[contains(@id,'option')][text()='"+city+"']").click();
        return this;
    }
    public RegistrationPracticeForm clickButtonSubmit() {
        submitButton.click();
        return this;
    }
    private void deleteFooterAndFixedban(){
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
