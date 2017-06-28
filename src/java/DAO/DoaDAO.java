/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.Usuario;
import Model.Doacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author <Leticia e Mylena>
 */
public class DoaDAO {

    private Connection conexao;

    public DoaDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void insereDoacao(Doacao u) {
        try {
            String sql = "INSERT INTO doacao (nome_ong,doacao,dt,necAlimento,"
                    + "necRoupa,necBrinquedo,necHigiene) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getDoacao());
            stmt.setDate(3, u.getData());
            stmt.setBoolean(4, u.isNecAlimento());
            stmt.setBoolean(5, u.isNecBrinquedo());
            stmt.setBoolean(6, u.isNecRoupa());
            stmt.setBoolean(7, u.isNecHigiene());

            stmt.execute();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean updateDao(Doacao u) {
        String sql = "UPDATE doacao SET nome_ong=?, doacao=?, dt=?,necAlimento=?,"
                + " necBrinquedo=?, necRoupa=?, necHigiene=?, WHERE id_doa =?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getDoacao());
            stmt.setDate(3, u.getData());
            stmt.setBoolean(4, u.isNecAlimento());
            stmt.setBoolean(5, u.isNecBrinquedo());
            stmt.setBoolean(6, u.isNecRoupa());
            stmt.setBoolean(7, u.isNecHigiene());

            stmt.execute();
            conexao.close();
            return true;
        } catch (Exception ee) {
            ee.printStackTrace();
            return false;
        }
    }

    public boolean deleteDao(Doacao d) {
        String sql = "DELETE FROM doacao WHERE id_doa=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, d.getId());
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Doacao> getDao() {
        List<Doacao> doa = new ArrayList<Doacao>();
        try {
            String sql = "SELECT * FROM doacao";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Doacao u = new Doacao();
                u.setNome(rs.getString("nome"));
                u.setDoacao(rs.getString("doacao"));
                u.setData(rs.getDate("data"));
                doa.add(u);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doa;
    }
}
