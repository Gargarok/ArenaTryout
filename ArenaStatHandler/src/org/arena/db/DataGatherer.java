package org.arena.db;

import javax.xml.transform.Result;

import org.arena.datamodel.Match;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;
import org.arena.datamodel.Strategy;

/**
 * Basically, allow the data extraction and injection between a given database file in whatever the format, and Java.
 */
public interface DataGatherer {
  /**
   * @return All the different types of matches existing currently (2v2, 3v3, ...)
   */
  public MatchType[] getKnownTypes();
  
  /**
   * @return All matches results known to man. Like, Victory, Defeat, Draw, and whatever ...  
   */
  public Result[] getKnownResults();
  
  /**
   * @return All the Strategies known as of today. Typically, we can expect something like "Focus one each", "Alternate Focus", 
   * "Focus Enemy 2", etc ...  
   */
  public Strategy[] getKnownStrats();
  
  /**
   * @return All the player specializations existing in the database: supposed to contains the different 
   * combinations of classes and their specializations, along with the associated role
   */
  public Speciality[] getKnownPlayerSpecs();
  
  /**
   * @return All the matches known in the Universe (of our database).
   */
  public Match[] getAllMatches();
  
  /**
   * @param type: the type of match we seek (2v2, 3v3, 5v5, ...)
   * @return The corresponding list of Matches
   */
  public Match[] getMatchsForType(MatchType type);
  
  /**
   * Add the given match into our database, or textfile, or whatever structure we're working with.
   * @param match
   */
  public void addMatch(Match match);
  
  /**
   * Merge the given database, or file (or anything which is supposed to be into the same format as the thing we're working with)
   * into the the one we work with since the creation of this interface's implementation.
   * @param otherDbPath: the path to the other database 
   * @throws IllegalArgumentException: if the format of the file given does not correspond to what we would expect 
   */
  public void mergeDatabases(String otherDbPath) throws IllegalArgumentException;
}
