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
}
