package ru.sovcombank.people.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement buttonVacancies = $x("//button//*[contains(text(),'Вакансии')]");
    public MainPage openMainPage(){
        open("https://people.sovcombank.ru/");
        return this;
    }
    public VacanciesPage clickButtonVacancies(){
        buttonVacancies.click();
        return new VacanciesPage();
    }
}
