package Control;

import Entity.EntityCliente;
import Entity.EntityCliente_Registrato;
import Entity.EntityImpiegato;


public class prova {

  public static void main(String[] args) {
    // TODO Auto-generated   method stub
    
    EntityCliente c = new EntityCliente ();
    c.Registrazione();
    
    
    EntityCliente_Registrato cr = new EntityCliente_Registrato("Vincenzo");
    cr.InserimentoLetturaMensile();

    EntityImpiegato im = new EntityImpiegato("Vincenzo");
    im.AssegnazioneFornitura();
    
    

  }  

}
