package Factory;

import Dao.*;
import classe.*;
import java.util.ArrayList;

public class FacOS {
 
    DaoOS daoOS = new DaoOS();
    OrdemDeServico os = new OrdemDeServico();
    ArrayList<OrdemDeServico> dadosOS = new ArrayList<OrdemDeServico>();
    
    public FacOS(){
        
    }
    
    public void cadastrarItem(String descricaoItem){
       os.setItemOS(descricaoItem);
       dadosOS.add(os);
       daoOS.cadatrarItemBD(dadosOS);
    }
    
    
    public ArrayList listaItemCombobox(){
        
        dadosOS = daoOS.listarItemBD();
        
        return dadosOS;
    }
    
     public void cadastrarServico(String descricaoItem){
       os.setServico(descricaoItem);
       dadosOS.add(os);
       daoOS.cadatrarServicoBD(dadosOS);
    }

      public ArrayList listaServicoCombobox(){
        
        dadosOS = daoOS.listarServicoBD();
        
        return dadosOS;
    }
}


