package src.main.java.es.deusto.spq.app;



import static javax.swing.JOptionPane.ERROR_MESSAGE;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.ProcessingException;

import src.main.java.es.deusto.spq.app.*;
import src.main.java.es.deusto.spq.data.Articulo;
import src.main.java.es.deusto.spq.data.Articulo.Categoria;

import java.util.Date;
import java.util.List;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.EventQueue;
import java.awt.Dimension;




public class Articulos_bien extends JFrame{

	private static final long serialVersionUID = 1L;
	private Client client;
	private Date date;
	private JTextField textField;
	
	public Articulos_bien() {
		setTitle("ARTICULOS");
		client = ClientBuilder.newClient();


		
		final WebTarget appTarget = client.target("http://localhost:8080/stock_manager/api/");
		final WebTarget articulosTarget = appTarget.path("getArticulos");
		final WebTarget eliminarTarget = appTarget.path("eliminarArticulo");


		setSize(1000, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel botonesPanel = new JPanel();
		
		JButton eliminarBoton = new JButton("Eliminar articulo");
		botonesPanel.add(eliminarBoton);
		getContentPane().add(botonesPanel, BorderLayout.SOUTH);

		getContentPane().add(botonesPanel, BorderLayout.SOUTH);
		
		JButton btnanyadir = new JButton("Anyadir Articulo");
		btnanyadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					CrearArticulo frame = new CrearArticulo();
					frame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		
		JButton modificarBoton = new JButton("Modificar articulo");

		GroupLayout gl_botonesPanel = new GroupLayout(botonesPanel);
		gl_botonesPanel.setHorizontalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addContainerGap(629, Short.MAX_VALUE)
					.addComponent(modificarBoton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(eliminarBoton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnanyadir)
					.addContainerGap())
		);
		gl_botonesPanel.setVerticalGroup(
			gl_botonesPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_botonesPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_botonesPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnanyadir)
						.addComponent(eliminarBoton)
						.addComponent(modificarBoton))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		botonesPanel.setLayout(gl_botonesPanel);
		
		final DefaultListModel<Articulo> articulosListModel = new DefaultListModel<>();


		final JList<Articulo> articulosLista = new JList<>(articulosListModel);
		
		JScrollPane listScrollPane = new JScrollPane(articulosLista);
		getContentPane().add(listScrollPane, BorderLayout.WEST);
		
		GenericType<List<Articulo>> genericType = new GenericType<List<Articulo>>() {};
		List<Articulo> articulos = articulosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
	
		articulosListModel.clear();
		for(Articulo articulo: articulos) {
			articulosListModel.addElement(articulo);
		}
		

		
		eliminarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Articulo a = articulosLista.getSelectedValue();
				System.out.println(a);
				String articuloText = a.toString();
				//eliminarTarget.request().post(Entity.entity(a, MediaType.APPLICATION_JSON));
				WebTarget deleteTarget = eliminarTarget.path(articuloText);
				Response response = deleteTarget.request().delete();
				if(response.getStatus() == Status.OK.getStatusCode()) {
					JOptionPane.showMessageDialog(Articulos_bien.this, "Articulo eliminado", "Message", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(Articulos_bien.this, "No se pudo eliminar el articulo", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		modificarBoton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Articulo articulo = articulosLista.getSelectedValue();
				try {
					ModificarArticulo frame = new ModificarArticulo(articulo);
					frame.setVisible(true);
					dispose();
				} catch (Exception er) {
					er.printStackTrace();
				}
				
			}
		});
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Articulos_bien();
				
			}
		});
	}
	
}