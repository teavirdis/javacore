package by.bsuir.houses.client.main;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import by.bsuir.houses.client.gui.HousesTableData;
import by.bsuir.houses.client.gui.HousesView;


public class StartClient {

	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	
	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
		//JFrame frame = new JFrame("Houses");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create and set up the content pane.
//        HousesTable newContentPane = new HousesTable();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
//
//        
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
    	
    	HousesView window = new HousesView();
    }

}
