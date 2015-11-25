package it.uniclam.rilevamento_presenze;
import it.uniclam.rilevamento_presenze.BeanClass.UserBean;

//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;

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
