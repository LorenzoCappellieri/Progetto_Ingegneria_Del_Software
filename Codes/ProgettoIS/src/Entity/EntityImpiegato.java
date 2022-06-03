package Entity;


import Database.DBImpiegato;

public class EntityImpiegato {




	private String username;     //PK
	private String password;
	
	
	public EntityImpiegato(String username) {
		
		DBImpiegato impiegato = new DBImpiegato(username);
		
		this.username = impiegato.getUsername();
		this.password = impiegato.getPassword();
		
	}
	
	public EntityImpiegato(DBImpiegato impiegato) {
		
		this.username = impiegato.getUsername();
		this.password = impiegato.getPassword();
		
	}
	
	public void AssegnazioneFornitura() {
		DBImpiegato impiegato = new DBImpiegato();
		impiegato.AssegnazioneFornitura();
	}
	
	
	public EntityImpiegato() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EntityImpiegato [Username=" + username + ", Password=" + password + "]";
	}
	
	
}

