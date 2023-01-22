package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
public class ParameterizedCsvFileSource {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @CsvFileSource(resources = "/testData.csv")

    @ParameterizedTest(name = "Название предмета {1} должно появиться по запросу {0}")

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void SubjectsNameShouldBePresentInResultsByLettersQuery(
            String letters,
            String subject
    ) {
        open("/automation-practice-form");
        $("#subjectsInput").setValue(letters);
        $(".subjects-auto-complete__option").shouldHave(text(subject));
    }
}
