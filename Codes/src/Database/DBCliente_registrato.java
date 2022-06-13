package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


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
	
	public ArrayList<String> CheckUPClienteReg(String u, String p){
		
		ArrayList<String> ar = new ArrayList<String>();
		int x = 0 ;
		String cf = new String();
		try {
	        
	        String query = "SELECT * FROM newschema.cliente_registrato WHERE Username = '" +u+ "' and Password ='"+p+"'";
	        ResultSet rs = DBConnectionManager.selectQuery(query);
	        if(rs.next() == false)	
	        {
	        	x = 1;
	        }
	        else
	        cf = rs.getString("cf");
		}catch(ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		String x2 = String.valueOf(x);
		ar.add(x2);
		ar.add(cf);
		return ar;
	}
	
	
	public int CheckFornitura(String fornitura, String cf) {
		int i = 0 ;
		String cf2 = new String();
		try {
        
		ResultSet rs2;
        String query3 = "SELECT * FROM newschema.fornitura WHERE id = '"+fornitura+"';";
        rs2 = DBConnectionManager.selectQuery(query3);
        if(rs2.next() == false){
            //System.out.println("L'id della fornitura non esiste!.");  
            i = 1;
        }
        else{
            cf2 = rs2.getString("cf");
        }
        
        if(cf2.compareTo(cf) != 0 && i==0){
        	i = 2;
           //System.out.println("L'id della fornitura inserita non corrisponde ad una fornitura di sua appartenenza");
        }
		} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
        }
		return i;
	}	
	

	public int CheckLettura(String fornitura, Double lettura){
	      
           double l1 = 0.00;    //lettura 1  mese fa
           int i = 0;
           try {
           String qr4 = "SELECT * FROM newschema.contatore WHERE ID_Fornitura = '"+fornitura+"';";
           ResultSet rs4 = DBConnectionManager.selectQuery(qr4);
			 
           if(rs4.next()) {
           l1 = rs4.getDouble("Lettura_Aggiornata");
           }
           
           if(lettura > l1){
              String query2 = "UPDATE newschema.contatore SET Lettura_Aggiornata = '"+lettura+"', Lettura_Precedente = '"+l1+"' WHERE ID_Fornitura = '"+fornitura+"';";
				DBConnectionManager.updateQuery(query2);
          }

          if(lettura < l1){
          // System.out.println("La lettura inserita è minore dell'ultima lettura inserita");
        	  i = 1;
          }
     
          //System.out.println("La lettura inserita è stata inserita correttamente.");	
           double consumo_mensile = lettura-l1;
           
           LocalDate today = LocalDate.now();

           String city = new String();
           String tipo = new String();

           String qr8 = "SELECT * FROM newschema.fornitura WHERE id = '"+fornitura+"'";
           ResultSet rs5 = DBConnectionManager.selectQuery(qr8);

           if(rs5.next()){
           city = rs5.getString("citta");
           tipo = rs5.getString("tipo");
           }

       
			String query3 = "Insert into" + " newschema.db_consumi" + "(consumo,idfornitura, data,citta,tipo)"+ "  values('"+consumo_mensile+"','"+fornitura+"','"+today+"','"+city+"','"+tipo+"')";
			DBConnectionManager.updateQuery(query3);
           
           } catch  (ClassNotFoundException | SQLException ex) {
               Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
           }            
           return i;
	}



             
public ArrayList<String> Genera_e_VisualizzaFattura(String fornitura) {
	
			ArrayList<String> ar = new ArrayList<String>() ;
		
			try {
			
			double l2 = 0.00;
            double l1 = 0.00;
            ResultSet rs3;
            String query4 = "SELECT * FROM newschema.contatore WHERE ID_Fornitura = "+fornitura;
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
            String query5 = "SELECT * FROM newschema.fornitura WHERE id = "+fornitura;
            rs4 = DBConnectionManager.selectQuery(query5);
            if(rs4.next()) {
                costo = rs4.getDouble("costo");
                unita = rs4.getString("unita");
                tipo = rs4.getString("tipo");
            }
            
            costo = consumo_mensile * costo;
           /* System.out.println("Fattura Generata");
            System.out.println();
            System.out.println("La quota mensile che le spetta da pagare per la vostra fornitura di "+tipo+" è di: "+costo);
            System.out.println("La cifra è stata calcolata su un consumo di "+consumo_mensile+" "+unita); */
            String costo1=String.valueOf(costo);
            String consumo_mensile1=String.valueOf(consumo_mensile);
            
            ar.add(tipo);
    		ar.add(costo1);
    		ar.add(unita);
    		ar.add(consumo_mensile1);
    		
            }catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
            } 
		
		
		return ar;
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


