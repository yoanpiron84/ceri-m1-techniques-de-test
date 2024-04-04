package fr.univavignon.pokedex.api;
/**
 * Factory interface for class that aims to create IPokedex instance.
 *
 * @author fv
 */
public interface IPokedexFactory {
/**
 * Creates a new pokedex instance using the given
 * <code>metadataProvider</code> and <code>pokemonFactory</code>.
 *
 * @param metadataProvider Metadata provider the created pokedex will use.
 * @param pokemonFactory Pokemon factory the created pokedex will use.
 * @return Created pokedex instance.
 */
IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);
}
