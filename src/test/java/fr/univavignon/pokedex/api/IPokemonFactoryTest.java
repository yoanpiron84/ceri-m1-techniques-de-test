package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.univavignon.pokedex.api.IPokemonFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IPokemonFactoryTest {

    @Mock
    public IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() throws PokedexException {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));

        // Configuration du comportement du mock pour lancer une exception lorsque l'index est négatif
        when(pokemonFactory.createPokemon(-1, 613, 64, 4000, 4))
                .thenThrow(new PokedexException("Index négatif !"));
    }

    @Test
    public void shouldThrowExceptionWhenIndexNegative() {
        assertThrows(PokedexException.class,
                () -> pokemonFactory.createPokemon(-1, 613, 64, 4000, 4));
    }

    @Test
    public void shouldReturnPokemonName(){
        assertEquals("Bulbizarre", pokemonFactory.createPokemon(0, 613, 64, 4000, 4).getName());
    }
}
