package dev.trip.model;

import lombok.Builder;

@Builder
public class Trip {
	private int id;
	private String continent; // 대륙
	private String country; // 나라
	private String city; // 도시
	private Boolean isVisited;
	//private LocalDate date; // 가고싶은 날짜
	
	
	public Trip(int id, String continent, String country, String city, Boolean isVisited) {
		this.id = id;
		this.continent = continent;
		this.country = country;
		this.city = city;
		this.isVisited = isVisited;
		//this.date = date;
	}

	
	public String getContinent() {
		return continent;
	}


	public String getCountry() {
		return country;
	}


	public String getCity() {
		return city;
	}

	public int getId() {
		return id;
	}

	public Boolean getIsVisited() {
		return isVisited;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
