import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Departamento implements Dados {

    // Atributos
    private int codigo;
    private String nome;
    private List<Funcionario> funcionarios;
    private Empresa empresa;

    // Construtor
    public Departamento(String nome, int codigo, Empresa empresa) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
        this.empresa = empresa;

    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removeFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);

    }

    public void exibirDados() {

        System.out.println(
                "\n\n============================================= INFORMAÇÕES DO DEPARTAMENTO =============================================");
        System.out.println("Código: " + codigo + "    Nome: " + nome);
        System.out.println(
                "\n========================================== FUNCIONARIOS DO DEPARTAMENTO ============================================");
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirDados();
        }
    }

    public void alterarDados(Scanner scanner) {

    }

}
