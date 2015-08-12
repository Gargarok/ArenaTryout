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

  public String entryCreation() {
	  String playersString = "";
	  String insertArgs = "";
	  int i = 1;
	  
	  assert(players.size() == enemies.length);
	  assert(enemies.length == type.getPlayerNumber());
	  
	  for(Map.Entry<String, Speciality> player : players.entrySet()){
		  insertArgs += "P" + i + ", " + "P" + i + "_spe, " + "E" + i + "_spe, ";
		  playersString += player.getKey() + ", " +
				  		   player.getValue().getSpecName() + ", " +
				  		   enemies[i - 1].getSpecName() + ", ";
		  i++;
	  }
	  
	  
	  return  "INSERT INTO match(" + insertArgs + "type, result, strat, date)" +
			  "VALUES (" + playersString + 
			  			   type.getId() + "," +
			  			   result.getId() + ", " +
			  			   strat.getId() + ", " +
			  			   date.getTime() + ")";
  }
  
  public static String tableCreation() {
	  String playersString = "P1	VARCHAR(63)	NOT NULL," +
				  		   	 "P1_spe	VARCHAR(63)	NOT NULL," +
				  		     "E1_spe	VARCHAR(63)	NOT NULL,";
	  String foreignPlayerString = "FOREIGN KEY(P1_spe)	REFERENCES speciality(specname)," +
			  					   "FOREIGN KEY(E1_spe)	REFERENCES speciality(specname),";

	  for(int i = 1; i < MatchType.getMaxPlayers(); i++) {
		  playersString += "P" + (i + 1) + "	VARCHAR(63)," +
				  		   "P" + (i + 1) + "_spe	VARCHAR(63)," +
				  		   "E" + (i + 1) + "_spe	VARCHAR(63),";
		  foreignPlayerString += "FOREIGN KEY(P" + (i + 1) + "_spe)	REFERENCES speciality(specname)," +
					   			 "FOREIGN KEY(E" + (i + 1) + "_spe)	REFERENCES speciality(specname),";
		  
	  }
	  
	  return  "CREATE TABLE match(" +
			  "id INT PRIMARY KEY	NOT NULL," +
			  playersString +
			  "type	INT	NOT NULL," +
			  "result	INT	NOT NULL," +
			  "strat	INT	NOT NULL," +
			  "date	DATE NOT NULL," +
			  foreignPlayerString +
			  "FOREIGN KEY(type)	REFERENCES match_types(id)," +
			  "FOREIGN KEY(result)	REFERENCES match_results(id)," +
			  "FOREIGN KEY(strat)	REFERENCES strategy(id))";
  }
}
