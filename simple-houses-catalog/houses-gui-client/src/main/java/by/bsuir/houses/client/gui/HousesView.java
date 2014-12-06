package by.bsuir.houses.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTable;

import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.table.TableColumnModel;

import java.awt.Insets;

public class HousesView {

	private JFrame frame;
	private JTable table;
	private static final String[] COLUMNS_NAMES = { "Id", "Address", "size" };

	/**
	 * Create the application.
	 */
	public HousesView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 299, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		table = new JTable(HousesTableData.prepareHousesdata(), COLUMNS_NAMES);
		table.setFillsViewportHeight(true);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(10, 10, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		frame.getContentPane().add(table, gbc_table);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ButtonActionListener());
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		frame.getContentPane().add(btnAdd, gbc_btnAdd);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		
		frame.getContentPane().add(panel, gbc_panel);
		frame.setVisible(true);
	}

}
