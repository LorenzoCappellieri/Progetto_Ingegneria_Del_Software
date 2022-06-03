package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCliente {
	private String nome;
	private String cognome;
	private String cf;
	private int codcliente;
	
	public DBCliente(String cf, int codcliente) {
		
		this.cf = cf;
		this.codcliente = codcliente;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM cliente WHERE cf='"+this.cf+"'"+"AND codcliente="+this.codcliente+";"; 
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setNome(rs.getString("nome"));
				this.setCognome(rs.getString("cognome"));
				this.setCf(rs.getString("cf"));
				this.setCodcliente(rs.getInt("codcliente"));
			}
		} catch (ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}
	
	
	public void Registrazione() {
		int x = 0 ;
		try {
			String cf;
	        do{
	        x=0;
	        System.out.println("Inserisci il codice fiscale");
	        Scanner tastiera3 = new Scanner(System.in);
	        cf = tastiera3.nextLine();
	        String query = "SELECT cf FROM newschema.cliente WHERE cf = '" +cf+ "'";
	        ResultSet rs = DBConnectionManager.selectQuery(query);
	        if(rs.next() == false && cf.length()==16)	
	        {
	        	System.out.println("Il codice fiscale da lei inserito non è presente nel database. Ci contatti per registrarsi.");
	        	System.exit(0);
	        }
	        String query1 = "SELECT cf FROM newschema.cliente_registrato WHERE cf = '"+cf+"'";
	        ResultSet rs1 = DBConnectionManager.selectQuery(query1);
	        if(rs1.next() == true && cf.length()==16)
	        {
	        System.out.println("Il codice fiscale inserito risulta gia è associato ad un utente registrato.");
	        System.exit(0);
	        } 
	        if(cf.length()!=16){
	        System.out.println("Il codice fiscale da lei inserito non ha il corretto numero di caratteri");
	        x++;
	        }
	        }while(x!=0);
	        
	        String u;
            do{
            System.out.println("Inserisci l'Username");
            Scanner tastiera = new Scanner(System.in);
            u = tastiera.nextLine();
            
            if (u.length()>20){
                System.out.println("Username troppo lungo.");
            }
            
            String query2 = "SELECT username FROM newschema.cliente_registrato WHERE username = '"+u+"'";
            ResultSet rs2 = DBConnectionManager.selectQuery(query2);
            if(rs2.next() == true){
                System.out.println("L'Username è già presente,inserirne un altro.");
                u="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
            }
            
            }while(u.length()>20 || u.length() == 0);

            String p;
            do{
            System.out.println("Inserisci Password");
            Scanner tastiera2 = new Scanner(System.in);
            p = tastiera2.nextLine();
            //tastiera2.close();

            if(p.length()!=8){
                System.out.println("La password deve essere di 8 caratteri!");
            }
            
            }while(p.length()!=8);
            
            
            String query3 = "Insert into newschema.cliente_registrato (username,password,cf) values ('"+u+"','"+p+"','"+cf+"';";
            DBConnectionManager.updateQuery(query3);
            System.out.println("La registrazione è avvenuta con successo!");
	        
            
		} catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}
	

	public DBCliente() {
		super();
		// TODO Auto-generated constructor stub
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
		return "DBCliente [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", codcliente=" + codcliente + "]";
	}
	
	

}
