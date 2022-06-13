package Entity;

import java.util.ArrayList;
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
	}
    
	public static ArrayList<String> CheckUPClienteReg(String username, String password) {
		ArrayList<String> ret = new ArrayList<String>();
		DBCliente_registrato cr = new DBCliente_registrato();
		ret = cr.CheckUPClienteReg(username, password);
		return ret;
	}
	
	
	public static int CheckFornitura(String fornitura, String cf) {
		int ret =  0;
		DBCliente_registrato cr = new DBCliente_registrato();
		ret = cr.CheckFornitura(fornitura, cf);
		return ret;
	}
	
	public static int CheckLettura(String fornitura, Double lettura) {
		int ret = 0;
		DBCliente_registrato cr = new DBCliente_registrato();
		ret = cr.CheckLettura(fornitura, lettura);
		return ret;
	}
	

	public ArrayList<String> Genera_e_VisualizzaFattura(String fornitura) {
		ArrayList<String> ret = new ArrayList<String>();
		DBCliente_registrato cliente = new DBCliente_registrato();
		ret = cliente.Genera_e_VisualizzaFattura(fornitura);
		return ret;
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

