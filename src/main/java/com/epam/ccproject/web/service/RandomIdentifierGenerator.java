package com.epam.ccproject.web.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomIdentifierGenerator {
	private final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
	private final Random rand = new Random();

	public String getRandomIdentifier() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = rand.nextInt(5) + 5;
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
		}
		return builder.toString();
	}

}
