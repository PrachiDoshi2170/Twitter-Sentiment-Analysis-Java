document.querySelector("#key").value = document.querySelector("#key1").value;
var vneg = 0, neg = 0, neu = 0, pos = 0, vpos = 0;

var ctx = document.getElementById('myChart');
const data = {
	labels: [
		'Very negative',
		'Negative',
		'Neutral',
		'Positive',
		'Very positive'
	],
	datasets: [{
		label: 'Sentiment Chart',
		data: [vneg, neg, neu, pos, vpos],
		backgroundColor: [
			'rgb(255, 99, 132)',
			'rgb(255, 205, 86)',
			'rgb(54, 162, 235)',
			'rgb(0, 255, 0)',
			'rgb(0, 102, 0)'
		],
		hoverOffset: 4
	}]
};
if (document.querySelector("#key1").value != "") {
	if (document.querySelector("#t").textContent != "[]") {
		document.querySelector("#stop").disabled = false;
		document.querySelector("#stop").style.cursor = "pointer";
		document.querySelector("#nochart").style.display = "none";
		var myChart = new Chart(ctx, {
			type: 'pie',
			data: data,
		});
	}
	else {
		document.querySelector("#empty").style.display = "block";
	}
}

var i = 0;
var count = document.querySelector("#count");
const interval = setInterval(function() {
	var p = document.querySelectorAll(".tweet");
	var sents = document.querySelectorAll(".sent");
	var n = sents.length;

	if (i < n) {
		p[i].style.display = "block";
		window.scrollTo(0, document.querySelector(".tweets-container").scrollHeight);
		if (sents[i].textContent == '0') {
			p[i].style.background = "rgba(255, 51, 51, 0.9)";
			vneg++;
		}
		else if (sents[i].textContent == '1') {
			p[i].style.background = "rgba(255, 205, 86, 0.9)";
			neg++;
		}
		else if (sents[i].textContent == '2') {
			p[i].style.background = "rgba(153, 179, 230, 0.9)";
			neu++;
		}
		else if (sents[i].textContent == '3') {
			p[i].style.background = "rgba(102, 255, 102, 0.9)";
			pos++;
		}
		else if (sents[i].textContent == '4') {
			p[i].style.background = "rgba(0, 153, 0, 0.9)";
			vpos++;
		}
		myChart.data.datasets[0].data = [vneg, neg, neu, pos, vpos];
		myChart.update();
		i++;
		count.textContent = i + " tweets analysed";
	}
}, 1000);

var btn = document.querySelector("#stop");
btn.addEventListener("click", function() {
	document.querySelector("#stop").disabled = true;
	window.stop();
	clearInterval(interval);
});