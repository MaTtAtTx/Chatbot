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
		movieList.add(new Movie("Angels and Demons"));
		movieList.add(new Movie("The Hunger Games"));
		movieList.add(new Movie("Harry Potter"));
		movieList.add(new Movie("Pirates of the Carribbean"));
		movieList.add(new Movie("Inception"));
		movieList.add(new Movie("National Treasure"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("protein");
		shoppingList.add("veggies");
		shoppingList.add("snacks");
		shoppingList.add("fruits");
		shoppingList.add("candy");
		shoppingList.add("eggs");
		shoppingList.add("hot peppers");
		shoppingList.add("onions");
		shoppingList.add("bagel");
		shoppingList.add("crunchy peanut butter");
		shoppingList.add("hot sauce");
		shoppingList.add("juice");
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
		followUps[0] = "I really like dogs. Do you?";
		followUps[1] = "I really like cats. Do you?";
		followUps[2] = "I really like ice cream. What's your favorite flavor of ice cream?";
		followUps[3] = "I like going to restaurants. What's your favorite restaurant?";
		followUps[4] = "I love boating. Have you ever been boating before?";
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
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " \n";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
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
		
		if (contentCheck.contains(content))
		{
			checkContent = true;
		}
		
		return checkContent;
	}
	
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
