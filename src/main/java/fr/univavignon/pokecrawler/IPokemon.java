package fr.univavignon.pokecrawler;

/**
 *
 * @author fv
 */
public interface IPokemon {

  /**
   *
   *
   * @return
   */
  String getName();

  /**
   *
   *
   * @return
   */
  int getIndex();

  /**
   *
   *
   * @return
   */
  IPokemonStat getStats();

}
