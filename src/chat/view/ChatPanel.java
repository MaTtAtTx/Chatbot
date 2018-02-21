package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
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
	private JButton loadButton;
	private JButton saveButton;
	private JButton searchButton;
	private JButton tweetButton;
	private JTextField inputField;
	private JTextArea chatArea;
	//private JButton checkerButton;
	//private JLabel infoLabel;
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
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/chat.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/save.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet.png")));
		//checkerButton = new JButton("Checker");
		inputField = new JTextField(20);
		chatArea = new JTextArea(10, 25);
		//infoLabel = new JLabel("Type to chat with the chatbot");
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
		this.setBackground(new Color(0, 255, 255));
		this.setLayout(appLayout);
		this.setSize(500, 400);
		this.add(chatButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(searchButton);
		this.add(tweetButton);	
		this.add(inputField);
		this.add(chatScrollPane);
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
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, searchButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 23, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 256, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -21, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 184, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -340, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 184, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 25, SpringLayout.EAST, tweetButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, -185, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, tweetButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.EAST, tweetButton);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, -54, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, tweetButton, 57, SpringLayout.NORTH, chatButton);
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

		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
		
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});

//		checkerButton.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent click)
//			{
//				String userText = inputField.getText();
//				String displayText = appController.useCheckers(userText);
//				chatArea.setText(displayText);
//				inputField.setText("");
//			}
//		});
	}
}
