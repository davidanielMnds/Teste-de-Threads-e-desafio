package jogo_cobra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Cobra extends JPanel{
    static final int TAMANHO_BLOCO = 20;
    static final int COLUNAS = 20;
    static final int LINHAS = 24;
    private final Point comida;
    public int direcaoX=1;
    public int direcaoY=0;
    LinkedList<Point> cobra = new LinkedList<>();
    
    public Cobra()
    {
        this.comida = new Point(0,0);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(COLUNAS*TAMANHO_BLOCO, LINHAS*TAMANHO_BLOCO));
        cobra.add(new Point(5, 5));
        cobra.add(new Point(4, 5));
        cobra.add(new Point(3, 5));
        setFocusable(true);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.green);
    for(Point p : cobra)
    {
        g.fillRect(p.x * TAMANHO_BLOCO, p.y * TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO);
    }
    g.setColor(Color.RED);
    g.fillRect(comida.x * TAMANHO_BLOCO, comida.y * TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO);
    }
    
    public void iniciar() {
    Timer timer = new Timer(100, e->
    {
        Point cabeca = cobra.getFirst();
        Point novaCabeca = new Point(cabeca.x + direcaoX, cabeca.y + direcaoY);
        if(novaCabeca.x >= COLUNAS) {novaCabeca.x = 0;}
        if(novaCabeca.x < 0) {novaCabeca.x = COLUNAS -1;}
        if(novaCabeca.y >= LINHAS) {novaCabeca.y = 0;}
        if(novaCabeca.y < 0) {novaCabeca.y = LINHAS -1;}
        
        cobra.addFirst(novaCabeca);
        cobra.removeLast();
        
        
        boolean comeu = false;
        if(cobra.getFirst().equals(comida)) {comeu=true; comida.x=-5;comida.y=-5;adicionarBloco();}
        if (comeu) {comida();}
        
        
        
        
        repaint();
    });
    timer.start();
    }
    
    public void adicionarBloco()
    {
        Point ultima = cobra.getLast();
        cobra.addLast(new Point(ultima.x - direcaoX, ultima.y - direcaoY));
    }
    
    public void comida()
    {
        Random random = new Random();
        comida.x = random.nextInt(COLUNAS);
        comida.y = random.nextInt(LINHAS);
    }
    
    
}
