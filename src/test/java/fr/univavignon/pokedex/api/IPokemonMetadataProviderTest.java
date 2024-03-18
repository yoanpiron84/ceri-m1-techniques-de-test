package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IPokemonMetadataProviderTest {

    private PokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata validMetadata;

    @Before
    public void setUp() {
        pokemonMetadataProvider = new PokemonMetadataProvider();

        validMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        pokemonMetadataProvider.addPokemonMetadata(0, validMetadata);
    }

    @Test
    public void shouldReturnPokemonIndex() throws PokedexException {
        int index = pokemonMetadataProvider.getPokemonMetadata(0).getIndex();
        assertEquals(validMetadata.getIndex(), index);
    }

    @Test
    public void shouldReturnPokemonName() throws PokedexException {
        String pokemonName = pokemonMetadataProvider.getPokemonMetadata(0).getName();
        assertEquals(validMetadata.getName(), pokemonName);
    }

    @Test
    public void shouldReturnPokemonAttack() throws PokedexException {
        int attack = pokemonMetadataProvider.getPokemonMetadata(0).getAttack();
        assertEquals(validMetadata.getAttack(), attack);
    }

    @Test
    public void shouldReturnPokemonDefense() throws PokedexException {
        int defense = pokemonMetadataProvider.getPokemonMetadata(0).getDefense();
        assertEquals(validMetadata.getDefense(), defense);
    }

    @Test
    public void shouldReturnPokemonStamina() throws PokedexException {
        int stamina = pokemonMetadataProvider.getPokemonMetadata(0).getStamina();
        assertEquals(validMetadata.getStamina(), stamina);
    }

    @Test(expected = PokedexException.class)
    public void shouldThrowWhenInvalidIndex() throws PokedexException {
        pokemonMetadataProvider.getPokemonMetadata(-2);
    }
}
