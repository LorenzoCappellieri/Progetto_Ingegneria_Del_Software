package Entity;



import Database.DBGestione;
import java.util.ArrayList;

public class EntityGestione {




	private String username;     //PK
	private String password;
	
	
	public EntityGestione(String username) {
		
		DBGestione impiegato = new DBGestione(username);
		
		this.username = impiegato.getUsername();
		this.password = impiegato.getPassword();
		
	}
	
	public EntityGestione(DBGestione impiegato) {
		
		this.username = impiegato.getUsername();
		this.password = impiegato.getPassword();
		
	}
	
	
	public int CheckUPDirettore(String username,String password){
		int ret = 0;
		DBGestione direttore = new DBGestione();
		ret = direttore.CheckUPDirettore(username, password);
		return ret;
	}
	
	
	public int CheckCitta(String citta) {
		int ret = 0;
		DBGestione direttore = new DBGestione();
		ret = direttore.CheckCitta(citta);
		return ret;
	}

	
	public ArrayList<String> CheckTipo(String tipo){
		ArrayList<String> ret = new ArrayList<String>();
		DBGestione direttore = new DBGestione();
		ret = direttore.CheckTipo(tipo);
		return ret;
	}
	
	public Double GeneraRep(String citta, String tipo, String unita) {
		Double cons = 0.00;
		DBGestione direttore = new DBGestione();
		cons = direttore.GeneraRep(citta, tipo, unita);
		return cons;
	}
	
	public int CheckDataIn(String in) {
		int ret = 0;
		DBGestione direttore = new DBGestione();
		ret = direttore.CheckDataIn(in);
		return ret;
	}
	
	public ArrayList<String> CheckDataFin(String fin, String in) {
		ArrayList<String> ret = new ArrayList<String>();
		DBGestione direttore = new DBGestione();
		ret = direttore.CheckDataFin(fin,in);
		return ret;
	}
	
	public ArrayList<Double> GeneraStat(String city, String tipo, String in, String fin) {
		ArrayList<Double> ret = new ArrayList<Double>();
		DBGestione direttore = new DBGestione();
		ret = direttore.GeneraStat(city,tipo,in,fin);
		return ret;
	}
	
	public static int CheckCf_Af(String cf) {
		int ret = 0;
		DBGestione imp = new DBGestione();
		ret = imp.CheckCf_Af(cf);
		return ret;
	}
	

	public int Checkup(String u,String p) {
		DBGestione imp = new DBGestione();
		return imp.DBCheckup(u,p);
	}
	
	public int CheckN(String nome) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckN(nome);
		return ret;
	}
	
	public int CheckC(String cognome) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckC(cognome);
		return ret;
	}
	
	public int CheckVia(String via) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckVia(via);
		return ret;
	}
	
	public int CheckCivico(String civico) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckCivico(civico);
		return ret;
	}
	
	public int CheckInterno(String interno) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckInterno(interno);
		return ret;
	}
	
	public int CheckCitta2(String citta) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckCitta2(citta);
		return ret;
	}
	
	public int CheckCap(String cap) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.CheckCap(cap);
		return ret;
	}
	
	public void InserisciCliente(String nome,String cognome, String cf) {
		DBGestione impiegato = new DBGestione();
		impiegato.InserisciCliente(nome, cognome, cf);
	}
	
	public int InserisciFornitura(String via, String civico, String interno, String citta, String cap, String tipo, String unita, String cf) {
		int ret = 0;
		DBGestione impiegato = new DBGestione();
		ret = impiegato.InserisciFornitura(via, civico, interno, citta, cap, tipo, unita, cf);
		return ret;
	}
	
	
	public EntityGestione() {
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

