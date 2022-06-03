package Entity;

import Database.DBCliente_registrato;

public class EntityCliente_Registrato {
	private String username;   //PK
	private String password;
	private String cf;
	
public EntityCliente_Registrato(String username) {
		
		DBCliente_registrato clientereg = new DBCliente_registrato(username);
		
		this.username = username;
		this.password = clientereg.getPassword();
		this.cf = clientereg.getCf();
	}
	
	public EntityCliente_Registrato(DBCliente_registrato clientereg) {
		
		this.username = clientereg.getUsername();
		this.password = clientereg.getPassword();
		this.cf = clientereg.getCf();
		
	}
	
	public EntityCliente_Registrato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void InserimentoLetturaMensile() {
		DBCliente_registrato cliente = new DBCliente_registrato();
		cliente.InserimentoLetturaMensile();
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "EntityCliente_Registrato [username=" + username + ", password=" + password + ", cf=" + cf + "]";
	}
	
	
	
}
