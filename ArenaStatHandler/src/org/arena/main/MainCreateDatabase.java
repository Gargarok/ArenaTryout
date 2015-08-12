package org.arena.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import org.arena.datamodel.*;
import org.arena.db.Cases;

public class MainCreateDatabase {
	public enum MatchResultCases{
		WIN,
		LOOSE,
		DRAW
	};

	public static void main(String[] args) {

		
		Scanner reader = new Scanner(System.in);
		System.out.println("Name of the database to create ?");
		String db_name = reader.nextLine();
		
		if ((db_name == null) || (db_name.compareTo("") == 0)) {
			System.out.println("OK JUST LEAVE ME THEN !");
			return;
		}

		Connection connection = null;
		Statement statement = null;
		
		try {
			
			/* Create the database */
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:src/org/arena/db/" + db_name + ".db");
			
			System.out.println("Database created successfully.");

			/* Create tables */
			statement = connection.createStatement();
			statement.executeUpdate(MatchResult.tableCreation());
			statement.executeUpdate(MatchType.tableCreation());
			statement.executeUpdate(Speciality.tableCreation());
			statement.executeUpdate(Strategy.tableCreation());
			statement.executeUpdate(Match.tableCreation());
			
			System.out.println("Tables created.");
			
			/* Initialize constant tables */
			for (MatchResult entry : Cases.matchResultCases) {
				System.out.println(entry.entryCreation());
				statement.executeUpdate(entry.entryCreation());
			}
			
			for (MatchType entry : Cases.matchTypeCases) {
				System.out.println(entry.entryCreation());
				statement.executeUpdate(entry.entryCreation());
			}
			
			for (Speciality entry : Cases.specialityCases) {
				System.out.println(entry.entryCreation());
				statement.executeUpdate(entry.entryCreation());
			}
			
			statement.close();
			//connection.commit();
			connection.close();			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Done !");
	}

}
