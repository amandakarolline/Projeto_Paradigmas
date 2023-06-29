import java.util.Scanner;

public class FuncionarioMeioPeriodo extends Funcionario {

    private double salario;
    private String turno;

    public FuncionarioMeioPeriodo(int codigo, String nome, Departamento departamento, double salario, String turno) {
        super(codigo, nome, departamento);
        this.salario = salario;
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void exibirDados() {
        System.out.println(
                "\n=====================================================================================================================");
        System.out.print("Código: " + this.getCodigo() + "   ");
        System.out.print("Nome: " + this.getNome() + "   ");
        System.out.print("Departamento: " + this.getDepartamento().getNome() + "   ");
        System.out.print("Salário: R$" + salario + "   ");
        System.out.println("Turno de Trabalho: " + turno);
        System.out.println(
                "=====================================================================================================================");
    }

    @Override
    public void alterarDados(Scanner scanner) {

        Empresa empresa = getDepartamento().getEmpresa();

        System.out.println("Novo nome: ");
        String novoNome = scanner.nextLine();

        String nomeDepartamento = Empresa.escolherDepartamento(scanner);
        Departamento novoDepartamento = empresa.getDepartamento(nomeDepartamento);

        this.getDepartamento().removeFuncionario(this);
        novoDepartamento.adicionar(this);

        System.out.println("\nNovo Salário: ");
        Double novoSalario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Novo turno de trabalho: ");
        String novoTurno = scanner.nextLine();

        this.setNome(novoNome);
        this.setDepartamento(novoDepartamento);
        this.setSalario(novoSalario);
        this.setTurno(novoTurno);
    }

}
