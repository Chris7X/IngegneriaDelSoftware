package it.uniclam.rilevamento_presenze;

import it.uniclam.rilevamento_presenze.BeanClass.UtenteBean;
import it.uniclam.rilevamento_presenze.JDBCDataAccessObject.UtenteJDBCDAO;

public class TestMain {
	public static void main(String[] args) {
		UtenteJDBCDAO dipendente = new UtenteJDBCDAO();
		UtenteBean utenteBean = new UtenteBean();
		//utenteBean.setNome("");
		// Displaying Data
		dipendente.findAll();
	}
}
