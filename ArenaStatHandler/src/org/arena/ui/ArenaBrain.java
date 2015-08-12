package org.arena.ui;

import org.arena.datamodel.Match;
import org.arena.datamodel.MatchResult;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;
import org.arena.db.DataGatherer;
import org.arena.lang.FrenchText;
import org.arena.lang.LocalText;

public class ArenaBrain {
  public static final String LANG_FR = "fr";
  
  private LocalText textManager; 
  private final DataGatherer dataManager;
  
  public ArenaBrain(String langCode, DataGatherer dataManager) {
    this.dataManager = dataManager;
    this.textManager = languageFactory(langCode);
  }
  
  public LocalText getLang() {
    return this.textManager;
  }
  
  public MatchType[] getModes() {
    return dataManager.getKnownTypes();
  }
  
  public Strategy[] getStrats() {
    return dataManager.getKnownStrats();
  }
  
  public MatchResult[] getResults() {
    return dataManager.getKnownResults();
  }
  
  public Speciality[] getSpecialities() {
    return dataManager.getKnownPlayerSpecs();
  }
  
  public void mergeDb(String otherDb) {
    this.dataManager.mergeDatabases(otherDb);
  }
  
  public void addMatch(Match matchToAdd) {
    this.dataManager.addMatch(matchToAdd);
  }
  
  // TODO: english file and default as english
  private static LocalText languageFactory(String language) {
    switch (language) {
      case LANG_FR:
        return new FrenchText();
      default: 
        return new FrenchText();
    }
  }
}
