function remainingTime(){
	var minutes = 29;
	var seconds = 59;
	var time = document.getElementById("time");
	window.setInterval(function (){seconds = seconds - 1;
		if(seconds < 0){
			seconds = 59;
			minutes = minutes - 1;
		}
		if(seconds>=0&&seconds<10){
			seconds = "0"+seconds;
		}
		if(minutes>=0&&minutes<10){
			minutes = "0"+minutes;
		}
		time.innerText = "00:"+minutes+":"+seconds;
	},1000);
}
