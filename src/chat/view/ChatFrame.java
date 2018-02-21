package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

/**
 * The JFrame  subclass for the chatbot project.
 * 
 * @author Matthew Johnsen
 * @version 11/21/17 1.2
 */

public class ChatFrame extends JFrame
{	
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		
		setupFrame();
	}
	
	/**
	 * This helper method setups the frame and makes it visible while putting the panel into it.
	 */
	private void setupFrame()
	{
		this.setSize(500,420);
		this.setTitle("Chatbot 2017");
		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
	}
}
