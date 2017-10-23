package chat.controller;

import chat.view.PopupDisplay;

public class ChatbotRunner
{
	public static void main(String [] args)
	{
//		ChatController myApp = new ChatController();
//		myApp.start();
		PopupDisplay sample = new PopupDisplay();
		sample.displayText("TestTest");
		sample.collectResponse("asdfaastest");
	}
}
