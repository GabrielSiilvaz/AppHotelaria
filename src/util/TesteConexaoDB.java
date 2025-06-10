package util;
import dao.*;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                /*UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.deletarUsuario();
                System.out.println("Usuario deletado com sucesso!");*/

                /*ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.deletarClientes();
                System.out.println("Cliente deletado com sucesso!");*/

                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.atualizarAdicional();
                System.out.println("Adicional atualizado com sucesso!");

                /*CargosDAO cargosDAO = new CargosDAO();
                cargosDAO.deletarCargo();
                System.out.println("Cargo deletado com sucesso!");*/

                /*QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.deletarQuarto();
                System.out.println("Quarto inserido com sucesso!");*/

                /*ReservasDAO reservasDAO = new ReservasDAO();
                reservasDAO.deletarReserva();
                System.out.println("Reserva deletada com sucesso!");*/

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
