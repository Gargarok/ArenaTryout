package org.arena.datamodel;

/**
 * A player's class and talent specialization, along with his role (Tank/DPS/Heal)
 */
public class Speciality {
  private int id;
  private String specName;
  private String className;
  private String role;  // Would usually be DPS / Heal / Tank / Panda 
  
  public Speciality(int id, String specName, String className, String role) {
    this.id = id;
    this.specName = specName;
    this.className = className;
    this.role = role;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getSpecName() {
    return specName;
  }
  
  public String getClassName() {
    return className;
  }
  
  public String getRole() {
    return role;
  }
  
  @Override
  public String toString() {
    return this.className + " " + this.specName + " (" + this.role + ")";
  }
}
