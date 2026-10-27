package Visual;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import Dao.DAO;
import Logica.Producto;

import java.awt.Font;
import javax.swing.JTable;

public class Maquina extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabla;
	private DAO dao = new DAO();

	/**
	 * Create the panel.
	 */
	public Maquina() 
	{
		setBounds(100, 100, 850, 800);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("MAQUINA EXPENDEDORA");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 321, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 73, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -309, SpringLayout.EAST, this);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel);
		
		tabla = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, tabla, 38, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, tabla, 23, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tabla, -326, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, tabla, -10, SpringLayout.EAST, this);
		add(tabla);
		JScrollPane scroll = new JScrollPane();
		add(scroll);
		Object[] columnas = new Object[]{"codigo" , "nombre" , "leyenda" , "precio", "cantidad"};
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "nombre", "leyenda", "precio", "cantidad"
			}
		));
		
		
		
		
		
		
		
		
		
		

	}

}
