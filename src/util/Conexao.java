package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/dbaHotel";
    private String usuario = "dbaHotel";
    private String senha = "dbaHotel123";

    public Connection conectar() {
        Connection condb = null;

        try {

            //Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(driver);

    /*Inicializar o driver ja carregado por meio do metodo
    getConnection(IP, porta, nome do banco, usuario, senha)*/
            DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados " + erro);
            return null;
        }
    }
}