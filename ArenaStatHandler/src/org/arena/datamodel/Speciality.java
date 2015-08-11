package org.arena.datamodel;

/**
 * A player's class and talent specialization, along with his role (Tank/DPS/Heal)
 */
public class Speciality {
  private String specName;
  private String className;
  private String role;  // Would usually be DPS / Heal / Tank / Panda 
  
  public Speciality(String specName, String className, String role) {
    this.specName = specName;
    this.className = className;
    this.role = role;
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
}
