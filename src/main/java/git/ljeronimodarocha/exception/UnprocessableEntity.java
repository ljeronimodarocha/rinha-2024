package git.ljeronimodarocha.exception;

public class UnprocessableEntity {
    public UnprocessableEntity(String erro) {
        this.erro = erro;
    }

    private String erro;


    public String getErro() {
        return erro;
    }
}