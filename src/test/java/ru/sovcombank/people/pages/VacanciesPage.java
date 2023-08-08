package ru.sovcombank.people.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {
    private SelenideElement
            fieldCity = $(".section-vacancies-filter .search-cities input[type='text']"),
            fieldCompany= $x("//*[contains(text(),'Компания')]/..//i[contains(@class,'icon')]");
    private ElementsCollection vacansies = $$x("//a[contains(@href,'/vacancies/')]");
    public VacanciesPage selectCity(String city){
        fieldCity.click();
        $x("//div[contains(text(),'"+city+"')]").click();
        return this;
    }
    public VacanciesPage selectCompany(String company){
        fieldCompany.click();
        $x("//div[contains(text(),'"+company+"')]").click();
        return this;
    }
    public List<String> getFilteredVacancies(){
        return vacansies.texts();
    }
}
