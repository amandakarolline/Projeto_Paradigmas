import java.util.Scanner;

public abstract class Funcionario implements Dados {

    //atributos
    private int codigo;
    private String nome;
    private Departamento departamento;
     
    //construtor
    public Funcionario(int codigo, String nome, Departamento departamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.departamento = departamento;
    }

    // Métodos getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
   
    //public void exibirDados() {

    //}

    /*public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento.getNome());
    }*/

    public abstract void alterarDados(Scanner scanner);
    
 
}



