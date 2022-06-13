package Database;

import java.net.NetworkInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBCliente {
	private String nome;
	private String cognome;
	private String cf;
	private int codcliente;
	private ArrayList<DBUnita_abitativa> proprieta;
	
	public DBCliente(String cf, int codcliente) {
		
		this.cf = cf;
		this.codcliente = codcliente;
		this.proprieta = new ArrayList<DBUnita_abitativa>();
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

public void caricaUnita_abitativaDaDB() {
	String query = "Select * From indirizzo where cf= '"+this.cf+"';";
	try{
		ResultSet rs = DBConnectionManager.selectQuery(query);
		while(rs.next()){
			DBUnita_abitativa Ua = new DBUnita_abitativa();
			Ua.setvia(rs.getString("via"));
			Ua.setncivico(rs.getString("ncivico"));
			Ua.setnint(rs.getString("nint"));
			Ua.setcitta(rs.getString("citta"));
			Ua.setcap(rs.getString("cap"));
		}
	}catch (ClassNotFoundException | SQLException ex) {
        
        Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
	}
}


	public int CheckCf(String cf) {
		int x = 0 ;
		try {
	        
	        String query = "SELECT cf FROM newschema.cliente WHERE cf = '" +cf+ "'";
	        ResultSet rs = DBConnectionManager.selectQuery(query);
	        if(rs.next() == false && cf.length()==16)	
	        {
	        	x = 1;
	        }
	        String query1 = "SELECT cf FROM newschema.cliente_registrato WHERE cf = '"+cf+"'";
	        ResultSet rs1 = DBConnectionManager.selectQuery(query1);
	        if(rs1.next() == true && cf.length()==16)
	        {
	        	x = -1;
	        } 
	        if(cf.length()!=16){
	        x = -2;
	        }
	       
		}catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return x;
	}
	
	public int  CheckUsername(String username) {
			int i = 0;
		try {
		//do{
            i = 0;
            if (username.length()>20){
            	i = 1;
                //System.out.println("Username troppo lungo.");
            }
            
            String query2 = "SELECT username FROM newschema.cliente_registrato WHERE username = '"+username+"'";
            ResultSet rs2 = DBConnectionManager.selectQuery(query2);
            if(rs2.next() == true){
            	i = -1;
                //System.out.println("L'Username è già presente,inserirne un altro.");
                //username="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
            }
           
            //}while(username.length()>20 || username.length() == 0);
		}catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return i ;
	}
	
	public int CheckPassword(String password) {
		//do{
			
			int i = 0;
            //tastiera2.close();

            if(password.length()!=8){
               i = 1;// System.out.println("La password deve essere di 8 caratteri!");
            }
            
           // }while(password.length()!=8);
		
		return i;
	}
	
	public void Insert(String cf,String u, String p) {
		try {
			
		String query3 = "Insert into newschema.cliente_registrato (username,password,cf) values ('"+u+"','"+p+"','"+cf+"');";
        DBConnectionManager.updateQuery(query3);
       // System.out.println("La registrazione è avvenuta con successo!");
        
		}catch(ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}
	
	public ArrayList<String> scaricaCliente(String cf) {
		String query = "Select * From newschema.cliente where cf= '"+cf+"';";
		ArrayList<String> info = new ArrayList<String>();
		
		String n = new String();
		String c = new String();
		
		try{
			ResultSet rs = DBConnectionManager.selectQuery(query);
			while(rs.next()){
				n = rs.getString("nome");
				c = rs.getString("cognome");
				info.add(n);
				info.add(c);	
				
			}
		}catch (ClassNotFoundException | SQLException ex) {
	        
	        Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
		return info;
	}

	

	public DBCliente() {
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

	
	public ArrayList<DBUnita_abitativa> getProprieta() {
		return proprieta;
	}

	public void setProprieta(ArrayList<DBUnita_abitativa> proprieta) {
		this.proprieta = proprieta;
	}

	@Override
	public String toString() {
		return "DBCliente [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", codcliente=" + codcliente + "]";
	}
	
	

}