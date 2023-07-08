import java.util.Scanner;

public abstract class Funcionario implements Dados {

    private int codigo;
    private String nome;
    private Departamento departamento;
    
    public Funcionario(int codigo, String nome, Departamento departamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.departamento = departamento;
    }

   
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
    
    public abstract void alterarDados(Scanner scanner);   

    public abstract String retornaStringFuncionario();
}

