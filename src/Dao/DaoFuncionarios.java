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
            ps = conn.prepareStatement("insert into funcioario "
                    + "(nomeUsuario, situacao, funcao, login, senha)"
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
        } finally {
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
    
    public ArrayList buscarFuncionarioBD(int idFuncionario) {
        
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idUsuario, nomeUsuario,situacao,funcao,login from funcioario where idUsuario=?");
            
            ps.setInt(1, idFuncionario);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Funcioario funcioario = new Funcioario();
                funcioario.setIdUsuario(rs.getInt("idUsuario"));
                funcioario.setNomeUsuario(rs.getString("nomeUsuario"));
                funcioario.setSituacao(rs.getString("situacao"));
                funcioario.setFuncao(rs.getString("funcao"));
                funcioario.setLogin(rs.getString("login"));
                
                dadosFuncionarioClass.add(funcioario);
                
            }
            
            ps.execute();
            
        } catch (Exception e) {
            System.err.println(e);
            
        } finally {
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
        return dadosFuncionarioClass;
    }
    
    public ArrayList listarFuncionariosBD() {
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idUsuario, nomeUsuario,situacao,funcao,login from funcioario");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Funcioario funcioario = new Funcioario();
                funcioario.setIdUsuario(rs.getInt("idUsuario"));
                funcioario.setNomeUsuario(rs.getString("nomeUsuario"));
                funcioario.setSituacao(rs.getString("situacao"));
                funcioario.setFuncao(rs.getString("funcao"));
                funcioario.setLogin(rs.getString("login"));
                
                dadosFuncionarioClass.add(funcioario);
                
            }
            
            ps.execute();
            
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return dadosFuncionarioClass;
    }
}
