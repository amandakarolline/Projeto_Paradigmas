import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;


public class EmpresaGUI extends JFrame {

    Empresa empresa = new Empresa();

    public EmpresaGUI() {

        // Janela principal
        setTitle("Sistema de Gerenciamento de Funcionários");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Painel de seleção de opções do menu
        JPanel opcoesPanel = new JPanel();
        opcoesPanel.setLayout(new GridLayout(0, 1, 0, 10));
        opcoesPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));

        // Label do menu
        JLabel menuLabel = new JLabel("MENU");
        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel.setFont(menuLabel.getFont().deriveFont(16f));
        opcoesPanel.add(menuLabel);

        // Botão de cadastrar funcionário
        JButton cadastrarButton = new JButton("Cadastrar Funcionário");
        cadastrarButton.setAlignmentX(CENTER_ALIGNMENT);
        cadastrarButton.addActionListener(e -> cadastrarFuncionario());
        opcoesPanel.add(cadastrarButton);

        // Botão de alterar funcionário
        JButton alterarButton = new JButton("Alterar Dados do Funcionário");
        alterarButton.setAlignmentX(CENTER_ALIGNMENT);
        alterarButton.addActionListener(e -> alterarDadosFuncionario());
        opcoesPanel.add(alterarButton);

        // Botão de excluir funcionário
        JButton excluirButton = new JButton("Excluir Funcionário");
        excluirButton.setAlignmentX(CENTER_ALIGNMENT);
        excluirButton.addActionListener(e -> excluirFuncionario());
        opcoesPanel.add(excluirButton);

        // Botão de exibir dados de um funcionário
        JButton exibirButton = new JButton("Exibir Dados do Funcionário");
        exibirButton.setAlignmentX(CENTER_ALIGNMENT);
        exibirButton.addActionListener(e -> exibirDadosFuncionario());
        opcoesPanel.add(exibirButton);

        // Botão de consultar dados de um departamento
        JButton consultarButton = new JButton("Consultar Departamento");
        consultarButton.setAlignmentX(CENTER_ALIGNMENT);
        consultarButton.addActionListener(e -> exibirDadosDepartamento());
        opcoesPanel.add(consultarButton);

        setContentPane(opcoesPanel);
    }

    // Método que verifica se o código informado para cadastrado já pertence a um
    // funcionário da empresa.
    // Retorna um novo código caso o código informado para cadastro já esteja no
    // sitema
    int verificarCodigo(int codigo) {
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

    // Método para cadastrar um funcionário no sistema da empresa
    private void cadastrarFuncionario() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 0, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

        String[] tipos = { "Funcionário Integral", "Funcionário Meio Período", "Funcionário Terceirizado" };
        JComboBox<String> tipoCombo = new JComboBox<>(tipos);

        JLabel tipoFuncionarioLabel = new JLabel("Tipo Funcionário:");
        tipoFuncionarioLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(tipoFuncionarioLabel);
        panel.add(tipoCombo);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            panel.remove(tipoFuncionarioLabel);
            panel.remove(tipoCombo);

            JTextField codigoField = new JTextField(20);
            JLabel codigoLabel = new JLabel("Código do funcionário:");
            codigoLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(codigoLabel);
            panel.add(codigoField);

            JTextField nomeField = new JTextField(20);
            JLabel nomeLabel = new JLabel("Nome do funcionário:");
            nomeLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(nomeLabel);
            panel.add(nomeField);

            String[] departamentos = { "Vendas", "Recursos Humanos", "Financeiro", "Tecnologia da Informação",
                    "Serviços Gerais" };
            JComboBox<String> departamentoCombo = new JComboBox<>(departamentos);
            JLabel departamentoLabel = new JLabel("Departamento do funcionário:");
            departamentoLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(departamentoLabel);
            panel.add(departamentoCombo);

            JTextField salarioField = new JTextField(20);
            JTextField cargaHorariaField = new JTextField(20);
            JTextField beneficiosField = new JTextField(20);

            String[] turnos = { "Matutino", "Vespertino", "Noturno" };
            JComboBox<String> turnoCombo = new JComboBox<>(turnos);

            JTextField empresaContratanteField = new JTextField(20);
            JTextField prazoContratoField = new JTextField(20);

            String selectedItem = (String) tipoCombo.getSelectedItem();

            switch (selectedItem) {
                case "Funcionário Integral" -> {

                    JLabel salarioLabel = new JLabel("Salário (em reais):");
                    salarioLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(salarioLabel);
                    panel.add(salarioField);

                    JLabel cargaHorariaLabel = new JLabel("Carga Horária Semanal (horas):");
                    cargaHorariaLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(cargaHorariaLabel);
                    panel.add(cargaHorariaField);

                    JLabel beneficiosLabel = new JLabel("Benefícios (em reais):");
                    beneficiosLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(beneficiosLabel);
                    panel.add(beneficiosField);

                }
                case "Funcionário Meio Período" -> {

                    JLabel salarioLabel = new JLabel("Salário (em reais):");
                    salarioLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(salarioLabel);
                    panel.add(salarioField);

                    JLabel turnoLabel = new JLabel("Turno de Trabalho:");
                    turnoLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(turnoLabel);
                    panel.add(turnoCombo);

                }
                case "Funcionário Terceirizado" -> {
                    JLabel empresaContratanteLabel = new JLabel("Empresa Contratante:");
                    empresaContratanteLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(empresaContratanteLabel);
                    panel.add(empresaContratanteField);
                    JLabel prazoContratoLabel = new JLabel("Prazo de Contrato (em meses):");
                    prazoContratoLabel.setHorizontalAlignment(JLabel.CENTER);
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
                            Departamento departamento = empresa
                                    .getDepartamento((String) departamentoCombo.getSelectedItem());
                            double salario = Double.parseDouble(salarioField.getText());
                            int cargaHoraria = Integer.parseInt(cargaHorariaField.getText());
                            double beneficios = Double.parseDouble(beneficiosField.getText());

                            codigo = verificarCodigo(codigo);
                            FuncionarioIntegral funcionarioIntegral = new FuncionarioIntegral(codigo, nome,
                                    departamento, salario, cargaHoraria, beneficios);
                            departamento.adicionar(funcionarioIntegral);
                            JOptionPane.showMessageDialog(this, funcionarioIntegral.retornaStringFuncionario() +
                                    "\n" + "Funcionário cadastrado com sucesso!");

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Por favor, dê informações válidas!");
                        }
                    }
                    case "Funcionário Meio Período" -> {
                        try {
                            int codigo = Integer.parseInt(codigoField.getText());
                            String nome = nomeField.getText();
                            Departamento departamento = empresa
                                    .getDepartamento((String) departamentoCombo.getSelectedItem());
                            double salario = Double.parseDouble(salarioField.getText());
                            String turno = (String) turnoCombo.getSelectedItem();

                            codigo = verificarCodigo(codigo);
                            FuncionarioMeioPeriodo funcionarioMeioPeriodo = new FuncionarioMeioPeriodo(codigo, nome,
                                    departamento, salario, turno);
                            departamento.adicionar(funcionarioMeioPeriodo);
                            JOptionPane.showMessageDialog(this, funcionarioMeioPeriodo.retornaStringFuncionario() +
                                    "\n" + "Funcionário cadastrado com sucesso!");

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Por favor, dê informações válidas!");
                        }
                    }
                    case "Funcionário Terceirizado" -> {
                        try {
                            int codigo = Integer.parseInt(codigoField.getText());
                            String nome = nomeField.getText();
                            Departamento departamento = empresa
                                    .getDepartamento((String) departamentoCombo.getSelectedItem());
                            String empresaContratante = empresaContratanteField.getText();
                            int prazoContrato = Integer.parseInt(prazoContratoField.getText());

                            codigo = verificarCodigo(codigo);
                            FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado(codigo, nome,
                                    departamento, empresaContratante, prazoContrato);
                            departamento.adicionar(funcionarioTerceirizado);
                            JOptionPane.showMessageDialog(this,funcionarioTerceirizado.retornaStringFuncionario() +
                                    "\n" + "Funcionário cadastrado com sucesso!");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Por favor, dê informações válidas!");
                        }
                    }
                }
            }
        }
    }



    // Método para alterar dados de um funcionário no sistema da empresa
    private void alterarDadosFuncionario() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

        JTextField codigoField = new JTextField(10);
        JLabel codigoLabel = new JLabel("Código do funcionário:");
        codigoLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(codigoLabel);
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Alterar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            panel.remove(codigoLabel);
            panel.remove(codigoField);

            try {
                int codigo = Integer.parseInt(codigoField.getText());
                Funcionario funcionario = empresa.searchFuncionario(codigo);

                if (funcionario != null) {
                    JTextField novoNomeField = new JTextField(20);
                    JLabel novoNomeLabel = new JLabel("Novo nome:");
                    novoNomeLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(novoNomeLabel);
                    panel.add(novoNomeField);
                    novoNomeField.setText(funcionario.getNome());

                    String[] departamentos = { "Vendas", "Recursos Humanos", "Financeiro", "Tecnologia da Informação",
                            "Serviços Gerais" };
                    JComboBox<String> novoDepartamentoCombo = new JComboBox<>(departamentos);
                    JLabel novoDepartamentoLabel = new JLabel("Novo departamento:");
                    novoDepartamentoLabel.setHorizontalAlignment(JLabel.CENTER);
                    panel.add(novoDepartamentoLabel);
                    panel.add(novoDepartamentoCombo);
                    novoDepartamentoCombo.setSelectedItem(funcionario.getDepartamento().getNome());

                    JTextField novoSalarioField = new JTextField(20);
                    JTextField novaCargaHorariaField = new JTextField(20);
                    JTextField novosBeneficiosField = new JTextField(20);

                    String[] turnos = { "Matutino", "Vespertino", "Noturno" };
                    JComboBox<String> turnoCombo = new JComboBox<>(turnos);

                    JTextField novaEmpresaContratanteField = new JTextField(20);
                    JTextField novoPrazoContratoField = new JTextField(20);

                    if (funcionario instanceof FuncionarioIntegral) {

                        FuncionarioIntegral funcionarioIntegral = (FuncionarioIntegral) funcionario;
                        String salarioAtual = Double.toString(funcionarioIntegral.getSalario());
                        JLabel novoSalarioLabel = new JLabel("Novo Salário:");
                        novoSalarioLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(novoSalarioLabel);
                        panel.add(novoSalarioField);
                        novoSalarioField.setText(salarioAtual);

                        String cargaHorariaAtual = Integer.toString(funcionarioIntegral.getCargaHoraria());
                        JLabel novaCargaHorariaLabel = new JLabel("Nova Carga Horária:");
                        novaCargaHorariaLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(novaCargaHorariaLabel);
                        panel.add(novaCargaHorariaField);
                        novaCargaHorariaField.setText(cargaHorariaAtual);

                        String beneficiosAtual = Double.toString(funcionarioIntegral.getBeneficios());
                        JLabel novosBeneficiosLabel = new JLabel("Novos Benefícios:");
                        novosBeneficiosLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(novosBeneficiosLabel);
                        panel.add(novosBeneficiosField);
                        novosBeneficiosField.setText(beneficiosAtual);

                    } else if (funcionario instanceof FuncionarioMeioPeriodo) {

                        FuncionarioMeioPeriodo funcionarioMeioPeriodo = (FuncionarioMeioPeriodo) funcionario;
                        String salarioAtual = Double.toString(funcionarioMeioPeriodo.getSalario());
                        JLabel novoSalarioLabel = new JLabel("Novo Salário:");
                        novoSalarioLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(novoSalarioLabel);
                        panel.add(novoSalarioField);
                        novoSalarioField.setText(salarioAtual);

                        JLabel turnoLabel = new JLabel("Novo Turno de Trabalho:");
                        turnoLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(turnoLabel);
                        panel.add(turnoCombo);
                        turnoCombo.setSelectedItem(funcionarioMeioPeriodo.getTurno());

                    } else {

                        FuncionarioTerceirizado funcionarioTerceirizado = (FuncionarioTerceirizado) funcionario;

                        JLabel empresaContratanteLabel = new JLabel("Empresa Contratante:");
                        empresaContratanteLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(empresaContratanteLabel);
                        panel.add(novaEmpresaContratanteField);
                        novaEmpresaContratanteField.setText(funcionarioTerceirizado.getEmpresaContratante());

                        String prazoContratoAtual = Integer.toString(funcionarioTerceirizado.getPrazoContrato());
                        JLabel prazoContratoLabel = new JLabel("Prazo de Contrato:");
                        prazoContratoLabel.setHorizontalAlignment(JLabel.CENTER);
                        panel.add(prazoContratoLabel);
                        panel.add(novoPrazoContratoField);
                        novoPrazoContratoField.setText(prazoContratoAtual);
                    }

                    result = JOptionPane.showConfirmDialog(this, panel, "Alterar Funcionário",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        if (funcionario instanceof FuncionarioIntegral) {

                            String novoNome = novoNomeField.getText();
                            Departamento novoDepartamento = empresa
                                    .getDepartamento((String) novoDepartamentoCombo.getSelectedItem());
                            double novoSalario = Double.parseDouble(novoSalarioField.getText());
                            int novaCargaHoraria = Integer.parseInt(novaCargaHorariaField.getText());
                            double novosBeneficios = Double.parseDouble(novosBeneficiosField.getText());

                            ((FuncionarioIntegral) funcionario).alterarDadosFuncionarioIntegral(novoNome,
                                    novoDepartamento, novoSalario, novaCargaHoraria, novosBeneficios);
                        } else if (funcionario instanceof FuncionarioMeioPeriodo) {

                            String novoNome = novoNomeField.getText();
                            Departamento novoDepartamento = empresa
                                    .getDepartamento((String) novoDepartamentoCombo.getSelectedItem());
                            double novoSalario = Double.parseDouble(novoSalarioField.getText());
                            String novoTurno = (String) turnoCombo.getSelectedItem();

                            ((FuncionarioMeioPeriodo) funcionario).alterarDadosMeioPeriodo(novoNome, novoDepartamento,
                                    novoSalario, novoTurno);
                        } else {

                            String novoNome = novoNomeField.getText();
                            Departamento novoDepartamento = empresa
                                    .getDepartamento((String) novoDepartamentoCombo.getSelectedItem());
                            String novaEmpresaContratante = novaEmpresaContratanteField.getText();
                            int novoPrazoContrato = Integer.parseInt(novoPrazoContratoField.getText());

                            ((FuncionarioTerceirizado) funcionario).alterarDadosTerceirizados(novoNome,
                                    novoDepartamento, novaEmpresaContratante, novoPrazoContrato);
                        }
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


    
    // Método para excluir um funcionário do sistema da empresa
    private void excluirFuncionario() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

        JTextField codigoField = new JTextField(10);
        JLabel codigoLabel = new JLabel("Código do funcionário:");
        codigoLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(codigoLabel);
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Excluir Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                Funcionario funcionario = empresa.searchFuncionario(codigo);

                if (funcionario != null) {
                    panel.remove(codigoLabel);
                    panel.remove(codigoField);
                    JLabel mensagemExcluir = new JLabel("<html>Tem certeza que deseja excluir?" + "<br><br>" +
                                            funcionario.retornaStringFuncionario());
                    panel.add(mensagemExcluir);

                    Integer nResult = JOptionPane.showConfirmDialog(this, panel, "Excluir Funcionário",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (nResult == JOptionPane.OK_OPTION) {
                        Departamento departamento = funcionario.getDepartamento();
                        departamento.removeFuncionario(funcionario);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Funcionário não encontrado!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Código inválido. Por favor, insira um número inteiro.");
            }
        }
    }


    // Método para exibir dados de um funcionário da empresa
    private void exibirDadosFuncionario() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 20, 25));

        JTextField codigoField = new JTextField(10);
        JLabel codigoLabel = new JLabel("Código do funcionário:");
        codigoLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(codigoLabel);
        panel.add(codigoField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Exibir Dados do Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            panel.remove(codigoLabel);
            panel.remove(codigoField);

            try {
                int codigo = Integer.parseInt(codigoField.getText());
                Funcionario funcionario = empresa.searchFuncionario(codigo);

                if (funcionario != null) {
                    JLabel codigoExibir = new JLabel("Código: " + funcionario.getCodigo());
                    codigoExibir.setAlignmentX(CENTER_ALIGNMENT);
                    JLabel nomeExibir = new JLabel("Nome: " + funcionario.getNome());
                    nomeExibir.setAlignmentX(CENTER_ALIGNMENT);
                    JLabel departamentoExibir = new JLabel("Departamento: " + funcionario.getDepartamento().getNome());
                    departamentoExibir.setAlignmentX(CENTER_ALIGNMENT);

                    if (funcionario instanceof FuncionarioIntegral) {
                        FuncionarioIntegral funcionarioIntegral = (FuncionarioIntegral) funcionario;

                        JLabel salarioExibir = new JLabel("Salário: R$ " + funcionarioIntegral.getSalario());
                        salarioExibir.setAlignmentX(CENTER_ALIGNMENT);
                        JLabel cargaHorariaExibir = new JLabel(
                                "Carga Horária: " + funcionarioIntegral.getCargaHoraria());
                        cargaHorariaExibir.setAlignmentX(CENTER_ALIGNMENT);
                        JLabel beneficiosExibir = new JLabel("Benefícios: R$" + funcionarioIntegral.getBeneficios());
                        beneficiosExibir.setAlignmentX(CENTER_ALIGNMENT);

                        panel.add(codigoExibir);
                        panel.add(nomeExibir);
                        panel.add(departamentoExibir);
                        panel.add(salarioExibir);
                        panel.add(cargaHorariaExibir);
                        panel.add(beneficiosExibir);

                    } else if (funcionario instanceof FuncionarioMeioPeriodo) {
                        FuncionarioMeioPeriodo funcionarioMeioPeriodo = (FuncionarioMeioPeriodo) funcionario;

                        JLabel salarioExibir = new JLabel("Salário: R$ " + funcionarioMeioPeriodo.getSalario());
                        salarioExibir.setAlignmentX(CENTER_ALIGNMENT);
                        JLabel turnoExibir = new JLabel("Turno: " + funcionarioMeioPeriodo.getTurno());
                        turnoExibir.setAlignmentX(CENTER_ALIGNMENT);

                        panel.add(codigoExibir);
                        panel.add(nomeExibir);
                        panel.add(departamentoExibir);
                        panel.add(salarioExibir);
                        panel.add(turnoExibir);

                    } else if (funcionario instanceof FuncionarioTerceirizado) {
                        FuncionarioTerceirizado funcionarioTerceirizado = (FuncionarioTerceirizado) funcionario;

                        JLabel empresaContratanteExibir = new JLabel(
                                "Empresa Contratante: " + funcionarioTerceirizado.getEmpresaContratante());
                        empresaContratanteExibir.setAlignmentX(CENTER_ALIGNMENT);
                        JLabel prazoContratoExibir = new JLabel(
                                "Prazo de Contrato: " + funcionarioTerceirizado.getPrazoContrato());
                        prazoContratoExibir.setAlignmentX(CENTER_ALIGNMENT);

                        panel.add(codigoExibir);
                        panel.add(nomeExibir);
                        panel.add(departamentoExibir);
                        panel.add(empresaContratanteExibir);
                        panel.add(prazoContratoExibir);
                    }

                    JOptionPane.showConfirmDialog(this, panel, "Dados do funcionário",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Funcionário não encontrado!");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido. Por favor, insira um número inteiro.");
            }
        }
    }

    
    //Método para exibir codigo e nome dos funcionarios alocados no departamento escolhido
    private void exibirDadosDepartamento() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 1, 0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        String[] departamentos = { "Vendas", "Recursos Humanos", "Financeiro", "Tecnologia da Informação",
                "Serviços Gerais" };
        JComboBox<String> departamentoCombo = new JComboBox<>(departamentos);
        
        JLabel departamentoLabel = new JLabel("Departamento:");
        departamentoLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(departamentoLabel);
        panel.add(departamentoCombo);

        int result = JOptionPane.showConfirmDialog(this, panel, "Consultar Departamento",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nomeDepartamento = (String) departamentoCombo.getSelectedItem();
            Departamento departamento = empresa.getDepartamento(nomeDepartamento);

            panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), departamento.getNome(), TitledBorder.LEFT, 
                TitledBorder.TOP
            ));

            if (departamento != null) {
                panel.remove(departamentoLabel);
                panel.remove(departamentoCombo);

                JLabel codigoFuncionarioLabel = new JLabel("Código do Funcionário" );
                codigoFuncionarioLabel.setHorizontalAlignment(JLabel.CENTER);
        
                JLabel nomeFuncionarioLabel = new JLabel("Nome do funcionário");
                nomeFuncionarioLabel.setHorizontalAlignment(JLabel.CENTER);

                String[] colunas = {"Codigo", "Funcionario"};
                String [][]dados = new String[departamento.getFuncionarios().size()][2];
                
                for (Integer i = 0; i < departamento.getFuncionarios().size(); i++) {
                    Funcionario funcionario = departamento.getFuncionarios().get(i);
                    String sCodigo = Integer.toString(funcionario.getCodigo());
                    String [] linha = {sCodigo, funcionario.getNome()};
                    dados[i] = linha;
                }

                JTable table = new JTable (dados ,colunas);
                JScrollPane scrollPane = new JScrollPane(table);

                panel.add(scrollPane);
               
                JOptionPane.showConfirmDialog(this, panel, "Informações do Departamento",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpresaGUI empresaGUI = new EmpresaGUI();
            empresaGUI.setVisible(true);
        });
    }
}
