package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appcontroller)
	{
		super();
		this.appController = appController;
		chatButton = new JButton("This is the first button");
		inputField = new JTextField("Test");
		appLayout = new SpringLayout();
	}
}
