import java.util.Scanner;

public class FuncionarioIntegral extends Funcionario {

    private double salario;
    private int cargaHoraria;
    private double beneficios;


    public FuncionarioIntegral(int codigo, String nome, Departamento departamento, double salario, int cargaHoraria, double beneficios) {
        super(codigo, nome, departamento);
        this.salario = salario;
        this.cargaHoraria = cargaHoraria;
        this.beneficios = beneficios;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

    public void exibirDados() {
        System.out.println("\n=====================================================================================================================");
        System.out.print("Código: " + this.getCodigo() + "   ");
        System.out.print("Nome: " + this.getNome()+ "   ");
        System.out.print("Departamento: " + this.getDepartamento().getNome() + "   ");
        System.out.print("Salário: R$" + salario + ",   ");
        System.out.print("Carga Horária: " + cargaHoraria + " h" + "   ");
        System.out.println("Benefícios: R$" + beneficios);
        System.out.println("=====================================================================================================================");
    }

    @Override
    public void alterarDados(Scanner scanner) {
        
        Empresa empresa = getDepartamento().getEmpresa();

        System.out.print("Novo mome: ");
        String novoNome = scanner.nextLine();

        String nomeDepartamento = Empresa.escolherDepartamento(scanner);
        Departamento novoDepartamento = empresa.getDepartamento(nomeDepartamento);

        this.getDepartamento().removeFuncionario(this);
        novoDepartamento.adicionar(this);

        System.out.print("\nNovo salário: ");
        Double novoSalario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("Nova carga horária semanal (horas): ");
        int novaCargaHoraria = scanner.nextInt();

        System.out.print("Novo valor dos benefícios: ");
        Double novosBeneficios = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do teclado

        this.setNome(novoNome);
        this.setDepartamento(novoDepartamento);
        this.setSalario(novoSalario);
        this.setCargaHoraria(novaCargaHoraria);
        this.setBeneficios(novosBeneficios);
    }

    public void alterarDadosFuncionarioIntegral(String novoNome, Departamento novoDepartamento, Double novoSalario, int novaCargaHoraria,  Double novosBeneficios) {

        this.getDepartamento().removeFuncionario(this);
        novoDepartamento.adicionar(this);

        this.setNome(novoNome);
        this.setDepartamento(novoDepartamento);
        this.setSalario(novoSalario);
        this.setCargaHoraria(novaCargaHoraria);
        this.setBeneficios(novosBeneficios);
    }

    @Override
    public String retornaStringFuncionario(){

        return ("<html> Código: " + this.getCodigo()+ "<br>" + 
                "Nome: " + this.getNome() + "<br>" + 
                "Departamento: " + this.getDepartamento().getNome() + "<br>" +
                "Salário: R$" + salario + "<br>" +
                "Carga Horária: " + cargaHoraria + " h" + "<br>" +
                "Benefícios: R$" + beneficios + "</html>"
                );        
    }
}



