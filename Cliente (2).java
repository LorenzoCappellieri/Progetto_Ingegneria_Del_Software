
public class Cliente {
	protected String nome;
	protected String cognome;
	protected int codice_fiscale;
	protected int codice_univoco;
	
	public Cliente(String nome, String cognome, int codice_fiscale, int codice_univoco) {
		this.nome = nome;
		this.cognome = cognome;
		this.codice_fiscale = codice_fiscale;
		this.codice_univoco = codice_univoco;
	}
	
	public void setnome(String nome) {
		this.nome =  nome;
	}
	public String getnome() {
		return this.nome;
	}
	
	public void setcognome(String cognome) {
		this.cognome = cognome;
	}
	public String getcognome() {
		return this.cognome;
	}
	public void setcodice_fiscale(int codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	public int getcodice_fiscale() {
		return this.codice_fiscale;
	}
	public void setcodice_univoco(int codice_univoco) {
		this.codice_univoco = codice_univoco;
	}
	public int getcodice_univoco() {
		return this.codice_univoco;
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
