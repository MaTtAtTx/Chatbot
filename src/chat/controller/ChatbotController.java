package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;

/**
 * The controller for the chatbot project.
 * 
 * @author Matthew Johnsen
 * @version 11/21/17 1.2
 */

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Matthew");
		myTwitter = new CTECTwitter(this);
		//View initialized after the Model
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		/*
		String results = IOController.loadFromFile(this, "commonWords.txt");
		IOController.saveToFile(this, results, "");
		*/
	}
	
	public String interactWithChatBot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.userNameChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.shoppingListChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "This text matches the special content";
		}
		//Continue with all checkers except length and quit checker
		
		return response;
	}
	
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	public void tweet(String text)
	{
		myTwitter.sendTweet(text);
	}
	
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
}
