import java.util.Scanner;

public class FuncionarioTerceirizado extends Funcionario {

    //Atributos específicos
    private String empresaContratante;
    private int prazoContrato;

    //Construtor
    public FuncionarioTerceirizado(int codigo, String nome, Departamento departamento, String empresaContratante, int prazoContrato) {
        super(codigo, nome, departamento);
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

    // Método para exibir os dados de funcionário terceirizado
    
    /*public void exibirDados() {
        //super.exibirDados();
        System.out.println("Empresa Contratante: " + empresaContratante);
        System.out.println("Prazo de Contrato: " + prazoContrato + " meses");
    }*/
    

    public void exibirDados() {
        //super.exibirDados();
        System.out.println("\n=====================================================================================================================");
        System.out.print("Código: " + this.getCodigo() + ",   ");
        System.out.print("Nome: " + this.getNome() + ",   ");
        System.out.print("Departamento: " + this.getDepartamento().getNome()+ ",   ");
        System.out.print("Empresa Contratante: " + empresaContratante + ",   ");
        System.out.println("Prazo de Contrato: " + prazoContrato + " meses");
        System.out.println("=====================================================================================================================");
    }

    @Override
    public void alterarDados(Scanner scanner){

        Empresa empresa = getDepartamento().getEmpresa();

        System.out.println("Novo Nome: ");
        String novoNome = scanner.nextLine();

        String nomeDepartamento = Empresa.escolherDepartamento(scanner);
        Departamento novoDepartamento= empresa.getDepartamento(nomeDepartamento);

        this.getDepartamento().removeFuncionario(this);
        novoDepartamento.adicionar(this);

        System.out.println("\nNova empresa contratante: ");
        String novaEmpresaContratante = scanner.nextLine();

        System.out.println("Novo prazode contrato (meses):");
        int novoPrazoDeContrato = scanner.nextInt();

        // Atualizamos os dados do funcionário
        this.setNome(novoNome);
        this.setDepartamento(novoDepartamento);
        this.setEmpresaContratante(novaEmpresaContratante);
        this.setPrazoContrato(novoPrazoDeContrato);
    }
}