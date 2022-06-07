package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class DBCliente_registrato {
	private String username;
	private String password;
	private String cf;
	
	public DBCliente_registrato(String username) {
		
		this.username = username;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM cliente_registrato WHERE username='"+this.username+"';";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setUsername(rs.getString("username"));
				this.setPassword(rs.getString("password"));
				this.setCf(rs.getString("cf"));
				
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}

	public void InserimentoLetturaMensile(){
		try{
        	 String u;
             do{
             System.out.println("Inserisci l'Username");
             Scanner tastiera = new Scanner(System.in);
             u = tastiera.nextLine();
             
             if (u.length()>20){
                 System.out.println("Username troppo lungo.");
             }
             	
             
			 String qr = "SELECT * FROM newschema.cliente_registrato WHERE username = '"+u+"'";
			 ResultSet rs1 = DBConnectionManager.selectQuery(qr);
             if(rs1.next() == false){
                 System.out.println("L'Username non è giusto, il cliente non è registrato!.");
                 u="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
             }
             
             }while(u.length()>20 || u.length() == 0);

             String psw = new String();
             String p;
             String cf = new String();
             
             do{
             System.out.println("Inserisci Password");
             Scanner tastiera2 = new Scanner(System.in);
             p = tastiera2.nextLine();
             //tastiera2.close();

             if(p.length()!=8){
                System.out.println("La password deve essere di 8 caratteri!");
             }

             String qr6 = "SELECT * FROM newschema.cliente_registrato WHERE username = '"+u+"'";
			 ResultSet rs6 = DBConnectionManager.selectQuery(qr6);
             if(rs6.next()==true){
             psw = rs6.getString("password");
             cf = rs6.getString("cf");
             }

             if(p.equals(psw) == false){
             System.out.println("La password inserita è sbagliata");
            }

             }while(p.equals(psw) == false);
           
             int f;
             int x =0;
             String cf2 = new String();
             do {
             x =0 ;
             System.out.println("Inserisci l' id fornitura");
             Scanner tastiera1 = new Scanner(System.in);
             f = tastiera1.nextInt();


             ResultSet rs2;
             String query3 = "SELECT * FROM newschema.fornitura WHERE id = '"+f+"';";
             rs2 = DBConnectionManager.selectQuery(query3);
             if(rs2.next() == false){
                 System.out.println("L'id della fornitura non esiste!.");  
                 x++;
             }
             else{
                 cf2 = rs2.getString("cf");
             }
             
             if(cf2.compareTo(cf) != 0 && x==0){
                System.out.println("L'id della fornitura inserita non corrisponde ad una fornitura di sua appartenenza");
             }
             
             }while((cf2.compareTo(cf) != 0));
                          
             
             double l = 0.00;     //lettura inserita piu nuova
             double l1 = 0.00;    //lettura 1  mese fa
             do {
             System.out.println("Inserisci la lettura");
             Scanner tastiera1 = new Scanner(System.in);
             l = tastiera1.nextDouble();

             String qr4 = "SELECT * FROM newschema.lettura WHERE ID_Fornitura = '"+f+"';";
             ResultSet rs4 = DBConnectionManager.selectQuery(qr4);
			 
             if(rs4.next()) {
             l1 = rs4.getDouble("Lettura_Aggiornata");
             }
             
             if(l > l1){
                String query2 = "UPDATE newschema.lettura SET Lettura_Aggiornata = '"+l+"', Lettura_Precedente = '"+l1+"' WHERE ID_Fornitura = '"+f+"';";
				DBConnectionManager.updateQuery(query2);
            }

            if(l < l1){
             System.out.println("La lettura inserita è minore dell'ultima lettura inserita");
            }

            }while(l < l1);

            System.out.println("La lettura inserita è stata inserita correttamente.");

            double consumo_mensile;
            
            consumo_mensile=l-l1;
            
            java.sql.Date date = new java.sql.Date(0000-00-00);           //da cambiare

            String city = new String();
            String tipo = new String();

            String qr8 = "SELECT * FROM newschema.fornitura WHERE id = '"+f+"'";
            ResultSet rs5 = DBConnectionManager.selectQuery(qr8);

            if(rs5.next()){
            city = rs5.getString("citta");
            tipo = rs5.getString("tipo");
            }

        
			String query3 = "Insert into" + " newschema.db_consumi" + "(consumo,idfornitura, data,citta,tipo)"+ "  values('"+consumo_mensile+"','"+f+"','"+date+"','"+city+"','"+tipo+"')";
			DBConnectionManager.updateQuery(query3);
            
        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
        }

	}

public void VisualizzaFattura(){
    try{
        	 String u;
             do{
             System.out.println("Inserisci l'Username");
             Scanner tastiera = new Scanner(System.in);
             u = tastiera.nextLine();
             
             if (u.length()>20){
                 System.out.println("Username troppo lungo.");
             }
             	
             ResultSet rs1;
             String query= "SELECT * FROM newschema.cliente_registrato WHERE username = '"+u+"';";
             rs1 = DBConnectionManager.selectQuery(query);
             if(rs1.next() == false){
                 System.out.println("L'Username non è giusto, il cliente non è registrato!.");
                 u="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
             }
             
             }while(u.length()>20 || u.length() == 0);

             String psw = new String();
             String p;
             String cf = new String();

             do{
             System.out.println("Inserisci Password");
             Scanner tastiera2 = new Scanner(System.in);
             p = tastiera2.nextLine();
             //tastiera2.close();

             if(p.length()!=8){
                System.out.println("La password deve essere di 8 caratteri!");
             }

             ResultSet rs6;
             String query2 = "SELECT * FROM newschema.cliente_registrato WHERE username = '"+u+"';";
             rs6 = DBConnectionManager.selectQuery(query2);
             if(rs6.next()==true){
             psw = rs6.getString("password");
             cf = rs6.getString("cf");
             }

             if(p.equals(psw) == false){
             System.out.println("La password inserita è sbagliata");
            }

             }while(p.equals(psw) == false);
           
             int f;
             int x;
             String cf2 = new String();
             do {
              x=0;
             System.out.println("Inserisci l' id fornitura");
             Scanner tastiera1 = new Scanner(System.in);
             f = tastiera1.nextInt();
             
             ResultSet rs2;
             String query3 = "SELECT * FROM newschema.fornitura WHERE id = '"+f+"';";
             rs2 = DBConnectionManager.selectQuery(query3);
             if(rs2.next() == false){
                 System.out.println("L'id della fornitura non esiste!.");  
                 x++;
             }
             else{
                 cf2 = rs2.getString("cf");
             }
             
             if(cf2.compareTo(cf) != 0 && x==0){
                System.out.println("L'id della fornitura inserita non corrisponde ad una fornitura di sua appartenenza");
             }
             
             }while((cf2.compareTo(cf) != 0));
            

            double l2 = 0.00;
            double l1 = 0.00;
            ResultSet rs3;
            String query4 = "SELECT * FROM newschema.lettura WHERE ID_Fornitura = "+f;
            rs3 = DBConnectionManager.selectQuery(query4);
            if(rs3.next()) {
            l2 = rs3.getDouble("Lettura_Precedente");
            l1 = rs3.getDouble("Lettura_Aggiornata");
            }

            double consumo_mensile = l1 - l2;
            double costo = 0.00;
            String unita = new String();
            String tipo = new String();
            ResultSet rs4;
            String query5 = "SELECT * FROM newschema.fornitura WHERE id = "+f;
            rs4 = DBConnectionManager.selectQuery(query5);
            if(rs4.next()) {
                costo = rs4.getDouble("costo");
                unita = rs4.getString("unita");
                tipo = rs4.getString("tipo");
            }
            
            costo = consumo_mensile * costo;
            System.out.println("Fattura Generata");
            System.out.println();
            System.out.println("La quota mensile che le spetta da pagare per la vostra fornitura di "+tipo+" è di: "+costo);
            System.out.println("La cifra è stata calcolata su un consumo di "+consumo_mensile+" "+unita);
            }catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
            }         
    }

	public DBCliente_registrato() {
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "DBCliente_registrato [username=" + username + ", password=" + password + ", cf=" + cf + "]";
	}
	
	
	
	
}
