package model;

public class Quartos {
    int idQuarto, qtd_cama_casal, qtd_cama_solteiro;
    String nome, numero;
    double  preco;
    boolean disponivel;

    public Quartos(String nome, String numero, int qtd_cama_casal, int qtd_cama_solteiro, boolean disponivel,double preco) {
        this.nome = nome;
        this.numero = numero;
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solteiro = qtd_cama_solteiro;
        this.disponivel = disponivel;
        this.preco = preco;
    }
    public int getIdQuarto() {
        return idQuarto;
    }

    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    public int getQtd_cama_casal() {
        return qtd_cama_casal;
    }
    public int getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }
    public double getPreco() {
        return preco;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setQtd_cama_casal(int qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }
    public void setQtd_cama_solteiro(int qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
