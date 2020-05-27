import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecundarioModal extends JDialog implements ActionListener {
    JLabel explicaTit;
    JTextField titulo;
    JLabel explicaCol;
    JComboBox<String> colores;
    JButton boton;
    String[] difCol = { "verde", "azul marino", "amarillo", "azul cian" };
    Color[] colo = { Color.green, Color.BLUE, Color.yellow, Color.CYAN };

    public SecundarioModal(Graphics gra) {
        super(gra, true);
        setLayout(new FlowLayout());
        setTitle("Secundaria Modal");
        setSize(200, 200);
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
        Graphics gra = (Graphics) this.getOwner();
        gra.teclasContenido = titulo.getText();

        gra.col = colo[colores.getSelectedIndex()];

        dispose();
    }

}