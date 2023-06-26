class FuncionarioMeioPeriodo extends Funcionario {

    //Atributos específicos
    private String horarioTrabalho;
    private double remuneracaoHora;

    //Construtor
    public FuncionarioMeioPeriodo(String nome, int identificacao, double salario, String departamento, String horarioTrabalho, double remuneracaoHora) {
        super(nome, identificacao, salario, departamento);
        this.horarioTrabalho = horarioTrabalho;
        this.remuneracaoHora = remuneracaoHora;
    }

    // Métodos getters e setters específicos
    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public double getRemuneracaoHora() {
        return remuneracaoHora;
    }

    public void setRemuneracaoHora(double remuneracaoHora) {
        this.remuneracaoHora = remuneracaoHora;
    }

   
    // Método para exibir os dados de funcionário de meio período
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Horário de Trabalho: " + horarioTrabalho);
        System.out.println("Remuneração por Hora: R$" + remuneracaoHora);
    }
}
