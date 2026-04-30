
package condicao_corrida;

public class RodarContagem {
    public static int contarCom() throws InterruptedException
    {
        Contador contador = new Contador();
        Thread t1 = new Thread(new Processador(contador, true));
        Thread t2 = new Thread(new Processador(contador, true));
        Thread t3 = new Thread(new Processador(contador, true));
        
        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();
        return contador.getQuantidade();
    }
    
    public static int contarSem() throws InterruptedException
    {
        Contador contador = new Contador();
        Thread t1 = new Thread(new Processador(contador, false));
        Thread t2 = new Thread(new Processador(contador, false));
        Thread t3 = new Thread(new Processador(contador, false));
        
        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();
        return contador.getQuantidade();
    }
}
