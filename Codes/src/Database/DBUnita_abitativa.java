package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUnita_abitativa {
    private String via;
    private String ncivico;
    private String nint;
    private String citta;
    private String cap;

    public DBUnita_abitativa (String via,String ncivico, String nint,String citta,String cap){
        this.via = via ;
        this.ncivico = ncivico;
        this.nint = nint;
        this.citta = citta;
        this.cap = cap;
        caricaDaDB();
    }

        public void caricaDaDB(){
            String query = "Select * from indirizzo where via ='"+this.via+"' and ncivico ='"+this.ncivico+"' and nint = '"+nint+"' and citta = '"+citta+"' and cap ='"+cap+"';";
            try{
                ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.setvia(rs.getString("via"));
				this.setncivico(rs.getString("ncivico"));
				this.setnint(rs.getString("nint"));
				this.setcitta(rs.getString("citta"));
                this.setcap(rs.getString("cap"));
			}
		} catch (ClassNotFoundException | SQLException ex) {
           
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
		}
	}
    public DBUnita_abitativa() {
        super();
      }
    
      public String getvia() {
        return via;
      }
    
      public void setvia(String via) {
        this.via = via;
      }
    
      public String getncivico() {
        return ncivico;
      }
    
      public void setncivico(String ncivico) {
        this.ncivico = ncivico;
      }
    
      public String getnint() {
        return nint;
      }
    
      public void setnint(String nint) {
        this.nint = nint;
      }
    
      public String getcitta() {
        return citta;
      }
    
      public void setcitta(String citta) {
        this.citta = citta;
      }

      public String getcap() {
        return cap;
      }
    
      public void setcap(String cap) {
        this.cap = cap;
      }
    
      @Override
      public String toString() {
        return "DBIndirizzo [via=" + via + ", ncivico=" + ncivico  + ", nint=" + nint + ", citta =" + citta + ",cap=" +cap+"]";
      }
      
      
    
    }
