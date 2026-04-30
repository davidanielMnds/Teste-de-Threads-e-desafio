package ui;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JogoCobrinha extends JFrame {

    static final int TAMANHO_BLOCO = 20;
    static final int COLUNAS = 20;
    static final int LINHAS = 20;

    LinkedList<Point> cobra = new LinkedList<>();
    Point comida;
    int direcaoAtual = KeyEvent.VK_RIGHT;

    JPanel canvas = new JPanel() {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.setColor(Color.GREEN);
            for (Point p : cobra)
                g.fillRect(p.x * TAMANHO_BLOCO, p.y * TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO);
            g.setColor(Color.RED);
            g.fillRect(comida.x * TAMANHO_BLOCO, comida.y * TAMANHO_BLOCO, TAMANHO_BLOCO, TAMANHO_BLOCO);
        }
    };

    public JogoCobrinha() {
        setTitle("Jogo Cobrinha");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        cobra.add(new Point(5, 5));
        cobra.add(new Point(4, 5));
        cobra.add(new Point(3, 5));
        gerarComida();

        canvas.setPreferredSize(new Dimension(COLUNAS * TAMANHO_BLOCO, LINHAS * TAMANHO_BLOCO));
        canvas.setBackground(Color.BLACK);
        add(canvas);
        canvas.setFocusable(true);
        canvas.requestFocusInWindow();
        canvas.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_UP && direcaoAtual != KeyEvent.VK_DOWN)
                    direcaoAtual = tecla;
                if (tecla == KeyEvent.VK_DOWN && direcaoAtual != KeyEvent.VK_UP)
                    direcaoAtual = tecla;
                if (tecla == KeyEvent.VK_LEFT && direcaoAtual != KeyEvent.VK_RIGHT)
                    direcaoAtual = tecla;
                if (tecla == KeyEvent.VK_RIGHT && direcaoAtual != KeyEvent.VK_LEFT)
                    direcaoAtual = tecla;
            }
        });
        pack();
        setLocationRelativeTo(null);
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new GameLoop(), 0, 150);
    }

    void gerarComida()
    {
        Random r = new Random();
        comida = new Point(r.nextInt(COLUNAS), r.nextInt(LINHAS));
    }

    public static void main(String[] args)
    {
        new JogoCobrinha().setVisible(true);
    }
    
    class GameLoop extends java.util.TimerTask {
    @Override
    public void run()
    {
        Point cabeca = cobra.getFirst();
        Point novaCabeca = new Point(cabeca);

        if (direcaoAtual == KeyEvent.VK_UP)    novaCabeca.y--;
        if (direcaoAtual == KeyEvent.VK_DOWN)  novaCabeca.y++;
        if (direcaoAtual == KeyEvent.VK_LEFT)  novaCabeca.x--;
        if (direcaoAtual == KeyEvent.VK_RIGHT) novaCabeca.x++;
        
        if (novaCabeca.x < 0)       novaCabeca.x = COLUNAS - 1;
        if (novaCabeca.x >= COLUNAS) novaCabeca.x = 0;
        if (novaCabeca.y < 0)       novaCabeca.y = LINHAS - 1;
        if (novaCabeca.y >= LINHAS)  novaCabeca.y = 0;

        cobra.addFirst(novaCabeca);
        if (novaCabeca.equals(comida))
            gerarComida();
        else
            cobra.removeLast();

        canvas.repaint();
    }
}
}