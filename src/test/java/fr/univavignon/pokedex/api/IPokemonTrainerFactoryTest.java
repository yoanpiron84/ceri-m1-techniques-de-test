package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonTrainerFactoryTest {

    private PokemonTrainerFactory pokemonTrainerFactory;
    private PokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void shouldReturnTrainerWhenCreate() {
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Enzo", Team.MYSTIC, pokedexFactory);
        assertEquals("Enzo", pokemonTrainer.getName());
    }

    @Test
    public void shouldReturnTrainerWhenTeam() {
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Enzo", Team.MYSTIC, pokedexFactory);
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
    }

    /*@Test
    public void shouldReturnTrainerWhenPokedex() {
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Enzo", Team.MYSTIC, pokedexFactory);
        assertEquals(pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider())), pokemonTrainer.getPokedex());
    }

    @Test
    public void shouldThrowExceptionWhenEmptyName() {
        assertThrows(PokedexException.class, () -> pokemonTrainerFactory.createTrainer("", Team.MYSTIC, pokedexFactory));
    }

    @Test
    public void shouldThrowExceptionWhenNullTeam() {
        assertThrows(PokedexException.class, () -> pokemonTrainerFactory.createTrainer("Enzo", null, pokedexFactory));
    }

    @Test
    public void shouldThrowExceptionWhenNullPokedexFactory() {
        assertThrows(PokedexException.class, () -> pokemonTrainerFactory.createTrainer("Enzo", Team.MYSTIC, null));
    }*/
}
