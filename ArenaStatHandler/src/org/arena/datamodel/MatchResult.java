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
  
  @Override
  public String toString() {
    return this.description;
  }
}
