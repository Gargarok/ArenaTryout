package org.arena.datamodel;

public class MatchResult {
  private int id;
  private String description;  // Victory / Defeat / Draw / etc (Really ? What else ?)
  
  public MatchResult(int id, String description) {
    this.id = id;
    this.description = description;
  }
  public int getId() {
    return id;
  }
  public String getDescription() {
    return description;
  }
  
  public String entryCreation() {
	  return  "INSERT INTO match_results(id, description)" +
			  "VALUES (" + id + ", " + description + ")";
  }
  
  public static String tableCreation() {
	  return  "CREATE TABLE match_results(" +
			  "id	INT	PRIMARY KEY	NOT NULL," +
			  "description VARCHAR(127)	NOT NULL)";
  }
}
