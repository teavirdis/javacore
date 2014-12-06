package by.bsuir.houses.client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

	enum ButtonActions {
		ADD, EDIT, DELETE
	}

	public void actionPerformed(ActionEvent e) {
		ButtonActions ba = ButtonActions.valueOf(e.getActionCommand()
				.toUpperCase());
		switch (ba) {
		case ADD:
			break;
		case EDIT:
			break;
		case DELETE:
			break;
		default:
			break;
		}
	}

}
