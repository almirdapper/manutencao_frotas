package Dao;

import classe.Funcioario;
import classe.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoVeiculos {

    ArrayList<Veiculo> dadosVeiculoDao = new ArrayList<Veiculo>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void DaoVeiculos() {

    }

    public void cadatrarVeiculoBD(ArrayList dadosVeiculosBD) {
        dadosVeiculoDao = dadosVeiculosBD;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into Veiculo (\n"
                    + "modelo, \n"
                    + "marca, \n"
                    + "placa, \n"
                    + "ano, \n"
                    + "descricao,\n"
                    + "categoria, \n"
                    + "tipo,\n"
                    + "statusVeiculo)\n"
                    + "values (?,?,?,?,?,?,?,?)");

            for (Veiculo v : dadosVeiculoDao) {
                ps.setString(1, v.getModelo());
                ps.setString(2, v.getMarca());
                ps.setString(3, v.getPlaca());
                ps.setString(4, v.getAno());
                ps.setString(5, v.getDescricao());
                ps.setString(6, v.getCategoria());
                ps.setString(7, v.getTipo());
                ps.setString(8, v.getStatus());

            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Veiculo Cadastrado com Sucesso!!");

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

    public ArrayList buscarVeiculoBD(String placaVeiculo) {

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idVeiculo,\n"
                    + "modelo,\n"
                    + "marca,\n"
                    + "placa,\n"
                    + "ano,\n"
                    + "descricao,\n"
                    + "categoria,\n"
                    + "tipo,\n"
                    + "statusVeiculo\n"
                    + "from veiculo\n"
                    + "where placa = ? ; ");

            ps.setString(1, placaVeiculo);

            rs = ps.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setAno(rs.getString("ano"));
                veiculo.setDescricao(rs.getString("descricao"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setTipo(rs.getString("tipo"));
                veiculo.setStatus(rs.getString("statusVeiculo"));

                dadosVeiculoDao.add(veiculo);

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
        return dadosVeiculoDao;
    }

    public void alterarVeiculoBD(ArrayList dadosVeiculosBD) {
        dadosVeiculoDao = dadosVeiculosBD;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("update veiculo set \n"
                    + "modelo = ?,\n"
                    + "marca= ?,\n"
                    + "placa= ?,\n"
                    + "ano= ?,\n"
                    + "descricao= ?,\n"
                    + "categoria= ?, \n"
                    + "tipo= ?,\n"
                    + "statusVeiculo = ? \n"
                    + "where placa = ?;");

            for (Veiculo v : dadosVeiculoDao) {
                ps.setString(1, v.getModelo());
                ps.setString(2, v.getMarca());
                ps.setString(3, v.getPlaca());
                ps.setString(4, v.getAno());
                ps.setString(5, v.getDescricao());
                ps.setString(6, v.getCategoria());
                ps.setString(7, v.getTipo());
                ps.setString(8, v.getStatus());
                ps.setString(9, v.getPlaca());

            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Veiculo Alterado com Sucesso!!");

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

    public ArrayList listarVeiculosBD() {
        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idVeiculo,\n"
                    + "modelo,\n"
                    + "marca,\n"
                    + "placa,\n"
                    + "ano,\n"
                    + "descricao,\n"
                    + "categoria,\n"
                    + "tipo,\n"
                    + "statusVeiculo\n"
                    + "from veiculo;");

            rs = ps.executeQuery();

            while (rs.next()) {
                
                Veiculo veiculo = new Veiculo();
                veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setAno(rs.getString("ano"));
                veiculo.setDescricao(rs.getString("descricao"));
                veiculo.setCategoria(rs.getString("categoria"));
                veiculo.setTipo(rs.getString("tipo"));
                veiculo.setStatus(rs.getString("statusVeiculo"));

                dadosVeiculoDao.add(veiculo);
                

                dadosVeiculoDao.add(veiculo);

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

        return dadosVeiculoDao;
    }

       public ArrayList listarPlacaComboboxBD() {
        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select placa from veiculo;");

            rs = ps.executeQuery();

            while (rs.next()) {
                
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("placa"));

               
                

                dadosVeiculoDao.add(veiculo);

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

        return dadosVeiculoDao;
    }

}
