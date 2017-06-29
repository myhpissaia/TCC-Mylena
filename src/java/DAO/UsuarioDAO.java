package DAO;

import JDBC.ConnectionFactory;
import Model.Usuario;
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
 * @author  <Leticia e Mylena>
 */
public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void insereUsuario(Usuario i) {
        try {
            String sql = "INSERT INTO cadastro (nome,sobrenome,email,login,senha,consenha) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
             
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getSobrenome());
            stmt.setString(3, i.getEmail());
            stmt.setString(4, i.getLogin());
            stmt.setString(5, i.getSenha());
            stmt.setString(6, i.getConsenha());

            stmt.execute();
            conexao.close();

        } catch (SQLException ex) {
            System.out.println("ta foda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean atualizaUsuario(Usuario i) {
        String sql = "UPDATE cadastro SET nome=?, sobrenome=?, email=?, login=?,senha=?, consenha=? WHERE id_user =?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, i.getNome());
            stmt.setString(2, i.getSobrenome());
            stmt.setString(3, i.getEmail());
            stmt.setString(4, i.getLogin());
            stmt.setString(5, i.getSenha());
            stmt.setString(6, i.getConsenha());
            stmt.setInt(7, i.getId());

            stmt.execute();
            conexao.close();
            return true;
        } catch (Exception ee) {
            ee.printStackTrace();
            return false;
        }
    }

    public boolean deletaUsuario(Usuario d) {
        String sql = "DELETE FROM cadastro WHERE id_user=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setLong(1, d.getId());
            stmt.execute();
            stmt.close();
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Usuario> getUsuario() {
        List<Usuario> cad = new ArrayList<Usuario>();
        try {
            String sql = "SELECT * FROM cadastro";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id_user"));
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setConsenha(rs.getString("consenha"));
                cad.add(u);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cad;
    }
}
