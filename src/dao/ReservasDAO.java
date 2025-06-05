package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirReserva() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novaReserva = condb.prepareStatement("INSERT INTO reservas" +
                    "() VALUES (?, ?, ?, ?);");

            //Setar parametros
            novaReserva.setString(1, "Gabriel");
            novaReserva.setString(2, "");
            novaReserva.setString(3, "Gabriel");
            novaReserva.setString(4, "Gabriel");

            int LinhaAfetada = novaReserva.executeUpdate();
            return LinhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Reserva: " + erro);
            return false;
        }
    }
}
