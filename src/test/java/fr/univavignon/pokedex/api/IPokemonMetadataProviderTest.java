package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;
    private PokemonMetadata validMetadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        validMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Index invalide !"));
        when(pokemonMetadataProvider.getPokemonMetadata(Mockito.anyInt())).thenAnswer(invocation -> {
            int index = invocation.getArgument(0);
            if (index < 0) {
                throw new PokedexException("Index non valide");
            } else {
                return validMetadata;
            }
        });
    }

    @Test
    public void shouldReturnCorrectPokemon() throws PokedexException {
        PokemonMetadata pokemonMetadataCorrect = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(validMetadata, pokemonMetadataCorrect);
    }

    /*@Test
    public void shouldThrowWhenInvalidIndex() throws PokedexException {
        PokemonMetadata actualMetadata = pokemonMetadataProvider.getPokemonMetadata(-2);
        assertEquals(validMetadata, actualMetadata);
    }*/

}
