package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon Bulbizarre;
    private Pokemon Aquali;
    private List<Pokemon> pokemonList;

    PokemonFactory pokemonFactory;
    PokemonMetadataProvider pokemonMetadataProvider;
    PokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp() throws PokedexException {

        pokemonFactory = new PokemonFactory();
        pokemonMetadataProvider = new PokemonMetadataProvider();
        pokedexFactory = new PokedexFactory();

        pokemonList = new ArrayList<>();
        pokedex = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());

        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        Bulbizarre = pokedex.createPokemon(0, 613, 64, 4000, 4);
        Aquali = pokedex.createPokemon(133, 2729, 202, 5000, 4);

        pokedex.addPokemon(Bulbizarre);
        pokedex.addPokemon(Aquali);

        pokemonList.add(Bulbizarre);
        pokemonList.add(Aquali);
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
        assertEquals(p, Bulbizarre);
    }

    @Test
    public void shouldReturnPokemonList() {
        assertEquals(pokedex.getPokemons(), pokemonList);
        assertNotNull(pokedex.getPokemons());
        assertNotNull(pokedex.getPokemons(PokemonComparators.NAME));
    }

    @Test
    public void shouldThrowPokedexException() throws PokedexException {
        assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(156);
        });
    }

    @Test
    public void shouldReturnPokemonMetadata() throws PokedexException {
        int index = pokedex.getPokemon(0).getIndex();
        String name = pokedex.getPokemon(0).getName();
        int attack = pokedex.getPokemon(0).getAttack();
        int defense = pokedex.getPokemon(0).getDefense();
        int stamina = pokedex.getPokemon(0).getStamina();
        assertEquals(index, pokemonMetadataProvider.getPokemonMetadata(0).getIndex());
        assertEquals(name, pokemonMetadataProvider.getPokemonMetadata(0).getName());
        assertEquals(attack, pokemonMetadataProvider.getPokemonMetadata(0).getAttack());
        assertEquals(defense, pokemonMetadataProvider.getPokemonMetadata(0).getDefense());
        assertEquals(stamina, pokemonMetadataProvider.getPokemonMetadata(0).getStamina());
        assertEquals(pokemonMetadataProvider.getPokemonMetadata(0), pokedex.getPokemonMetadata(0));
    }
}
