package Modelos;

public class Cliente extends Pessoa{
    private int id;
    private String senha;

    public int getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
