
package Factory;

import java.util.ArrayList;
import classe.*;
import Dao.*;
import javax.swing.JOptionPane;


public class FacFuncionarios implements Listar{
    DaoFuncionarios daoFuncionarios = new DaoFuncionarios();
    Funcioario funcioario;
    ArrayList<Funcioario>arrayDadosFuncionario = new ArrayList<Funcioario>();
    
   
    
    public void cadastrarFuncionario( String nome ,String situacao,String funcao,String login,String senha ){
        funcioario = new Funcioario();
        
        funcioario.setNomeUsuario(nome);
        funcioario.setSituacao(situacao);
        funcioario.setFuncao(funcao);
        funcioario.setLogin(login);
        funcioario.setSenha(senha);             
        arrayDadosFuncionario.add(funcioario);
        for (Funcioario f : arrayDadosFuncionario){
            //JOptionPane.showMessageDialog(null, f.getNomeUsuario() +"\n"+ f.getSituacao() +"\n"+ f.getFuncao()+"\n"+ f.getLogin()+"\n"+ f.getSenha());
        }
        daoFuncionarios.cadatrarFuncionarioBD(arrayDadosFuncionario);
        
      
    }
    
    public void cadastrarCondutor( String nome ,String situacao,String funcao, String cnh, String categoriaCnh, String Telefone ){
        
        Condutor condutor = new Condutor();
        
        condutor.setNomeUsuario(nome);
        condutor.setSituacao(situacao);
        condutor.setFuncao(funcao);
        condutor.setCnh(cnh);
        condutor.setCategoriaCnh(categoriaCnh);         
        
        arrayDadosFuncionario.add(condutor);
       
        daoFuncionarios.cadatrarCondutorBD(arrayDadosFuncionario);
        
      
    }
    
    public void alterarUsuario(int idUsuario,String nome ,String situacao,String funcao,String login,String senha){
          funcioario = new Funcioario();
       
        funcioario.setIdUsuario(idUsuario);
        funcioario.setNomeUsuario(nome);
        funcioario.setSituacao(situacao);
        funcioario.setFuncao(funcao);
        funcioario.setLogin(login);
        funcioario.setSenha(senha);             
        arrayDadosFuncionario.add(funcioario);
        for (Funcioario f : arrayDadosFuncionario){
            //JOptionPane.showMessageDialog(null, f.getNomeUsuario() +"\n"+ f.getSituacao() +"\n"+ f.getFuncao()+"\n"+ f.getLogin()+"\n"+ f.getSenha());
        }
        daoFuncionarios.alterarFuncionarioBD(arrayDadosFuncionario);
        
      
    }
    
    
     public ArrayList buscarUsuario(int id){
         
         arrayDadosFuncionario =daoFuncionarios.buscarFuncionarioBD(id);
         return arrayDadosFuncionario;
     }
     
     
    
     public ArrayList listarCondutor(){
         arrayDadosFuncionario = daoFuncionarios.listarCondutorBD();
         return arrayDadosFuncionario;
     }

    @Override
    public ArrayList listar() {
        arrayDadosFuncionario = daoFuncionarios.listarFuncionariosBD();
         return arrayDadosFuncionario;
    }


}
