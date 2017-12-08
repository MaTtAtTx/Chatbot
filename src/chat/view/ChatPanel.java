package chat.view;

import javax.swing.JPanel;
import chat.controller.ChatbotController;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The JPanel subclass for the chatbot project.
 * 
 * @author Matthew Johnsen
 * @version 11/21/17 1.2
 */

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	private SpringLayout appLayout;

	/**
	 * This is the constructor for the GUIPanel where all the Panel components are initialized.
	 * @param appcontroller
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;

		//Initialize GUI data members
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Checker");
		inputField = new JTextField(20);
		chatArea = new JTextArea(10, 25);
		infoLabel = new JLabel("Type to chat with the chatbot");
		chatScrollPane = new JScrollPane();
		appLayout = new SpringLayout();

		//call new helper methods
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	/**
	 * This helper method adds the specific components you want to the GUIPanel and you also must
	 * set the layout to the appLayout you made in this helper method.
	 */
	private void setupPanel()
	{
		this.setBackground(new Color(((int) (Math.random() * 256)), ((int) (Math.random() * 256)), ((int) (Math.random() * 256))));
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(checkerButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}

	/**
	 * All the constraints on the components of the panel go into this helper method. If you move
	 * components around in the WindowBuilder Editor, the coding of the constraints will move back to
	 * the chatPanel constructor.
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -40, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, -35, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 29, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
	}

	/**
	 * This helper method contains the action listeners you create, which are action for different things like
	 * clicking for buttons, etc.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatBot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});

		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.setText(displayText);
				inputField.setText("");
			}
		});
	}
}
