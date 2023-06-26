import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Empresa {

    private List<Funcionario> funcionarios;
    private List<Departamento> departamentos;

    public Empresa() {
        funcionarios = new ArrayList<>();
        departamentos = new ArrayList<>();
    }

    
    public void exibirMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Alterar Dados do Funcionário");
        System.out.println("3. Excluir Funcionário");
        System.out.println("4. Exibir Dados do Funcionário");
        System.out.println("5. Exibir Departamentos");
        System.out.println("0. Sair");
        System.out.println("==========================");
        System.out.println("Digite a opção desejada:");
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
                        exibirDepartamenos(scanner);
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Digite um número válido.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número válido.");
                scanner.nextLine(); // Limpar o buffer do teclado
            }
        }

        scanner.close();
    }


    private void cadastrarFuncionario(Scanner scanner) {
        System.out.println("========== CADASTRO DE FUNCIONÁRIO ==========");
        System.out.println("Digite o tipo de funcionário:");
        System.out.println("1. Funcionário Integral");
        System.out.println("2. Funcionário Meio Período");
        System.out.println("3. Funcionário Terceirizado");

        try {
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            System.out.println("Digite o nome do funcionário:");
            String nome = scanner.nextLine();
            System.out.println("Digite o número de identificação do funcionário:");
            int identificacao = scanner.nextInt();
            System.out.println("Digite o salário do funcionário:");
            double salario = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do teclado
            String departamento = escolherDepartamento(scanner);

            switch (tipo) {
                case 1:
                    System.out.println("Digite a carga horária semanal do funcionário:");
                    int cargaHoraria = scanner.nextInt();
                    System.out.println("Digite o valor dos benefícios do funcionário:");
                    double beneficios = scanner.nextDouble();

                    FuncionarioIntegral funcionarioIntegral = new FuncionarioIntegral(nome, identificacao, salario, departamento, cargaHoraria, beneficios);
                    adicionarFuncionario(funcionarioIntegral);
                    break;
                case 2:
                    scanner.nextLine(); // Limpar o buffer do teclado
                    System.out.println("Digite o horário de trabalho do funcionário:");
                    String horarioTrabalho = scanner.nextLine();
                    System.out.println("Digite a remuneração por hora do funcionário:");
                    double remuneracaoHora = scanner.nextDouble();

                    FuncionarioMeioPeriodo funcionarioMeioPeriodo = new FuncionarioMeioPeriodo(nome, identificacao, salario, departamento, horarioTrabalho, remuneracaoHora);
                    adicionarFuncionario(funcionarioMeioPeriodo);
                    break;
                case 3:
                    scanner.nextLine(); // Limpar o buffer do teclado
                    System.out.println("Digite a empresa contratante do funcionário:");
                    String empresaContratante = scanner.nextLine();
                    System.out.println("Digite o prazo de contrato em meses do funcionário:");
                    int prazoContrato = scanner.nextInt();

                    FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado(nome, identificacao, salario, departamento, empresaContratante, prazoContrato);
                    adicionarFuncionario(funcionarioTerceirizado);
                    break;
                default:
                    System.out.println("Tipo de funcionário inválido!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }




    private String escolherDepartamento(Scanner scanner) {
        System.out.println("========== DEPARTAMENTO ==========");
        System.out.println("Digite o departamento:");
        System.out.println("1. Administrativo");
        System.out.println("2. Financeiro");
        System.out.println("3. RH");
        System.out.println("4. Marketing");
        System.out.println("5. Serviços Gerais");

        try {
            int dep = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (dep) {
                case 1:
                    return "Administrativo";
                case 2:
                    return "Financeiro";
                case 3:
                    return "RH";
                case 4:
                    return "Marketing";
                case 5:
                    return "Serviços Gerais";
                default:
                    System.out.println("Tipo de funcionário inválido!");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
        return null;
    }
    
    
    
    
    private void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        adicionarFuncionarioDepartamento(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }




     public void alterarDadosFuncionario(Scanner scanner) {
        System.out.println("========== ALTERAÇÃO DE DADOS DO FUNCIONÁRIO ==========");
        System.out.println("Digite o número de identificação do funcionário que deseja alterar:");

        try {
            int identificacao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Funcionario funcionario = buscarFuncionario(identificacao);

            if (funcionario != null) {
                // Aqui solicitamos ao usuário as novas informações para o funcionário
                System.out.println("Digite o novo nome do funcionário:");
                String novoNome = scanner.nextLine();
                System.out.println("Digite o novo salário do funcionário:");
                double novoSalario = scanner.nextDouble();
                String departamento = escolherDepartamento(scanner);

                // Atualizamos os dados do funcionário
                funcionario.setNome(novoNome);
                funcionario.setSalario(novoSalario);
                funcionario.setDepartamento(departamento);


                // Salvando a informação atual

                System.out.println("Dados do funcionário alterados com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }




    private void excluirFuncionario(Scanner scanner) {
        System.out.println("========== EXCLUSÃO DE FUNCIONÁRIO ==========");
        System.out.println("Digite o número de identificação do funcionário que deseja excluir:");

        try {
            int identificacao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Funcionario funcionario = buscarFuncionario(identificacao);

            if (funcionario != null) {
                funcionarios.remove(funcionario);
                System.out.println("Funcionário excluído com sucesso!");
            } else {
                System.out.println("Funcionário não encontrado!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }




    private void exibirDadosFuncionario(Scanner scanner) {
        System.out.println("========== EXIBIÇÃO DE DADOS DO FUNCIONÁRIO ==========");
        System.out.println("Digite o número de identificação do funcionário que deseja exibir os dados:");

        try {
            int identificacao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Funcionario funcionario = buscarFuncionario(identificacao);

            if (funcionario != null) {
                funcionario.exibirDados();
            } else {
                System.out.println("Funcionário não encontrado!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }


     private Funcionario buscarFuncionario(int identificacao) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdentificacao() == identificacao) {
                return funcionario;
            }
        }
        return null;
    }


    private void exibirDepartamenos(Scanner scanner) {
        System.out.println("========== EXIBIÇÃO DE DEPARTAMENTOS ==========");
        System.out.println("Digite o número de identificação do departamento que deseja exibir os dados:");

        try {
            int identificacao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            Departamento departamento = buscarDepartamento(identificacao);

            if (departamento != null) {
                departamento.exibirDados();
            } else {
                System.out.println("Departamento não encontrado!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine(); // Limpar o buffer do teclado
        }
    }

    private Departamento buscarDepartamento(int identificacao) {
        for (Departamento departamento : departamentos) {
            if (departamento.getIdentificacao() == identificacao) {
                return departamento;
            }
        }
        return null;
    }
}
