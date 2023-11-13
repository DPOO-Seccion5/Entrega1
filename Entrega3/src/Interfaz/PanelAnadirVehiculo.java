package Interfaz;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAnadirVehiculo extends JPanel{
	 private JTextField[] textFields;
	 private JLabel infoLabel;
	private JPanel cardPanel;
	private CardLayout cardLayout;
	 
	public PanelAnadirVehiculo(JPanel cardPanel, CardLayout cardLayout) {
    	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
		setLayout(new BorderLayout());

	     // Title Label
	     JLabel titleLabel = new JLabel("Añadir Vehiculo");
	     titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
	     titleLabel.setHorizontalAlignment(JLabel.CENTER);
	     add(titleLabel, BorderLayout.NORTH);

	     // Panel for text boxes and button
	     JPanel inputPanel = new JPanel(new GridLayout(11, 1));

	     // Create an array of text fields and labels
	     textFields = new JTextField[11];
	     String[] data = { "Nombre", "Marca", "Color", "Placa", "Modelo", 
	         "Tipo de Transmision", "Categoria", "Precio", "Tamaño", 
	         "Tarifa Temporada Alta","Tarifa Temporada Baja"};
	     
	     for (int i = 0; i < data.length; i++) {
	         JLabel label = new JLabel(data[i] + ": ");
	         textFields[i] = new JTextField(8); // Smaller text fields
	         JPanel fieldPanel = new JPanel(new BorderLayout());
	         fieldPanel.add(label, BorderLayout.WEST);
	         fieldPanel.add(textFields[i], BorderLayout.CENTER);
	         inputPanel.add(fieldPanel);
	     }

	     // Button to send information with a smaller size
	     JButton sendButton = new JButton("Enviar");
	     sendButton.setPreferredSize(new Dimension(100, 30)); // Smaller button
	     sendButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             StringBuilder info = new StringBuilder();
	            
	             for (int i = 0; i < data.length; i++) {
	                 info.append(textFields[i].getText());
	                 
	             }
	             
	             infoLabel.setText(info.toString());
	             cardLayout.show(cardPanel, "panelEmpleado");
	            
	             // La lista si comienza en nombre y termina en clave
	         }
	     });
	     
	     JButton sendButton2 = new JButton("Devolverse");
	     sendButton2.setPreferredSize(new Dimension(100, 30)); // Smaller button
	     sendButton2.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 cardLayout.show(cardPanel, "panelABVehi");
	         }
	     });


	        JLabel titleLabel2 = new JLabel("    ");
	        inputPanel.add(titleLabel2);
	     
	     inputPanel.add(sendButton2);

	     
	     
	     inputPanel.add(sendButton);

	     add(inputPanel, BorderLayout.CENTER);

	     // Label to display the entered information
	     infoLabel = new JLabel("Information will be shown here");
	     infoLabel.setVerticalAlignment(SwingConstants.CENTER);
	     add(infoLabel, BorderLayout.SOUTH);
		
		
	}
}