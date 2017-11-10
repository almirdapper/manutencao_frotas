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
    ArrayList<Condutor> arrayListDadosCondutor = new ArrayList<Condutor>();
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
    
        public void cadatrarCondutorBD(ArrayList dadosUsuariosBD) {
        
            arrayListDadosCondutor = dadosUsuariosBD;
        
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into funcioario "
                    + "(nomeUsuario, situacao, funcao, login, senha,cnh,categoriaCnh, celular)"
                    + "values (?,?,?,?,?,?,?,?)");
            
            for (Condutor f : arrayListDadosCondutor) {
                ps.setString(1, f.getNomeUsuario());
                ps.setString(2, f.getSituacao());
                ps.setString(3, f.getFuncao());
                ps.setString(4, f.getLogin());
                ps.setString(5, f.getSenha());
                ps.setString(6, f.getCnh());
                ps.setString(7, f.getCategoriaCnh());
                ps.setInt(8, f.getCelular());
                
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
    
    public void alterarFuncionarioBD (ArrayList dadosFuncionarioAlterar){
        dadosFuncionarioClass = dadosFuncionarioAlterar;
        
        
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("update funcioario set nomeUsuario=?,"+ 
                                        "situacao=?,"+
                                        "funcao=?,"+
                                        "login=?,"+
                                        "senha=?"+
                                        "where idUsuario=?");
            
            
            for (Funcioario f : dadosFuncionarioClass) {
                ps.setString(1, f.getNomeUsuario());
                ps.setString(2, f.getSituacao());
                ps.setString(3, f.getFuncao());
                ps.setString(4, f.getLogin());
                ps.setString(5, f.getSenha());
                ps.setInt   (6, f.getIdUsuario());
            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuário Alterado com Sucesso!!");
            
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
            ps = conn.prepareStatement("select idUsuario, nomeUsuario,situacao,funcao,login from funcioario where login != 'null'");
            
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
    
     public ArrayList listarCondutorBD() {
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idUsuario,\n" +
"                                      nomeUsuario,\n" +
"                                      situacao,\n" +
"                                      funcao ,\n" +
"                                      cnh,\n" +
"                                      categoriaCnh,\n" +
"                                      celular\n" +
"                                      from funcioario where cnh!= 'null'");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Condutor funcioario = new Condutor();
                funcioario.setIdUsuario(rs.getInt("idUsuario"));
                funcioario.setNomeUsuario(rs.getString("nomeUsuario"));
                funcioario.setSituacao(rs.getString("situacao"));
                funcioario.setFuncao(rs.getString("funcao"));
                funcioario.setCnh(rs.getString("cnh"));
                funcioario.setCategoriaCnh(rs.getString("categoriaCnh"));
                funcioario.setCelular(rs.getInt("celular"));
                
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
