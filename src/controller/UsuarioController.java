package controller;

import dao.UsuarioDAO;
import model.Usuarios;

public class UsuarioController{
    private final UsuarioDAO usuarioDAO;

    /*Construtor para inicializar objeto UsuarioController()Ao inicializá-lo, o construtor de UsuarioDao() será executado,
    o que significa que a camada de Controle estará verificandose os parametros necessarios foram informandos para que sejam
    enviados ás requesições (package DAO)*/
    public UsuarioController(){
        usuarioDAO = new UsuarioDAO();
    }

    /*Metodo para verificar se os parametros necessarios para autenticação
    estão presentes, ou seja, não podem ser vazios ou nulos; se estiverem presentes,
    um objeto de Usuario é inicializado como uma intancia*/
    public boolean verificarCredenciais(String email, String senha){
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()){
            return false;}
        Usuarios usuario = new Usuarios("", email, senha, 0);
        return usuarioDAO.autenticarUsuario(usuario);
    }
}
