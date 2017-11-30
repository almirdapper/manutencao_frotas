package Dao;

import classe.Abastecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Factory.*;
import classe.*;

public class DaoOS {

    ArrayList<OrdemDeServico> dadosOS = new ArrayList<OrdemDeServico>();
    OrdemDeServico ordemDeServico = new OrdemDeServico();

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Abastecimento abastecimento = new Abastecimento();

    public DaoOS() {

    }

    public void cadatrarItemBD(ArrayList dadosItem) {
        dadosOS = dadosItem;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into itemos\n"
                    + "(descricaoItem)\n"
                    + "values(?);  ");

            for (OrdemDeServico o: dadosOS){
                ps.setString(1, o.getItemOS());
            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Item  Cadastrado com Sucesso!!");

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
    
     public ArrayList listarItemBD() {
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select descricaoItem from itemos");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                OrdemDeServico ordemDeServico = new OrdemDeServico();
                ordemDeServico.setItemOS(rs.getString("descricaoItem"));
               
                dadosOS.add(ordemDeServico);
                
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
        
        return dadosOS;
    }

      public void cadatrarServicoBD(ArrayList dadosItem) {
        dadosOS = dadosItem;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into servico (descricaoServico) values (?); ");

            for (OrdemDeServico o: dadosOS){
                ps.setString(1, o.getServico());
            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Serviço  Cadastrado com Sucesso!!");

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
      
      public ArrayList listarServicoBD() {
        try {
            
            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select descricaoServico from servico;");
            
            rs = ps.executeQuery();
            
            dadosOS = new ArrayList<>();
            while (rs.next()) {
                OrdemDeServico ordemDeServico = new OrdemDeServico();
                ordemDeServico.setServico(rs.getString("descricaoServico"));
               
                dadosOS.add(ordemDeServico);
                
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
        
        return dadosOS;
    }
}
