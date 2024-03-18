package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonFactoryTest {

    private PokemonFactory pokemonFactory;

    private Pokemon Aquali;
    private Pokemon Bulbizarre;

    @BeforeEach
    public void setUp() {
        pokemonFactory = new PokemonFactory();
        Bulbizarre = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Aquali = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
    }

    @Test
    public void createPokemonTest() throws PokedexException {
        assertNotNull(pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
        assertNotNull(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
    }

    @Test
    public void shouldReturnPokemonWhenIndex() throws PokedexException {
        assertEquals(0, pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIndex());
    }

    @Test
    public void shouldReturnPokemonWhenCP() throws PokedexException {
        assertEquals(Bulbizarre.getCp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCp());
    }

    @Test
    public void shouldReturnPokemonWhenHP() throws PokedexException {
        assertEquals(Bulbizarre.getHp(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getHp());
    }

    @Test
    public void shouldReturnPokemonWhenDust() throws PokedexException {
        assertEquals(Bulbizarre.getDust(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getDust());
    }

    @Test
    public void shouldReturnPokemonWhenCandy() throws PokedexException {
        assertEquals(Bulbizarre.getCandy(), pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getCandy());
    }

    @Test
    public void shouldReturnTrueWhenPokemonIV() throws PokedexException {
        double iv = pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getIv();
        assertEquals(true, iv >= 0 && iv <= 100);
    }

    /*@Test
    public void shouldThrowExceptionWhenIndexNegative() throws PokedexException {
        assertThrows(PokedexException.class, () -> pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
    }*/

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
