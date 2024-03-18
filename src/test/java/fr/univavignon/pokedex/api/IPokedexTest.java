package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon Bulbizarre;
    private Pokemon Aquali;
    private List<Pokemon> pokemonList;

    @BeforeEach
    public void setUp() {
        pokemonList = new ArrayList<>();
        pokedex = new Pokedex(new PokemonMetadataProvider());

        Bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        pokedex.addPokemon(Bulbizarre);
        pokedex.addPokemon(Aquali);
    }

    @Test
    public void shouldReturnPokemonWhenAdd() throws PokedexException {
        int index = pokedex.addPokemon(Bulbizarre);
        assertEquals(Bulbizarre, pokedex.getPokemon(index));
    }

    /*@Test
    public void shouldReturnPokemonListSizeWhenSize() {
        assertEquals(pokedex.size(), pokemonList.size());
    }*/

    @Test
    public void shouldReturnPokemonWhenGet() throws PokedexException {
        Pokemon p = pokedex.getPokemon(0);
        assertEquals(p, Bulbizarre);
    }

    /*@Test
    public void shouldReturnPokemonListWhenGet() throws PokedexException {
        assertEquals(pokedex.getPokemons(), pokemonList);
    }*/
}
