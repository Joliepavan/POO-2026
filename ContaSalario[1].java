public class ContaSalario extends ContaCorrente {
    public ContaSalario(int numero, Cliente dono) {
        super(numero, dono);
        
        this.taxaOperacao = 0.01; 
    }
}