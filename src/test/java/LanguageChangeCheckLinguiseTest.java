import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LanguageChangeCheckLinguiseTest {

    @DisplayName("Проверка смены языка в блоке Поддержка в хедере")
    @ParameterizedTest
    @CsvSource({"Russian, Поддерживать", "Spanish, Apoyo"})

    void LanguageChangeCheckForHederBlock(String language, String word) {

        Configuration.pageLoadStrategy = "eager";

        open("https://www.linguise.com/");

        sleep(3000);

        $(".linguise_flags.linguise_language_icon").click();

        $$(".linguise_lang_name").filter(text(language)).get(0).click();

        $("ul.uc-mega_menu_list").shouldHave(text(word));

    }


}