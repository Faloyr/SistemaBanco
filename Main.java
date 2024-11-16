package parte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    public static int codcliente =0,codconta =0;
    public static List<Cliente> Clientes= new ArrayList<>();
    public static List<Conta> Contas= new ArrayList<>();

    public static void main(String[] args)
    {
        menuprincipal();
    }

    static void menuprincipal(){
        boolean sair = true;
        while (sair) {
            System.out.println("1-Gerenciar CLIENTES");
            System.out.println("2-Gerenciar CONTAS");
            System.out.println("3-SAIR");
            System.out.println("Opção: ");
            int escolha = leri();


            switch (escolha) {
                case 1:
                    menucliente();
                    break;
                case 2:
                    menuconta();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Erro!Opção inválida: ");
                    menuprincipal();
                    break;

            }
        }
    }

    static void menucliente() {

        System.out.println("1-Cadastrar CLIENTE");
        System.out.println("2-Consultar CLIENTE");
        System.out.println("3-Remover CLIENTE");
        System.out.println("4-Atualizar CLIENTE");
        System.out.println("5-Voltar ao MENU INICIAL");
        System.out.println("Opção: ");
        int escolha = leri();
        switch (escolha) {
            case 1:
                createcliente();
                break;
            case 2:
                consultacliente();
                break;
            case 3:
                apagarcliente();
                break;
            case 4:
                attcliente();
                break;
            case 5:
                return;
            default:
                System.out.println("Erro!Opção inválida: ");
                break;
        }

    }




    static void menuconta() {

        System.out.println("1 - Criar CONTA para um CLIENTE");
        System.out.println("2 - Sacar dinheiro de uma CONTA de um CLIENTE");
        System.out.println("3 - Depositar dinheiro para uma CONTA de um CLIENTE");
        System.out.println("4 - Verificar saldo de uma CONTA de um CLIENTE");
        System.out.println("5 - Transferir dinheiro de uma CONTA de um CLIENTE para outro CLIENTE");
        System.out.println("6 - Voltar ao MENU INICIAL");
        System.out.println("Opção: ");
        int escolha = leri();
        switch (escolha) {
            case 1:
                criarconta();
                break;
            case 2:
                sacar();
                break;
            case 3:
                depositar();
                break;
            case 4:
                verificarsaldo();
                break;
            case 5:
                transferir();
                break;
            case 6:
                return;
            default:
                System.out.println("Erro!Opção inválida: ");
                break;

        }



    }
    public static void createcliente() {
        System.out.println("Informe o CPF: ");
        String cpf = lers();
        System.out.println("Informe o nome: ");
        String nome = lers();
        String convert = "" + codcliente++;

        Cliente cliente = new Cliente (cpf,nome,convert);
        Clientes.add(cliente);

    }

    public static Cliente consultacliente() {
        System.out.println("Digite o cpf do cliente: ");
        String idcliente = lers();

        Cliente cliente = Clientes.stream().filter(c -> c.getCpf().equals(idcliente)).findFirst().orElse(null);

        if(cliente != null){
            System.out.println("Nome: " + cliente.getNome());
            if(cliente.getConta() != null){
            System.out.println("Conta ID: " + cliente.getConta().getIdconta());
            System.out.println("Saldo: R$" + cliente.getConta().getSaldo());
            System.out.println("Codigo: " + codconta);
                }   else
            System.out.println("O cliente ainda nao possui uma conta.");

        }
        else {
            System.out.println("Cliente nao encontrado");

        }
        return cliente;
    }
    public static void apagarcliente() {

        Cliente rmover= consultacliente();

        Clientes.remove(rmover);

    }
    public static void attcliente() {
        Cliente atualizar = consultacliente();
        if(atualizar!=null){
        System.out.println("Digite o novo nome do cliente: ");
        String nome = lers();
        System.out.println("Digite o novo código do cliente: ");
        String idC = lers();

        atualizar.setNome(nome);
        atualizar.setCodcliente(idC);
        }

    }
    public static void criarconta() {

        if(Clientes!= null) {
            System.out.println("Informe o cpf do cliente que utilizara esta conta: ");
            String idconta = lers();
            System.out.println("Informe o saldo da conta: ");
            double saldo = lerd();

            Conta conta = new Conta(++codconta, saldo);

            Contas.add(conta);
            System.out.println("Conta criada codigo: " + codconta);
            System.out.println("Saldo: " + saldo);

            Clientes.stream().filter(c -> c.getCpf().equals(idconta)).findFirst().ifPresent(cliente -> cliente.addconta(conta));


        }
        else {
            System.out.println("Crie um cliente antes de criar uma conta");
            createcliente();
        }
    }

    public static void sacar() {

        Cliente csaque = consultacliente();
        if(csaque != null){
        System.out.println("Digite o valor a ser sacado: ");
        Double valor = lerd();

        csaque.getConta().sacar(valor);
        }


    }
    public static void depositar() {

        Cliente cdeposito = consultacliente();

        if (cdeposito != null) {
            System.out.println("Digite o valor a ser depositar: ");
            Double valor = lerd();

            cdeposito.getConta().depositar(valor);
        }
    }
    public static void verificarsaldo() {

        Cliente cdeposito = consultacliente();


    }
    public static void transferir() {

        if(Clientes.size() >1) {
            Cliente primeiro = consultacliente();

            System.out.println("Digite o valor que sera sacado por " + primeiro.getNome());
            double valor = lerd();


            Cliente segundo = consultacliente();

            if (!primeiro.getConta().sacar(valor)) {
                System.out.println("Saldo insuficiente na conta de " + primeiro.getNome());
                return;
            }
            segundo.getConta().depositar(valor);

            System.out.println("Transferencia realizada com sucesso");
        }
        else
        {
            System.out.println("Crie outro Cliente antes de fazer uma transferencia");

        }
    }

    public static String lers() {
        Scanner lers = new Scanner(System.in);
        return lers.nextLine();
    }
    public static int leri() {
        return parseInt(lers());
    }
    public static Double lerd() {
        return parseDouble(lers());
    }


}

