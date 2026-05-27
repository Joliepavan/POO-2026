public class ContaCorrente extends Conta {
    
    protected double taxaOperacao = 0.05; 

    public ContaCorrente(int numero, Cliente dono) {
        super(numero, dono);
    }

    @Override
    public void sacar(double valor) {
        
        super.sacar(valor + taxaOperacao);
    }

    @Override
    public void depositar(double valor) {
        
        super.depositar(valor - taxaOperacao);
    }

    @Override
    public void transferir(double valor, Conta destino) {
        this.sacar(valor); 
        destino.depositar(valor); 
    }
}