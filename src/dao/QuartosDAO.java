package dao;

import model.Quartos;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirQuarto(Quartos quarto) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos (nome, numero, camaSolteiro, camaCasal, disponível, preco) VALUES (?, ?, ?, ?, ?, ?);");

            //Setar parametros
            novoQuarto.setString(1, quarto.getNome());
            novoQuarto.setString(2, quarto.getNumero());
            novoQuarto.setInt(3, quarto.getQtd_cama_solteiro());
            novoQuarto.setInt(4, quarto.getQtd_cama_casal());
            novoQuarto.setBoolean(5, quarto.isDisponivel());
            novoQuarto.setDouble(6, quarto.getPreco());


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
            PreparedStatement atualizaQuarto = condb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, camaSolteiro = ?, camaCasal = ?, disponivel = ?, preco = ?, WHERE id = ?;");

            //Setar parametros
            atualizaQuarto.setString(2, "777");
            atualizaQuarto.setString(3, "Familia");
            atualizaQuarto.setInt(4, 1);
            atualizaQuarto.setInt(5, 1);
            atualizaQuarto.setDouble(6, 150.00);
            atualizaQuarto.setInt(7, 1);

            int LinhaAfetada = atualizaQuarto.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar quarto: " + erro);
            return false;
        }
    }
    public void pesquisarQuarto() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarQuarto = condb.prepareStatement("SELECT nome, numero, camaSolteiro, camaCasal, preco, disponivel" + " FROM quartos WHERE id = ?");

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

    }
}
