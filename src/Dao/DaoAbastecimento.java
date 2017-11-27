package Dao;


import classe.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import classe.*;

public class DaoAbastecimento {
    ArrayList<Abastecimento> dadosAbastecimento = new ArrayList<Abastecimento>();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void DaoAbastecimento() {

    }

    public void cadatrarAbastecimentoBD(ArrayList dadosVeiculosBD) {
        dadosAbastecimento= dadosVeiculosBD;

        try {

            conn = ConexaoBD.getConnection();
            ps = conn.prepareStatement("insert into abastecimento \n"
                    + "(placaVeiculo,\n"
                    + "qtdlitros,\n"
                    + "data,\n"
                    + "kmAbasteceimento)\n"
                    + "values (?,?,?,?);");

           for(Abastecimento a: dadosAbastecimento){
               ps.setString(1, a.getPlacaVeiculo());
               ps.setInt(2, a.getQtdLitros());
               ps.setString(3, a.getData());
               ps.setString(4, a.getKmAbasteceimento());
           }
            ps.execute();
            JOptionPane.showMessageDialog(null, "Abastecimento Cadastrado com Sucesso!!");

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
