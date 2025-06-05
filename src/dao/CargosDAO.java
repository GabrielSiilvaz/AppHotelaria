package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}