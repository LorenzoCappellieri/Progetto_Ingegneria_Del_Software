package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.DateFormat;  
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBGestione {

	private String username;
	private String password;
	
	public DBGestione(String username) {
		
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM impiegato WHERE username='"+this.username+"';"; 
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setUsername(rs.getString("username"));
				this.setPassword(rs.getString("password"));
			}
		} catch (ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}
	

	public DBGestione() {
		super();
	}
	
	public static int DBCheckup(String u,String p) {
		int x = 0 ;
		try {
	        
	        String query = "SELECT * FROM newschema.impiegato WHERE Username = '" +u+ "' and Password ='"+p+"'";
	        ResultSet rs = DBConnectionManager.selectQuery(query);
	        if(rs.next() == false)	
	        {
	        	x = 1;
	        }	       
		}catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return x;
	}
	
	
	public int CheckCf_Af(String cf) {//Check cf per Assengnazione fornitura leggermente diverso dal Check cf.
		int x = 0 ;
		try {
			
	        String query = "select * from cliente WHERE cf='"+cf+"';";
	        ResultSet rs = DBConnectionManager.selectQuery(query);
	        
	        if(rs.next() == false)	
	        {
	        	x = 1; //Riempie campi l'impiegato
	        }
	        if(cf.length()!=16){
	        x = -2; //cf errato
	        }
	        
		}catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return x;
	}
	
	
	public int CheckN(String nome){
		
		int c = 0;
		
    if(Pattern.matches("[a-zA-Z_ò_à_è_ì_ù_'_ _]+", nome)==false){                 
    	c++;
    }
    return c;
	}
	
	public int CheckC(String cognome) {
		
		int c = 0;
		
    if(Pattern.matches("[a-zA-Z_ò_à_è_ì_ù_'_ _]+", cognome)==false){                 
    	c = 2;
    }
    return c;
	}
	
	public int CheckVia(String via) {
	
	int c=0;
        
    if(Pattern.matches("[a-zA-Z_ò_à_è_ì_'_ _]+", via)==false){                 
        c++;
        //System.out.println("La via da lei inserita non rispetta il formato richiesto");
    }
    return c;
	}
	
	public int CheckCivico(String civico) {
	
	int c = 0;
		
	if(Pattern.matches("[a-zA-Z_0-9]+", civico)==false){                 
        c++;
            //System.out.println("Il civico da lei inserito non rispetta il formato richiesto");
    }
	return c;
	}
	
	public int CheckInterno(String interno) {
	
	int c = 0;
	
	if(Pattern.matches("[a-zA-Z_0-9]+", interno)==false){                 
       c++;
            //System.out.println("L'interno non rispetta il formato richiesto");
    }
	return c;
	}

	public int CheckCitta2(String citta) {
	
	int c = 0;
	
	if(Pattern.matches("[a-zA-Z_ò_à_è_ì_ù_'_ _]+", citta)==false){                 
         c++;
        // System.out.println("La città da lei inserita non rispetta il formato richiesto");
    }
	return c;
	}

	public int CheckCap(String cap) {
	
	int c = 0;
	
	if(Pattern.matches("[0-9]{5}+", cap)==false){                 
        c++;
        //System.out.println("Il CAP deve essere formato da 5 numeri.");
    }
	return c;
	}
	
	
	public void InserisciCliente(String nome,String cognome,String cf) {
		
		try {
		String query = "Select * from newschema.cliente where nome = '"+nome+"' and cognome = '"+cognome+"' and cf = '"+cf+"';";
		ResultSet rs = DBConnectionManager.selectQuery(query);
		if(rs.next() == false) {
			String query2 = "Insert into" + " newschema.cliente" + "(nome, cognome, cf)"+ "  values('"+nome+"','"+cognome+"','"+cf+"');";
		    DBConnectionManager.updateQuery(query2);
		}
		}catch (ClassNotFoundException | SQLException ex) {
	        Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
	    }
	}
		
	public int InserisciFornitura(String via, String civico, String interno, String citta, String cap, String tipo, String unita, String cf) {
		
		int id = 0;
		
		try {
		String query = "Select * from newschema.indirizzo where via = '"+via+"' and ncivico = '"+civico+"' and ninterno = '"+interno+"' and citta = '"+citta+"' and cap = '"+cap+"';";
		ResultSet rs = DBConnectionManager.selectQuery(query);
		if(rs.next() == false) {
	    String query4 = "Insert into" + " newschema.indirizzo" + "(via, ncivico, ninterno, citta, Cap, cf)"+ "  values('"+via+"','"+civico+"','"+interno+"','"+citta+"','"+cap+"','"+cf+"');";
	    DBConnectionManager.updateQuery(query4);
		}
	  
	    ResultSet rs3;
	    Double costo = 0.00;
	    String query5 = "SELECT costo FROM newschema.tariffa WHERE tipo = '"+tipo+"';";
	    rs3 = DBConnectionManager.selectQuery(query5);
	    if(rs3.next())
	    {
	    costo = rs3.getDouble("costo");
	    }

	    String query6 = "Insert into" + " newschema.fornitura" + "(tipo, costo, unita, cf, citta)"+ "  values('"+tipo+"','"+costo+"','"+unita+"','"+cf+"','"+citta+"');";
	    DBConnectionManager.updateQuery(query6);
	    
	    
	    String query7 = "SELECT id FROM newschema.fornitura WHERE tipo = '"+tipo+"' AND cf = '"+cf+"';";
	    ResultSet rs6 = DBConnectionManager.selectQuery(query7);
	    if(rs6.next() == true){
	    id = rs6.getInt("id");
	    }
	    
	    String query8 = "Insert into" + " newschema.contatore" + "(ID_Fornitura)"+ "  values('"+id+"');";
	    DBConnectionManager.updateQuery(query8);

//	    System.out.println("La fornitura creata ha questo identificativo: "+id); 

	    }catch (ClassNotFoundException | SQLException ex) {
	        Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
	    }

		return id;
		
	}
		
		
	
    public int CheckUPDirettore(String u, String p){
    	int x = 0 ;
		try {
	        
	        String query = "SELECT * FROM newschema.direttore_commerciale WHERE Username = '" +u+ "' and Password ='"+p+"'";
	        ResultSet rs = DBConnectionManager.selectQuery(query);
	        if(rs.next(	) == false)	
	        {
	        	x = 1;
	        }	       
		}catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return x;
	}
	

	public int CheckCitta(String citta) {
		int x = 0;
	
		try {
		ResultSet rsc;
		
	
		String query = "SELECT citta FROM newschema.fornitura WHERE citta = '"+citta+"'";
		rsc = DBConnectionManager.selectQuery(query);
		//media consumi annuali
		if(rsc.next() == false){
		//System.out.println("La città da lei inserita non è presente nel database.Inserirne una corretta.");
		x++;
		}
		}catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return x;	
	}
	
	public ArrayList<String> CheckTipo(String tipo){
		
			ArrayList<String> ar = new ArrayList<String>();
			int c=0;
		/*	System.out.println("Inserire il tipo della fornitura di cui si richiedono i report");
			System.out.println("     Premere 1 se si desidera generare report su ENERGIA ELETTRICA.");
			System.out.println("     Premere 2 se si desidera generare report su ACQUA.");
			System.out.println("     Premere 3 se si desidera generare report su GAS.");   */
			
			if(Pattern.matches("[1_2_3]+", tipo)==false){                 
				c++;
				//System.out.println("Ciò che ha inserito non rispetta il formato richiesto");
			}
	
		String c2 = String.valueOf(c);
		String unita = new String();
	
		if(tipo.equals("1")){
			tipo = "ENERGIA ELETTRICA";
			unita = "KiloWattOra";
		}
		if(tipo.equals("2")){
			tipo = "ACQUA";
			unita = "MetriCubi";
		}
		if(tipo.equals("3")){
			tipo = "GAS";
			unita = "MetriCubi";
		}
		ar.add(c2);
		ar.add(tipo);
		ar.add(unita);
		return ar;
	}
	
	
	
public Double GeneraRep(String citta, String tipo, String unita){
	
	Double consumi_medi = 0.00;
	
	try {
	LocalDateTime today = LocalDateTime.now(); 
	LocalDateTime oneyearago = today.minusYears(1);
	ResultSet rsq;
	String query2 = "SELECT avg(consumo) as Consumi_medi FROM newschema.db_consumi WHERE citta = '"+citta+"' and tipo = '"+tipo+"' and data > '"+oneyearago+"'";
	rsq = DBConnectionManager.selectQuery(query2);
	if(rsq.next() == true){
	consumi_medi = rsq.getDouble("Consumi_medi");
	//System.out.println(" I consumi medi mensili dell'ultimo anno per unità abitativa sono " + rsq.getDouble("Consumi_medi")+" "+unita+" per la città di "+citta+" per quanto riguarda la fornitura di "+tipo);
	}
			 
}catch (ClassNotFoundException | SQLException ex) {
Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
}
	
	return consumi_medi;
}

public int CheckDataIn(String in) {
	
	Date data_inizio = new Date();
	LocalDate today2 = LocalDate.now();
	ZoneId defaultZoneId = ZoneId.systemDefault();
	Date today = Date.from(today2.atStartOfDay(defaultZoneId).toInstant());
	
	int i = 0;
		try {
			data_inizio = new SimpleDateFormat("yyyy-mm-dd").parse(in);
		}catch (ParseException e) {
			//System.out.println("La data inserita non è valida");
			i++;
		}
		if(data_inizio.compareTo(today) > 0)
		{
			//System.out.println("La data inserita non è valida");
			i++;
		}	
		return i;
}

public ArrayList<String> CheckDataFin(String fin, String in){
		
		ArrayList<String> ar = new ArrayList<String>();
		Date data_fine = new Date();
		Date data_inizio = new Date();
		LocalDate today2 = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date today = Date.from(today2.atStartOfDay(defaultZoneId).toInstant());
		int j =0;
		//System.out.println("Inserisci la data di fine (yyyy-mm-dd) da quando vuoi sapere le analytics di questa città");
		try {
			data_fine = new SimpleDateFormat("yyyy-mm-dd").parse(fin);
		}catch (ParseException e){
			//System.out.println("La data inserita non è valida");
			j++;
		}
		if(data_fine.compareTo(today) > 0){
			//System.out.println("La data inserita non è valida");
			j++;
		}
		
		try {
			data_inizio = new SimpleDateFormat("yyyy-mm-dd").parse(in);
		} catch (ParseException e) {
			j++;
		}
		
		if(data_fine.compareTo(data_inizio) < 0){
			Date a = new Date(); 
		    a = data_inizio;
			data_inizio = data_fine;
			data_fine = a;
		}	
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String Din = dateFormat.format(data_inizio);
		String Dfin = dateFormat.format(data_fine);
		String s=String.valueOf(j); 
		ar.add(s);
		ar.add(Din);
		ar.add(Dfin);
	return ar;
}

public ArrayList<Double> GeneraStat(String city, String tipo, String in, String fin){
	
	ArrayList<Double> ar = new ArrayList<Double>();
	
	try {
	
	ResultSet rs;
	String query = "SELECT MIN(consumo) as consumo_minimo FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data between '"+in+"' and '"+fin+"'";
	Double consumo_minimo = 0.00;
	rs = DBConnectionManager.selectQuery(query);
	if(rs.next() == true){
		consumo_minimo = rs.getDouble("consumo_minimo");
	}

	ResultSet rs2;
	String query2 = "SELECT MAX(consumo) as consumo_massimo FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data between '"+in+"' and '"+fin+"'";
	rs2 = DBConnectionManager.selectQuery(query2);
	Double consumo_massimo = 0.00;
	if(rs2.next() == true){
		consumo_massimo = rs2.getDouble("consumo_massimo");
	}

	ResultSet rs3;
	String query3 = "SELECT avg(consumo) as Consumi_medi FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data between '"+in+"' and '"+fin+"'";
	rs3 = DBConnectionManager.selectQuery(query3);
	Double consumo_medio = 0.00;
	if(rs3.next() == true){
		consumo_medio = rs3.getDouble("Consumi_medi");
	}
	
	ar.add(consumo_minimo);
	ar.add(consumo_massimo);
	ar.add(consumo_medio);
			 
}catch (ClassNotFoundException | SQLException ex) {
	Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
}
	
	return ar;
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
		return "DBImpiegato [Username=" + username + ", Password=" + password + "]";
	}
	

}

