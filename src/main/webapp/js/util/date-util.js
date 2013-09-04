function getTheDay(day,offset){
	var ONE_DAY = 86400000;
	if( day instanceof Date){
		var theDay = new Date();
		theDay.setTime(day.getTime() + offset * ONE_DAY);
		return theDay;
	}
}