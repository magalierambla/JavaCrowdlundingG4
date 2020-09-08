package com.api.crowdlending.model;

import java.io.Serializable;


public class StatistiquesChartsUsersModel implements Serializable{
	
	private  String year;
	
	private Integer nbrUsers ;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getNbrUsers() {
		return nbrUsers;
	}

	public void setNbrUsers(Integer nbrUsers) {
		this.nbrUsers = nbrUsers;
	}

}
