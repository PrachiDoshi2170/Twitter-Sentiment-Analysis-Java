package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TweetManager {
	public static ArrayList<String> getTweets(String topic) {

		Twitter twitter = new TwitterFactory().getInstance();
		ArrayList<String> tweetList = new ArrayList<String>();
		try {
			Query query = new Query();
			query.setLang("en");
			query.setQuery(topic);
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				String t;
				for (Status tweet : tweets) {
					t = tweet.getText().trim()
			                // remove links
			                .replaceAll("http.*?[\\S]+", "")
			                // remove usernames
			                .replaceAll("@[\\S]+", "")
			                // replace hashtags by just words
			                .replaceAll("#[\\S]+", "")
			                // correct all multiple white spaces to a single white space
			                .replaceAll("[\\s]+", " ").trim();
					if(!t.equals("") && !t.equals("RT")) {
						tweetList.add(t);
						System.out.println(t);
					}
					//tweetList.add(tweet.getText());
				}
			} while ((query = result.nextQuery()) != null);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to search tweets: " + te.getMessage());
		}
		return tweetList;
	}
}
