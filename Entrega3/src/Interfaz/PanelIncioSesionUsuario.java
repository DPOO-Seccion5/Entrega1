package Interfaz;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIncioSesionUsuario extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel infoLabel;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public PanelIncioSesionUsuario(JPanel cardPanel, CardLayout cardLayout) {
    	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
    	
        setLayout(new BorderLayout());
        
        
        // Title Label
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("Inicio de Sesion");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        add(titleLabel,BorderLayout.NORTH);
        // Panel for text boxes and button
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));

        // Username field
        usernameField = new JTextField(15);
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Usuario: "));
        usernamePanel.add(usernameField);

        // Password field
        passwordField = new JPasswordField(15);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Contraseña: "));
        passwordPanel.add(passwordField);

        inputPanel.add(usernamePanel);
        inputPanel.add(passwordPanel);
        add(inputPanel, BorderLayout.CENTER);
        
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton sendButton = new JButton("Enviar");
        Dimension buttonSize = new Dimension(100, 50); // Adjust the button size
        sendButton.setPreferredSize(buttonSize);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
              
                if (username.contains("1")){
                	 cardLayout.show(cardPanel, "panelEmpleado");
                }
                else {
                	cardLayout.show(cardPanel, "panelUsuario");
                }
               
            }
        });
        
       
        
        
        
        
        
       
        
        JButton returnButton = new JButton("Devolverse");
        Dimension buttonSize2 = new Dimension(100, 50); // Adjust the button size
        returnButton.setPreferredSize(buttonSize2);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                	cardLayout.show(cardPanel, "mainPanel");
                
               
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(sendButton);
        add(buttonPanel, BorderLayout.SOUTH);
        

        

        
    }
}
