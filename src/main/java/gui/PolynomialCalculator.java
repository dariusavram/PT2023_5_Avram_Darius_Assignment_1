package gui;
import logic.Operatii;
import models.Polynom;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static logic.Operatii.*;

public class PolynomialCalculator extends JFrame implements ActionListener {

    private JTextField poly1Field, poly2Field, resultField;
    private JButton addButton, subtractButton, multipButton, integrationButton, derivativeButton;

    public PolynomialCalculator() {
        super("Polynomial Calculator");

        poly1Field = new JTextField(20);
        poly2Field = new JTextField(20);
        resultField = new JTextField(20);
        resultField.setEditable(false);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multipButton = new JButton("Multiply");
        integrationButton = new JButton("Integrate");
        derivativeButton = new JButton("Derive");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multipButton.addActionListener(this);
        integrationButton.addActionListener(this);
        derivativeButton.addActionListener(this);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Polynomial 1:"), c);

        c.gridx = 1;
        panel.add(poly1Field, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Polynomial 2:"), c);

        c.gridx = 1;
        panel.add(poly2Field, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Result:"), c);

        c.gridx = 1;
        panel.add(resultField, c);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multipButton);
        buttonPanel.add(integrationButton);
        buttonPanel.add(derivativeButton);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(buttonPanel, c);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        String poly1 = poly1Field.getText().trim();
        String poly2 = poly2Field.getText().trim();

        if (e.getSource() == addButton) {
            String result = addPolynomials(poly1, poly2);
            resultField.setText(result);
        } else if (e.getSource() == subtractButton) {
            String result = subtractPolynomials(poly1, poly2);
            resultField.setText(result);
        } else if (e.getSource() == multipButton) {
            String result = multipPolynomials(poly1, poly2);
            resultField.setText(result);
        } else if (e.getSource() == derivativeButton) {
            String result = Operatii.derivativePolynomials(poly1);
            resultField.setText(result);}
        else if (e.getSource() == integrationButton) {
                String result = integratePolynomials(poly1);
                resultField.setText(result);
        }
    }
        public static void main (String[]args){
            new PolynomialCalculator();
        }
    }