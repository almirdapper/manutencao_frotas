
package Factory;

import classe.*;
import Dao.*;
import java.util.ArrayList;

public class FacAbastecimento {
    Abastecimento abastecimento = new Abastecimento();
    DaoAbastecimento daoAbastecimento = new DaoAbastecimento();
    ArrayList<Abastecimento> dadosAbastecimento = new ArrayList<Abastecimento>();
    
    public void FacAbastecimento (){
        
    }
    
    public void cadastrarAbastecimentoFac(int idAbasteciento, int qtdLitros,  String data , String kmAbasteceimento,  String placaVeiculo){
        abastecimento.setIdAbasteciento(idAbasteciento);
        abastecimento.setQtdLitros(qtdLitros);
        abastecimento.setData(data);
        abastecimento.setKmAbasteceimento(kmAbasteceimento);
        abastecimento.setPlacaVeiculo(placaVeiculo);
        dadosAbastecimento.add(abastecimento);
        
        daoAbastecimento.cadatrarAbastecimentoBD(dadosAbastecimento);
    }
}
