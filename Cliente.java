package parte2;

public class Cliente {
    private String cpf;
    private String nome;
    private Conta conta;
    private String codcliente;


    public Cliente (String cpf,String nome,String codcliente) {
        this.cpf = cpf;
        this.nome = nome;
        this.codcliente = codcliente;

    }

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public void addconta(Conta conta) {
        this.conta = conta  ;
    }


}
