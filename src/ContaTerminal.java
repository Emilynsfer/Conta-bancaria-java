import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner dadosContaCliente = new Scanner(System.in)) {
            int numeroDaConta = 0;
            String agencia;
            String nomeDoCliente;
            double saldo = 237.48;

            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.println("Informe o número da sua conta: ");
                    while (!dadosContaCliente.hasNextInt()) {
                        System.out.println("Por favor, insira um número válido para a conta.");
                        dadosContaCliente.next();
                    }
                    numeroDaConta = dadosContaCliente.nextInt();
                    dadosContaCliente.nextLine();

                    if (numeroDaConta <= 0) {
                        System.out.println("Número da conta deve ser um número positivo.");
                    } else {
                        entradaValida = true;
                    }

                } catch (Exception e) {
                    System.out.println("Erro ao processar o número da conta. Tente novamente.");
                    dadosContaCliente.nextLine();
                }
            }


            String nomeDoClienteValido = "";
            while (nomeDoClienteValido.isEmpty()) {

                try {
                    System.out.println("Informe o seu nome: ");
                    nomeDoCliente = dadosContaCliente.nextLine();
                    if (nomeDoCliente.isEmpty()) {
                        System.out.println("Nome não pode ser vazio. Por favor, insira o seu nome.");
                    } else {
                        nomeDoClienteValido = nomeDoCliente;
                    }

                } catch (Exception e) {
                    System.out.println("Erro ao processar o nome. Tente novamente.");
                }
            }


            System.out.println("Informe o número da sua agência: ");
            agencia = dadosContaCliente.nextLine();

            Conta conta = new Conta(numeroDaConta, agencia, nomeDoClienteValido, saldo);

            conta.exibirDetalhes();
            conta.consultarSaldo();



            System.out.println("Deseja realizar um depósito? (sim/não)");
            String resposta = dadosContaCliente.nextLine();

            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Digite o valor a ser depositado: ");
                double valorDeposito = dadosContaCliente.nextDouble();
                dadosContaCliente.nextLine();
                conta.depositar(valorDeposito);
            }

            System.out.println("Deseja realizar um saque? (sim/não)");
            resposta = dadosContaCliente.nextLine();
            
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.println("Digite o valor do saque: ");
                double valorSaque = dadosContaCliente.nextDouble();
                dadosContaCliente.nextLine();
                conta.sacar(valorSaque);
            }
           
        }

    }
}

class Conta {
    private final int numeroDaConta;
    private final String agencia; 
    private final String nomeDoCliente;
    private double saldo;

    public Conta(int numeroDaConta, String agencia, String nomeDoCliente, double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.nomeDoCliente = nomeDoCliente;
        this.saldo = saldo;
    }

    public void exibirDetalhes() {
        System.out.printf("Conta criada com sucesso para %s%n", nomeDoCliente);
        System.out.printf("Número da conta: %d%n", numeroDaConta);
        System.out.printf("Agência: %s%n", agencia);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor; 
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
            consultarSaldo();
        } else {
            System.out.println("Valor de depósito inválido. O valor deve ser positivo");
        }
    }

    
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor; 
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
            consultarSaldo();
        } else {
            System.out.println("Saldo insuficiente para o saque.");
        }
    }

    public void consultarSaldo() {
        System.out.printf("Seu saldo atual: R$ %.2f%n", saldo);
    
    }
}
    


