import java.util.ArrayList;
import java.util.List;

abstract class Departamento {

    private String nome;
    private int identificador;
    private List<Object[]> departamentos;
    private List<Funcionario> pessoas;
        
    public Departamento(){
        departamentos = new ArrayList<>();
        pessoas = new ArrayList<>();

        // Definindo departamentos
        departamentos.add(new Object[]{"Administrativo", 1, new ArrayList<>()});
        departamentos.add(new Object[]{"Financeiro", 2, new ArrayList<>()});
        departamentos.add(new Object[]{"RH", 3, new ArrayList<>()});
        departamentos.add(new Object[]{"Marketing", 4, new ArrayList<>()});
        departamentos.add(new Object[]{"Servicos Gerais", 5, new ArrayList<>()});

        //lista de pessoas por departamentos
        List<Object> departamentoAdministrativo = (List<Object>) departamentos.get(0)[2];
        List<Object> departamentoFinanceiro = (List<Object>) departamentos.get(1)[2];
        List<Object> departamentoRH = (List<Object>) departamentos.get(2)[2];
        List<Object> departamentoMarketing = (List<Object>) departamentos.get(3)[2];
        List<Object> departamentoServicosGerais = (List<Object>) departamentos.get(4)[2];
    }

    //atributos
    private String funcionario;
     
    //construtor
    public Departamento(String funcionario) {
        this.funcionario = funcionario;
    }

    // Métodos getters e setters
    public int getIdentificacao() {
        return identificador;
    }

    public String getFuncionario() {
        return nome;
    }


    // Método para exibir os dados do funcionário
    public void exibirDados() {
        Object[] selecionado = departamentos.get(0);
        System.out.println("Nome: " + selecionado[0]);
        System.out.println("Identificação: " + selecionado[1]);
        System.out.println("Funcionarios no departamento: "+ selecionado[2]);
    }
}
