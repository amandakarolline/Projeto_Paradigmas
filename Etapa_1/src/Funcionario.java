abstract class Funcionario {

    //atributos
    String nome;
    private int identificacao;
    private double salario;
    String departamento;
     
    //construtor
    public Funcionario(String nome, int identificacao, double salario, String departamento) {
        this.nome = nome;
        this.identificacao = identificacao;
        this.salario = salario;
        this.departamento = departamento;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Método para exibir os dados do funcionário
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Identificação: " + identificacao);
        System.out.println("Salário: R$" + salario);
        System.out.println("Departamento: "+ departamento);
    }
}
