package Database; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBDirettore_commerciale {
	private String username;
	private String password;

		public DBDirettore_commerciale(String username) {
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
	
	public void GeneraReport(){

		try{
				String city;
				ResultSet rsc;
				int x = 0;
			do{
				x = 0;
				System.out.println("Inserisci la città di cui si richiedono le statistiche.");
				Scanner tastiera1 = new Scanner(System.in);
				city = tastiera1.nextLine();
		
				String query = "SELECT citta FROM newschema.fornitura WHERE citta = '"+city+"'";
				rsc = DBConnectionManager.selectQuery(query);
				//media consumi annuali
				if(rsc.next() == false){
				System.out.println("La città da lei inserita non è presente nel database.Inserirne una corretta.");
				x++;
				}
			}while(x != 0);
				
			int c=0;
			String tipo;
			do{
				c=0;
				System.out.println("Inserire il tipo della fornitura di cui si richiedono i report");
				System.out.println("     Premere 1 se si desidera generare report su ENERGIA ELETTRICA.");
				System.out.println("     Premere 2 se si desidera generare report su ACQUA.");
				System.out.println("     Premere 3 se si desidera generare report su GAS.");
				Scanner tastiera = new Scanner(System.in);
				tipo = tastiera.nextLine();
				if(Pattern.matches("[1_2_3]+", tipo)==false){                 
					c++;
					System.out.println("Ciò che ha inserito non rispetta il formato richiesto");
				}
			}while(c!=0);
			
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
			LocalDateTime today = LocalDateTime.now(); 
    		LocalDateTime oneyearago = today.minusYears(1);
			ResultSet rsq;
			String query2 = "SELECT avg(consumo) as Consumi_medi FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data > '"+oneyearago+"'";
			rsq = DBConnectionManager.selectQuery(query2);
			if(rsq.next() == true){
			System.out.println(" I consumi medi mensili per persona sono " + rsq.getDouble("Consumi_medi")+" "+unita+" per la città di "+city+" per quanto riguarda la fornitura di "+tipo);
			}
					 
		}catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}

	public void GeneraStatistiche(){

		try{
				String city;
				ResultSet rsc;
				int x =0;
			do{
				x = 0;
				System.out.println("Inserisci la città di cui si richiedono le statistiche.");
				Scanner tastiera1 = new Scanner(System.in);
				city = tastiera1.nextLine();
		
				String query = "SELECT citta FROM newschema.fornitura WHERE citta = '"+city+"'";
				rsc = DBConnectionManager.selectQuery(query);
	
				if(rsc.next() == false){
				System.out.println("La città da lei inserita non è presente nel database.Inserirne una corretta.");
				x++;
				}
			}while(x != 0);

			String data1 = new String();
			Date data_inizio = new Date();
			LocalDate today2 = LocalDate.now();
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Date today = Date.from(today2.atStartOfDay(defaultZoneId).toInstant());
			int i = 0;
			int j = 0;
			do{
				i = 0;
				System.out.println("Inserisci la data d'inizio (yyyy-mm-dd) da quando vuoi sapere le analytics di questa città");
				Scanner tastiera1 = new Scanner(System.in);
				data1 = tastiera1.nextLine();
				try {
				data_inizio=new SimpleDateFormat("yyyy-mm-dd").parse(data1);
				}catch (ParseException e) {
					System.out.println("La data inserita non è valida");
					i++;
				}
				if(data_inizio.compareTo(today) > 0)
				{
					System.out.println("La data inserita non è valida");
					i++;
				}	
			}while(i != 0);

			String data2 = new String();
			Date data_fine = new Date();
			do{
				j =0;
				System.out.println("Inserisci la data di fine (yyyy-mm-dd) da quando vuoi sapere le analytics di questa città");
				Scanner tastiera2 = new Scanner(System.in);
				data2 = tastiera2.nextLine();
				try {
				data_fine=new SimpleDateFormat("yyyy-mm-dd").parse(data2);
				}catch (ParseException e){
					System.out.println("La data inserita non è valida");
					j++;
				}
				if(data_fine.compareTo(today) > 0){
					System.out.println("La data inserita non è valida");
					j++;
				}
			}while(j != 0);

			if(data_fine.compareTo(data_inizio) < 0){
				Date a; 
			    a = data_inizio;
				data_inizio = data_fine;
				data_fine = a;
			}

			String tipo = new String();
			int c;
			do{
				c=0;
				System.out.println("Inserire il tipo della fornitura di cui si richiedono i report");
				System.out.println("     Premere 1 se si desidera generare report su ENERGIA ELETTRICA.");
				System.out.println("     Premere 2 se si desidera generare report su ACQUA.");
				System.out.println("     Premere 3 se si desidera generare report su GAS.");
				Scanner tastiera = new Scanner(System.in);
				tipo = tastiera.nextLine();
				if(Pattern.matches("[1_2_3]+", tipo)==false){                 
					c++;
					System.out.println("Ciò che ha inserito non rispetta il formato richiesto");
				}
			}while(c!=0);
			
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

			LocalDate data_ini = data_inizio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate data_fin = data_fine.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			ResultSet rs;
			String query = "SELECT MIN(consumo) as consumo_minimo FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data between '"+data_ini+"' and '"+data_fin+"'";
			Double consumo_minimo = 0.00;
			rs = DBConnectionManager.selectQuery(query);
			if(rs.next() == true){
				consumo_minimo = rs.getDouble("consumo_minimo");
			}

			ResultSet rs2;
			String query2 = "SELECT MAX(consumo) as consumo_massimo FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data between '"+data_ini+"' and '"+data_fin+"'";
			rs2 = DBConnectionManager.selectQuery(query2);
			Double consumo_massimo = 0.00;
			if(rs2.next() == true){
				consumo_massimo = rs2.getDouble("consumo_massimo");
			}

			ResultSet rs3;
			String query3 = "SELECT avg(consumo) as Consumi_medi FROM newschema.db_consumi WHERE citta = '"+city+"' and tipo = '"+tipo+"' and data between '"+data_ini+"' and '"+data_fin+"'";
			rs3 = DBConnectionManager.selectQuery(query3);
			Double consumo_medio = 0.00;
			if(rs3.next() == true){
				consumo_medio = rs3.getDouble("Consumi_medi");
			}

			System.out.println("Analytics generate: ");

			System.out.println("Ecco il consumo minimo nel periodo "+data_ini+"  -  "+data_fin+" : "+consumo_minimo+" "+unita);
			System.out.println("Ecco il consumo massimo nel periodo "+data_ini+"  -  "+data_fin+" : "+consumo_massimo+" "+unita);
			System.out.println("Ecco il consumo medio nel periodo "+data_ini+"  -  "+data_fin+" : "+consumo_medio+" "+unita);
					 
		}catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}
    
	
	public DBDirettore_commerciale() {
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
		return "DBDirettoreCommerciale [username=" + username + ", password=" + password + "]";
	}
	
	
}