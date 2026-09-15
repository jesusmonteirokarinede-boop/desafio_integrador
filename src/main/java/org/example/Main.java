import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE CONSULTA DE BENEFÍCIOS ===");

        // Entrada de dados
        System.out.print("Nome do colaborador: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Salário (R$): ");

        double salario = Double.parseDouble(scanner.next().replace(",", "."));

        System.out.print("Tempo de empresa (em anos): ");
        int tempoEmpresa = scanner.nextInt();


        scanner.nextLine();

        System.out.print("Quantidade de filhos pequenos (0 a 6 anos): ");
        int qtdFilhos = scanner.nextInt();


        scanner.nextLine();

        System.out.print("Modalidade de trabalho (presencial / home office): ");
        String modalidade = scanner.nextLine().trim().toLowerCase();

        System.out.print("Utiliza veículo próprio? (sim/nao): ");
        String veiculoProprio = scanner.nextLine().trim().toLowerCase();

        // Regras de Benefícios
        boolean valeAlimentacao = salario <= 5000.00;
        boolean auxilioCreche = qtdFilhos > 0;
        boolean planoSaude = idade >= 18;
        boolean auxilioHomeOffice = modalidade.equals("home office") || modalidade.equals("homeoffice");
        boolean auxilioCombustivel = veiculoProprio.equals("sim") || veiculoProprio.equals("s");
        boolean plr = tempoEmpresa >= 1;
        boolean bolsaEstudos = tempoEmpresa >= 2 || salario <= 3000.00;

        // Exibição do relatório
        System.out.println("\n========================================");
        System.out.println("   RELATÓRIO DE BENEFÍCIOS  " + nome.toUpperCase());
        System.out.println("========================================");
        System.out.println("• Vale-Alimentação: " + (valeAlimentacao ? "Elegível" : "Não elegível (Teto salarial atingido)"));
        System.out.println("• Auxílio-Creche: " + (auxilioCreche ? "Elegível" : "Não elegível"));
        System.out.println("• Plano de Saúde: " + (planoSaude ? "Elegível" : "Não elegível"));
        System.out.println("• Auxílio Home Office: " + (auxilioHomeOffice ? "Elegível" : "Não elegível"));
        System.out.println("• Auxílio Combustível: " + (auxilioCombustivel ? "Elegível" : "Não elegível"));
        System.out.println("• Participação nos Lucros (PLR): " + (plr ? "Elegível" : "Não elegível (Requer mínimo 1 ano de empresa)"));
        System.out.println("• Bolsa de Estudos: " + (bolsaEstudos ? "Elegível" : "Não elegível"));
        System.out.println("========================================");

        scanner.close();
    }
}