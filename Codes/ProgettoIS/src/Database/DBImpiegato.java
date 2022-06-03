package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBImpiegato {

	private String username;
	private String password;
	
	public DBImpiegato(String username) {
		
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
	

	public DBImpiegato() {
		super();
		// TODO Auto-generated constructor stub
	}


    public void AssegnazioneFornitura(){
        String tipo = new String(); 
        String cf = new String();

        try{

        String nome;
        int c;
        do{
        c=0;
        System.out.println("Inserire il nome del nuovo cliente");
        Scanner tastiera = new Scanner(System.in);
        nome = tastiera.nextLine();
        
        if(Pattern.matches("[a-zA-Z_ò_à_è_ì_ù_'_ _]+", nome)==false){                 
            c++;
            System.out.println("Il nome da lei inserito non è valido");
        }
        }while(c!=0);

        String cognome;

        do{
            c=0;
            System.out.println("Inserire il cognome del nuovo cliente");
            Scanner tastiera = new Scanner(System.in);
            cognome = tastiera.nextLine();
            
            if(Pattern.matches("[a-zA-Z_ò_à_è_ì_ù_'_ _]+", cognome)==false){                 
                c++;
                System.out.println("Il cognome da lei inserito non è valido");
            }
            }while(c!=0);


        do{
            ResultSet rs2;
            c=0;
            System.out.println("Inserire il codice fiscale del nuovo cliente");
            Scanner tastiera = new Scanner(System.in);
            cf = tastiera.nextLine();
            
            if(Pattern.matches("[a-zA-Z_0-9]{16}+", cf)==false){                 
                c++;
                System.out.println("Il codice fiscale da lei inserito non è valido");
            }
            String qr2 = "SELECT cf FROM newschema.cliente WHERE cf = '"+cf+"';";
            rs2 = DBConnectionManager.selectQuery(qr2); 
    
            if(rs2.next() == true)
            {
            System.out.println("Il codice fiscale da lei inserito è già presente nel database. Il cliente è già registrato.");
            System.exit(0);
            }
            }while(c!=0);
    
        String via;

        do{
            c=0;
            System.out.println("Inserire la via dell'abitazione nella quale si vuole aprire una fornitura ");
            Scanner tastiera = new Scanner(System.in);
            via = tastiera.nextLine();
                
            if(Pattern.matches("[a-zA-Z_ò_à_è_ì_'_ _]+", via)==false){                 
                c++;
                System.out.println("La via da lei inserita non rispetta il formato richiesto");
            }
            }while(c!=0);
        
            String num_civico;

        do{
            c=0;
            System.out.println("Inserire il numero civico dell'abitazione nella quale si vuole aprire una fornitura ");
            Scanner tastiera = new Scanner(System.in);
            num_civico = tastiera.nextLine();
                    
            if(Pattern.matches("[a-zA-Z_0-9]+", num_civico)==false){                 
                c++;
                System.out.println("Il civico da lei inserito non rispetta il formato richiesto");
            }
            }while(c!=0);

        String num_interno;

        do{
            c=0;
            System.out.println("Inserire l'interno dell'abitazione nella quale si vuole aprire una fornitura ");
            Scanner tastiera = new Scanner(System.in);
            num_interno = tastiera.nextLine();
                       
            if(Pattern.matches("[a-zA-Z_0-9]+", num_interno)==false){                 
                c++;
                System.out.println("L'interno non rispetta il formato richiesto");
            }
            }while(c!=0);

        String citta;
                
        do{
            c=0;
            System.out.println("Inserire la città dove è locata l'abitazione");
            Scanner tastiera = new Scanner(System.in);
            citta = tastiera.nextLine();
                
            if(Pattern.matches("[a-zA-Z_ò_à_è_ì_ù_'_ _]+", citta)==false){                 
                c++;
                System.out.println("La città da lei inserita non rispetta il formato richiesto");
            }
            }while(c!=0);

        String cap;

        do{
            c=0;
            System.out.println("Inserire il CAP dell'abitazione nella quale si vuole aprire una fornitura ");
            Scanner tastiera = new Scanner(System.in);
            cap = tastiera.nextLine();
                    
            if(Pattern.matches("[0-9]{5}+", cap)==false){                 
                c++;
                System.out.println("Il CAP deve essere formato da 5 numeri.");
            }
            }while(c!=0);


        do{
            c=0;
            System.out.println("Inserire il tipo della fornitura desiderata");
            System.out.println("Deve premere 1 se il cliente desidera avere una fornitura di ENERGIA ELETTRICA.");
            System.out.println("     Premere 2 se il cliente desidera avere una fornitura di GAS.");
            System.out.println("     Premere 3 se il cliente desidera avere una fornitura di ACQUA.");
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
            tipo = "GAS";
            unita = "MetriCubi";
        }
        if(tipo.equals("3")){
            tipo = "ACQUA";
            unita = "MetriCubi";
        }

        String query3 = "Insert into" + " newschema.cliente" + "(nome, cognome, cf)"+ "  values('"+nome+"','"+cognome+"','"+cf+"');";
        DBConnectionManager.updateQuery(query3);

        String query4 = "Insert into" + " newschema.indirizzo" + "(via, ncivico, ninterno, citta, Cap, cf)"+ "  values('"+via+"','"+num_civico+"','"+num_interno+"','"+citta+"','"+cap+"','"+cf+"');";
        DBConnectionManager.updateQuery(query4);
        

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
        
        
        int id = 0;
        String query7 = "SELECT id FROM newschema.fornitura WHERE tipo = '"+tipo+"' AND cf = '"+cf+"';";
        ResultSet rs6 = DBConnectionManager.selectQuery(query7);
        if(rs6.next() == true){
        id = rs6.getInt("id");
        }
        
        String query8 = "Insert into" + " newschema.lettura" + "(ID_Fornitura)"+ "  values('"+id+"');";
        DBConnectionManager.updateQuery(query8);

        System.out.println("La fornitura creata ha questo identificativo: "+id); 

        }catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger("com.mysql.cj.jdbc.Driver").log(Level.SEVERE, null, ex);
        }
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

