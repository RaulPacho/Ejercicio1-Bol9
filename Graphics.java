import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Graphics extends JFrame implements MouseListener, MouseMotionListener, KeyListener {
    JLabel teclas;
    JButton boton1;
    JButton boton2;
    protected Color col = new Color(255,0,0);
    public Graphics() {
        super("Control Raton");
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // teclas
        teclas = new JLabel("Teclas");
        teclas.setSize(teclas.getPreferredSize().width, teclas.getPreferredSize().height);
        teclas.setLocation(100, 100);
        add(teclas);

        // boton1
        boton1 = new JButton("Boton 1");
        boton1.setBounds(new Rectangle(100, 50, 85, 30));
        boton1.addMouseMotionListener(this);
        boton1.addMouseListener(this);
        add(boton1);

        // boton2
        boton2 = new JButton("Boton 2");
        boton2.setBounds(new Rectangle(300, 50, 85, 30));
        boton2.addMouseMotionListener(this);
        boton2.addMouseListener(this);
        add(boton2);

        
        addWindowListener(new Cerrar());
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.getKeyCode() == e.VK_C) {
            SecundarioModal sm = new SecundarioModal(this);
            sm.setVisible(true);
            sm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        teclas.setText("<html><body>Caracter Unicode: " + e.getKeyChar() + "<br>Codigo de tecla: " + e.getKeyCode()
                + "</body></html>");
        teclas.setSize(teclas.getPreferredSize().width, teclas.getPreferredSize().height);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas.setText("Teclas");
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.BUTTON1 == e.getButton()) {
            boton1.setBackground(col);
            // boton1.setVisible(false);
        }
        if (e.BUTTON3 == e.getButton()) { // Con mi raton por lo menos el Button2 es para la rueda
            boton2.setBackground(col);
            // boton1.setVisible(false);
        }

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        boton1.setBackground(new JButton().getBackground());
        // boton1.setVisible(true);
        boton2.setBackground(new JButton().getBackground());

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

        this.setTitle("Teclas - (" + e.getX() + "," + e.getY() + ")");

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        this.setTitle("Control Raton");
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

        if (e.getSource() == boton1) {
            this.setTitle("Teclas - (" + (boton1.getX() + e.getX() + 7) + "," + (boton1.getY() + e.getY() + 10) + ")");
        } else if (e.getSource() == boton2) {
            this.setTitle("Teclas - (" + (boton2.getX() + e.getX() + 7) + "," + (boton2.getY() + e.getY() + 10) + ")");
        } else {
            this.setTitle("Teclas - (" + e.getX() + "," + e.getY() + ")");
        }
    }
    public class Cerrar extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            int res = JOptionPane.showConfirmDialog(null, "Cerramos?", "Seguro?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    System.out.println(res);
                    if(res == JOptionPane.YES_OPTION){
                        e.getWindow().dispose();
                    }
        }
        
    }
}