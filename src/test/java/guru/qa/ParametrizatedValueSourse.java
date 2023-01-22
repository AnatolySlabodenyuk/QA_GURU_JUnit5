package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizatedValueSourse {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(
            strings = {"ma", "m"}
    )

    @ParameterizedTest(name = "Название предмета Maths должно появиться по запросу {0}")

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void SubjectsNameShouldBePresentInResultsByLettersQuery(
            String letters
    ) {
        open("/automation-practice-form");
        $("#subjectsInput").setValue(letters);
        $(".subjects-auto-complete__option").shouldHave(text("Maths"));
    }
}