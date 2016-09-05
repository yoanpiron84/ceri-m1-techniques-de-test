package fr.univavignon.pokedex.api;

/**
 *
 * @author fv
 */
public interface IPokedex {

  /**
   * Retrieves a pokemon instance using the given <tt>name</tt>.
   *
   * @param name Name of the pokemon to retrieve.
   * @return Retrived pokemon.
   * @throws PokedexException If the given name is not valid.
   */
  IPokemon get(String name) throws PokedexException;

  /**
   * Retrieves a pokemon instance using the given <tt>index</tt>.
   *
   * @param index Index of the pokemon to retrieve.
   * @return Retrived pokemon.
   * @throws PokedexException If the given index is not valid.
   */
  IPokemon get(int index) throws PokedexException;

}
