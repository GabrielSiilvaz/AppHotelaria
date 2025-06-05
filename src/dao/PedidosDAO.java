package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos" +
                    "() VALUES (?, ?, ?, ?);");

            //Setar parametros
            novoPedido.setString(1, "Gabriel");
            novoPedido.setString(2, "");
            novoPedido.setString(3, "Gabriel");
            novoPedido.setString(4, "Gabriel");

            int LinhaAfetada = novoPedido.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir o pedido: " + erro);
            return false;
        }
    }
}
