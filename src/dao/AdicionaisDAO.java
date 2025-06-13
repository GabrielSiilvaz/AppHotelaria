package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirAdicional() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicional = condb.prepareStatement("INSERT INTO adicionais (nome, preco) VALUES (?, ?);");

            //Setar parametros
            novoAdicional.setString(1, "bebida");
            novoAdicional.setDouble(2, 5.50);

            int LinhaAfetada = novoAdicional.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicional: " + erro);
            return false;
        }
    }
    public boolean deletarAdicional() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerAdicional = condb.prepareStatement("DELETE FROM adicionais WHERE id = ?;");
            removerAdicional.setInt(1, 1);
            int linhasAfetada = removerAdicional.executeUpdate();
            condb.close();
            return linhasAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar adicional: " + erro);
            return false;
        }
    }
    public boolean atualizarAdicional() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizaAdicional = condb.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?;");

            //Setar parametros
            atualizaAdicional.setString(1, "breja");
            atualizaAdicional.setDouble(2, 5.55);
            atualizaAdicional.setInt(3, 1);

            int LinhaAfetada = atualizaAdicional.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar adicional: " + erro);
            return false;
        }
    }
    public boolean pesquisarAdicional() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarAdicional = condb.prepareStatement("SELECT nome, preco" + " FROM adicionais WHERE id = ?");

            //Setar parametros
            buscarAdicional.setInt(1, 1);
            ResultSet resultado = buscarAdicional.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                System.out.println("Nome: " + nome + "\nPreço: " + preco);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar adicional: " + erro);

        }
        return false;
    }
}
