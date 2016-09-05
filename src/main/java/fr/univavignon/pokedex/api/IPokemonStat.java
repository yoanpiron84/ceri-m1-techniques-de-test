package fr.univavignon.pokedex;

/**
 * Simple interface for Pokemon stats.
 *
 * @author fv
 */
public interface IPokemonStat {

  /**
   * Stamina level getter.
   *
   * @return Stamina level.
   */
  int getStamina();

  /**
   * Defense level getter.
   *
   * @return Defense level.
   */
  int getDefense();

  /**
   * Attack level getter.
   *
   * @return Attack level.
   */
  int getAttack();

  /**
   * Maximum combat point (CP) getter.
   *
   * @return Maximum combat point.
   */
  int getMaximumCombatPoint();

}
