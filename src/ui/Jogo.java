package ui;


import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import jogo_cobra.Cobra;


public class Jogo extends javax.swing.JFrame {
    private Cobra jogo = new Cobra();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo.class.getName());

    public Jogo() {
        initComponents();
        setFocusable(true);
        requestFocus();
        jogo.setVisible(true);
        pnlVisor.add(jogo);
        jogo.iniciar();
         KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> 
         {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                int tecla = e.getKeyCode();
                if (tecla == KeyEvent.VK_RIGHT && jogo.direcaoX != -1) { jogo.direcaoX = 1;  jogo.direcaoY = 0; }
                if (tecla == KeyEvent.VK_LEFT  && jogo.direcaoX != 1)  { jogo.direcaoX = -1; jogo.direcaoY = 0; }
                if (tecla == KeyEvent.VK_DOWN  && jogo.direcaoY != -1) { jogo.direcaoY = 1;  jogo.direcaoX = 0; }
                if (tecla == KeyEvent.VK_UP    && jogo.direcaoY != 1)  { jogo.direcaoY = -1; jogo.direcaoX = 0; }
                if(tecla == KeyEvent.VK_Q) {jogo.adicionarBloco();}
            }
            return false;
        });
        jogo.onGameOver = ()-> {
        System.out.println("MORREU");
        };
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        pnlBaixo = new javax.swing.JPanel();
        pnlBotaoCima = new javax.swing.JPanel();
        btnCima = new javax.swing.JButton();
        pnlBotaoBaixo = new javax.swing.JPanel();
        btnEsquerda = new javax.swing.JButton();
        btnBaixo = new javax.swing.JButton();
        btnDireita = new javax.swing.JButton();
        pnlVisor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 600));
        setMinimumSize(new java.awt.Dimension(400, 600));
        setResizable(false);

        root.setPreferredSize(new java.awt.Dimension(400, 600));
        root.setLayout(new java.awt.BorderLayout());

        pnlBaixo.setBackground(new java.awt.Color(255, 255, 255));
        pnlBaixo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        pnlBaixo.setMaximumSize(new java.awt.Dimension(400, 100));
        pnlBaixo.setMinimumSize(new java.awt.Dimension(400, 100));
        pnlBaixo.setLayout(new javax.swing.BoxLayout(pnlBaixo, javax.swing.BoxLayout.Y_AXIS));

        pnlBotaoCima.setBackground(new java.awt.Color(102, 102, 102));
        pnlBotaoCima.setMaximumSize(new java.awt.Dimension(400, 50));
        pnlBotaoCima.setMinimumSize(new java.awt.Dimension(400, 50));
        pnlBotaoCima.setPreferredSize(new java.awt.Dimension(400, 50));
        pnlBotaoCima.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnCima.setText("⬆️");
        btnCima.setPreferredSize(new java.awt.Dimension(72, 30));
        btnCima.addActionListener(this::btnCimaActionPerformed);
        pnlBotaoCima.add(btnCima);

        pnlBaixo.add(pnlBotaoCima);

        pnlBotaoBaixo.setBackground(new java.awt.Color(102, 102, 102));
        pnlBotaoBaixo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnEsquerda.setText("⬅️");
        btnEsquerda.setPreferredSize(new java.awt.Dimension(72, 30));
        btnEsquerda.addActionListener(this::btnEsquerdaActionPerformed);
        pnlBotaoBaixo.add(btnEsquerda);

        btnBaixo.setText("⬇️");
        btnBaixo.setPreferredSize(new java.awt.Dimension(72, 30));
        btnBaixo.addActionListener(this::btnBaixoActionPerformed);
        pnlBotaoBaixo.add(btnBaixo);

        btnDireita.setText("➡️");
        btnDireita.setPreferredSize(new java.awt.Dimension(72, 30));
        btnDireita.addActionListener(this::btnDireitaActionPerformed);
        pnlBotaoBaixo.add(btnDireita);

        pnlBaixo.add(pnlBotaoBaixo);

        root.add(pnlBaixo, java.awt.BorderLayout.PAGE_END);

        pnlVisor.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        pnlVisor.setMaximumSize(new java.awt.Dimension(400, 495));
        pnlVisor.setMinimumSize(new java.awt.Dimension(400, 495));
        pnlVisor.setPreferredSize(new java.awt.Dimension(400, 495));
        pnlVisor.setLayout(new java.awt.GridLayout(1, 0));
        root.add(pnlVisor, java.awt.BorderLayout.CENTER);

        getContentPane().add(root, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDireitaActionPerformed
        jogo.direcaoX=1;
        jogo.direcaoY=0;
    }//GEN-LAST:event_btnDireitaActionPerformed

    private void btnEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsquerdaActionPerformed
        jogo.direcaoX = -1;
        jogo.direcaoY=0;
    }//GEN-LAST:event_btnEsquerdaActionPerformed

    private void btnBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaixoActionPerformed
        jogo.direcaoY = 1;
        jogo.direcaoX = 0;
    }//GEN-LAST:event_btnBaixoActionPerformed

    private void btnCimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCimaActionPerformed
        jogo.direcaoY = -1;
        jogo.direcaoX = 0;
    }//GEN-LAST:event_btnCimaActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Jogo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaixo;
    private javax.swing.JButton btnCima;
    private javax.swing.JButton btnDireita;
    private javax.swing.JButton btnEsquerda;
    private javax.swing.JPanel pnlBaixo;
    private javax.swing.JPanel pnlBotaoBaixo;
    private javax.swing.JPanel pnlBotaoCima;
    private javax.swing.JPanel pnlVisor;
    private javax.swing.JPanel root;
    // End of variables declaration//GEN-END:variables
}
