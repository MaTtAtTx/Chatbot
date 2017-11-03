package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildShoppingList();
		buildVerbs();
		buildTopics();
		buildFollowUps();
		buildQuestions();
	}
	
	private void buildMovieList()
	{

	}
	
	private void buildShoppingList()
	{
		shoppingList.add("protein");
		shoppingList.add("veggies");
		shoppingList.add("snacks");
		shoppingList.add("fruits");
		shoppingList.add("candy");
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildTopics()
	{
		topics[0] = "programming";
		topics[1] = "school";
		topics[2] = "sports";
		topics[3] = "food";
		topics[4] = "TV shows";
		topics[5] = "books";
		topics[6] = "computers";
	}
	
	private void buildFollowUps()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "How are you today?";
		questions[2] = "What are you going to do this weekend?";
		questions[3] = "What is your favorite thing to do in you free time?";
		questions[4] = "What is your favorite subject in school?";
		questions[5] = "What is your favorite color?";
		questions[6] = "What is your favorite restaurant?";
		questions[7] = "Do you have a car?";
		questions[8] = "How old are you?";
		questions[9] = "What country do you live in?";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
				validLength = true;
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean userNameCheck = false;
		String letter = "";
		int indexCount = 0;
		
		if (input != null && input.length() > 0)
		{
			if (input.startsWith("@"))
			{
				for (int currentLetterIndex = 0; currentLetterIndex < input.length(); currentLetterIndex += 1)
				{
					letter = (input.substring(currentLetterIndex, currentLetterIndex + 1));
					indexCount += 1;
					if (letter.equals("@") && indexCount > 0)
					{
						userNameCheck = false;
					}
					else
					{
						userNameCheck = true;
					}
				}
			}
		}
		
		return userNameCheck;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean shoppingListCheck = false;
		
		for (int index = 0; index < shoppingList.size(); index += 1)
		{
			if (shoppingItem.contains("protein") || shoppingItem.contains("veggies") || shoppingItem.contains("snacks") || !shoppingItem.contains("slug bait"))
			{
				shoppingListCheck = true;
			}
		}
		
		return shoppingListCheck;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString != null && exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
