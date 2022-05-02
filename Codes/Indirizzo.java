public class Indirizzo {
private String via;
private int ncivico;
private int nint;
private String citta;
private int cod_postale;

public Indirizzo(String via,int ncivico,int nint,String citta,int cod_postale){
    this.via = via;
    this.ncivico = ncivico;
    this.nint = nint;
    this.citta = citta;
    this.cod_postale = cod_postale;
}

public String getvia(){return via;}
public int getncivico(){return ncivico;}
public int getnint(){return nint;}
public String getcitta(){return citta;}
public int getcod_postale(){return cod_postale;}

public void setvia(String via){this.via = via;}
public void setncivico(int ncivico){this.ncivico = ncivico;}
public void setint(int nint){this.nint = nint;}
public void setcitta(String citta){this.citta = citta;}
public void setcod_postale(int cod_postale){this.cod_postale = cod_postale;}
    
}

