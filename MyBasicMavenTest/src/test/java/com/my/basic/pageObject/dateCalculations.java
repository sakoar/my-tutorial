package com.my.basic.pageObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateCalculations {
	
	public String dateCalculate() {
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
	Date date = new Date();
	
	return dateFormat.format(date);
		}
	
	public String datenTimeCalculate(){
		DateFormat datenTimeformat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = new Date();
		return datenTimeformat.format(date);
	}
}


/*String[] Day = (dateFormat.format(date).split("/")); 		//read the 'dd'
int dy = Integer.parseInt(Day[1])+1; 						//Convert String to Int & increase the 'dd' by 1 as this is known issue in Portal QA
String dy_str = Integer.toString(dy); 						//Convert back to String
String fullDate = Day[0]+"\b/"+dy_str+"\b/"+Day[2];			//This is complete date in mm/dd/yyyy with system 'dd' + 1
return fullDate;*/