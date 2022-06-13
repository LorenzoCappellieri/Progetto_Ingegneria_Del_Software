package Control;

import Entity.EntityGestione;
import Entity.EntityCliente;
import Entity.EntityCliente_Registrato;
import java.util.ArrayList;

public class Controller {
	
	
	
	public static int CheckCf(String cf) {
		EntityCliente cliente = new EntityCliente();
		return cliente.CheckCf(cf);
	}
	
	public static int CheckUsername(String user) {
		EntityCliente cliente = new EntityCliente();
		return cliente.CheckUsername(user);
	}
	
	public static int CheckPassword(String psw) {
		EntityCliente cliente = new EntityCliente();
		return cliente.CheckPassword(psw);
	}
	
	public static void Insert(String cf, String user, String psw) {
		EntityCliente cliente = new EntityCliente();
		cliente.Insert(cf,user,psw);
	}
	
	public static ArrayList<String> CheckUPClienteReg(String username, String password) {
		EntityCliente_Registrato cr = new EntityCliente_Registrato();
		return cr.CheckUPClienteReg(username, password);
	}

	
	public static int CheckFornitura(String fornitura, String cf) {
		EntityCliente_Registrato cr = new EntityCliente_Registrato();
		return cr.CheckFornitura(fornitura,cf);
	}
	
	public static int CheckLettura(String fornitura, Double lettura) {
		EntityCliente_Registrato cr = new EntityCliente_Registrato();
		return cr.CheckLettura(fornitura,lettura);
	}
	
	public static ArrayList<String> Genera_e_VisualizzaFattura(String fornitura) {
		ArrayList<String> ret = new ArrayList<String>();
		EntityCliente_Registrato cliente = new EntityCliente_Registrato();
		ret = cliente.Genera_e_VisualizzaFattura(fornitura);
		return ret;
	}
	
	
	public static int CheckUPDirettore(String username, String password){
		
		EntityGestione direttore = new EntityGestione();
		return direttore.CheckUPDirettore(username, password);
	
	}
	
	public static int CheckCitta(String citta){
		
		EntityGestione direttore = new EntityGestione();
		return direttore.CheckCitta(citta);
		
	}
	
	public static ArrayList<String> CheckTipo(String tipo){
		ArrayList<String> ret = new ArrayList<String>();
		EntityGestione direttore = new EntityGestione();
		ret = direttore.CheckTipo(tipo);
		return ret;
	}
	
	public static Double GeneraRep(String citta, String tipo, String unita){
		Double ret = 0.00;
		EntityGestione direttore = new EntityGestione();
		ret = direttore.GeneraRep(citta,tipo,unita);
		return ret;
	}
	


public static int CheckDataIn(String in){
	int ret = 0;
	EntityGestione direttore = new EntityGestione();
	ret = direttore.CheckDataIn(in);
	return ret;
}

public static ArrayList<String> CheckDataFin(String fin, String in){
	ArrayList<String> ret = new ArrayList<String>(); 
	EntityGestione direttore = new EntityGestione();
	ret = direttore.CheckDataFin(fin,in);
	return ret;
}

public static ArrayList<Double> GeneraStat(String city, String tipo, String in, String fin){
	ArrayList<Double> ret = new ArrayList<Double>(); 
	EntityGestione direttore = new EntityGestione();
	ret = direttore.GeneraStat(city,tipo,in,fin);
	return ret;
}

public static int Checkup(String u,String p) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.Checkup(u,p);
	return ret;
}


public static int CheckCf_Af(String cf) {
	EntityGestione impiegato = new EntityGestione();
    return impiegato.CheckCf_Af(cf);
}



public static int CheckN(String nome) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckN(nome);
	return ret;
}

public static int CheckC(String cognome) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckC(cognome);
	return ret;
}

public static int CheckVia(String via) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckVia(via);
	return ret;
}

public static int CheckCivico(String civico) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckCivico(civico);
	return ret;
}


public static int CheckInterno(String nint) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckInterno(nint);
	return ret;
}


public static int CheckCitta2(String citta) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckCitta2(citta);
	return ret;
}

public static int CheckCap(String cap) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.CheckCap(cap);
	return ret;
}


public static void InserisciCliente(String nome, String cognome, String cf) {
	EntityGestione impiegato = new EntityGestione();
	impiegato.InserisciCliente(nome,cognome,cf);
}

public static int InserisciFornitura(String via, String civico, String interno, String citta, String cap, String tipo, String unita, String cf) {
	int ret = 0;
	EntityGestione impiegato = new EntityGestione();
	ret = impiegato.InserisciFornitura(via, civico, interno, citta, cap, tipo, unita, cf);
	return ret;
}


public static ArrayList<String> scaricaCliente(String cf) {
	
	ArrayList<String> info = new ArrayList<String>();
	EntityCliente cl = new EntityCliente();
	info = cl.scaricaCliente(cf);
	return info;
}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
