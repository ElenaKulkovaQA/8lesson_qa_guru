
import org.junit.jupiter.params.provider.CsvSource;
import utils.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LanguageChangeCheckLinguiseTest extends BaseLinguise {

    @DisplayName("Проверка смены языка в блоке Поддержка в хедере")
    @ParameterizedTest
    @CsvSource({"Russian, Поддерживать", "Spanish, Apoyo"})
    void languageChangeCheckForHederBlock(String language, String word) {

        open("https://www.linguise.com/");

        $(".linguise_flags.linguise_language_icon").click();

        $$(".linguise_lang_name").filter(text(language)).get(0).click();

        $("ul.uc-mega_menu_list").shouldHave(text(word));

    }
    @DisplayName("Проверкасмены  языка для баннера")
    @EnumSource(Language.class)
    @ParameterizedTest
    void changeTexstForBanner(Language chooseLang) {

        open("https://www.linguise.com/");

        $(".linguise_flags.linguise_language_icon").click();

        $$(".linguise_lang_name").filter(text(chooseLang.name())).get(0).click();

        $(".elementor-heading-title").shouldHave(text(chooseLang.description));
    }

}
