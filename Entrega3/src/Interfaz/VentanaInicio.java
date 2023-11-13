package Interfaz;
import javax.swing.*;

import consola.Consola;
import procesamiento.Compañia;
import modelo.Cliente;
import modelo.Empleado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio  extends JFrame{
	private static CardLayout cardLayout;
    private static JPanel cardPanel;
    private Consola consola;
    private Compañia compania;
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    
   public void cargar_datos() {
    	this.consola = new Consola();
    	
    	consola.cargar_los_datos();
    	
    	
    }
  public Boolean empleadoLogIn(String usuario, String clave) {
	 Boolean bool= consola.inicioSesionEmpleado(usuario, clave);
	  
	 return bool;

  }
  public Boolean clienteLogIn(String usuario, String clave) {
		 Boolean bool= consola.inicioSesionCliente(usuario, clave);
		  
		 return bool; 
	  }  
    
  public void registroCliente(String nombre,String numID, String fechaNacimiento, String nacionalidad, String username, String password, String numeroLicencia, String paisExpedicion,String numeroTarjeta, String fechaVencimiento, String nombreTitular, String cvc) {
		consola.registroCliente(nombre, numID, fechaNacimiento, nacionalidad, username, password, numeroLicencia, paisExpedicion, numeroTarjeta, fechaVencimiento, nombreTitular, cvc);	
	}
  
  
  
  
  
  
  
  
  
  
  
  
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create panel for the main interface
        JPanel mainPanel = createMainPanel();
        cardPanel.add(mainPanel, "mainPanel");
        
        PanelCliente panelusuario = new PanelCliente(cardPanel, cardLayout);
        cardPanel.add(panelusuario,"panelUsuario");
        
        PanelIncioSesionUsuario panelIU = new PanelIncioSesionUsuario(cardPanel, cardLayout);
        cardPanel.add(panelIU, "panelIU");
        
        PanelCrearReserva panelCrearReserva= new PanelCrearReserva(cardPanel, cardLayout);
        cardPanel.add(panelCrearReserva,"panelCrearReserva");
        
       PanelConfirmarReserva panelConfirResrva = new PanelConfirmarReserva(cardPanel, cardLayout);
       cardPanel.add(panelConfirResrva,"panelConfReserva");
        
        RegistroCliente panelRegCli = new RegistroCliente(cardPanel,cardLayout);
        cardPanel.add(panelRegCli, "panelRegCli");
        
     
        PanelRegistroEmpleado panelRegEmpl = new PanelRegistroEmpleado(cardPanel,cardLayout);
        cardPanel.add(panelRegEmpl, "panelRegEmpl");
        
        PanelEmpleado panelEmpleado= new PanelEmpleado(cardPanel,cardLayout);
        cardPanel.add(panelEmpleado, "panelEmpleado");
        
        PanelBuscarVehiculo panelBusacrVehi= new PanelBuscarVehiculo(cardPanel,cardLayout);
        cardPanel.add(panelBusacrVehi,"panelBuscarVehi");
        
        PanelAnadirBorrarVehiculo panelABVehi = new PanelAnadirBorrarVehiculo(cardPanel, cardLayout);
        cardPanel.add(panelABVehi,"panelABVehi");
        
        PanelInformacionVehiculo panelInfoVehi = new PanelInformacionVehiculo(cardPanel, cardLayout);
        cardPanel.add(panelInfoVehi,"panelInfoVehi");
        
        PanelAnadirVehiculo panelAnadirVehi= new PanelAnadirVehiculo(cardPanel, cardLayout);
        cardPanel.add(panelAnadirVehi,"panelAnadirVehi");
        
        PanelBorrarVehiculo panelBorrarVehi = new PanelBorrarVehiculo(cardPanel, cardLayout);
        cardPanel.add(panelBorrarVehi,"panelBorrarVehi");
        
        frame.add(cardPanel);

        frame.setVisible(true);
    }
    
    

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create a big title label centered at the top
        JLabel titleLabel = new JLabel("Alquiler Carros");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        
        
       
        
        // Create a button panel with Button 1 and Button 2
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton button1 = new JButton("Inicio Sesion");
        JButton button2 = new JButton("Registro Cliente");
        JButton button3 = new JButton("Registro Empleado");

        // Set the preferred size for the buttons
        Dimension buttonSize = new Dimension(200,30);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
                cardLayout.show(cardPanel, "panelIU");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "panelRegCli");
            }
        
        }
        );
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "panelRegEmpl");
            }
        
        }
        );
        

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding
        gbc.fill = GridBagConstraints.BOTH;  // Allow buttons to expand

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(button1, gbc);

        gbc.gridx = 1;
        buttonPanel.add(button2, gbc);

        gbc.gridx = 2;
        buttonPanel.add(button3, gbc);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        return mainPanel;
    }
}
