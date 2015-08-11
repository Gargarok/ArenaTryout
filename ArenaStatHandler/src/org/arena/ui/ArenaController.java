package org.arena.ui;


public class ArenaController {
  private final ArenaBrain theBrain;
  private ArenaWindow arenaView;
  
  public ArenaController(ArenaBrain theBrain) {
    this.theBrain = theBrain;
    this.arenaView = new ArenaWindow(theBrain.getLang(), theBrain.getModes(), theBrain.getStrats(), theBrain.getResults(), theBrain.getSpecialities());
  }
  
  public void startWindow() {
    this.arenaView.initComponents(e -> mergeDatabaseAction(), e -> addMatchAction());
  }
  
  private void mergeDatabaseAction() {
    //TODO: refer to the brain and give him the necessary info
  }
  
  private void addMatchAction() {
    // TODO: refer to the brain AND give him what he needs to know
  }
  
}
