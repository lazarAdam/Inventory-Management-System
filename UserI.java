

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * UI class
 *
 * User interface to collect, edit and display data.
 * 
 * Uses swing
 * 
 * @author Copyright (c) Sue Fitzgerald All rights reserved 8/21/16
 * 
 *         Edited by oussama el aallali 9/20/2016 
 * Note to students - you may use this example and adapt it for your programs in this class
 */

public class UserI extends JFrame {

	// input panel
	private JPanel inputPane;

	// REPLACE NAMES OF TEXT FIELDS WITH NAMES OF YOUR ITEMS
	private JTextField partNameTextField;
	private JTextField brandTextField;
	private JTextField typelTextField;
	private JTextField priceTextField;
	private JTextField quantTextField;
	private JTextField msgTextField;
	private JTextField msgTextField2;
	private JButton enterDataButton;
	private JButton searchButton;
	private JButton displayButton;
	private JButton updateButton;
	private JButton deleteButton;

	// output panel
	private JPanel contentPane;
	private JTable displayTable;

	// REPLACE WITH A REFERENCE TO YOUR DATA COLLECTION
	private BinarySearchTree BST;
	
	

	/**
	 * UI - manages interaction with user
	 * 
	 * Collects data when button is pressed and stores data in array Displays
	 * all data collected in text area Searches for matching name and displays
	 * associated data
	 */
	public UserI() {
		// REPLACE title to window WITH YOUR TITLE
		super("Computer parts  Management System");

		// Initialize data structure WITH YOUR COLLECTION
		//pl = new MyLinkedList(20);
		
		BST = new BinarySearchTree();
		
		
		

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);

		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(112, 12, 102), 4, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Default font for the user interface
		Font defaultFont = new Font("Arial", Font.PLAIN, 12);

		// Input related fields for add/updating an item
		inputPane = new JPanel();
		inputPane.setBorder(new LineBorder(new Color(112, 12, 102), 1, true));
		inputPane.setBounds(10, 32, 974, 180);
		contentPane.add(inputPane);
		inputPane.setLayout(null);

		// REPLACE labels for input fields WITH YOUR LABELS
		JLabel lblFoodName = new JLabel("Part Name");
		lblFoodName.setFont(defaultFont);
		lblFoodName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFoodName.setBounds(16, 11, 60, 14);
		inputPane.add(lblFoodName);

		JLabel lblPrice = new JLabel("Brand");
		lblPrice.setFont(defaultFont);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(16, 36, 60, 14);
		inputPane.add(lblPrice);

		JLabel lblQty = new JLabel("Type");
		lblQty.setFont(defaultFont);
		lblQty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQty.setBounds(16, 61, 60, 14);
		inputPane.add(lblQty);

		// ADD TWO MORE LABELS HERE.
		JLabel lblTemp = new JLabel("Price");
		lblTemp.setFont(defaultFont);
		lblTemp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemp.setBounds(16, 86, 60, 14);
		inputPane.add(lblTemp);

		JLabel lblTemp2 = new JLabel("Quantity");
		lblTemp2.setFont(defaultFont);
		lblTemp2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemp2.setBounds(16, 111, 60, 14);
		inputPane.add(lblTemp2);

		JLabel lblMsg = new JLabel("Message");
		lblMsg.setFont(defaultFont);
		lblMsg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMsg.setBounds(16, 151, 60, 14);
		inputPane.add(lblMsg);

		// REPLACE input field for name WITH YOUR DATA ITEM
		partNameTextField = new JTextField();
		partNameTextField.setFont(defaultFont);
		partNameTextField.setBounds(80, 8, 400, 20);
		inputPane.add(partNameTextField);
		partNameTextField.setColumns(25);

		// REPLACE input field for price WITH YOUR DATA ITEM
		brandTextField = new JTextField();
		brandTextField.setFont(defaultFont);
		brandTextField.setBounds(80, 33, 400, 20);
		inputPane.add(brandTextField);
		brandTextField.setColumns(15);

		// REPLACE input field for quantity WITH YOUR DATA ITEM
		typelTextField = new JTextField();
		typelTextField.setFont(defaultFont);
		typelTextField.setBounds(80, 58, 400, 20);
		inputPane.add(typelTextField);
		typelTextField.setColumns(15);

		// REPLACE input field WITH YOUR DATA ITEM
		priceTextField = new JTextField();
		priceTextField.setFont(defaultFont);
		priceTextField.setBounds(80, 83, 400, 20);
		inputPane.add(priceTextField);
		priceTextField.setColumns(15);

		// REPLACE input field WITH YOUR DATA ITEM
		quantTextField = new JTextField();
		quantTextField.setFont(defaultFont);
		quantTextField.setBounds(80, 108, 400, 20);
		inputPane.add(quantTextField);
		quantTextField.setColumns(15);

		// Text field for error messages
		msgTextField = new JTextField();
		msgTextField.setFont(defaultFont);
		msgTextField.setBounds(80, 148, 400, 20);
		msgTextField.setEditable(false);
		inputPane.add(msgTextField);
		msgTextField.setColumns(15);

		msgTextField2 = new JTextField();
		msgTextField2.setFont(defaultFont);
		msgTextField2.setBounds(80, 148, 400, 20);
		msgTextField2.setEditable(false);
		inputPane.add(msgTextField2);
		msgTextField2.setColumns(15);

		enterDataButton = new JButton("Insert");
		// Event trigger for the Add button click
		enterDataButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				addItemTotree();
			}
		});
		enterDataButton.setFont(defaultFont);
		enterDataButton.setBounds(665, 11, 90, 28);
		inputPane.add(enterDataButton);

		// Search function

		searchButton = new JButton("Search");
		// Event trigger for the Search button click
		searchButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// THIS EXAMPLE USES THE name FOR SEARCHING. YOU CAN USE ANY
				// FIELD FOR SEARCHING
				searchForItem(partNameTextField.getText());
			}
		});
		searchButton.setFont(defaultFont);
		searchButton.setBounds(665, 51, 90, 28);
		inputPane.add(searchButton);

		// Update an item
		updateButton = new JButton("Display in pre-order");
		// Event trigger for the Update button click
		updateButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				displayListInPreOrder();
			}
		});
		
		
		updateButton.setFont(defaultFont);
		updateButton.setBounds(640, 92, 142, 28);
		inputPane.add(updateButton);

		// Delete an item
		deleteButton = new JButton("Display in post-order");
		// Event trigger for the Search button click
		deleteButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				displayListInPostOrder();
			}
		});
		deleteButton.setFont(defaultFont);
		deleteButton.setBounds(799, 92, 142, 28);
		inputPane.add(deleteButton);

		// display grocery list on button click
		displayButton = new JButton("Display in order ");
		displayButton.addMouseListener(new MouseAdapter() {
			// Event trigger for the search button click
			public void mouseClicked(MouseEvent e) {
				displayListInOrder();
			}
		});

		displayButton.setFont(defaultFont);
		displayButton.setBounds(500, 91, 123, 28);
		inputPane.add(displayButton);

		
		
		JButton getDepth = new JButton("Get Depth");
		getDepth.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
				getDepth();
			}
		});
		
		getDepth.setFont(defaultFont);
		getDepth.setBounds(666, 135, 92, 28);
		inputPane.add(getDepth);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 250, 974, 200);
		contentPane.add(scrollPane);

		// ADD SCROLL BAR HERE

		// output table
		displayTable = new JTable();
		displayTable.setFont(defaultFont);
		displayTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// CHANGE THE LABELS TO MATCH YOUR ITEMS

		// Set the model of the search results table that defines the layout of
		// the data
		displayTable.setModel(new DefaultTableModel(new String[] {
				"Part Name ", "Brand", "Type", "Price", "Quantity" }, 0) {
			boolean[] columnEditables = new boolean[] { false, false, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		displayTable.getTableHeader().setFont(defaultFont);
		scrollPane.setViewportView(displayTable);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	
	public void displayListInOrder(){
		int i2 =0;
		ArrayList listToDis = BST.displayInorder();
		//ComputerPartsIterator itr = new ComputerPartsIterator(pl);
		// Clear the search results table
		DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
		for (int i = model.getRowCount() - 1; i >= 0; i--)
			model.removeRow(i);

		
		
		while (i2 < listToDis.size()) {
			ComputerParts gi = (ComputerParts) listToDis.get(i2);
			model.addRow(new Object[] { gi.getPartName(), gi.getBrand(),
					gi.getType(), Double.valueOf(gi.getPrice()),
					Integer.valueOf(gi.getQuant()),

					"", "" });
			i2++;
		}
	}
public void displayListInPreOrder(){
		
	int i2 =0;
	ArrayList listToDis = BST.displayPreOrder();
	//ComputerPartsIterator itr = new ComputerPartsIterator(pl);
	// Clear the search results table
	DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
	for (int i = model.getRowCount() - 1; i >= 0; i--)
		model.removeRow(i);

	
	
	while (i2 < listToDis.size()) {
		ComputerParts gi = (ComputerParts) listToDis.get(i2);
		model.addRow(new Object[] { gi.getPartName(), gi.getBrand(),
				gi.getType(), Double.valueOf(gi.getPrice()),
				Integer.valueOf(gi.getQuant()),

				"", "" });
		i2++;
	}
	}
public void displayListInPostOrder(){
	
	int i2 =0;
	ArrayList listToDis = BST.displayPostOrder();
	//ComputerPartsIterator itr = new ComputerPartsIterator(pl);
	// Clear the search results table
	DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
	for (int i = model.getRowCount() - 1; i >= 0; i--)
		model.removeRow(i);

	
	
	while (i2 < listToDis.size()) {
		ComputerParts gi = (ComputerParts) listToDis.get(i2);
		model.addRow(new Object[] { gi.getPartName(), gi.getBrand(),
				gi.getType(), Double.valueOf(gi.getPrice()),
				Integer.valueOf(gi.getQuant()),

				"", "" });
		i2++;
	}
}

	/**
	 * addGrocItemToList ()
	 * 
	 * Collects data from UI, instantiates a new ComputerParts and adds it to
	 * the PcPartsList
	 *
	 * 
	 * NOTE : CODE FOR CECHING ArrayIndexOutOfBounds Exception WAS ADDED
	 * 
	 * 
	 */
	public void addItemTotree() {

		// Check for input errors
		double price = 0.00;
		int quant = 0;

		try {

			price = Double.parseDouble(priceTextField.getText());
			quant = Integer.parseInt(quantTextField.getText());

		} catch (NumberFormatException e00) {

			msgTextField
					.setText("Enter Digits In Price and Quantity  Fields !");
			return;
		}

		// Add YOUR ITEM TO YOUR LIST. INSTANTIATE YOUR ITEM WITH FIVE FIELDS.
		/**
		 * CHECK CODE FOR THE ArrayIndexOutOfBoundsException HANDLER
		 */
if(partNameTextField.getText().equals("")|| (brandTextField.getText().equals(""))||(typelTextField.getText().equals("")) ){
			
			msgTextField.setText("Missing values");
			return;}
		
			BST.add(new ComputerParts(partNameTextField.getText(),
					brandTextField.getText(), typelTextField.getText(), price,
					quant));
			
		
		// display updated list
		

		/**
		 * This line will display the number of items in the PC part list using
		 * the message text field every time the user add a new part to the list
		 * 
		 */

		msgTextField.setText("current number of items: "
				+ String.valueOf(BST.count()));

		// reset input fields to empty
		partNameTextField.setText("");
		brandTextField.setText("");
		typelTextField.setText("");
		priceTextField.setText("");
		quantTextField.setText("");

	}

	/**
	 * searchForItem (String n)
	 * 
	 * @param n
	 *            Name of part item to find
	 * 
	 *            NOTE : CODE FOR CECHING ArrayIndexOutOfBounds Exception WAS
	 *            ADDED
	 */
	public void searchForItem(String name) {
		// Instantiate an item with only one meaningful data item - the search
		// key
		// CHANGE THIS TO BE YOUR ITEM. YOUR CONSTRUCTOR SHOULD HAVE 5 FIELDS

		ComputerParts p = new ComputerParts(name, "b", "m", 0.0, 0);

		// Call the search function from YOUR COLLECTION CLASS. Return a
		// matching item with
		// all field filled in OR return NULL if not found

			p = BST.searchForIt(p);
	

		

		if (p == null) {
			msgTextField.setText("Item not found");
			partNameTextField.setText("");
			brandTextField.setText("");
			typelTextField.setText("");
			priceTextField.setText("");
			quantTextField.setText("");
		} else {
			partNameTextField.setText(p.getPartName());
			brandTextField.setText(String.valueOf(p.getBrand()));
			typelTextField.setText(String.valueOf(p.getType()));
			priceTextField.setText(String.valueOf(p.getPrice()));
			quantTextField.setText(String.valueOf(p.getQuant()));
			
			msgTextField.setText("");
			
		}
		
		
	}
	
	public void getDepth(){
		
		int x = BST.depth();
		
		msgTextField.setText("The depth of this tree is : "+x);
		
	}
	
}
