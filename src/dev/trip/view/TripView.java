package dev.trip.view;

import java.util.List;

import dev.trip.model.Trip;

public class TripView {
	// 전체 조회
	public void selectAll(List<Trip> trips) {
		for (Trip trip : trips) {
            System.out.println(String.format(" %d.\n 대륙 : %s\n 국가 : %s\n 도시 : %s\n 방문 유무 : %s", trip.getId(), trip.getContinent(), trip.getCountry(), trip.getCity(), trip.getIsVisited()));
            System.out.println();
            
        }
	}
	// 추가
	public void insertTrip() {
		System.out.println(String.format("여행 목록이 추가되었습니다."));
	}
	// 삭제
	public void deleteTrip(int state, int id) {
		if(state == 1) {
			System.out.println(String.format("여행 목록 %d번이 삭제되었습니다.", id));
		}
		else {
			System.out.println(String.format("여행 목록을 %d번을 찾을 수 없습니다.", id));
		}
	}
	public void updateTrip(int state, int id) {
		if(state == 1) {
			System.out.println(String.format("여행 목록 %d번이 수되었습니다.", id));
		}
		else {
			System.out.println(String.format("여행 목록 %d번을 찾을 수 없습니.", id));
		}
	}

}
