<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.example.demo.NLP" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Twitter Sentiment Analysis</title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link href="style.css" rel="stylesheet">
	</head>
	<body>
		<div id="top">
			<h1><i class="fa fa-twitter"></i> Twitter Sentiment Analysis</h1>
			<form action="/">
				<input type="text" name="keyword" id="key" placeholder="Enter a keyword">
				<input type="submit" value="Start" class="formbtn">
			</form>
			<button id="stop" class="formbtn" disabled>Stop</button>
		</div>
		<input type="hidden" id="key1" value='${keyword}'/>
		<p style="display: none;" id="t">${tweets}</p>
		<div class="container">
			<div class="chart-container">
				<div class="one">
					<canvas id="myChart"></canvas>
					<p id="nochart">No chart to show</p>
					<p id="count"></p>
				</div>
				<div class="two">
					Twitter Sentiment Analysis helps you to understand the sentiment behind the word used in the tweet and anlayse the impact of the sentiment thats helps tweets to go viral based on their negative to positive influence.
				</div>
			</div>
			<div class="tweets-container">
				<p style="display: none;" id="empty">Sorry, no tweets found for the keyword '${keyword}'.</p>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.3.2/chart.min.js"></script>
<script src="script.js"></script>
	<% NLP.init(); %>
	
		<c:forEach items="${tweets}" var="tweet">
			<p class="tweet">${tweet}<br>Predicted Sentiment: <span class="sent">${NLP.findSentiment(tweet)}</span></p>
		</c:forEach>
	</div>
	</div>
</body>
</html>