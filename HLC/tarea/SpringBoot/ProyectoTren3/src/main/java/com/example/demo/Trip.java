package com.example.demo;

import java.util.HashSet;
import java.util.Set;

public class Trip {
	private String name;
	private String origin;
	private String destination;
	private Train train;

	private Set<Passenger> passengers = new HashSet<Passenger>();

	public Trip(String name, String origin, String destination) {
		this.name = name;
		this.origin = origin;
		this.destination = destination;
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Trip [name=" + name + ", origin=" + origin + ", destination=" + destination + ", train=" + train
				+ ", passengers=" + passengers + "]";
	}
}
