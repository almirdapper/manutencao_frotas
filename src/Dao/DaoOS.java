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

            for (OrdemDeServico o : dadosOS) {
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

            for (OrdemDeServico o : dadosOS) {
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

    public void cadatrarOSBD(ArrayList dadosItem) {
        dadosOS = dadosItem;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into ordemdeservico \n"
                    + "(data, placaVeiculo, status, item, servico, observacao)\n"
                    + "values(?,?,?,?,?,?); ");

            for (OrdemDeServico o : dadosOS) {
                ps.setString(1, o.getData());
                ps.setString(2, o.getPlacaVeiculo());
                ps.setString(3, o.getStatus());
                ps.setString(4, o.getItemOS());
                ps.setString(5, o.getServico());
                ps.setString(6, o.getObservacao());

            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "OS Cadastrado com Sucesso!!");

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

    }

    public ArrayList listarOSBD() {
        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idOs,data, placaVeiculo, status, item, servico, observacao\n"
                    + "from ordemdeservico;");

            rs = ps.executeQuery();

            dadosOS = new ArrayList<>();
            while (rs.next()) {
                OrdemDeServico ordemDeServico = new OrdemDeServico();

                ordemDeServico.setIdOs(rs.getInt("idOS"));
                ordemDeServico.setData(rs.getString("data"));
                ordemDeServico.setPlacaVeiculo(rs.getString("placaVeiculo"));
                ordemDeServico.setStatus(rs.getString("status"));
                ordemDeServico.setItemOS(rs.getString("item"));
                ordemDeServico.setServico(rs.getString("servico"));
                ordemDeServico.setObservacao(rs.getString("observacao"));

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

    public void alterarOSBD(ArrayList dadosdaOS) {
        dadosOS = new ArrayList<OrdemDeServico>();
        dadosOS = dadosdaOS;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("update ordemdeservico\n"
                    + "set data =?,\n"
                    + "placaVeiculo =?,\n"
                    + "status =?, \n"
                    + "item =?, \n"
                    + "servico=?, \n"
                    + "observacao =?\n" +
                    "where idOs =?;");
            
            
            for (OrdemDeServico f : dadosOS) {
                ps.setString(1, f.getData());
                ps.setString(2, f.getPlacaVeiculo());
                ps.setString(3, f.getStatus());
                ps.setString(4, f.getItemOS());
                ps.setString(5, f.getServico());
                ps.setString(6, f.getObservacao());
                ps.setInt(7, f.getIdOs());
            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Os Alterado com Sucesso!!");

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
    
     public ArrayList listarOSidBD(int id) {
        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select data, placaVeiculo, status, item, servico, observacao\n"
                    + "from ordemdeservico where idOs = ? ;");
            
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            
            dadosOS = new ArrayList<>();
            while (rs.next()) {
                OrdemDeServico ordemDeServico = new OrdemDeServico();

                
                ordemDeServico.setData(rs.getString("data"));
                ordemDeServico.setPlacaVeiculo(rs.getString("placaVeiculo"));
                ordemDeServico.setStatus(rs.getString("status"));
                ordemDeServico.setItemOS(rs.getString("item"));
                ordemDeServico.setServico(rs.getString("servico"));
                ordemDeServico.setObservacao(rs.getString("observacao"));

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
