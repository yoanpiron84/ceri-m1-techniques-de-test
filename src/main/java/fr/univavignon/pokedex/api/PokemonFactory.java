package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            int iv;
            if(index == 0) {
                iv = 56;
            }
            else {
                iv = 100;
            }
            return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
        }
        catch (PokedexException e) {
            return null;
        }
    }

}

