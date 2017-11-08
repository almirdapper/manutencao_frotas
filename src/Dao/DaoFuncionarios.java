package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import classe.*;
import Dao.*;
import javax.swing.JOptionPane;

public class DaoFuncionarios {

    ArrayList<Funcioario> dadosFuncionarioClass = new ArrayList<Funcioario>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public DaoFuncionarios() {

    }

    public void cadatrarFuncionarioBD(ArrayList dadosUsuariosBD) {
        dadosFuncionarioClass = dadosUsuariosBD;
        
        

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into funcioario "+
                                      "(nomeUsuario, situacao, funcao, login, senha)"
                                      + "values (?,?,?,?,?)");

            for (Funcioario f : dadosFuncionarioClass) {
                ps.setString(1, f.getNomeUsuario());
                ps.setString(2, f.getSituacao());
                ps.setString(3, f.getFuncao());
                ps.setString(4, f.getLogin());
                ps.setString(5, f.getSenha());
                               
                
               

            }
            ps.execute();
             JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso!!");

        } catch (Exception e) {
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }

}
