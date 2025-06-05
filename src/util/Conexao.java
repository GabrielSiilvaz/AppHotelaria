package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    private String driver;
    private String url;
    private String usuario;
    private String senha;

    public Conexao() {
        carregarConfiguracoes();
    }

    //Metodo com os parametros de configuração das variaveis de ambiente
    private void carregarConfiguracoes() {
        Properties prop = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream
                ("config.properties")) {
            prop.load(inputPropsConfig);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            usuario = prop.getProperty("usuario");
            senha = prop.getProperty("senha");

        }
        catch (IOException erro) {
            System.out.println("Erro ao carregar configurações: " + erro.getMessage());
        }
    }

    public Connection conectar() {
        Connection condb = null;

        try {

            //Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)
            Class.forName(driver);

    /*Inicializar o driver ja carregado por meio do metodo
    getConnection(IP, porta, nome do banco, usuario, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;
        } catch (SQLException | ClassNotFoundException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados " + erro);
            return null;
        }
    }
}