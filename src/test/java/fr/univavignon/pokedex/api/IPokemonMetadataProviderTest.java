package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata validMetadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        validMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index invalide !"));
    }

    @Test
    public void shouldReturnCorrectPokemon() throws PokedexException {
        PokemonMetadata pokemonMetadataCorrect = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(validMetadata, pokemonMetadataCorrect);
    }

    @Test
    public void shouldThrowWhenInvalidIndex() throws PokedexException {
        PokemonMetadata actualMetadata = pokemonMetadataProvider.getPokemonMetadata(-1);
        assertEquals(null, actualMetadata);
    }

}
