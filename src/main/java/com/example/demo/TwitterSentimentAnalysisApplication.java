package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.TwitterException;

@SpringBootApplication
public class TwitterSentimentAnalysisApplication {

	public static void main(String[] args) throws TwitterException {
		SpringApplication.run(TwitterSentimentAnalysisApplication.class, args);
	}

}
