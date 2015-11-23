package it.uniclam.rilevamento_presenze;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.*;

public class Sessione_Utente {
	
	private Sessione_Utente(){

	}
	
	private static Sessione_Utente istance;
	public UserBean cu;
	
	public static Sessione_Utente getIstance(){
		if(istance==null){
			istance = new Sessione_Utente();
		}
		return istance;
	}
	
	public void Populate_User(UserBean user){
		cu = user;
	}
	
	
	
}
