package org.arena.datamodel;

public class MatchType {
  private int id;
  private String name;
  private int playerNumber;
  final static private int maxPlayerNumber = 5;

  public MatchType(int id, String name, int playerNumber) {
    this.id = id;
    this.name = name;
    this.playerNumber = playerNumber;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPlayerNumber() {
    return this.playerNumber;
  }
  
  public String entryCreation() {
	  return  "INSERT INTO match_types(id, name, player_number)" +
			  "VALUES (" + id + ", " + name + "," + playerNumber +")";
  }
  
  public static String tableCreation() {
	  return  "CREATE TABLE match_types(" +
			  "id	INT	PRIMARY KEY	NOT NULL," +
			  "name	VARCHAR(127)	NOT NULL," +
			  "player_number	INT	NOT NULL)";
  }
  
  public static int getMaxPlayers(){
	  return maxPlayerNumber;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
