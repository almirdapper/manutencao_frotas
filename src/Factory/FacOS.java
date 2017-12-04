package Factory;

import Dao.*;
import classe.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FacOS {

    DaoOS daoOS = new DaoOS();
    OrdemDeServico os = new OrdemDeServico();
    ArrayList<OrdemDeServico> dadosOS = new ArrayList<OrdemDeServico>();

    public FacOS() {

    }

    public void cadastrarItem(String descricaoItem) {
        os.setItemOS(descricaoItem);
        dadosOS.add(os);
        daoOS.cadatrarItemBD(dadosOS);
    }

    public ArrayList listaItemCombobox() {

        dadosOS = daoOS.listarItemBD();

        return dadosOS;
    }

    public void cadastrarServico(String descricaoItem) {
        os.setServico(descricaoItem);
        dadosOS.add(os);
        daoOS.cadatrarServicoBD(dadosOS);
    }

    public ArrayList listaServicoCombobox() {

        dadosOS = daoOS.listarServicoBD();

        return dadosOS;
    }

    public ArrayList salvarListaItens(String item) {
        ArrayList<ItemOs> listaItens = new ArrayList<ItemOs>();
        ItemOs itemOs = new ItemOs();
        itemOs.setDescricaoItem(item);

        listaItens.add(itemOs);
        for (ItemOs i : listaItens) {
            JOptionPane.showMessageDialog(null, i.getDescricaoItem());
        }

        return listaItens;
    }

    public void cadastrarOs(String data,  String placadoVeiculo, String status, String item,  String servico,  String observacao) {
        os = new OrdemDeServico();
        os.setData(data);
        os.setPlacaVeiculo(placadoVeiculo);
        os.setStatus(status);
        os.setItemOS(item);
        os.setServico(servico);
        os.setObservacao(observacao);
        dadosOS.add(os);
        
        daoOS.cadatrarOSBD(dadosOS);

    }
    
    public ArrayList listarOsAberta (){
       
        dadosOS = daoOS.listarOSBD();
        
        return dadosOS;
    }
    
    public void alterarOs (int id, String data,  String placadoVeiculo, String status, String item,  String servico,  String observacao){
        os = new OrdemDeServico();
        os.setIdOs(id);
        os.setData(data);
        os.setPlacaVeiculo(placadoVeiculo);
        os.setStatus(status);
        os.setItemOS(item);
        os.setServico(servico);
        os.setObservacao(observacao);
        dadosOS.add(os);
        
        daoOS.alterarOSBD(dadosOS);
    }

    
    public ArrayList listarOSid(int id){
        dadosOS = daoOS.listarOSidBD(id);
        return dadosOS;
    }
}
