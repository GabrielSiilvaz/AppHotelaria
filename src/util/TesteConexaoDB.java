package util;
import controller.Clientes;
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
                usuarioDAO.inserirUsuario();
                System.out.println("Usuario inserido com sucesso!");*/

                /*ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.inserirClientes();
                System.out.println("Clientes inserido com sucesso!");*/

                /*AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirAdicional();
                System.out.println("Adicional inserida com sucesso!");*/

                /*CargosDAO cargosDAO = new CargosDAO();
                cargosDAO.inserirCargo();
                System.out.println("Cargo inserido com sucesso!");*/

                QuartosDAO quartosDAO = new QuartosDAO();
                quartosDAO.inserirQuarto();
                System.out.println("Quarto inserido com sucesso!");





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
