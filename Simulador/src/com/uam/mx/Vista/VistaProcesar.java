/*La rafaga debe ser ,menor a 100 ya que es el maximo de nuestra barra de progreso :D*/

package com.uam.mx.Vista;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VistaProcesar extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuantum;
	private JTextField txtRafaga;
	private final JTable tableLista;
	private JTable tableHistorico;
	private JProgressBar progressBar;
	private JLabel lblQuantum;
	private JLabel lblRafaga;
	private JButton btnAgregar;
	private JButton btnIniciar;
	private JScrollPane scrollPaneLista;
	private DefaultTableModel model;
	private JLabel lblProceso;
	private JLabel lblNumProc;
	private JLabel lblCantidadProcesos;
	private JLabel lblTiempoProcesos;
	private JLabel lblCantidadProc;
	private JLabel lblTiempoProce;
	private JScrollPane scrollPaneHistorico;
	private DefaultTableModel modeld;
	private JLabel lblPocentajeProceso;
	private String[] columnNms = {"# Proceso","Rafaga","Quantum","Residuo rafaga","Estado"};
	private String[] columnNmsd = {"# Proceso","Rafaga","Quantum","Tiempo Final","Estado"};
	private Object[][] data = {};
	private Object[][] datad = {};

	private int Contador 	  	 = 0;
	private int NProceso 	  	 = 0;
	private int Rafaga 		  	 = 0;
	private int Quantum 	  	 = 0;
	private int ResiduoRafaga 	 = 0;
	private int TiempoProceso 	 = 0;
	private int ValorBarra	  	 = 0;
	private int CantidadProcesos = 0;
	
	public VistaProcesar() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 800);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblQuantum = new JLabel("Quantum");
		lblQuantum.setBounds(22, 12, 70, 15);
		contentPane.add(lblQuantum);
		
		lblRafaga = new JLabel("Rafaga");
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
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtQuantum.getText().isEmpty() && !txtRafaga.getText().isEmpty()){
					if(Integer.parseInt(txtRafaga.getText()) <= 100){
						Ingresar();
						txtQuantum.setEditable(false);
					}else{
						JOptionPane.showMessageDialog(null, "Las rafagas deben ser menores a 100");
						txtRafaga.setText(null);
						txtRafaga.grabFocus();
					}					
				}else{
					JOptionPane.showMessageDialog(null, "Ingrese Quantum o Rafaga.\n Por favor");
					txtRafaga.setText(null);
					txtRafaga.grabFocus();
				}

			}
		});
		btnAgregar.setBounds(396, 12, 117, 25);
		contentPane.add(btnAgregar);
		
	    btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(396, 43, 117, 25);
		contentPane.add(btnIniciar);
		
		scrollPaneLista = new JScrollPane();
		scrollPaneLista.setBounds(12, 72, 524, 204);
		contentPane.add(scrollPaneLista);
		
		model = new DefaultTableModel(data,columnNms);
		tableLista = new JTable(model);
		scrollPaneLista.setViewportView(tableLista);
		tableLista.setBackground(Color.WHITE);
		tableLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		progressBar = new JProgressBar();
		progressBar.setBounds(297, 299, 239, 17);
		contentPane.add(progressBar);
		
		lblProceso = new JLabel("Proceso");
		lblProceso.setBounds(22, 277, 70, 15);
		contentPane.add(lblProceso);
		
		lblNumProc = new JLabel("");
		lblNumProc.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblNumProc.setBounds(22, 299, 104, 17);
		contentPane.add(lblNumProc);
		
		lblCantidadProcesos = new JLabel("Cantidad Proceso");
		lblCantidadProcesos.setBounds(22, 328, 157, 15);
		contentPane.add(lblCantidadProcesos);
		
		lblTiempoProcesos = new JLabel("Tiempo Procesos");
		lblTiempoProcesos.setBounds(22, 355, 143, 15);
		contentPane.add(lblTiempoProcesos);
		
		lblCantidadProc = new JLabel("");
		lblCantidadProc.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblCantidadProc.setBounds(165, 328, 195, 17);
		contentPane.add(lblCantidadProc);
		
		lblTiempoProce = new JLabel("");
		lblTiempoProce.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblTiempoProce.setBounds(165, 353, 195, 17);
		contentPane.add(lblTiempoProce);
		
		scrollPaneHistorico = new JScrollPane();
		scrollPaneHistorico.setBounds(22, 382, 514, 156);
		contentPane.add(scrollPaneHistorico);
		
		modeld = new DefaultTableModel(datad,columnNmsd);
		tableHistorico = new JTable(modeld);
		scrollPaneHistorico.setViewportView(tableHistorico);
		
		lblPocentajeProceso = new JLabel("");
		lblPocentajeProceso.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		lblPocentajeProceso.setBounds(160, 299, 104, 17);
		contentPane.add(lblPocentajeProceso);
	}


	protected void Ingresar() {
		DefaultTableModel model = (DefaultTableModel)tableLista.getModel();

		Contador ++;
		Object[] miTabla = new Object[5];
		
		miTabla[0] = Contador;
		miTabla[1] = txtRafaga.getText();
		miTabla[2] = txtQuantum.getText();
		miTabla[3] = txtRafaga.getText();
		miTabla[4] = "Listo";
		model.addRow(miTabla);
		tableLista.setModel(model);
		txtRafaga.setText(null);
		txtRafaga.grabFocus();
	}
	
	private class Hilo implements Runnable{

		@Override
		public void run() {
			int estado = 1;
			int i = 0;
			
			while(estado != 0){
				while(i < Contador){
					Cargar(i);
					if(ResiduoRafaga != 0 && ResiduoRafaga > Quantum){
						for (int c = 1; c <= Quantum; c++) {
							tableLista.setValueAt("Procesando", i, 4);
							ResiduoRafaga--;
							Barra(Rafaga,ResiduoRafaga);
							Pintar();
							tableLista.setValueAt(String.valueOf(ResiduoRafaga), i, 3);
							TiempoProceso++;
							Dormir();
						}
						tableLista.setValueAt("Esperando", i, 4);
						if(ResiduoRafaga == 0){
							tableLista.setValueAt("Terminado", i, 4);
							Pintar();
							Informe(i);
							Borrar(i);
							progressBar.setValue(0);
						}
					}else{
						if(ResiduoRafaga>0 && Quantum !=0){
							while (ResiduoRafaga > 0) {
								tableLista.setValueAt("Procesando", i, 4);
								ResiduoRafaga--;
								Barra(Rafaga,ResiduoRafaga);
								Pintar();
								tableLista.setValueAt(String.valueOf(ResiduoRafaga), i, 3);
								TiempoProceso++;
								Dormir();
							}
							tableLista.setValueAt("Esperando", i, 4);
							if(ResiduoRafaga == 0 && Quantum != 0){
								tableLista.setValueAt("Terminado", i, 4);
								Pintar();
								Informe(i);
								Borrar(i);
								progressBar.setValue(0);
							}
						}else{
							if(ResiduoRafaga == 0 && Quantum != 0){
								tableLista.setValueAt("Terminado", i, 4);
								Pintar();
								Informe(i);
								Borrar(i);
								progressBar.setValue(0);
							}
						}
					}
					lblNumProc.setText(String.valueOf(""));
					lblPocentajeProceso.setText(String.valueOf(""));
					i++;
				}
				i=0;
				lblNumProc.setText(String.valueOf(""));
				lblPocentajeProceso.setText(String.valueOf(""));
			}
						
		}
		
	}
	
	public void Dormir(){
		try {
			Thread.sleep(700);
			
		} catch (InterruptedException e) {
			Logger.getLogger(VistaProcesar.class.getName()).log(Level.SEVERE,null, e);
		}
	}
	
	public void Cargar(int i){
		NProceso = (int)tableLista.getValueAt(i, 0);
		Rafaga = parseInt((String) (tableLista.getValueAt(i, 1)));
		Quantum = parseInt((String)(tableLista.getValueAt(i, 2))); 
		ResiduoRafaga = parseInt((String)(tableLista.getValueAt(i, 3)));
		
		if(NProceso > 0){
			lblNumProc.setText(String.valueOf(NProceso));
		}
	}
}
