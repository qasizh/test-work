package com.demoqa;

import com.demoqa.pages.RegistrationPracticeForm;
import com.demoqa.pages.RegistrationPracticeResultTable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTest extends BaseTest{
    private RegistrationPracticeForm registrationForm;
    private RegistrationPracticeResultTable resultTable;
    String firstName = "Ilshad",
            lastName = "Siddikov",
            userEmail = "testSI@test.ru",
            gender = "Male",
            mobile = "1000000000",
            subject = "Computer Science",
            fileName = "img.jpg",
            currentAddress = "Kazan, Test street,13",
            state = "NCR",
            city = "Delhi";

    String day = "11", month = "June", year = "1999";

    String hobbie1 = "Sports", hobbie2 = "Music";
    @BeforeEach
    void setup() {
        registrationForm = new RegistrationPracticeForm();
        resultTable = new RegistrationPracticeResultTable();
    }
    @Test
    void fillOutFormAndSubmitTest() {
        registrationForm
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(mobile)
                .setDateOfBirth(day,month,year)
                .setSubject(subject)
                .selectHobbies(hobbie1,hobbie2)
                .selectPicture(fileName)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickButtonSubmit();
        resultTable.checkFormSubmissionSuccess();
        Assertions.assertThat(resultTable.getValue("Student Name")).isEqualTo(firstName+" "+lastName);
        Assertions.assertThat(resultTable.getValue("Student Email")).isEqualTo(userEmail);
        Assertions.assertThat(resultTable.getValue("Gender")).isEqualTo(gender);
        Assertions.assertThat(resultTable.getValue("Mobile")).isEqualTo(mobile);
        Assertions.assertThat(resultTable.getValue("Date of Birth")).isEqualTo(String.format("%s %s,%s", day, month, year));
        Assertions.assertThat(resultTable.getValue("Subjects")).isEqualTo(subject);
        Assertions.assertThat(resultTable.getValue("Hobbies")).isEqualTo(String.format("%s, %s", hobbie1, hobbie2));
        Assertions.assertThat(resultTable.getValue("Picture")).isEqualTo(fileName);
        Assertions.assertThat(resultTable.getValue("Address")).isEqualTo(currentAddress);
        Assertions.assertThat(resultTable.getValue("State and City")).isEqualTo(state+" "+city);
    }

}
