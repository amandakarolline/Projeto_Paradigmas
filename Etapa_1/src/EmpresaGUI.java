import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.*;

public class EmpresaGUI extends JFrame {

    public EmpresaGUI() {
        Empresa empresa = new Empresa();
        setTitle("Sistema de Gerenciamento de Funcionários");
        setSize(400, 300);
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
        JTextField codigoField = new JTextField(10);
        JTextField nomeField = new JTextField(10);
        String[] tipos = {"Funcionário Integral", "Funcionário Meio Período", "Funcionário Terceirizado"};
        JComboBox<String> tipoCombo = new JComboBox<>(tipos);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Tipo de funcionário:"));
        panel.add(tipoCombo);

        int result = JOptionPane.showConfirmDialog(this, panel, "Cadastrar Funcionário",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int codigo = Integer.parseInt(codigoField.getText());
                String nome = nomeField.getText();
                String tipo = (String) tipoCombo.getSelectedItem();
                // Adicionar lógica para cadastrar o funcionário
                JOptionPane.showMessageDialog(this, "Funcionário cadastrado com sucesso!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Código inválido. Por favor, insira um número inteiro.");
            }
        }
    }

    private void alterarDadosFuncionario() {
        // Lógica para alterar os dados do funcionário
        JOptionPane.showMessageDialog(this, "Funcionário alterado com sucesso!");
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
                // Adicionar lógica para excluir o funcionário
                JOptionPane.showMessageDialog(this, "Funcionário excluído com sucesso!");
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
