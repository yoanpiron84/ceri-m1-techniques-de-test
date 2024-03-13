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
            int index = invocation.getArgument(0);
            int cp = invocation.getArgument(1);
            int hp = invocation.getArgument(2);
            int dust = invocation.getArgument(3);
            int candy = invocation.getArgument(4);
            if (index < 0) {
                throw new PokedexException("Index non valide");
            } else if(cp < 0){
                throw new PokedexException("CP non valide");
            } else if(hp < 0) {
                throw new PokedexException("HP non valide");
            } else if(dust < 0){
                    throw new PokedexException("Dust non valide");
            } else if(candy < 0){
                throw new PokedexException("Candy non valide");
            } else {
                return validMetadata;
            }
        });
    }

    @Test
    public void shouldReturnPokemonWhenIndex() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(validMetadata.getIndex(), actualMetadata.getIndex());
    }

    @Test
    public void shouldReturnPokemonWhenCP() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(validMetadata.getCp(), actualMetadata.getCp());
    }

    @Test
    public void shouldReturnPokemonWhenHP() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(validMetadata.getHp(), actualMetadata.getHp());
    }

    @Test
    public void shouldReturnPokemonWhenDust() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(validMetadata.getDust(), actualMetadata.getDust());
    }

    @Test
    public void shouldReturnPokemonWhenCandy() throws PokedexException {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(validMetadata.getCandy(), actualMetadata.getCandy());
    }

    @Test
    public void shouldReturnTrueWhenPokemonIV() throws PokedexException {
        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        System.out.println(actualPokemon.getIv());
        assertEquals(true, actualPokemon.getIv() >= 0);
    }

    /*@Test
    public void shouldThrowExceptionWhenIndexNegative() {
        Pokemon actualMetadata = pokemonFactory.createPokemon(0,-613,64,4000,4);
        assertEquals(validMetadata, actualMetadata);
    }*/
}
