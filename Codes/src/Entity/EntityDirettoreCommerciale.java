package Entity;

import Database.DBDirettore_commerciale;

public class EntityDirettoreCommerciale {
	private String username;
	private String password;
	
public EntityDirettoreCommerciale(String username) {
		
		DBDirettore_commerciale impiegato = new DBDirettore_commerciale(username);
		
		this.username = impiegato.getUsername();
		this.password = impiegato.getPassword();
		
	}
	
	public EntityDirettoreCommerciale(DBDirettore_commerciale direttore) {
		
		this.username = direttore.getUsername();
		this.password = direttore.getPassword();
		
	}
	
	
	public EntityDirettoreCommerciale() {
		super();
	}

	public void GeneraReport() {
		DBDirettore_commerciale direttore = new DBDirettore_commerciale();
		direttore.GeneraReport();
	}

	public void GeneraStatistiche() {
		DBDirettore_commerciale direttore = new DBDirettore_commerciale();
		direttore.GeneraStatistiche();
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
		return "EntityDirettoreCommerciale [username=" + username + ", password=" + password + "]";
	}
	
	
}
