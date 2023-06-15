package dev.trip.controller;

import java.util.List;

import dev.trip.dao.TripDAO;
import dev.trip.model.Trip;
import dev.trip.view.TripView;

public class TripController {
	private final TripView view;
	private final TripDAO dao;
	
	public TripController() {
		view = new TripView();
		dao = new TripDAO();
	}
	
	// 전체 조회
	public void selectAll() {
		List<Trip> trips = dao.selectAll();
		view.selectAll(trips);
	}

	// 추가
	public void insertTrip(Trip trip) {
		dao.insertTrip(trip);
	}
	// 삭제
	public void deleteTrip(int id) {
		dao.deleteTrip(id);
	}
	// 수정
	public void updateTrip(Trip trip, int id) {
		dao.updateTrip(trip, id);
	}
	
	
}
