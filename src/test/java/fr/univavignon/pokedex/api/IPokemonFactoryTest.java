package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univavignon.pokedex.api.IPokemonFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IPokemonFactoryTest {

    @Mock
    public IPokemonFactory pokemonFactory;
    private Pokemon validMetadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonFactory = mock(IPokemonFactory.class);

        validMetadata = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 2.0);

        Mockito.when(pokemonFactory.createPokemon(anyInt(), anyInt(), Mockito.eq(64), Mockito.eq(4000), Mockito.eq(4)
        )).thenAnswer(invocation -> {
            int cp = invocation.getArgument(1);
            if (cp < 0) {
                throw new PokedexException("CP non valide");
            } else {
                return validMetadata;
            }
        });
    }

    @Test
    public void shouldReturnPokemonName() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(validMetadata, actualMetadata);
    }

    /*@Test
    public void shouldThrowExceptionWhenIndexNegative() {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,-613,64,4000,4);
        assertEquals(validMetadata, actualMetadata);
    }*/
}
