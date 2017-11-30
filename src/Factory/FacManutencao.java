package Factory;

import java.util.ArrayList;
import classe.Manutencao;
import Dao.DaoManutencao;

public class FacManutencao implements Listar{
    Manutencao manutencao = new Manutencao();
    ArrayList<Manutencao> dadosManutencao =  new ArrayList<Manutencao>();
    DaoManutencao daoManutencao = new DaoManutencao();
    
    public FacManutencao(){
        
    }
    
    public void cadastrarManutencao(String TipoManutencao, String placa, String DescricaoManutencao, String StatusManutencao, String DataManutencao, String numeroOS){
         manutencao.setTipoManutencao(TipoManutencao);
         manutencao.setPlaca(placa);
         manutencao.setDataManutencao(DataManutencao);
         manutencao.setStatusManutencao(StatusManutencao);
         manutencao.setDataManutencao(DataManutencao);
         manutencao.setNumeroOS(numeroOS);
         
         dadosManutencao.add(manutencao);
         daoManutencao.cadatrarFuncionarioBD(dadosManutencao);
         
    }

    @Override
    public ArrayList listar() {
        dadosManutencao = daoManutencao.listarManutencaoBD();
        return  dadosManutencao;
    }

}
