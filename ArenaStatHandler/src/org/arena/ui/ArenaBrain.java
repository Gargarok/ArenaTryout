package org.arena.ui;

import javax.xml.transform.Result;

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
  
  public ArenaBrain(String lang, DataGatherer dataManager) {
    this.dataManager = dataManager;
    this.textManager = languageFactory(lang);
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
  
  public Result[] getResults() {
    return dataManager.getKnownResults();
  }
  
  public Speciality[] getSpecialities() {
    return dataManager.getKnownPlayerSpecs();
  }
  
  private static LocalText languageFactory(String language) {
    switch (language) {
      case LANG_FR:
        return new FrenchText();
      default: 
        return new FrenchText();
    }
  }
}
