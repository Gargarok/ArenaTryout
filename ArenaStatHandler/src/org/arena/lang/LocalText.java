package org.arena.lang;

/**
 * Localised text corresponding to a given language.
 */
public interface LocalText {
  public String getMatchType();
  public String getPlayers();
  public String getAddData();
  public String getStats();
  public String getEnemies();
  public String getName();
  public String getEnemy(int enemyNumber);
  public String getStrat();
  public String getResult();
  public String getDate();
  public String getDbMerge();
  public String getMergeConfirm();
  public String getDataConfirm();
}
