package org.arena.db;

import org.arena.datamodel.MatchResult;
import org.arena.datamodel.MatchType;
import org.arena.datamodel.Speciality;

/**
 * Regroup known cases of static tables
 */

public class Cases {
	public static enum matchResultID
		{
			WIN(0),
			LOOSE(1),
			DRAW(2);
		
			public final int value;
			private matchResultID(int value){
				this.value = value;
			}
		}
	
	public static enum roles
	{
		DPS("'DPS'"),
		HEAL("'HEAL'"),
		TANK("'TANK'");
		
		public final String value;
		private roles(String value){
			this.value = value;
		}
	}
	
	public static MatchResult[] matchResultCases = 
		{
			new MatchResult(matchResultID.WIN.value, "'WIN'"),
			new MatchResult(matchResultID.LOOSE.value, "'LOOSE'"),
			new MatchResult(matchResultID.DRAW.value, "'DRAW'")				
		};
	
	public static MatchType[] matchTypeCases =
		{
				new MatchType(0, "'Arena'", 2),
				new MatchType(1, "'Arena'", 3),
				new MatchType(2, "'Arena'", 5),
				new MatchType(3, "'Battle Ground'", 2),
				new MatchType(4, "'Battle Ground'", 3),
				new MatchType(5, "'Battle Ground'", 5)
		};
	
	public static Speciality[] specialityCases =
		{
				new Speciality("'Amelioration'", "'Chaman'", roles.DPS.value),
				new Speciality("'Restauration'", "'Chaman'", roles.HEAL.value),
				new Speciality("'Elementaire'", "'Chaman'", roles.DPS.value)
		};
		
}
