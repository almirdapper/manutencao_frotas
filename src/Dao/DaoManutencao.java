package Dao;

import classe.Manutencao;
import classe.Manutencao;
import classe.Manutencao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DaoManutencao {

    ArrayList<Manutencao> dadosManutencaoClass = new ArrayList<Manutencao>();
    ArrayList<Manutencao> arrayListDadosManutencao = new ArrayList<Manutencao>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public DaoManutencao() {

    }

    public void cadatrarFuncionarioBD(ArrayList dadosUsuariosBD) {
        dadosManutencaoClass = dadosUsuariosBD;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into manutencao\n"
                    + "(tipoManutencao, placa, descricaoManutencao, statusManutencao, dataManutencao,numeroOs)\n"
                    + "values(?,?,?,?,?,?)");

            for (Manutencao f : dadosManutencaoClass) {
                ps.setString(1, f.getTipoManutencao());
                ps.setString(2, f.getPlaca());
                ps.setString(3, f.getDescricaoManutencao());
                ps.setString(4, f.getStatusManutencao());
                ps.setString(5, f.getDataManutencao());
                ps.setString(6, f.getNumeroOS());

            }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Manutençao Cadastrada com Sucesso!!");

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

    public ArrayList listarManutencaoBD() {
        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("select idManutencao,\n"
                    + "placa,\n"
                    + "descricaoManutencao,\n"
                    + "statusManutencao,\n"
                    + "dataManutencao,\n"
                    + "numeroOS\n"
                    + "from manutencao;  ");

            rs = ps.executeQuery();

            while (rs.next()) {

                Manutencao manutencao = new Manutencao();
                manutencao.setIdManutencao(rs.getInt("idManutencao"));
                manutencao.setPlaca(rs.getString("placa"));
                manutencao.setDescricaoManutencao(rs.getString("descricaoManutencao"));
                manutencao.setDataManutencao(rs.getString("dataManutencao"));
                manutencao.setNumeroOS(rs.getString("numeroOS"));
 
                

                dadosManutencaoClass.add(manutencao);

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

        return dadosManutencaoClass;
    }
}
