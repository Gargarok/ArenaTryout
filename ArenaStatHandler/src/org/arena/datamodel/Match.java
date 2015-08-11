package org.arena.datamodel;

import java.util.Date;
import java.util.Map;

public class Match {
  private Map<String,Speciality> players;
  private Speciality[] enemies;
  private MatchType type;
  private MatchResult result;
  private Date date;
  private Strategy strat;

  public Match(Map<String, Speciality> players, Speciality[] enemies,
      MatchType type, MatchResult result, Date date, Strategy strat) {
    this.players = players;
    this.enemies = enemies;
    this.type = type;
    this.result = result;
    this.date = date;
    this.strat = strat;
  }

  public Map<String, Speciality> getPlayers() {
    return this.players;
  }
  
  public Speciality[] getEnemies() {
    return this.enemies;
  }
  
  public MatchType getType() {
    return this.type;
  }
  
  public MatchResult getResult() {
    return this.result;
  }
  
  public Date getDate() {
    return this.date;
  }
  
  public Strategy getStrategy() {
    return this.strat;
  }
}
