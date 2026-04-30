
package condicao_corrida;

public class Contador {
    private int quantidade = 0;
    
    public void incrementarSem() 
    {
        int atual = this.quantidade;
        try {Thread.sleep(2);}
        catch(InterruptedException e) {}
        this.quantidade = atual + 1;
    }
    public synchronized void incrementarCom() 
    {
        int atual = this.quantidade;
        try {Thread.sleep(2);}
        catch(InterruptedException e) {}
        this.quantidade = atual + 1;
    }
    
    public int getQuantidade() {return quantidade;}
}
