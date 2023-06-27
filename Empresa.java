import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Empresa {


    private List<Departamento> departamentos;


    public Empresa() {
        departamentos = new ArrayList<>();
        departamentos.add(new Departamento("Vendas", 1, this));
        departamentos.add(new Departamento("Recursos Humanos", 2, this));
        departamentos.add(new Departamento("Financeiro", 3, this));
        departamentos.add(new Departamento("Tecnologia da Informação", 4, this));
        departamentos.add(new Departamento("Serviços Gerais", 5, this));
    }



    public List<Funcionario> getFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();
        for(Departamento departamento : departamentos){
            funcionarios.addAll(departamento.getFuncionarios());
        }
        return funcionarios;
    }



     public List<Funcionario> getFuncionariosDepartamento(String nome){
        Departamento departamento = getDepartamento(nome);
        if (departamento != null){
            return departamento.getFuncionarios();
        }
        return null;
     }



     private Funcionario searchFuncionario(int codigo) {
        List<Funcionario> funcionarios = getFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCodigo() == codigo) {
                return funcionario;
            }
        }
        return null;
    }


     public Departamento getDepartamento(String nome){
        for (Departamento departamento: departamentos){
            if (departamento.getNome().equals(nome)){
                return departamento;
            }
        }
        return null;
     }



     public void removeFuncionario(Funcionario funcionario){
        
     }



    public void exibirMenu() {
        System.out.println("\n============== MENU ==============");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Alterar Dados do Funcionário");
        System.out.println("3. Excluir Funcionário");
        System.out.println("4. Exibir Dados do Funcionário");
        System.out.println("5. Consultar Departamento");
        System.out.println("0. Sair");
        System.out.println("==================================");
        System.out.print("Digite a opção desejada: ");
    }



    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do teclado

                switch (opcao) {
                    case 1:
                        cadastrarFuncionario(scanner);
                        break;
                    case 2:
                        alterarDadosFuncionario(scanner);
                        break;
                    case 3:
                        excluirFuncionario(scanner);
                        break;
                    case 4:
                        exibirDadosFuncionario(scanner);
                        break;
                    case 5:
                        exibirDadosDepartamento(scanner);
                        break;
                        
                    case 0:
                        System.out.println("=========================================================================");
                        System.out.println("                        Saindo do programa...");
                        System.out.println("=========================================================================\n");
                        break;
                    default:
                        System.out.println("=========================================================================");
                        System.out.println("               Opção inválida! Digite um número válido.");
                        System.out.println("=========================================================================\n");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("=========================================================================");
                System.out.println("               Entrada inválida! Digite um número válido.");
                System.out.println("=========================================================================\n");
                scanner.nextLine(); // Limpar o buffer do teclado
            }
        }

        scanner.close();
    }



     private void cadastrarFuncionario(Scanner scanner) {
        System.out.println("\n\n======================= CADASTRO DE FUNCIONÁRIO ========================");
        System.out.println("\n============== TIPOS ==============");
        System.out.println("1. Funcionário Integral");
        System.out.println("2. Funcionário Meio Período");
        System.out.println("3. Funcionário Terceirizado");
        System.out.println("===================================");
        System.out.print("Número do tipo de funcionário a ser cadastrado: ");

        try {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado


            System.out.println("\n\n=================== INSERÇÃO DE DADOS DO FUNCIONÁRIO ====================");
            System.out.print("Código: "); //Mudar para autoincremento
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            String nomeDepartamento = escolherDepartamento(scanner);
    
            Departamento departamento = getDepartamento(nomeDepartamento);

            if (departamento == null) return;

            switch (tipo) {

                case 1:

                    System.out.print("\nSalário: ");
                    double salario = scanner.nextDouble();

                    System.out.print("Carga horária semanal(horas): ");
                    int cargaHoraria = scanner.nextInt();

                    System.out.print("Valor dos benefícios: ");
                    double beneficios = scanner.nextDouble();

                    FuncionarioIntegral funcionarioIntegral = new FuncionarioIntegral(codigo, nome, departamento, salario, cargaHoraria, beneficios);
                    departamento.adicionar(funcionarioIntegral);
                    System.out.println("=========================================================================");
                    System.out.println("                  Funcionário cadastrado com sucesso!");
                    System.out.println("=========================================================================\n");
                    break;

                case 2:
                    
                    System.out.print("\nSalário: ");
                    salario = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do teclado

                    System.out.print("Turno de trabalho: ");
                    String turno = scanner.nextLine();
                    
                    FuncionarioMeioPeriodo funcionarioMeioPeriodo = new FuncionarioMeioPeriodo(codigo, nome, departamento, salario, turno);
                    departamento.adicionar(funcionarioMeioPeriodo);
                    System.out.println("=========================================================================");
                    System.out.println("                  Funcionário cadastrado com sucesso!");
                    System.out.println("=========================================================================\n");
                    break;

                case 3:

                    System.out.print("\nEmpresa contratante: ");
                    String empresaContratante = scanner.nextLine();

                    System.out.print("Prazo de contrato (meses): ");
                    int prazoContrato = scanner.nextInt();

                    FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado(codigo, nome, departamento, empresaContratante, prazoContrato);
                   departamento.adicionar(funcionarioTerceirizado);
                    System.out.println("=========================================================================");
                    System.out.println("                  Funcionário cadastrado com sucesso!");
                    System.out.println("=========================================================================\n");
                    break;

                default:
                    System.out.println("=========================================================================");
                    System.out.println("                     Tipo de funcionário inválido!");
                    System.out.println("=========================================================================\n");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("=========================================================================");
            System.out.println("               Entrada inválida! Digite um número válido.");
            System.out.println("=========================================================================\n");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }



     public void alterarDadosFuncionario(Scanner scanner) {
        System.out.println("\n\n=================== ALTERAÇÃO DE DADOS DO FUNCIONÁRIO ====================\n");
        System.out.print("Código do funcionário que deseja alterar: ");

        try {
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Funcionario funcionario = searchFuncionario(codigo);

            if (funcionario != null) {
                System.out.println("\n\n================= INSERÇÃO DE NOVOS DADOS DO FUNCIONÁRIO =================");
                funcionario.alterarDados(scanner);

                System.out.println("=========================================================================");
                System.out.println("             Dados do funcionário alterados com sucesso!");
                System.out.println("=========================================================================\n");


            } else {
                System.out.println("=========================================================================");
                System.out.println("                       Funcionário não encontrado!");
                System.out.println("=========================================================================\n");

            }
        } catch (InputMismatchException e) {
            System.out.println("=========================================================================");
            System.out.println("               Entrada inválida! Digite um número válido.");
            System.out.println("=========================================================================\n");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }




    private void excluirFuncionario(Scanner scanner) {
        System.out.println("\n\n======================= EXCLUSÃO DE FUNCIONÁRIO ==========================\n");
        System.out.print("Código do funcionário que deseja excluir: ");

        try {

            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Funcionario funcionario = searchFuncionario(codigo);

            if (funcionario != null) {

                Departamento departamento = funcionario.getDepartamento();
                departamento.removeFuncionario(funcionario);

                System.out.println("=========================================================================");
                System.out.println("                    Funcionário excluído com sucesso!");
                System.out.println("=========================================================================\n");


            } else {
                System.out.println("=========================================================================");
                System.out.println("                       Funcionário não encontrado!");
                System.out.println("=========================================================================\n");


            }

        } catch (InputMismatchException e) {
            System.out.println("=========================================================================");
            System.out.println("               Entrada inválida! Digite um número válido.");
            System.out.println("=========================================================================\n");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }




    private void exibirDadosFuncionario(Scanner scanner) {
        System.out.println("\n\n========================================= EXIBIÇÃO DE DADOS DO FUNCIONÁRIO ==========================================\n");
        System.out.print("Código do funcionário que deseja exibir os dados: ");

        try {
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Funcionario funcionario = searchFuncionario(codigo);

            if (funcionario != null) {
                funcionario.exibirDados();
            } else {
                System.out.println("=========================================================================");
                System.out.println("                       Funcionário não encontrado!");
                System.out.println("=========================================================================\n");

            }
        } catch (InputMismatchException e) {
           System.out.println("=========================================================================");
            System.out.println("               Entrada inválida! Digite um número válido.");
            System.out.println("=========================================================================\n");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }


    

    public static String escolherDepartamento(Scanner scanner) {
        System.out.println("\n======= DEPARTAMENTOS =======");
        System.out.println("1. Vendas");
        System.out.println("2. Recursos Humanos");
        System.out.println("3. Financeiro");
        System.out.println("4. Tecnologia da Informação");
        System.out.println("5. Serviços Gerais");
        System.out.println("=============================");

        try {
            System.out.print("Número do Departamento: ");
            int dep = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (dep) {
                case 1:
                    return "Vendas";
                case 2:
                    return "Recursos Humanos";
                case 3:
                    return "Financeiro";
                case 4:
                    return "Tecnologia da Informação";
                case 5:
                    return "Serviços Gerais";
                default:
                    System.out.println("=========================================================================");
                    System.out.println("                           Departamento inválido!");
                    System.out.println("=========================================================================\n");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("=========================================================================");
            System.out.println("               Entrada inválida! Digite um número válido.");
            System.out.println("=========================================================================\n");
            scanner.nextLine(); // Limpar o buffer do teclado
        }

        return null;
    }


    public void exibirDadosDepartamento(Scanner scanner){

          try {
            String nomeDepartamento = escolherDepartamento(scanner);

            Departamento departamento = getDepartamento(nomeDepartamento);

            if (departamento!= null) {
                departamento.exibirDados();

            } else {
                System.out.println("=========================================================================");
                System.out.println("                     Departamento não encontrado!");
                System.out.println("=========================================================================\n");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("=========================================================================");
            System.out.println("               Entrada inválida! Digite um número válido.");
            System.out.println("=========================================================================\n");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
        
    }
}