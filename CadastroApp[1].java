import javax.swing.JOptionPane;

public class CadastroApp {
    public static void main(String[] args) {
       
        Conta[] arrayDeContas = new Conta[100];
        int contador = 0;

        while (true) {
            String numStr = JOptionPane.showInputDialog("Digite o número da conta (0 para sair):");
            if (numStr == null || numStr.isEmpty()) break;
            
            int numero = Integer.parseInt(numStr);
            if (numero == 0) break;

            String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
            String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
            Cliente cliente = new Cliente(nome, telefone);

            String menuTipo = "Escolha o tipo da conta:\n"
                            + "1 - Conta Corrente\n"
                            + "2 - Conta Salário\n"
                            + "3 - Conta Poupança";
            String tipoStr = JOptionPane.showInputDialog(menuTipo);
            int tipo = Integer.parseInt(tipoStr);

            Conta novaConta = null;
            
            
            switch (tipo) {
                case 1:
                    novaConta = new ContaCorrente(numero, cliente);
                    break;
                case 2:
                    novaConta = new ContaSalario(numero, cliente);
                    break;
                case 3:
                    novaConta = new ContaPoupanca(numero, cliente);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Tipo inválido! Cadastro cancelado para esta conta.");
                    continue;
            }

            
            String depStr = JOptionPane.showInputDialog("Qual o valor do depósito inicial?");
            if (depStr != null && !depStr.isEmpty()) {
                novaConta.depositar(Double.parseDouble(depStr));
            }

            arrayDeContas[contador] = novaConta;
            contador++;

            if (contador >= arrayDeContas.length) {
                JOptionPane.showMessageDialog(null, "Limite máximo do array atingido.");
                break;
            }
        }

      
        StringBuilder resumo = new StringBuilder("Contas Cadastradas:\n\n");
        for (int i = 0; i < contador; i++) {
            resumo.append(arrayDeContas[i].toString()).append("\n");
        }

        if (contador > 0) {
            JOptionPane.showMessageDialog(null, resumo.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma conta foi cadastrada.");
        }
    }
}