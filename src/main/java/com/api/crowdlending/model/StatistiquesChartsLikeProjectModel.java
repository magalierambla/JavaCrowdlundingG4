package com.api.crowdlending.model;

import java.io.Serializable;


public class StatistiquesChartsLikeProjectModel implements Serializable{
		
		private  int year;
		
		private  String month;
		
		private String day;
		
		private Integer nbrLikes ;

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

		public Integer getNbrLikes() {
			return nbrLikes;
		}

		public void setNbrLikes(Integer nbrLikes) {
			this.nbrLikes = nbrLikes;
		}

		


		

		

}

