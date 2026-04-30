package ui;


import java.awt.CardLayout;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jogo_cobra.Cobra;


public class Jogo extends javax.swing.JFrame {
    private Cobra jogo = new Cobra();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo.class.getName());

    public Jogo() {
        initComponents();
        //-----------------BOTAO DE CIMA-----------------------------------------------------
        ImageIcon icon = new ImageIcon(getClass().getResource("/assets/seta_cima.png"));
        Image imgCima = icon.getImage().getScaledInstance(40, 40 , Image.SCALE_FAST);
        btnCima.setIcon(new ImageIcon(imgCima));
        btnCima.setContentAreaFilled(false); 
        btnCima.setBorderPainted(false);     
        btnCima.setFocusPainted(false);      
        btnCima.setOpaque(false);            
        //-----------------BOTAO DA DIREITA-----------------------------------------------------
        ImageIcon iconDireita = new ImageIcon(getClass().getResource("/assets/seta_direita.png"));
        Image imgDireita = iconDireita.getImage().getScaledInstance(40, 40, Image.SCALE_FAST);
        btnDireita.setIcon(new ImageIcon(imgDireita));
        btnDireita.setContentAreaFilled(false);
        btnDireita.setBorderPainted(false);
        btnDireita.setFocusPainted(false);
        btnDireita.setOpaque(false);
        //-----------------BOTAO DA ESQUERDA-----------------------------------------------------
        ImageIcon iconEsquerda = new ImageIcon(getClass().getResource("/assets/seta_esquerda.png"));
        Image imgEsquerda = iconEsquerda.getImage().getScaledInstance(40, 40, Image.SCALE_FAST);
        btnEsquerda.setIcon(new ImageIcon(imgEsquerda));
        btnEsquerda.setContentAreaFilled(false);
        btnEsquerda.setBorderPainted(false);
        btnEsquerda.setFocusPainted(false);
        btnEsquerda.setOpaque(false);
        //-----------------BOTAO DE BAIXO-----------------------------------------------------
        ImageIcon iconBaixo = new ImageIcon(getClass().getResource("/assets/seta_baixo.png"));
        Image imgBaixo = iconBaixo.getImage().getScaledInstance(40, 40, Image.SCALE_FAST);
        btnBaixo.setIcon(new ImageIcon(imgBaixo));
        btnBaixo.setContentAreaFilled(false);
        btnBaixo.setBorderPainted(false);
        btnBaixo.setFocusPainted(false);
        btnBaixo.setOpaque(false);
        //----------------------------------------------------------------------------------------
        pnlBotaoCima.setOpaque(false);
        pnlBotaoBaixo.setOpaque(false);
        setFocusable(true);
        requestFocus();
        CardLayout layout = new CardLayout();
        pnlVisor.setLayout(layout);
        pnlVisor.add(jogo, "jogo");
        jogo.setVisible(true);
        jogo.iniciar();
        layout.show(pnlVisor, "jogo");
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
        pnlBaixo = new PainelFundo("/assets/tela_fundo_comandos.png", 400, 100);
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
        pnlBaixo.setMaximumSize(new java.awt.Dimension(400, 100));
        pnlBaixo.setMinimumSize(new java.awt.Dimension(400, 100));
        pnlBaixo.setLayout(new javax.swing.BoxLayout(pnlBaixo, javax.swing.BoxLayout.Y_AXIS));

        pnlBotaoCima.setBackground(new java.awt.Color(102, 102, 102));
        pnlBotaoCima.setMaximumSize(new java.awt.Dimension(400, 50));
        pnlBotaoCima.setMinimumSize(new java.awt.Dimension(400, 50));
        pnlBotaoCima.setPreferredSize(new java.awt.Dimension(400, 50));
        pnlBotaoCima.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        btnCima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seta_cima.png"))); // NOI18N
        btnCima.setFocusPainted(false);
        btnCima.setPreferredSize(new java.awt.Dimension(60, 35));
        btnCima.addActionListener(this::btnCimaActionPerformed);
        pnlBotaoCima.add(btnCima);

        pnlBaixo.add(pnlBotaoCima);

        pnlBotaoBaixo.setBackground(new java.awt.Color(102, 102, 102));
        pnlBotaoBaixo.setPreferredSize(new java.awt.Dimension(400, 50));
        pnlBotaoBaixo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 0));

        btnEsquerda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seta_esquerda.png"))); // NOI18N
        btnEsquerda.setPreferredSize(new java.awt.Dimension(60, 35));
        btnEsquerda.addActionListener(this::btnEsquerdaActionPerformed);
        pnlBotaoBaixo.add(btnEsquerda);

        btnBaixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seta_baixo.png"))); // NOI18N
        btnBaixo.setPreferredSize(new java.awt.Dimension(60, 35));
        btnBaixo.addActionListener(this::btnBaixoActionPerformed);
        pnlBotaoBaixo.add(btnBaixo);

        btnDireita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/seta_direita.png"))); // NOI18N
        btnDireita.setPreferredSize(new java.awt.Dimension(60, 35));
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
