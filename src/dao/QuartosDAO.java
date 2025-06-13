package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos (nome, numero, tipo, camaSolteiro, camaCasal, disponível, preco) VALUES (?, ?, ?, ?, ?, ?, ?);");

            //Setar parametros
            novoQuarto.setString(1, "quarto");
            novoQuarto.setString(2, "777");
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
    public boolean deletarQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerQuarto = condb.prepareStatement("DELETE FROM quartos WHERE id = ?;");
            removerQuarto.setInt(1, 1);
            int linhasAfetada = removerQuarto.executeUpdate();
            condb.close();
            return linhasAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Quarto: " + erro);
            return false;
        }
    }
    public boolean atualizarQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizaQuarto = condb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, tipo = ?, camaSolteiro = ?, camaCasal = ?, disponivel = ?, preco = ?, WHERE id = ?;");

            //Setar parametros
            atualizaQuarto.setString(1, "quarto");
            atualizaQuarto.setString(2, "777");
            atualizaQuarto.setString(3, "Familia");
            atualizaQuarto.setInt(4, 2);
            atualizaQuarto.setInt(5, 1);
            atualizaQuarto.setInt(6, 1);
            atualizaQuarto.setDouble(7, 150.00);
            atualizaQuarto.setInt(8, 1);

            int LinhaAfetada = atualizaQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar quarto: " + erro);
            return false;
        }
    }
    public boolean pesquisarQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarQuarto = condb.prepareStatement("SELECT nome, numero, tipo, camaSolteiro, camaCasal, preco, disponivel" + " FROM quartos WHERE id = ?");

            //Setar parametros
            buscarQuarto.setInt(1, 1);
            ResultSet resultado = buscarQuarto.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                String tipo = resultado.getString("tipo");
                int camaSolteiro = resultado.getInt("camaSolteiro");
                int camaCasal = resultado.getInt("camaCasal");
                double preco = resultado.getDouble("preco");
                int disponivel = resultado.getInt("disponivel");


                System.out.println("Nome: " + nome + "\nNumeros: " + numero +  "\nTipo: " + tipo + "\nCamas de solteiro: " + camaSolteiro + "\nCamas de casal: " + camaCasal + "\nPreco: " + preco + "\nDisponiveis: " + disponivel);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);

        }
        return false;
    }
}
