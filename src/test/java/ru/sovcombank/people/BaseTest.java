package ru.sovcombank.people;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    static void configure(){
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        //Configuration.browserSize = "1920x1080";
    }
}
