
package condicao_corrida;

public class Processador implements Runnable{
    private final Contador c;
    private final boolean rodarSincronizado;
    public Processador(Contador c, boolean rodarSincronizado) {this.c=c; this.rodarSincronizado = rodarSincronizado;}
    @Override
    public void run()
    {
        if(rodarSincronizado)
        {
            for (int i = 0; i<100; i++) 
            {
                c.incrementarCom();
            }
        }
        else
        {
            for (int i = 0; i<100; i++) 
            {
                c.incrementarSem();
            }
        }
        
    }
    
}
