package org.arena.main;

import org.arena.db.DataGatherer;
import org.arena.db.MockGatherer;
import org.arena.ui.ArenaBrain;
import org.arena.ui.ArenaController;

public class MainTest {
  
  public static void main(String[] args) {
    DataGatherer gatherer = new MockGatherer();
    ArenaBrain brain = new ArenaBrain(ArenaBrain.LANG_FR, gatherer);
    ArenaController control = new ArenaController(brain);
    control.startWindow();
  }
  
}
