package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {

    private Conexao conexao = new Conexao();

    public boolean deletarReserva() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement removerReserva = condb.prepareStatement("DELETE FROM reservas WHERE id = ?;");
            removerReserva.setInt(1, 1);
            int linhasAfetada = removerReserva.executeUpdate();
            condb.close();
            return linhasAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar reserva: " + erro);
            return false;
        }
    }
}
