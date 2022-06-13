package Entity;

import java.util.ArrayList;

import Database.DBCliente;

public class EntityCliente {
	private String nome;
	private String cognome;
	private String cf;     //PK
	private int codcliente;   //PK
	private ArrayList<EntityUnita_abitativa> proprieta;
	
	public EntityCliente(String cf, int codcliente) {
		
		DBCliente cliente = new DBCliente(cf,codcliente);
		
		this.nome = cliente.getNome();
		this.cognome = cliente.getCognome();
		this.cf = cf;
		this.codcliente = codcliente;
		this.proprieta = new ArrayList<EntityUnita_abitativa>();
		cliente.caricaUnita_abitativaDaDB();
		caricaUnita_abitativa(cliente);
		
	}
	
	public EntityCliente(DBCliente cliente) {
		
		this.nome = cliente.getNome();
		this.cognome = cliente.getCognome();
		this.cf = cliente.getCf();
		this.codcliente = cliente.getCodcliente();
		cliente.caricaUnita_abitativaDaDB();
		caricaUnita_abitativa(cliente);
		
	}
	
	public static int CheckCf(String cf) {
		int ret = 0;
		DBCliente cliente = new DBCliente();
		ret = cliente.CheckCf(cf);
		return ret;
	}
	
	public static int CheckUsername(String user) {
		int ret = 0;
		DBCliente cliente = new DBCliente();
		ret = cliente.CheckUsername(user);
		return ret;
	}
	
	public static int CheckPassword(String psw) {
		int ret = 0;
		DBCliente cliente = new DBCliente();
		ret = cliente.CheckPassword(psw);
		return ret;
	}
	
	public static void Insert(String cf, String user, String psw) {
		DBCliente cliente = new DBCliente();
		cliente.Insert(cf,user,psw);
	}

	public static ArrayList<String> scaricaCliente(String cf) {
		ArrayList<String> info = new ArrayList<String>();
		DBCliente c = new DBCliente();
		info = c.scaricaCliente(cf);
		return info;
	}
	
	public EntityCliente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public int getCodcliente() {
		return codcliente;
	}

	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}
	
	

	public ArrayList<EntityUnita_abitativa> getProprieta() {
		return proprieta;
	}

	public void setProprieta(ArrayList<EntityUnita_abitativa> proprieta) {
		this.proprieta = proprieta;
	}

	@Override
	public String toString() {
		return "EntityCliente [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", codcliente=" + codcliente
				+ "]";
	}
	
	public void caricaUnita_abitativa(DBCliente cliente) {
		for(int i = 0;i<cliente.getProprieta().size();i++ ){
			EntityUnita_abitativa v = new EntityUnita_abitativa(cliente.getProprieta().get(i));
			this.proprieta.add(v);
		}
	}
	
	
}