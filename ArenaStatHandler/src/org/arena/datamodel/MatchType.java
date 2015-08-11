package org.arena.datamodel;

public class MatchType {
  private int id;
  private String name;
  private int playerNumber;

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
}
