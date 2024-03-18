package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonFactoryTest {

    private PokemonFactory pokemonFactory;
    private PokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        metadataProvider.addPokemonMetadata(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
    }

    @Test
    public void shouldReturnPokemonWhenIndex() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, actualPokemon.getIndex());
    }

    @Test
    public void shouldReturnPokemonWhenCP() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(613, actualPokemon.getCp());
    }

    @Test
    public void shouldReturnPokemonWhenHP() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(64, actualPokemon.getHp());
    }

    @Test
    public void shouldReturnPokemonWhenDust() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4000, actualPokemon.getDust());
    }

    @Test
    public void shouldReturnPokemonWhenCandy() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4, actualPokemon.getCandy());
    }

    @Test
    public void shouldReturnTrueWhenPokemonIV() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        double iv = actualPokemon.getIv();
        assertEquals(true, iv >= 0 && iv <= 100);
    }

    @Test
    public void shouldThrowExceptionWhenIndexNegative() throws PokedexException {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
    }

    /*@Test
    public void shouldThrowExceptionWhenCPNegative() {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, -613, 64, 4000, 4));
    }

    @Test
    public void shouldThrowExceptionWhenHPNegative() {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, 613, -64, 4000, 4));
    }

    @Test
    public void shouldThrowExceptionWhenDustNegative() {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, 613, 64, -4000, 4));
    }

    @Test
    public void shouldThrowExceptionWhenCandyNegative() {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, 613, 64, 4000, -4));
    }*/
}
