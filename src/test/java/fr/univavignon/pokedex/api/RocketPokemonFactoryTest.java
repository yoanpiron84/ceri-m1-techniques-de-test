package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RocketPokemonFactoryTest {
    RocketPokemonFactory rocketPokemonFactory;

    private Pokemon Aquali;
    private Pokemon Bulbizarre;

    @BeforeEach
    public void setUp() {
        rocketPokemonFactory = new RocketPokemonFactory();
        Bulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void createPokemonTest() throws PokedexException {
        assertNotNull(rocketPokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertNotNull(rocketPokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }


}
