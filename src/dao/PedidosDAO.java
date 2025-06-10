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
                    "(Id_usuario_fk, id_cliente_fk, pagamento) VALUES (?, ?, ?);");

            //Setar parametros
            novoPedido.setInt(1, 1);
            novoPedido.setInt(2, 4);
            novoPedido.setString(3, "Pix");
            int LinhaAfetada = novoPedido.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir o pedido: " + erro);
            return false;
        }
    }
    public boolean deletarPedido() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerPedido = condb.prepareStatement("DELETE FROM pedidos WHERE id = ?;");
            removerPedido.setInt(1, 1);
            int linhasAfetada = removerPedido.executeUpdate();
            condb.close();
            return linhasAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Pedido: " + erro);
            return false;
        }
    }
    public boolean atualizarPedido() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizaPedido = condb.prepareStatement("UPDATE pedidos SET Id_usuario_fk, id_cliente_fk, pagamento, WHERE id = ?;");

            //Setar parametros
            atualizaPedido.setInt(1, 1);
            atualizaPedido.setInt(2, 4);
            atualizaPedido.setString(3, "Pix");
            atualizaPedido.setInt(4, 1);

            int LinhaAfetada = atualizaPedido.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar o pedido: " + erro);
            return false;
        }
    }
}
