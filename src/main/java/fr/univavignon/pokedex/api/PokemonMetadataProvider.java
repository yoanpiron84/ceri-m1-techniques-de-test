package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    ArrayList<PokemonMetadata> pokemonMetadataArrayList;

    public PokemonMetadataProvider() {
        this.pokemonMetadataArrayList = new ArrayList<PokemonMetadata>();
        pokemonMetadataArrayList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126,90));
        pokemonMetadataArrayList.add(new PokemonMetadata(133,"Aquali",186,168,260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index > 150) {
            throw new PokedexException("Index invalid !");
        }
        for(PokemonMetadata buffer : pokemonMetadataArrayList) {
            if(buffer.getIndex() == index) {
                return buffer;
            }
        }
        return null;
    }
}

