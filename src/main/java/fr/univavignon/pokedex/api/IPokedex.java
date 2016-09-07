package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

/**
 * Pokedex definition.
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

  /**
   * Retrieves n-th best pokemon of the pokedex using the given <tt>comparator</tt>.
   *
   * @param comparator Comparator to use to compare two pokemons.
   * @param n Number of higher pokemon to retrieve.
   * @return List of pokemon that are higher regarding of the given <tt>comparator</tt>
   * @throws IllegalArgumentException If the given comparator is <tt>null</tt> or the limit is less or equals than 0.
   */
  List<IPokemon> get(Comparator<IPokemon> comparator, int n);

  /**
   * Retrieves fifth best pokemon of the pokedex using the given <tt>comparator</tt>.
   *
   * @param comparator Comparator to use to compare two pokemons.
   * @return List of pokemon that are higher regarding of the given <tt>comparator</tt>
   * @throws IllegalArgumentException If the given comparator is <tt>null</tt>.
   */
  default List<IPokemon> get(final Comparator<IPokemon> comparator) {
    return get(comparator, 5);
  }

  /**
   * Retrieves the best pokemon of the pokedex using the given <tt>comparator</tt>.
   *
   * @param comparator Comparator to use to compare two pokemons.
   * @return Best pokemon regarding of the given <tt>comparator</tt>.
   * @throws IllegalArgumentException If the given comparator is <tt>null</tt>
   */
  default IPokemon getBest(final Comparator<IPokemon> comparator) {
    return get(comparator, 1).get(0);
  }

}
