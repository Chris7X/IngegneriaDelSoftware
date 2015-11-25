package it.uniclam.rilevamento_presenze.JDBCDataAccessObject;



import it.uniclam.rilevamento_presenze.ConnectionDB;
import it.uniclam.rilevamento_presenze.BeanClass.UtenteBean;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UtenteJDBCDAO {
	Connection connection = null;
	PreparedStatement ptmt,ptmt2 = null;
	ResultSet resultSet = null;

	public UtenteJDBCDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionDB.getInstance().getConnection();
		return conn;
	}

	public void add(UtenteBean UtenteBean) {
		try {
		 	String queryString ="INSERT INTO amici(Cognome, Nome, Telefono) VALUES(?,?,?)";
            connection = getConnection();
			ptmt = connection.prepareStatement(queryString);


           ptmt.setInt(1, UtenteBean.getID_User());
            ptmt.setString(2, UtenteBean.getCognome());
			ptmt.setString(3, UtenteBean.getNome());
			//ptmt.setString(4, UtenteBean.getTelefono());
            //ptmt.setString(5, UtenteBean.getEmail());
			ptmt.executeUpdate();
			System.out.println("Dati Inseriti Correttamente");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}



    public void add1(UtenteBean UtenteBean) {
        try {
            String queryString = "INSERT INTO amici(Cognome, Nome, Telefono) VALUES(?,?,?)";
            String queryString2 = "INSERT INTO prestiti(idPrestiti, idAmico, idLibro, DataPrestito, DataRestituzione) VALUES(?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt2 = connection.prepareStatement(queryString2);

            ptmt.setString(1, UtenteBean.getCognome());
            ptmt.setString(2, UtenteBean.getNome());
            ptmt.setString(3, UtenteBean.getTelefono());
            ptmt2.setString(3,"SETptm2");
            // ptmt.setString(4, UtenteBean.getEmail());
            ptmt.executeUpdate();
            ptmt2.executeUpdate();
            System.out.println("Dati Inseriti Correttamente");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

	public void update(UtenteBean UtenteBean) {

		try {
			String queryString = "UPDATE amici SET Cognome=? WHERE Telefono=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, UtenteBean.getCognome());
			ptmt.setString(2, UtenteBean.getTelefono());
			ptmt.executeUpdate();
			System.out.println("Aggiornamento OK");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	public void delete(int rollNo) {

		try {
			String queryString = "DELETE FROM amici WHERE RollNo=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, rollNo);
			ptmt.executeUpdate();
			System.out.println("Eliminato con SUCCESSO");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void findAll() {

        //JOptionPane.showMessageDialog("Ricerca Query Fallita",this);
        try {
            String queryString = "SELECT * FROM user";
            connection = getConnection();
            System.out.println("Prepare statement OK");
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(queryString);

            while (res.next()) {
                int id=res.getInt("ID_User");
                String nome = res.getString("Nome");
                String cognome = res.getString("Cognome");
                String telefono=res.getString("Telefono");

                System.out.println(id + "\t" + nome + "\t" + cognome+ "\t" + telefono);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public int SELECT_NameSurname(String name,String surname,String id_user) {
        GregorianCalendar gcalendar = new GregorianCalendar();
//String Nom="Christian";GregorianCalendar gcalendar = new GregorianCalendar();
  //      String Cognom="Naposli";
        //JOptionPane.showMessageDialog("Ricerca Query Fallita",this);

        int state=0;
        try {
            String queryString = "SELECT * FROM user WHERE Cognome='"+surname+"'AND Nome='"+name+"' OR ID_User='"+id_user+"' ";
            connection = getConnection();
            System.out.println("Prepare statemòent OK");
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(queryString);
          /* if (res.next()!=false){
                System.out.println("ACCESSO VALIDO");
*/
            while (res.next()==true) {
                int id=res.getInt("ID_User");
                String nome = res.getString("Nome");
                String cognome = res.getString("Cognome");
                String telefono=res.getString("Telefono");

                System.out.println(id + "\t" + nome + "\t" + cognome+ "\t" + telefono);
                state=id;}
            //if(res.next()==false) { System.out.println("ACCESSO NEGATO:Badge non valido");}

        } catch (SQLException e) {
             e.printStackTrace();
        } finally {
            try {

                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return state;
    }

}