package com.api.crowdlending.model;



import java.io.Serializable;


public class StatistiquesChartsHeartsProjectModel implements Serializable{
		
		private  int year;
		
		private  String month;
		
		private Integer nbrHearts ;
		
		private String day;
		
		

		
		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public Integer getNbrHearts() {
			return nbrHearts;
		}

		public void setNbrHearts(Integer nbrHearts) {
			this.nbrHearts = nbrHearts;
		}

		

		

}

