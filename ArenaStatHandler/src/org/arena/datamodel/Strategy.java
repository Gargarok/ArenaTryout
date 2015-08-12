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

  public String entryCreation() {
	  return  "INSERT INTO strategy(id, description)" +
			  "VALUES (" + id + ", " + focusDescription + ")";
  }
  
  public static String tableCreation() {
	  return  "CREATE TABLE strategy(" +
			  "id	INT	PRIMARY KEY	NOT NULL," +
			  "description	VARCHAR(255)	NOT NULL)";
  }
  
  public String toString() {
    return this.focusDescription;
  }
}
