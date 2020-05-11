import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecundarioModal extends JDialog implements ActionListener {
    JLabel explicaTit;
    JTextField titulo;
    JLabel explicaCol;
    JComboBox<String> colores;
    JButton boton;
    String[] difCol= {"verde","azul marino","amarillo","azul cian"};

    public SecundarioModal(Graphics gra){
        super(gra, true);
        setLayout(new FlowLayout());
        setTitle("Secundaria Modal");
        setSize(200,200);
        explicaTit = new JLabel("Introduce el titulo");
        add(explicaTit);

        titulo = new JTextField(10);
        add(titulo);

        explicaCol = new JLabel("Introduce el color de los botones");
        add(explicaCol);

        colores = new JComboBox<>(difCol);
        colores.setSelectedIndex(0);
        add(colores);

        boton = new JButton("Aceptar");
        boton.addActionListener(this);
        add(boton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics gra=(Graphics)this.getOwner();
        gra.setTitle(titulo.getText());

        switch(colores.getSelectedIndex()){
            case 0:
                gra.col = new Color(0,255,0);
                break;
            case 1:
                gra.col = new Color(0,0,255);
                break;
            case 2:
                gra.col = new Color(255,255,0);
                break;
            case 3:
                gra.col = new Color(0,255,255);
                break;

        }
        
        dispose();
    }


}