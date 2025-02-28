package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Train {
	private String model;
	private TrainType trainType;
	private Integer seats;
	private List<Crew> crew = new ArrayList<Crew>();

	public Train() {
	}

	public Train(String model, TrainType trainType, Integer seats) {
		this.model = model;
		this.trainType = trainType;
		this.seats = seats;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public TrainType getTrainType() {
		return trainType;
	}

	public void setTrainType(TrainType trainType) {
		this.trainType = trainType;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public List<Crew> getCrew() {
		return crew;
	}

	public void setCrew(List<Crew> crew) {
		this.crew = crew;
	}

	@Override
	public String toString() {
		return "Train [model=" + model + ", trainType=" + trainType + ", seats=" + seats + ", crew=" + crew + "]";
	}
}
