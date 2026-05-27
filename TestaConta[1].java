public class TestaConta {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente("Ana", "1111-1111");
        Cliente cli2 = new Cliente("João", "2222-2222");

        Conta cc = new ContaCorrente(1, cli1);
        Conta cp = new ContaPoupanca(2, cli2);

        cc.depositar(100.0); 
        cp.depositar(100.0); 
        
        cc.sacar(50.0); 
        cp.sacar(50.0); 

        System.out.println("--- Após Saques e Depósitos iniciais ---");
        System.out.println(cc);
        System.out.println(cp);

        ((ContaPoupanca) cp).atualizaSaldo(10.0); 
        
        ContaPoupanca cpPropria = new ContaPoupanca(3, cli2);
        cpPropria.depositar(100.0);
        cpPropria.atualizaSaldo(5.0); 

        System.out.println("\n--- Após atualizaSaldo ---");
        System.out.println(cp);
        System.out.println(cpPropria);

        cc.transferir(10.0, cp);
        
        System.out.println("\n--- Após Transferência da CC para CP ---");
        System.out.println("Origem " + cc);
        System.out.println("Destino " + cp);

        Conta cs = new ContaSalario(4, cli1);
        cs.depositar(100.0);
        cs.transferir(20.0, cc);
        
        System.out.println("\n--- Conta Salário: Transferência para CC ---");
        System.out.println("Origem " + cs);
        System.out.println("Destino " + cc);
    }
}