import java.util.InputMismatchException;
import javax.swing.*;

public class EmpresaGUI extends JFrame {

    int verificarCodigo(int codigo){
        Funcionario funcionario = empresa.searchFuncionario(codigo);
        if (funcionario != null) {
            do {
                codigo++;
                funcionario = empresa.searchFuncionario(codigo);
            } while (funcionario != null);
            JOptionPane.showMessageDialog(this, "Código já existe!\n Novo código: " + codigo);
            return codigo;
        }
        return codigo;
    }
    Empresa empresa = new Empresa();
    public EmpresaGUI() {
        setTitle("Sistema de Gerenciamento de Funcionários");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Painel de seleção de opções
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));
        optionsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Labels e botões de opções
        JLabel titleLabel = new JLabel("MENU");
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24f));
        optionsPanel.add(titleLabel);
        optionsPanel.add(Box.createVerticalStrut(10));

        JButton cadastrarButton = new JButton("Cadastrar Funcionário");
        cadastrarButton.setAlignmentX(CENTER_ALIGNMENT);
        cadastrarButton.addActionListener(e -> cadastrarFuncionario());
        optionsPanel.add(cadastrarButton);
        optionsPanel.add(Box.createVerticalStrut(5));

        JButton alterarButton = new JButton("Alterar Dados do Funcionário");
        alterarButton.setAlignmentX(CENTER_ALIGNMENT);
        alterarButton.addActionListener(e -> alterarDadosFuncionario());
        optionsPanel.add(alterarButton);
        optionsPanel.add(Box.createVerticalStrut(5));

        JButton excluirButton = new JButton("Excluir Funcionário");
        excluirButton.setAlignmentX(CENTER_ALIGNMENT);
        excluirButton.addActionListener(e -> excluirFuncionario());
        optionsPanel.add(excluirButton);
        optionsPanel.add(Box.createVerticalStrut(5));

        JButton exibirButton = new JButton("Exibir Dados do Funcionário");
        exibirButton.setAlignmentX(CENTER_ALIGNMENT);
        exibirButton.addActionListener(e -> exibirDadosFuncionario());
        optionsPanel.add(exibirButton);
        optionsPanel.add(Box.createVerticalStrut(5));

        JButton consultarButton = new JButton("Consultar Departamento");
        consultarButton.setAlignmentX(CENTER_ALIGNMENT);
        consultarButton.addActionListener(e -> exibirDadosDepartamento());
        optionsPanel.add(consultarButton);
        optionsPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(optionsPanel);
        setContentPane(mainPanel);
    }
    

     private void cadastrarFuncionario() {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        String[] tipos = {"Funcionário Integral", "Funcionário Meio Período", "Funcionário Terceirizado"};
        JComboBox<String> tipoCombo = new JComboBox<>(tipos);
        JLabel tipo_funcionario = new JLabel("Tipo Funcionário:");
        tipo_funcionario.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(tipo_funcionario);
        panel.add(tipoCombo);
        
      
        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
             panel.remove(tipo_funcionario);
             panel.remove(tipoCombo);

            JTextField codigoField = new JTextField(20);
            JLabel codigoLabel = new JLabel("Código:");
            codigoLabel.setAlignmentX(CENTER_ALIGNMENT);
            panel.add(codigoLabel);
            panel.add(codigoField);

            JTextField nomeField = new JTextField(20);
            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setAlignmentX(CENTER_ALIGNMENT);
            panel.add(nomeLabel);
            panel.add(nomeField);
     
            String[] departamentos = {"Vendas", "Recursos Humanos", "Financeiro", "Tecnologia da Informação", "Serviços Gerais"};
            JComboBox<String> departamentoCombo = new JComboBox<>(departamentos);
            JLabel departamentoLabel = new JLabel("Departamento:");
            departamentoLabel.setAlignmentX(CENTER_ALIGNMENT);
            panel.add(departamentoLabel);
            panel.add(departamentoCombo);

            JTextField salarioField = new JTextField(20);
            JTextField cargaHorariaField = new JTextField(20);
            JTextField beneficiosField = new JTextField(20);

            JTextField turnoField = new JTextField(20);

            JTextField empresaContratanteField = new JTextField(20);
            JTextField prazoContratoField = new JTextField(20);


            String selectedItem = (String) tipoCombo.getSelectedItem();


            switch (selectedItem) {
                case "Funcionário Integral" -> {

                    JLabel salarioLabel = new JLabel("Salário:");
                    salarioLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(salarioLabel);
                    panel.add(salarioField);

                    JLabel cargaHorariaLabel = new JLabel("Carga Horária:");
                    cargaHorariaLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(cargaHorariaLabel);
                    panel.add(cargaHorariaField);

                    JLabel beneficiosLabel = new JLabel("Benefícios:");
                    beneficiosLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(beneficiosLabel);
                    panel.add(beneficiosField);


                }
                case "Funcionário Meio Período" -> {

                    JLabel salarioLabel = new JLabel("Salário:");
                    salarioLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(salarioLabel);
                    panel.add(salarioField);

                    JLabel turnoLabel = new JLabel("Turno de Trabalho:");
                    turnoLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(turnoLabel);
                    panel.add(turnoField);


                }
                case "Funcionário Terceirizado" -> {
                    JLabel empresaContratanteLabel = new JLabel("Empresa Contratante:");
                    empresaContratanteLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(empresaContratanteLabel);
                    panel.add(empresaContratanteField);
                    JLabel prazoContratoLabel = new JLabel("Prazo de Contrato:");
                    prazoContratoLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(prazoContratoLabel);
                    panel.add(prazoContratoField);
                }
            }

            
            result = JOptionPane.showConfirmDialog(this, panel, "Cadastro de Funcionário",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {

                switch (selectedItem) {
                    case "Funcionário Integral" -> {
                        try {
                            int codigo = Integer.parseInt(codigoField.getText());
                            String nome = nomeField.getText();
                            Departamento departamento = empresa.getDepartamento( (String) departamentoCombo.getSelectedItem());
                            double salario = Double.parseDouble(salarioField.getText());
                            int cargaHoraria = Integer.parseInt(cargaHorariaField.getText());
                            double beneficios = Double.parseDouble(beneficiosField.getText());

                            codigo = verificarCodigo(codigo);
                            FuncionarioIntegral funcionarioIntegral = new FuncionarioIntegral(codigo, nome, departamento, salario, cargaHoraria, beneficios);
                            departamento.adicionar(funcionarioIntegral);
                            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");

                        } catch (InputMismatchException e) {
                            JOptionPane.showMessageDialog(this, "Por favor, dê informações válidas!");
                        }
                    }
                    case "Funcionário Meio Período" -> {
                        try {
                            int codigo = Integer.parseInt(codigoField.getText());
                            String nome = nomeField.getText();
                            Departamento departamento = empresa.getDepartamento( (String) departamentoCombo.getSelectedItem());
                            double salario = Double.parseDouble(salarioField.getText());
                            String turno = turnoField.getText();

                            codigo = verificarCodigo(codigo);
                            FuncionarioMeioPeriodo funcionarioMeioPeriodo = new FuncionarioMeioPeriodo(codigo, nome, departamento, salario, turno);
                            departamento.adicionar(funcionarioMeioPeriodo);
                            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");

                        } catch (InputMismatchException e) {
                            JOptionPane.showMessageDialog(this, "Por favor, dê informações válidas!");
                        }
                    }
                    case "Funcionário Terceirizado" -> {
                        try {
                            int codigo = Integer.parseInt(codigoField.getText());
                            String nome = nomeField.getText();
                            Departamento departamento = empresa.getDepartamento( (String) departamentoCombo.getSelectedItem());
                            String empresaContratante = empresaContratanteField.getText();
                            int prazoContrato = Integer.parseInt(prazoContratoField.getText());

                            codigo = verificarCodigo(codigo);
                            FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado(codigo, nome, departamento, empresaContratante, prazoContrato);
                            departamento.adicionar(funcionarioTerceirizado);
                            JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");

                        } catch (InputMismatchException e) {
                            JOptionPane.showMessageDialog(this, "Por favor, dê informações válidas!");
                        }
                    }
                }
            }
        }
    }
    

    private void alterarDadosFuncionario() {
        JTextField codigoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Código do funcionário a ser Alterado:"));
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Alterar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {

            try {
                int codigo = Integer.parseInt(codigoField.getText());
                Funcionario funcionario = empresa.searchFuncionario(codigo);
                if (funcionario != null) {
                    JTextField novoNomeField = new JTextField(20);
                    JLabel novoNomeLabel = new JLabel("Novo nome:");
                    novoNomeLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(novoNomeLabel);
                    panel.add(novoNomeField);

                    String[] departamentos = {"Vendas", "Recursos Humanos", "Financeiro", "Tecnologia da Informação", "Serviços Gerais"};
                    JComboBox<String> novoDepartamentoCombo = new JComboBox<>(departamentos);
                    JLabel novoDepartamentoLabel = new JLabel("Novo departamento:");
                    novoDepartamentoLabel.setAlignmentX(CENTER_ALIGNMENT);
                    panel.add(novoDepartamentoLabel);
                    panel.add(novoDepartamentoCombo);

                    JTextField novoSalarioField = new JTextField(20);
                    JTextField novaCargaHorariaField = new JTextField(20);
                    JTextField novosBeneficiosField = new JTextField(20);

                    JTextField novoTurnoField = new JTextField(20);

                    JTextField novaEmpresaContratanteField = new JTextField(20);
                    JTextField novoPrazoContratoField = new JTextField(20);

                    if (funcionario instanceof FuncionarioIntegral) {
                        JLabel novoSalarioLabel = new JLabel("Novo Salário:");
                        novoSalarioLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(novoSalarioLabel);
                        panel.add(novoSalarioField);

                        JLabel novaCargaHorariaLabel = new JLabel("Nova Carga Horária:");
                        novaCargaHorariaLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(novaCargaHorariaLabel);
                        panel.add(novaCargaHorariaField);

                        JLabel novosBeneficiosLabel = new JLabel("Novos Benefícios:");
                        novosBeneficiosLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(novosBeneficiosLabel);
                        panel.add(novosBeneficiosField);

                        String novoNome = novoNomeField.getText();
                        Departamento nomeDepartamento = empresa.getDepartamento( (String) novoDepartamentoCombo.getSelectedItem());
                        double novoSalario = Double.parseDouble(novoSalarioField.getText());
                        int novaCargaHoraria = Integer.parseInt(novaCargaHorariaField.getText());
                        double novosBeneficios = Double.parseDouble(novosBeneficiosField.getText());

                        ((FuncionarioIntegral) funcionario).alterarDadosFuncionarioIntegral(novoNome, String.valueOf(nomeDepartamento), novoSalario, novaCargaHoraria,  novosBeneficios);
                    } else if (funcionario instanceof FuncionarioMeioPeriodo) {
                        JLabel novoSalarioLabel = new JLabel("Novo Salário:");
                        novoSalarioLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(novoSalarioLabel);
                        panel.add(novoSalarioField);

                        JLabel turnoLabel = new JLabel("Novo Turno de Trabalho:");
                        turnoLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(turnoLabel);
                        panel.add(novoTurnoField);

                       String novoNome = novoNomeField.getText();
                       Departamento nomeDepartamento = empresa.getDepartamento( (String) novoDepartamentoCombo.getSelectedItem());
                       double novoSalario = Double.parseDouble(novoSalarioField.getText());
                       String novoTurno = novoTurnoField.getText();

                        ((FuncionarioMeioPeriodo) funcionario).alterarDadosMeioPeriodo(novoNome, String.valueOf(nomeDepartamento), novoSalario,  novoTurno);
                    } else {
                        JLabel empresaContratanteLabel = new JLabel("Empresa Contratante:");
                        empresaContratanteLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(empresaContratanteLabel);
                        panel.add(novaEmpresaContratanteField);
                        JLabel prazoContratoLabel = new JLabel("Prazo de Contrato:");
                        prazoContratoLabel.setAlignmentX(CENTER_ALIGNMENT);
                        panel.add(prazoContratoLabel);
                        panel.add(novoPrazoContratoField);

                        String novoNome = novoNomeField.getText();
                        Departamento novoDepartamento = empresa.getDepartamento( (String) novoDepartamentoCombo.getSelectedItem());
                        String novaEmpresaContratante = novaEmpresaContratanteField.getText();
                        int novoPrazoContrato = Integer.parseInt(novoPrazoContratoField.getText());

                        ((FuncionarioTerceirizado) funcionario).alterarDadosTerceirizados(novoNome, String.valueOf(novoDepartamento), novaEmpresaContratante, novoPrazoContrato);
                    }
                    JOptionPane.showMessageDialog(this, "Funcionário alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Funcionário não encontrado!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido. Por favor, insira um número inteiro.");
            }
        }
    }

    private void excluirFuncionario() {
        JTextField codigoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Código do funcionário a ser excluído:"));
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Excluir Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                Funcionario funcionario = empresa.searchFuncionario(codigo);
                if (funcionario != null) {
                    Departamento departamento = funcionario.getDepartamento();
                    departamento.removeFuncionario(funcionario);
                    JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Funcionário não encontrado!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido. Por favor, insira um número inteiro.");
            }
        }
    }

    private void exibirDadosFuncionario() {
        JTextField codigoField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Código do funcionário a ser exibido:"));
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Exibir Dados do Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                // Adicionar lógica para exibir os dados do funcionário
                JOptionPane.showMessageDialog(this, "Dados do funcionário exibidos com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido. Por favor, insira um número inteiro.");
            }
        }
    }

    private void exibirDadosDepartamento() {
        String[] departamentos = {"Vendas", "Recursos Humanos", "Financeiro", "Tecnologia da Informação", "Serviços Gerais"};
        JComboBox<String> departamentoCombo = new JComboBox<>(departamentos);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Departamento:"));
        panel.add(departamentoCombo);

        int result = JOptionPane.showConfirmDialog(this, panel, "Consultar Departamento",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String departamento = (String) departamentoCombo.getSelectedItem();
            // Adicionar lógica para exibir os dados do departamento
            JOptionPane.showMessageDialog(this, "Dados do departamento exibidos com sucesso!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpresaGUI empresaGUI = new EmpresaGUI();
            empresaGUI.setVisible(true);
        });
    }
}
