package com.example.demo;

public class Passenger {
	private String name;
	private Integer seat;

	public Passenger() {
	}

	public Passenger(String name, Integer seat) {
		this.name = name;
		this.seat = seat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Passengers [name=" + name + ", seat=" + seat + "]";
	}
}
