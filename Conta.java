package parte2;

public class Conta {
    private int idconta;
    private double saldo;


    public Conta (int idconta,double saldo) {
        this.idconta = idconta;
        this.saldo = saldo;

    }

    public int getIdconta() {
        return idconta;
    }
    public double getSaldo() {
        return saldo;
    }



    public boolean sacar(double saque) {
        boolean fim;
        if (saque <= saldo && saque > 0) {
            this.saldo -= saque;
            System.out.println("Saque realizado com sucesso");
            System.out.println("Saldo atual" + getSaldo());
            fim = true;
        }
        else {
            System.out.println("Saque não pode ser realizado");
            fim = false;
        }
        return fim;

    }
    public void depositar (double deposito) {
        if (deposito >   0) {
            this.saldo += deposito;
            System.out.println("Deposito realizado com sucesso");
            System.out.println("Saldo atual: " + getSaldo());
        }
        else
            System.out.println("Error");
    }

}
