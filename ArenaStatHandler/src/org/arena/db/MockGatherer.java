package org.arena.db;

import org.arena.datamodel.Match;
import org.arena.datamodel.MatchResult;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;

/*
 * Debug purposes only.
 * TODO: Delete, please
 */
public class MockGatherer implements DataGatherer {

  @Override
  public MatchType[] getKnownTypes() {
    MatchType mt1 = new MatchType(1, "2v2", 2);
    MatchType mt2 = new MatchType(2, "3v3", 3);
    MatchType mt3 = new MatchType(3, "5v5", 5);
    return new MatchType[]{mt1, mt2, mt3}; 
  }

  @Override
  public MatchResult[] getKnownResults() {
    MatchResult r1 = new MatchResult(1, "Super Win");
    MatchResult r2 = new MatchResult(2, "Stomp Lose");
    MatchResult r3 = new MatchResult(3, "All decided to have lunch together");
    return new MatchResult[] {r1, r2, r3};
  }

  @Override
  public Strategy[] getKnownStrats() {
    Strategy s1 = new Strategy(1, "Focus Horse");
    Strategy s2 = new Strategy(2, "Focus everyone");
    Strategy s3 = new Strategy(3, "No focus");
    return new Strategy[]{s1, s2, s3};
  }

  @Override
  public Speciality[] getKnownPlayerSpecs() {
    Speciality s1 = new Speciality(1, "Mathemagician", "Wizard", "Annoyer");
    Speciality s2 = new Speciality(2, "Holy Knight", "Thug", "Annoyer");
    Speciality s3 = new Speciality(3, "Wanderer", "Thug", "Murderer");
    return new Speciality[]{s1, s2, s3};
  }

  @Override
  public Match[] getAllMatches() {
    return new Match[0];  // No return: too annoying to build 
  }

  @Override
  public Match[] getMatchsForType(MatchType type) {
    return new Match[0];  // Same
  }

  @Override
  public void addMatch(Match match) {
    // Adding Match ...
    System.out.println("Adding match " + match + " ... ");
    // Match added. So easy.
  }

  @Override
  public void mergeDatabases(String otherDbPath) throws IllegalArgumentException {
    System.out.println("Foreign base " + otherDbPath + " does not have the correct format.");
    throw new IllegalArgumentException();  // Ah-ah.
  }

}
