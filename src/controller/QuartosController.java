package controller;

import dao.QuartosDAO;
import model.Quartos;

public class QuartosController {
    private final QuartosDAO quartosDAO;

    public QuartosController() {
        this.quartosDAO = new QuartosDAO();
    }

    public boolean verificarInfosQuartos(String nome, String numero, int qtd_cama_casal, int qtd_cama_solteiro, boolean disponivel, double preco) {

        Quartos quarto = new Quartos(nome, numero, qtd_cama_casal, qtd_cama_solteiro, disponivel, preco);
        quartosDAO.inserirQuarto(quarto);
        return false;
    }
}