package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex;

    private Pokemon Bulbizarre;

    private Pokemon Aquali;

    private ArrayList<Pokemon> pokemonList;

    @BeforeEach
    public void setUp() throws PokedexException {

        pokemonList = new ArrayList<Pokemon>();

        pokedex = mock(IPokedex.class);

        Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);

        Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokemonList.add(Bulbizarre);
        pokemonList.add(Aquali);

        Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);

        Mockito.when(pokedex.size()).thenReturn(pokemonList.size());

        Mockito.when(pokedex.addPokemon(any(Pokemon.class))).thenAnswer(input -> {
            Pokemon inputPokemon = input.getArgument(0);
            pokemonList.add(inputPokemon);
            return pokemonList.size() - 1;
        });

        Mockito.when(pokedex.getPokemon(any(Integer.class))).thenAnswer(input -> {
            int index = input.getArgument(0);
            return pokemonList.get(index);
        });
    }

    @Test
    public void shouldReturnPokemonWhenAdd() throws PokedexException {

        int index = pokedex.addPokemon(Bulbizarre);
        assertEquals(Bulbizarre, pokedex.getPokemon(index));
    }

    @Test
    public void shouldReturnPokemonListSizeWhenSize() {
        assertEquals(pokedex.size(), pokemonList.size());
    }

    @Test
    public void shouldReturnPokemonWhenGet() throws PokedexException {
        Pokemon p = pokedex.getPokemon(0);
        assertEquals(p, pokemonList.get(0));
    }

    @Test
    public void shouldReturnPokemonListWhenGet() throws PokedexException {
        pokedex.addPokemon(Bulbizarre);
        assertEquals(pokedex.getPokemons(), pokemonList);
    }

    /*@Test
    public void shouldThrowExceptionWhenPokemonInvalid() {
        int index = pokedex.addPokemon(null);
        assertEquals(validPokemon.getIndex(), index);
    }*/


}
