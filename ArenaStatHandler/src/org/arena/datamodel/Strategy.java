package org.arena.datamodel;

public class Strategy {
  private int id;
  private String focusDescription;
  
  public Strategy(int id, String focusDescription) {
    this.id = id;
    this.focusDescription = focusDescription;
  }
  
  public int getId() {
    return id;
  }
  
  public String getFocusDescription() {
    return focusDescription;
  }

  @Override
  public String toString() {
    return this.focusDescription;
  }
}
