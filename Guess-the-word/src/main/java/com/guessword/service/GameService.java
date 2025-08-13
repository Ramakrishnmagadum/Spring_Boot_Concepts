package com.guessword.service;

import java.util.Random;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GameService {
	Random randomnum = new Random();
	String[] randomwords = { "father", "mother", "student", "daugther", "bottle", "computer", "phone" };
	char[] randomchossenword;
	String randomword;
	String word = "";
	public static int chances;
	public static String successmsg;
	

//	# While Loading the GameServiceObject ..it will pick random Word from Array ..
//	Whenever we click on Reload Button it will create New GameService Bean Object Each Time
	public GameService() {
		randomword = randomwords[randomnum.nextInt(randomwords.length)];
		System.out.println("Randomlly picked word is :- " + randomword);
		randomchossenword = new char[randomword.length()];
		chances=5;
	}

	public String toString(String guesseschar) {
		
//		Logic here written
		if(guesseschar!=null  &&  guesseschar.length()>0 ) {
			if( randomword.contains(guesseschar)) {
			int indexOf = randomword.indexOf(guesseschar);
			StringBuilder builder= new StringBuilder(word);
			builder.setCharAt(indexOf*2, guesseschar.charAt(0));
			word=builder.toString();
			if(randomword.equals(word.replace(" ", ""))) {
				successmsg="You win the Game";
			}
			}else {
				this.chances=chances-1;
			}
		}
		
		if(guesseschar==null) {
			for (char ch : randomchossenword) {
				if (ch == '\u0000') {
					word = word + "_";
				}
				word = word + " ";
			}
		}
		return word;
	}

}
