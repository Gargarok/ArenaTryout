package org.arena.ui;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.UIManager;

import org.arena.datamodel.Match;
import org.arena.datamodel.MatchResult;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;


public class ArenaController {
  private final static String DATE_SEP = "/";
  private final ArenaBrain theBrain;
  private ArenaWindow arenaView;
  
  public ArenaController(ArenaBrain theBrain) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
      // Do nothing : the swing components will look the same way as the usual
      // java components
      System.out.println("No look and feel, Java components will have standard appearance");
    }
    
    this.theBrain = theBrain;
    this.arenaView = new ArenaWindow(theBrain.getLang(), theBrain.getModes(), theBrain.getStrats(), theBrain.getResults(), theBrain.getSpecialities());
  }
  
  public void startWindow() {
    this.arenaView.initComponents(e -> mergeDatabaseAction(), e -> addMatchAction());
  }
  
  private void mergeDatabaseAction() {
    this.theBrain.mergeDb(this.arenaView.getDbField());
  }
  
  private void addMatchAction() {
    Map<String, Speciality> playersMap = new HashMap<>();
    Speciality[] enemiesSpec = this.arenaView.getEnemies();
    Speciality[] playersSpec = this.arenaView.getPlayerSpec();
    String[] playersNames = this.arenaView.getPlayerNames();
    
    for (int i = 0 ; i < playersSpec.length ; i++) {
      playersMap.put(playersNames[i], playersSpec[i]);  // TODO: verify that there ain't twice the same name
    }
    MatchResult result = this.arenaView.getMatchResult();
    MatchType type = this.arenaView.getMatchType();
    Strategy strat = this.arenaView.getStrategy();
    
  //TODO: better date-safety (days <= 31, months <= 12, and such)
    String[] dateParts = this.arenaView.getDate().split(DATE_SEP);
    if (dateParts.length < 3) {    
      System.out.println("Bad date format...");  
      return;
    }
    
    //TODO: get indexes from LocalText interface (static final fields) + Integer cast check
    int days = Integer.parseInt(dateParts[0]);
    int months = Integer.parseInt(dateParts[1]) - 1;  // -1: seems like months start at 0 for some reason
    int years = Integer.parseInt(dateParts[2]);
    Calendar calendar = new GregorianCalendar();
    calendar.set(years, months, days, 0, 0, 0);
    Date date = calendar.getTime();
    
    Match newMatch = new Match(playersMap, enemiesSpec, type, result, date, strat);
    this.theBrain.addMatch(newMatch);
  }
  
}
