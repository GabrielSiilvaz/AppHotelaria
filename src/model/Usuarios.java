package model;

public class Usuarios extends Pessoa {
   private int id, rolesId;
    private String senha;


    public Usuarios(String nome, String email, String senha,  int rolesid) {
        super(nome, email);
        this.senha = senha;
        this.rolesId = rolesId;
    }
    public int getId() {return id;}
    public String getSenha() {
        return senha;
    }
    public void setIdUsuario(int idUsuario) {
        this.rolesId = idUsuario;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}