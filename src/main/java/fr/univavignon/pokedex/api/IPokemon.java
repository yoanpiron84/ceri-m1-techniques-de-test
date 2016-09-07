package fr.univavignon.pokedex.api;

/**
 * Pokemon definition.
 *
 * @author fv
 */
public interface IPokemon {

  /**
   * Pokemon name getter.
   *
   * @return Name of this pokemon.
   */
  String getName();

  /**
   * Pokemon index getter.
   *
   * @return Index of this pokemon.
   */
  int getIndex();

  /**
   * Pokemon stats getter.
   *
   * @return Stats of this pokemon.
   */
  IPokemonStat getStats();

}
