package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatbotController appcontroller)
	{
		super();
		this.appController = appController;
		chatButton = new JButton("This is the first button");
		inputField = new JTextField("Test");
		baseLayout = new SpringLayout();
	}
}
