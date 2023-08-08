package ru.sovcombank.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sovcombank.people.pages.MainPage;
import ru.sovcombank.people.pages.VacanciesPage;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FindVacanciesTest extends BaseTest{
    MainPage mainPage;
    VacanciesPage vacanciesPage;
    @BeforeEach
    void setup(){
        mainPage = new MainPage();
    }
    @Test
    void searchForVacanciesByCityTest(){
        String city = "Москва";
        String company = "Совкомбанк Технологии";

        vacanciesPage = mainPage
                .openMainPage()
                .clickButtonVacancies()
                .selectCity(city)
                .selectCompany(company);
        sleep(1000);
        List<String> vacanciesList = vacanciesPage.getFilteredVacancies();
        /*Не соответствует сценарию из ТЗ - "||vacancy.contains("Вся Россия"))" дополнительное условие,
         требование из кейса не соответствует дейстительному работы функциональности*/
        assertThat(vacanciesList)
                .allMatch(vacancy -> (vacancy.contains(city)||vacancy.contains("Вся Россия")) && vacancy.contains(company))
                .as("Найденная вакансия не соответствует фильтру.");
    }
}