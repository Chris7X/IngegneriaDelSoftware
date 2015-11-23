package it.uniclam.rilevamento_presenze;

public class TestMain {
	public static void main(String[] args) {
		UtenteJDBCDAO dipendente = new UtenteJDBCDAO();
		UtenteBean utenteBean = new UtenteBean();
		//utenteBean.setNome("");
		// Displaying Data
		dipendente.findAll();
	}
}
