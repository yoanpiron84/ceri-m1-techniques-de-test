package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    private Pokemon validPokemon;

    @BeforeEach
    public void setUp() throws PokedexException {

        pokedex = mock(IPokedex.class);

        validPokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 2.0);

        Mockito.when(pokedex.addPokemon(Mockito.any(Pokemon.class))).thenAnswer(invocation -> {
            Pokemon pokemon = invocation.getArgument(0);
            System.out.println(pokemon.getIndex());
            if (pokemon == null) {
                System.out.println("test");
                throw new PokedexException("Pokémon non valide");
            } else {
                return pokemon.getIndex();
            }
        });
    }

    @Test
    public void shouldAddValidPokemon() throws PokedexException {

        int index = pokedex.addPokemon(validPokemon);

        // Then
        assertEquals(validPokemon.getIndex(), index);
    }

    /*@Test
    public void shouldThrowExceptionWhenPokemonInvalid() {
        int index = pokedex.addPokemon(null);
        assertEquals(validPokemon.getIndex(), index);
    }*/


}
