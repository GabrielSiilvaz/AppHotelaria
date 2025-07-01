package util;
import controller.UsuarioController;
import dao.*;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        UsuarioController usuarioController = new UsuarioController();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                usuarioController.verificarCredenciais("gabriell@gmail.com", "Gabriel9098");
                /*UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.autenticarUsuario();
                System.out.println("Usuario encontrado com sucesso!");*/

                /*ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.pesquisarClientes();
                System.out.println("Cliente encontrado com sucesso!");*/

                /*AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.pesquisarAdicional();
                System.out.println("Adicional encontrado com sucesso!");*/

                /*CargosDAO cargosDAO = new CargosDAO();
                cargosDAO.pesquisarCargos();
                System.out.println("Cargo encontrado com sucesso!");*/

                /*QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.pesquisarQuarto();
                System.out.println("Quarto encontrado com sucesso!");*/

                /*ReservasDAO reservasDAO = new ReservasDAO();
                reservasDAO.deletarReserva();
                System.out.println("Reserva deletada com sucesso!");*/

                /*PedidosDAO pedidosDAO = new PedidosDAO();
                pedidosDAO.pesquisarPedidos();
                System.out.println("Pedido encontrado com sucesso!");*/

                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }
        }else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
