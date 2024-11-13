import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        try (Scanner dadosContaCliente = new Scanner(System.in)) {
            int numeroDaConta;
            String agencia;
            String nomeDoCliente;
            double saldo = 237.48;


            System.out.println("Informe o número da sua conta: ");
            numeroDaConta = dadosContaCliente.nextInt();

            dadosContaCliente.nextLine();

            System.out.println("Informe o número da sua agência: ");
            agencia = dadosContaCliente.nextLine();

            System.out.println("Informe o seu nome: ");
            nomeDoCliente = dadosContaCliente.nextLine();


            
            System.out.println("Olá " + nomeDoCliente + ", agradecemos por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroDaConta + " e seu saldo " + saldo + " já está disponível para saque.");

            dadosContaCliente.close();
        }
    } 

    
}
