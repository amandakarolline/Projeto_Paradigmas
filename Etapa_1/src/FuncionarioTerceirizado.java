class FuncionarioTerceirizado extends Funcionario {

    //Atributos específicos
    private String empresaContratante;
    private int prazoContrato;

    //Construtor
    public FuncionarioTerceirizado(String nome, int identificacao, double salario, String departamento, String empresaContratante, int prazoContrato) {
        super(nome, identificacao, salario, departamento);
        this.empresaContratante = empresaContratante;
        this.prazoContrato = prazoContrato;
    }

    // Métodos getters e setters específicos
    public String getEmpresaContratante() {
        return empresaContratante;
    }

    public void setEmpresaContratante(String empresaContratante) {
        this.empresaContratante = empresaContratante;
    }

    public int getPrazoContrato() {
        return prazoContrato;
    }

    public void setPrazoContrato(int prazoContrato) {
        this.prazoContrato = prazoContrato;
    }

    //// Método para exibir os dados de funcionário terceirizado
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Empresa Contratante: " + empresaContratante);
        System.out.println("Prazo de Contrato: " + prazoContrato + " meses");
    }
}