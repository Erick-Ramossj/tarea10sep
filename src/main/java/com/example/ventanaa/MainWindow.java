package com.example.ventanaa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MainWindow extends JFrame {

    private Locale locale;

    public MainWindow(Locale locale) {
        this.locale = locale;

        // Internacionalización simple
        String title = locale.getLanguage().equals("en") ? "Welcome" : "Bienvenid@";
        String buttonText = locale.getLanguage().equals("en") ? "Show Greeting" : "Mostrar saludo";

        setTitle(title);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fondo
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Botón
        JButton button = new JButton(buttonText);
        button.setBackground(Color.CYAN);

        // Ícono personalizado (ubicado en resources)
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        setIconImage(icon.getImage());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prompt = locale.getLanguage().equals("en") ? "Enter your name:" : "Por favor, escribe tu nombre:";
                String dialogTitle = locale.getLanguage().equals("en") ? "Name input" : "Entrada de nombre";
                String messageSuccess = locale.getLanguage().equals("en") ? "Hello, " : "¡Hola, ";
                String messageEnd = locale.getLanguage().equals("en") ? "! Great job!" : "! ¡Buen trabajo!";

                String nombre = JOptionPane.showInputDialog(
                        null,
                        prompt,
                        dialogTitle,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (nombre != null && !nombre.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(
                            null,
                            messageSuccess + nombre + messageEnd,
                            title,
                            JOptionPane.INFORMATION_MESSAGE,
                            icon
                    );
                } else {
                    String warning = locale.getLanguage().equals("en") ? "You did not enter a name." : "No ingresaste un nombre.";
                    JOptionPane.showMessageDialog(
                            null,
                            warning,
                            "Warning",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        add(button);
        setVisible(true);
    }
}
