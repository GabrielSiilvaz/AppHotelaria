package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCliente = condb.prepareStatement("INSERT INTO clientes (nome, email, cpf, telefone) VALUES (?, ?, ?, ?);");

            //Setar parametros
            novoCliente.setString(1, "Gabriel");
            novoCliente.setString(2, "gabrielpooi8@gmail.com");
            novoCliente.setString(3, "244.157.171-01");
            novoCliente.setString(4, "15-99789-0627");

            int LinhaAfetada = novoCliente.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
}
