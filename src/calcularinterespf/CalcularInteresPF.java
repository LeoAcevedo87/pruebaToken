
package calcularinterespf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcularInteresPF extends JFrame implements ActionListener {

    private JTextField capitalField, tnaField, interesField;
    private JButton calcularButton;

    public CalcularInteresPF() {
        setTitle("Calcular Interés PF");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        ImageIcon icon = new ImageIcon("C:/Users/Leo/Pictures/iconos/dolar.png");
        setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel capitalLabel = new JLabel("Capital:");
        capitalField = new JTextField();
        panel.add(capitalLabel);
        panel.add(capitalField);

        JLabel tnaLabel = new JLabel("TNA (%):");
        tnaField = new JTextField();
        panel.add(tnaLabel);
        panel.add(tnaField);

        JLabel interesLabel = new JLabel("Interés:");
        interesField = new JTextField();
        interesField.setEditable(false);
        panel.add(interesLabel);
        panel.add(interesField);

        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);
        panel.add(calcularButton);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcularButton) {
            try {
                double capital = Double.parseDouble(capitalField.getText());
                double tna = (Double.parseDouble(tnaField.getText()))/100;
                final double MESES = 12;
                double ganado = (capital * tna) / MESES;
                interesField.setText(String.valueOf(ganado));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos en los campos.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalcularInteresPF ventana = new CalcularInteresPF();
            ventana.setVisible(true);
        });
    }
}

