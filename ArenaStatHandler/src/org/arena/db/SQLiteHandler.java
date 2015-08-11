package org.arena.db;

import javax.xml.transform.Result;

import org.arena.datamodel.Match;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;

public class SQLiteHandler implements DataGatherer {
  private final String databasePath;
  
  public SQLiteHandler(String databasePath) {
    this.databasePath = databasePath;
  }

  @Override
  public MatchType[] getKnownTypes() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Result[] getKnownResults() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Strategy[] getKnownStrats() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Speciality[] getKnownPlayerSpecs() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Match[] getMatchsForType(MatchType type) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addMatch(Match match) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mergeDatabases(String otherDbPath) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Match[] getAllMatches() {
    // TODO Auto-generated method stub
    return null;
  }

}
