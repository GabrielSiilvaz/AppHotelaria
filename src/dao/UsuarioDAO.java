package dao;

import model.Usuarios;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoUsuario = condb.prepareStatement("INSERT INTO usuarios (nome, email, senha, id_perm_fk) VALUES (?, ?, md5(?), ?);");

            //Setar parametros
            novoUsuario.setString(1, "Gabriel");
            novoUsuario.setString(2, "gabrielll@gmail.com");
            novoUsuario.setString(3, "Gabriel99098");
            novoUsuario.setInt(4, 1);

            int LinhaAfetada = novoUsuario.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
    public boolean deletarUsuario() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerUsuario = condb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");
            removerUsuario.setInt(1, 2);
            int linhasAfetada = removerUsuario.executeUpdate();
            condb.close();
            return linhasAfetada > 1;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }
    public boolean atualizarUsuario() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizaUsuario = condb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?), id_perm_fk = ? WHERE id = ?;");

            //Setar parametros
            atualizaUsuario.setString(1, "Silvia");
            atualizaUsuario.setString(2, "gabriell@gmail.com");
            atualizaUsuario.setString(3, "Gabriel9098");
            atualizaUsuario.setInt(4, 1);
            atualizaUsuario.setInt(5, 5);

            int LinhaAfetada = atualizaUsuario.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar usuario: " + erro);
            return false;
        }
    }

    public boolean autenticarUsuario(Usuarios usuarios) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement stmt = condb.prepareStatement("SELECT nome" + " FROM usuarios WHERE email = ? AND senha = md5(?);");

            //Setar parametros
            stmt.setString(1, usuarios.getEmail());
            stmt.setString(2, usuarios.getSenha());
            ResultSet resultado = stmt.executeQuery();
            boolean acessoAutorizado = resultado.next();
            String nome = resultado.getString("nome");
            System.out.println("Olá, seja bem-vindo, " + nome);

            condb.close();
            return acessoAutorizado;

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
            return false;

        }
    }
}

