class FuncionarioIntegral extends Funcionario {

    // Atributos específicos
    private int cargaHoraria;
    private double beneficios;

    // Construtor
    public FuncionarioIntegral(String nome, int identificacao, double salario, String departamento, int cargaHoraria, double beneficios) {
        super(nome, identificacao, salario, departamento);
        this.cargaHoraria = cargaHoraria;
        this.beneficios = beneficios;
    }

    // Métodos getters e setters específicos
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

    // Método para exibir os dados de funcionário integral
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Carga Horária: " + cargaHoraria);
        System.out.println("Benefícios: R$" + beneficios);
    }
}
