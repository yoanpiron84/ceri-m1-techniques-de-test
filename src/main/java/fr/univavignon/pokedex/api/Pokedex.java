package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemonList;
    private IPokemonMetadataProvider metadataProvider;

    public Pokedex(IPokemonMetadataProvider metadataProvider) {
        this.pokemonList = new ArrayList<>();
        this.metadataProvider = metadataProvider;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.indexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemonList.size()) {
            throw new PokedexException("Invalid index: " + id);
        }
        return pokemonList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemonList);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemonList);
        Collections.sort(sortedPokemons, order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        double iv = Math.random() * 100;
        String name = null;
        int attack = 0;
        int defense = 0;
        int stamina = 0;
        try {
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            name = metadata.getName();
            attack = metadata.getAttack();
            defense = metadata.getDefense();
            stamina = metadata.getStamina();
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }
}
