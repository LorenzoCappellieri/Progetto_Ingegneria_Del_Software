package Entity;

import Database.DBCliente;

public class EntityCliente {
	private String nome;
	private String cognome;
	private String cf;     //PK
	private int codcliente;   //PK
	
	public EntityCliente(String cf, int codcliente) {
		
		DBCliente cliente = new DBCliente(cf,codcliente);
		
		this.nome = cliente.getNome();
		this.cognome = cliente.getCognome();
		this.cf = cf;
		this.codcliente = codcliente;
		
	}
	
	public EntityCliente(DBCliente cliente) {
		
		this.nome = cliente.getNome();
		this.cognome = cliente.getCognome();
		this.cf = cliente.getCf();
		this.codcliente = cliente.getCodcliente();
		
	}
	
	public void Registrazione() {
		DBCliente cliente = new DBCliente();
		cliente.Registrazione();
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

	@Override
	public String toString() {
		return "EntityCliente [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", codcliente=" + codcliente
				+ "]";
	}
	
	
}
