package Control;

import Entity.EntityCliente;
import Entity.EntityCliente_Registrato;
import Entity.EntityDirettoreCommerciale;
import Entity.EntityImpiegato;


public class prova {

  public static void main(String[] args) {
    
    /* EntityCliente c = new EntityCliente ();
    c.Registrazione();
    
    
    EntityCliente_Registrato cr = new EntityCliente_Registrato("Vincenzo");
    cr.InserimentoLetturaMensile();

    EntityImpiegato im = new EntityImpiegato("Vincenzo");
    im.AssegnazioneFornitura();   

    EntityCliente_Registrato cr = new EntityCliente_Registrato("Vincenzo");
    cr.VisualizzaFattura();
    */
    //EntityCliente_Registrato cr = new EntityCliente_Registrato("Vincenzo");
    //cr.VisualizzaFattura();
    
    EntityDirettoreCommerciale dr = new EntityDirettoreCommerciale("Lollo");
    dr.GeneraReport();
  
  }  

}
