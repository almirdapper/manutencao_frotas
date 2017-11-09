
package Factory;

import java.util.ArrayList;
import classe.Funcioario;
import Dao.*;
import javax.swing.JOptionPane;


public class FacFuncionarios {
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
    
    
     public ArrayList buscarUsuario(int id){
         
         arrayDadosFuncionario =daoFuncionarios.buscarFuncionarioBD(id);
         return arrayDadosFuncionario;
     }
     
     
     public ArrayList listarUsuario(){
         arrayDadosFuncionario = daoFuncionarios.listarFuncionariosBD();
         return arrayDadosFuncionario;
     }
}
