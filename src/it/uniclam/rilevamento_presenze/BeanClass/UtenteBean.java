package it.uniclam.rilevamento_presenze.BeanClass;

import java.io.Serializable;

/*
https://books.google.it/books?id=VymiT1pHYE0C&pg=PA403&lpg=PA403&dq=serializable+java+cos%27%C3%A8&source=bl&ots=7PzHYYJaf3&sig=s21MG6NvXaJ9VxuBqDg6VKt-LLo&hl=it&sa=X&ved=0CDsQ6AEwB2oVChMInZ2cwsSTyQIVgUwUCh19BguC#v=onepage&q=serializable%20java%20cos%27%C3%A8&f=false
https://books.google.it/books?id=rjztAgAAQBAJ&pg=PT820&lpg=PT820&dq=serializable+java+cos%27%C3%A8&source=bl&ots=MxJGeKugzT&sig=9TNkqqQ0dSyzwbSwzxnt4JebN3A&hl=it&sa=X&ved=0CEEQ6AEwCWoVChMInZ2cwsSTyQIVgUwUCh19BguC#v=onepage&q=serializable%20java%20cos%27%C3%A8&f=false
Il processo di serializzazione consiste nel memorizzare e recuperare oggetti in un file esterno,leggere e scrivere oggetti di ogni tipo di classe
    Una Java Bean è una classe scritta secondo la regola che la qualificano tale:
 *  1)deve avere un costruttore public senza argo
  * 2)le variabili d'istanza dovrebbero essere private
  * 3)deve contenere metodi get() e set() accedendo alle variabili desiderate*/

public class UtenteBean implements Serializable {
	int ID_User;
	String Cognome;//Cognome
	String Nome;//Nome
	String Telefono;//Telefono
    String Email;//Email address
    String Username;
    String Password;
    int Role_ID;



	public UtenteBean() {

	}

	public UtenteBean(int id_user ,String nome, String cognome, String username,String password ,int role_id,String telefono,String email) {

		this.ID_User=id_user;
        this.Cognome= cognome;
		this.Nome= nome;
		this.Telefono= telefono;
        this.Email=email;
        this.Username=username;
        this.Password=password;
        this.Role_ID=role_id;
	}

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int id_user) {
        this.ID_User = id_user;
    }

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		this.Cognome = cognome;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = Password;
    }

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int role_id) {
        this.Role_ID = role_id;
    }

}

