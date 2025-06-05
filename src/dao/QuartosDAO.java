package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos (nome, numero, tipo, camaSolteiro, camaCasal, disponível, preco) VALUES (?, ?, ?, ?, ?, ?, ?);");

            //Setar parametros
            novoQuarto.setString(1, "quarto");
            novoQuarto.setString(2, "177");
            novoQuarto.setString(3, "Familia");
            novoQuarto.setInt(4, 2);
            novoQuarto.setInt(5, 1);
            novoQuarto.setInt(6, 1);
            novoQuarto.setDouble(7, 150.00);


            int LinhaAfetada = novoQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Quarto: " + erro);
            return false;
        }
    }
}
