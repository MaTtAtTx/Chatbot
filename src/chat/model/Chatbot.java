package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The Chatbot subclass for the chatbot project.
 * 
 * @author Matthew Johnsen
 * @version 11/21/17 1.2
 */

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
	
	/**
	 * This is the constructor for the chatbot model, where all the data members
	 * of the chatbot are initialized.
	 * @param username This is one of the data members of the chatbot.
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.verbs = new String [4];
		this.topics = new String [7];
		this.followUps = new String [5];
		this.questions = new String [10];
		this.username = username;
		this.content = "";
		this.intro = "";
		this.currentTime = LocalTime.now();
		
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildVerbs();
		buildTopics();
		buildFollowUps();
		buildQuestions();
	}
	
	private void buildMovieList()
	{
		movieList.add(new Movie("Justice League"));
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
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("kittie");
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
		followUps[0] = "dogs";
		followUps[1] = "cats";
		followUps[2] = "ice cream";
		followUps[3] = "restaurants";
		followUps[4] = "boating";
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
	
	/**
	 * Takes the user's text input and processes it and returns a string.
	 * @param input The user's supplied text.
	 * @return The combined user input and chatbot response
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " \n";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * Builds a random response using the chatbot's sentence part arrays.
	 * @return The random response of the chatbot.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random2 = ((int) (Math.random() * 2)) % 2;
		
		int random = (int) (Math.random() * verbs.length);
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		if (random2 == 0)
		{
			response += questions[random];
		}
		else
		{
			response += questions[random] + "\n";
		}
		
		if (random2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!\n";
		}
		
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 2:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	 
	/**
	 * This checker checks to see if the length of the string in the chatbot is greater than 2.
	 * @param input This is the user's input in the chatbot.
	 * @return This checker will only return a boolean as true if all the conditions of it are met.
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
			validLength = true;
		}
		
		return validLength;
	}
	
	/** 
	 * This checker is suppose to check to make sure only correct html tags work.
	 * @param input This is the users input in the chatbot.
	 * @return The checker returns a boolean that will only be true if all the conditions are met.
	 */
	public boolean htmlTagChecker(String input)
	{
		boolean containsHTML = false;
		
		if (input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">",firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if(input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		//Check singleton
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br>"))
		{
			containsHTML = true;
		}
		//Check others
		else if (firstClose > firstOpen)
		{
			
			
			//Others
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
		
		
		}
		
		return containsHTML;
	}
	
	/**
	 * This checker checks to see if the username meets all the conditions, which include
	 * not being null, having a length greater than 0, starting with an @ sign, and the
	 * username only having 1 @ sign in it.
	 * @param input This is just the users input
	 * @return Returns a boolean that is only true if all the conditions of the checker are met.
	 */
	public boolean userNameChecker(String input)
	{
		boolean userNameCheck = false;
		
		if (input != null && input.length() > 0 && input.startsWith("@"))
		{
			if (input.indexOf("@") == input.lastIndexOf("@"))
			{
				userNameCheck = true;
			}
		}
		
		return userNameCheck;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		boolean checkContent = false;
		
		if (contentCheck.length() > 6)
		{
			checkContent = true;
		}
		
		return checkContent;
	}
	
	/**
	 * This checker checks to see if the cute animal memes list contains the required memes.
	 * @param input This is just the users input when the checker is being used.
	 * @return It returns a boolean that only changes to true if the checkers conditions are met.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean animalCheck = false;
		
		for (int index = 0; index < cuteAnimalMemes.size(); index += 1)
		{
			if (input.contains(cuteAnimalMemes.get(index)))
			{
				animalCheck = true;
			}
		}
		
		return animalCheck;
	}
	
	/**
	 * This checker checks to see if the shopping list contains the required items.
	 * @param shoppingItem This is just the users input when the checker is being used.
	 * @return It returns a boolean that only changes to true if the checkers conditions are met.
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean shoppingListCheck = false;
		
		for (int index = 0; index < shoppingList.size(); index += 1)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
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

	/**
	 * Checks to see the if the user types a string as quit and the string isn't null.
	 * @param exitString This is the user's input in the chatbot.
	 * @return Returns a boolean as true only if the conditions of the checker are met.
	 */
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
