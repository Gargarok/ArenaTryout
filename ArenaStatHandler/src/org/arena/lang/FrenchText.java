package org.arena.lang;

public class FrenchText implements LocalText {
  private final static String MATCH_TYPE = "Type de match";
  private final static String PLAYERS = "Joueurs";
  private final static String ADD_DATA = "Données";
  private final static String STATS = "Statistiques";
  private final static String ENEMIES = "Ennemis";
  private final static String NAME = "Nom";
  private final static String ENEMY = "Ennemi";
  private final static String STRAT = "Stratégie";
  private final static String RESULT = "Résultat";
  private final static String DATE = "Date (JJ/MM/AAAA)";
  private final static String DB_MERGE = "Fusionner avec la base de données";
  private final static String DB_MERGE_CONFIRM = "Fusionner";
  private final static String DATA_CONFIRM = "Confirmer";
  
  @Override
  public String getMatchType() {
    return MATCH_TYPE;
  }

  @Override
  public String getPlayers() {
    return PLAYERS;
  }

  @Override
  public String getAddData() {
    return ADD_DATA;
  }

  @Override
  public String getStats() {
    return STATS;
  }

  @Override
  public String getEnemies() {
    return ENEMIES;
  }

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public String getEnemy(int enemyNumber) {
    return ENEMY + " " + enemyNumber;
  }

  @Override
  public String getStrat() {
    return STRAT;
  }

  @Override
  public String getResult() {
    return RESULT;
  }

  @Override
  public String getDate() {
    return DATE;
  }

  @Override
  public String getDbMerge() {
    return DB_MERGE;
  }

  @Override
  public String getMergeConfirm() {
    return DB_MERGE_CONFIRM;
  }

  @Override
  public String getDataConfirm() {
    return DATA_CONFIRM;
  }

}
