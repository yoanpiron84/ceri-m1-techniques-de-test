package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokemonComparatorsTest {

    @Test
    public void testCompareByName() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        int result = PokemonComparators.NAME.compare(bulbizarre, aquali);

        assertEquals(1, result);  // 1 car on attend Aquali avant Bulbizarre (Nom)
    }

    @Test
    public void testCompareByIndex() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        int result = PokemonComparators.INDEX.compare(bulbizarre, aquali);

        assertEquals(-1, result); // -1 car on attend Bulbizarre avant Aquali (Index)
    }

    @Test
    public void testCompareByCP() {
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        int result = PokemonComparators.CP.compare(bulbizarre, aquali);

        assertEquals(-1, result); // -1 car on attend Bulbizarre avant Aquali (CP)
    }
}