package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class PolynomialCalculator extends JFrame implements ActionListener {

    private JTextField poly1Field, poly2Field, resultField;
    private JButton addButton, subtractButton, multipButton, integrationButton, derivativeButton;

    public PolynomialCalculator() {
        super("Polynomial Calculator");

        // Initialize UI components
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

        // Create UI layout
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

        // Set UI attributes
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    static HashMap<Integer, Double> parsePolynomial(String poly) {
        HashMap<Integer, Double> map = new HashMap<>();
        Pattern pattern = Pattern.compile("([+-]?\\d*)x\\^(\\d+)");
        Matcher matcher = pattern.matcher(poly);

        while (matcher.find()) {

            int exponent = 0;
            double coefficient = 0;
            if (!matcher.group(1).isEmpty()) {
                coefficient = Integer.parseInt(matcher.group(1));
            }
            if (!matcher.group(2).isEmpty()) {
                exponent = Integer.parseInt(matcher.group(2));
            }
            map.put(exponent, coefficient);
        }

        return map;
    }


    public void actionPerformed(ActionEvent e) {
        String poly1 = poly1Field.getText().trim();
        String poly2 = poly2Field.getText().trim();

        if (e.getSource() == addButton) {
            String result = Operatii.addPolynomials(poly1, poly2);
            resultField.setText(result);
        } else if (e.getSource() == subtractButton) {
            String result = Operatii.subtractPolynomials(poly1, poly2);
            resultField.setText(result);
        } else if (e.getSource() == multipButton) {
            String result = Operatii.multipPolynomials(poly1, poly2);
            resultField.setText(result);
        } else if (e.getSource() == derivativeButton) {
            String result = Operatii.derivativePolynomials(poly1);
            resultField.setText(result);}
        else if (e.getSource() == integrationButton) {
                String result = Operatii.integratePolynomials(poly1);
                resultField.setText(result);
        }
    }
        public static void main (String[]args){
            new PolynomialCalculator();
        }
    }