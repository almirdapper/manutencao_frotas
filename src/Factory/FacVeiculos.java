package Factory;
import classe.Veiculo;
import java.util.ArrayList;
import Dao.DaoVeiculos;

public class FacVeiculos {

    Veiculo veiculo = new Veiculo();
    DaoVeiculos daoVeiculos = new DaoVeiculos();
    ArrayList<Veiculo>dadosVeiculoFac = new ArrayList<Veiculo>();
    
    public FacVeiculos() {

    }

    public void cadastrarVeiculo(String modelo,  String marca, String placa,String ano,String descricao , String categoria, String tipo,String status) {
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setPlaca(placa);
        veiculo.setAno(ano);
        veiculo.setDescricao(descricao);
        veiculo.setCategoria(categoria);
        veiculo.setTipo(tipo);
        veiculo.setStatus(status);
        
        dadosVeiculoFac.add(veiculo);
        
        daoVeiculos.cadatrarVeiculoBD(dadosVeiculoFac);
        
    }
    
    public ArrayList buscaVeiculoPlaca (String placa){
        String placaFac = placa;
        
        dadosVeiculoFac = daoVeiculos.buscarVeiculoBD(placaFac);
        
        
        return dadosVeiculoFac;
    }

    public void alterarVeiculo(String modelo,  String marca, String placa,String ano,String descricao , String categoria, String tipo,String status) {
        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setPlaca(placa);
        veiculo.setAno(ano);
        veiculo.setDescricao(descricao);
        veiculo.setCategoria(categoria);
        veiculo.setTipo(tipo);
        veiculo.setStatus(status);
        
        dadosVeiculoFac.add(veiculo);
        
        daoVeiculos.alterarVeiculoBD(dadosVeiculoFac);
    }
    
    public ArrayList listarVeiculosFac (){
        
        dadosVeiculoFac = daoVeiculos.listarVeiculosBD();
        
        return dadosVeiculoFac;
    }
    
    public ArrayList listaPlacaComboboxFac(){
        dadosVeiculoFac = daoVeiculos.listarPlacaComboboxBD();
        return dadosVeiculoFac;
    }
}
