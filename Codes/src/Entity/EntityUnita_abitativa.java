package Entity;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.DBUnita_abitativa;

public class EntityUnita_abitativa {
    private String via;
    private String ncivico;
    private String nint;
    private String citta;
    private String cap;
    private String cf;

    public EntityUnita_abitativa (String via,String ncivico, String nint,String cap){
        DBUnita_abitativa indirizzo = new DBUnita_abitativa(via,ncivico,nint,cap);

        this.via = via ;
        this.ncivico = ncivico;
        this.nint = nint;
        this.cap = cap;
        
    }

    public EntityUnita_abitativa (DBUnita_abitativa indirizzo){
        this.via = indirizzo.getvia();
        this.ncivico = indirizzo.getncivico();
        this.nint = indirizzo.getnint();
        this.citta = indirizzo.getcitta();
        this.cap = indirizzo.getcap();
        this.cf = indirizzo.getcf();
    }


    public EntityUnita_abitativa() {
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
    
      public String getcf() {
        return cf;
      }
    
      public void setcf(String cf) {
        this.cf = cf;
      }
      @Override
      public String toString() {
        return "EntityIndirizzo [via=" + via + ", ncivico=" + ncivico  + ", nint=" + nint + ", citta =" + citta + ",cap=" +cap+"]";
      }
      
    }

