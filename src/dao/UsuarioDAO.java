package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            atualizaUsuario.setString(1, "Gabriel");
            atualizaUsuario.setString(2, "gabrielll@gmail.com");
            atualizaUsuario.setString(3, "Gabriel99098");
            atualizaUsuario.setInt(4, 1);
            atualizaUsuario.setInt(5, 1);

            int LinhaAfetada = atualizaUsuario.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar usuario: " + erro);
            return false;
        }
    }
}
