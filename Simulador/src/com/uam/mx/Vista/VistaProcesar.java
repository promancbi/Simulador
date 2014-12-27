package com.uam.mx.Vista;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class VistaProcesar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuantum;
	private JTextField txtRafaga;
	private final JTable tableLista;
	private JTable tableHistorico;
	private String[] columnNms = {"# Proceso","Rafaga","Quantum","Residuo rafaga","Estado"};
	private Object[][] data = {};
	private String[] columnNmsd = {"# Proceso","Rafaga","Quantum","Tiempo Final","Estado"};
	private Object[][] datad = {};
	public static void main(String[] args) {
					VistaProcesar frame = new VistaProcesar();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public VistaProcesar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 800);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblQuantum = new JLabel("Quantum");
		lblQuantum.setBounds(22, 12, 70, 15);
		contentPane.add(lblQuantum);
		
		JLabel lblRafaga = new JLabel("Rafaga");
		lblRafaga.setBounds(194, 12, 70, 15);
		contentPane.add(lblRafaga);
		
		txtQuantum = new JTextField();
		txtQuantum.setBounds(12, 41, 153, 19);
		contentPane.add(txtQuantum);
		txtQuantum.setColumns(10);
		
		txtRafaga = new JTextField();
		txtRafaga.setBounds(184, 41, 153, 19);
		contentPane.add(txtRafaga);
		txtRafaga.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(396, 12, 117, 25);
		contentPane.add(btnAgregar);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(396, 43, 117, 25);
		contentPane.add(btnIniciar);
		
		JScrollPane scrollPaneLista = new JScrollPane();
		scrollPaneLista.setBounds(12, 72, 524, 204);
		contentPane.add(scrollPaneLista);
		
		DefaultTableModel model = new DefaultTableModel(data,columnNms);
		tableLista = new JTable(model);
		scrollPaneLista.setViewportView(tableLista);
		tableLista.setBackground(Color.WHITE);
		tableLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(297, 299, 239, 17);
		contentPane.add(progressBar);
		
		JLabel lblProceso = new JLabel("Proceso");
		lblProceso.setBounds(22, 277, 70, 15);
		contentPane.add(lblProceso);
		
		JLabel lblNumProc = new JLabel("");
		lblNumProc.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblNumProc.setBounds(22, 299, 104, 17);
		contentPane.add(lblNumProc);
		
		JLabel lblCantidadProcesos = new JLabel("Cantidad Proceso");
		lblCantidadProcesos.setBounds(22, 328, 157, 15);
		contentPane.add(lblCantidadProcesos);
		
		JLabel lblTiempoProcesos = new JLabel("Tiempo Procesos");
		lblTiempoProcesos.setBounds(22, 355, 143, 15);
		contentPane.add(lblTiempoProcesos);
		
		JLabel lblCantidadProc = new JLabel("");
		lblCantidadProc.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblCantidadProc.setBounds(165, 328, 195, 17);
		contentPane.add(lblCantidadProc);
		
		JLabel lblTiempoProce = new JLabel("");
		lblTiempoProce.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblTiempoProce.setBounds(165, 353, 195, 17);
		contentPane.add(lblTiempoProce);
		
		JScrollPane scrollPaneHistorico = new JScrollPane();
		scrollPaneHistorico.setBounds(22, 382, 514, 156);
		contentPane.add(scrollPaneHistorico);
		
		DefaultTableModel modeld = new DefaultTableModel(datad,columnNmsd);
		tableHistorico = new JTable(modeld);
		scrollPaneHistorico.setViewportView(tableHistorico);
		
		JLabel lblPocentajeProceso = new JLabel("");
		lblPocentajeProceso.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblPocentajeProceso.setBounds(160, 299, 104, 17);
		contentPane.add(lblPocentajeProceso);
	}
}
