package com.formation.taskops.util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

class TitreUtilsTest {
    @ParameterizedTest(name = "\"{0}\" -> \"{1}\"")
    @CsvSource({
        "' bonjour ', Bonjour",
        "'ecrire les tests', Ecrire les tests",
        "'a', A",
        "'Deja Correct', Deja Correct",
        "' multiple espaces ', Multiple espaces"
    })
    @DisplayName("normaliser nettoie les espaces et capitalise")
    void normaliser_nettoieCorrectement(String entree, String attendu) {
        assertThat(TitreUtils.normaliser(entree)).isEqualTo(attendu);
    }
    
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    @DisplayName("normaliser renvoie une chaine vide pour toute entree vide")
    void normaliser_gereLesEntreesVides(String entree) {
        assertThat(TitreUtils.normaliser(entree)).isEmpty();
    }
}
