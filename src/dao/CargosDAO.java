package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CargosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirCargo() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCargo = condb.prepareStatement("INSERT INTO permissao (nome) VALUES (?);");

            //Setar parametros
            novoCargo.setString(1, "Soldador");

            int LinhaAfetada = novoCargo.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }
    public boolean deletarCargo() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerCargo = condb.prepareStatement("DELETE FROM permissao WHERE id = ?;");
            removerCargo.setInt(1, 1);
            int linhasAfetada = removerCargo.executeUpdate();
            condb.close();
            return linhasAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
            return false;
        }
    }
    public boolean atualizarCargo() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizaCargo = condb.prepareStatement("UPDATE permissao SET nome = ? WHERE id = ?;");

            //Setar parametros
            atualizaCargo.setString(1, "Soldador");
            atualizaCargo.setInt(2, 4);

            int LinhaAfetada = atualizaCargo.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cargo: " + erro);
            return false;
        }
    }
    public boolean pesquisarCargos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarCargos = condb.prepareStatement("SELECT nome" + " FROM permissao WHERE id = ?");

            //Setar parametros
            buscarCargos.setInt(1, 1);
            ResultSet resultado = buscarCargos.executeQuery();

            while (resultado.next()) {
               String nome = resultado.getString("nome");
               System.out.println("Cargo: " + nome);
            }
            condb.close();

        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar cargo: " + erro);

        }
        return false;
    }
}