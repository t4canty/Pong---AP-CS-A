/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author domingodavid
 */
public class Logic {
	
	
	public static void main(String[] arg){
		/* test your own methods below! */
		// testing updateScore 
		
		//System.out.println(updateScore(1,true));
		//System.out.println(addStrike("n", "n"));
		//System.out.println(guessWord("test", "TST"));
		//System.out.println(guessLetter("g", "g_", "g"));
		System.out.println(encrypt("hello", "____", ""));
		
	}
	
	
    
    /**
     * Return an updated score if won is true.
     * updateScore(1,true)-> 2
     * updateScore(2,false)->2
     * @param score
     * @param won
     * @return the updated score
     */
    public static int updateScore(int score, boolean won){
       if(won){
    	   return score;
       }else{
    	   System.out.println("Error in updateScore: not won");
    	   return -1;
       }
    }
    
    /**
     * Given an existing string that keeps track of guessed letters/words
     * add the current guess to the list. If the letter already exists then don't add it.
     * addStrike("rslt","n")->"rsltn"
     * addStrike("abc","n")->"abcn"
     * @param list current list of strikes or incorrect guesses
     * @param guess current incorrect guess
     * @return the new list containing the newly made incorrect guess
     */
    public static String addStrike(String list, String guess){
        if(list.indexOf(guess) == -1){
        	return list + guess;
        }else {
			System.out.println("Error in addStrike: already exists");
			return list;
        }
    }
    
    /**
     * Checks if the user word guess matches the word to be guessed.
     * GuessWord("test", "best")->False GuessWord("test", "TEST")->True
     * GuessWord("test", "t est")->False
     *
     * @param word
     * @param guess
     * @return
     */
    public static boolean guessWord(String word, String guess) {
        if(guess.toLowerCase().equals(word)){
        	return true;
        }else{
        	System.out.println("Error in GuessWord: Not equal");
        	return false;
        }
    }
    
    /**
     * A method used to figure out if a player's guess is successful or not.
     * A guess is successful if the letter has not already been guessed and is 
     * in the word to be guessed. A guess of a letter that has already been
     * guessed will count against the player.
     * guessLetter("apcs","A_CS","A")->false
     * guessLetter("apcs","A_CS","P")->true
     * @param word the word to be guessed
     * @param curr the current displayed text to the user
     * @param guess the letter being guessed
     * @return true or false
     */
    public static boolean guessLetter(String word, String curr, String guess){
    		if(word.indexOf(guess.toLowerCase()) != -1 && curr.toLowerCase().indexOf(guess.toLowerCase()) == -1){
    			return true;
    		}else{
    			if(curr.toLowerCase().indexOf(guess.toLowerCase()) !=-1){
    				System.out.println("Error: already guessed");
    				return false;
    			}else{
    				System.out.println(("Error: not in word"));
    				return false;
    			}
    		}

        
 
    }

    /**
     * The word shown to a player for Hang-Man must be coded such that only the
     * correctly guessed letters are visible to the player. The rest of the
     * letters must be underscores __.
     *
     * This method has three parameters as described below. Given the word, the
     * current displayed text and the letter that was guessed return a new
     * version of the display word.
     *
     * @param word to be guessed
     * @param curr text shown to the player
     * @param guess letter or word guessed by the player
     * @return new version of displayed text
     */
    public static String encrypt(String word, String curr, String guess) {
        String result = "";
        for(int f = 0; f < word.length(); f++){
        	result += "_";
        }
        for(int i = 0; i < word.length()-1; i++){
        	if(word.substring(i, i+1).equals(guess)){
        		result = result.substring(0, i) + guess + result.substring(i + 1, result.length());
        		//System.out.println(newString);
        	}
        }
        return result;
    }
    
    /**
     * Return a version of the given string without spacing
     * You may assume that each character is followed immediately by a 
     * white space
     * withoutSpace("a b ")->"ab". 
     * withoutSpace("t _ r _ ")-> "t_r_"
     * @param str the string to be transformed
     * @return version of the string without spaces as shown above
     */
    public static String withoutSpaces(String str){
        String result = "";
        for(int i = 0; i < str.length(); i++){
        	
        }
        return result;
    }
    
    /**
     * Return a version of the string with spaces in between the letters
     * withSpaces("hi")->"h i "
     * withSpaces("apcs")-> "a p c s "
     * @param str the word to be transformed
     * @return the word with spaces as shown above
     */
    public static String withSpaces(String str){
        String result = "";

        
        
        return result;
    }

  
    /**
     * Return an empty string
     * @return an empty string
     */
    public static String clearText() {
        return "result";
    }

    /**
     * Return a version of the string where each letter is replaced with
     * underscores (_)
     * reset("reset")->"_____";
     * reset("David")->"_____";
     * @param word the word to be transformed
     * @return a version of the word all with underscores
     */
    public static String reset(String word) {
        String result = "";

        
        
        
        return result;
    }
}
