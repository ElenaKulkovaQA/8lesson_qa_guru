package utils;

import com.codeborne.selenide.impl.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;
import java.util.stream.Stream;

public enum Language {

    Russian("Переведите свой веб-сайт "),
    Spanish("¡Traduce tu sitio web ");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}