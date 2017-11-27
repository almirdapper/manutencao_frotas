package Dao;

import View.Abastecimento;
import classe.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classe.*;

public class DaoAbastecimento {
    Abastecimento abastecimento = new Abastecimento();
    ArrayList<Abastecimento> dadosAbastecimentosDao = new ArrayList<Abastecimento>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void DaoAbastecimento() {

    }

    public void cadatrarAbastecimentoBD(ArrayList dadosVeiculosBD) {
        dadosAbastecimentosDao = dadosVeiculosBD;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into abastecimento \n"
                    + "(placaVeiculo,\n"
                    + "qtdlitros,\n"
                    + "data,\n"
                    + "kmAbasteceimento)\n"
                    + "values (?,?,?,?);");

            for (Abastecimento a: dadosAbastecimentosDao) {
                ps.setString(1,  );
                ps.setString(2, v.getMarca());
                ps.setString(3, v.getPlaca());
                ps.setString(4, v.getAno());
                
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

}
