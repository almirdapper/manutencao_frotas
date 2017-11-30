
package Factory;

import classe.*;
import Dao.*;
import java.util.ArrayList;

public class FacAbastecimento implements Listar{
    Abastecimento abastecimento = new Abastecimento();
    DaoAbastecimento daoAbastecimento = new DaoAbastecimento();
    ArrayList<Abastecimento> dadosAbastecimento = new ArrayList<Abastecimento>();
    
    public void FacAbastecimento (){
        
    }
    
    public void cadastrarAbastecimentoFac( int qtdLitros,  String data , String kmAbasteceimento,  String placaVeiculo){
      
        abastecimento.setQtdLitros(qtdLitros);
        abastecimento.setData(data);
        abastecimento.setKmAbasteceimento(kmAbasteceimento);
        abastecimento.setPlacaVeiculo(placaVeiculo);
        dadosAbastecimento.add(abastecimento);
        
        daoAbastecimento.cadatrarAbastecimentoBD(dadosAbastecimento);
    }
    
 

    @Override
    public ArrayList listar() {
        dadosAbastecimento = daoAbastecimento.listarAbastecimentoBD();
        
        return  dadosAbastecimento;
    }


}
