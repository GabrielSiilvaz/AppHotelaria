package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos" +
                    "(pagamento) VALUES (?);");

            //Setar parametros
            novoPedido.setString(1, "Pix");
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
    public boolean pesquisarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarPedidos = condb.prepareStatement("SELECT pagamento" + " FROM pedidos WHERE id = ?");

            //Setar parametros
            buscarPedidos.setInt(1, 3);
            ResultSet resultado = buscarPedidos.executeQuery();

            while (resultado.next()) {
                 String pagamento = resultado.getString("pagamento");
                 System.out.println("Pagamento: " + pagamento);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar pedido: " + erro);

        }
        return false;
    }
}
