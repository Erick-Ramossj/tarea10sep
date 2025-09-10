package com.example.ventanaa;

import javax.swing.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            // Cambiar el estilo visual (Look & Feel moderno)
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el Look & Feel");
        }

        // Detectar idioma del sistema
        Locale locale = Locale.getDefault();
        System.out.println("Idioma detectado: " + locale.getLanguage());

        // Iniciar ventana
        new MainWindow(locale);
    }
}
