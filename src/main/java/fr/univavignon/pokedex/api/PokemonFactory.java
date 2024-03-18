package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{

    private final IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata metadata;
        try {
            metadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            e.printStackTrace();
            return new Pokemon(index, null, 0, 0, 0, cp, hp, dust, candy, 0.0);
        }

        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(),
                metadata.getStamina(), cp, hp, dust, candy, Math.random() * 100);
    }

}

