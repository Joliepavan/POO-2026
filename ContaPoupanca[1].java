public class ContaPoupanca extends Conta {
    
    public ContaPoupanca(int numero, Cliente dono) {
        super(numero, dono);
    }

    public void atualizaSaldo(double percentual) {
        double rendimento = saldo * (percentual / 100);
        this.saldo += rendimento;
    }

    @Override
    public void transferir(double valor, Conta destino) {
        this.sacar(valor); 
        destino.depositar(valor); 
    }
}