package dev.trip;

import java.util.Scanner;

import dev.trip.controller.TripController;
import dev.trip.model.Trip;

public class App {

	public static void main(String[] args) {
		TripController tc = new TripController();

		Scanner scanner = new Scanner(System.in);

		boolean buf = true;
		while (buf) {
			System.out.println("원하는 작업을 선택해주세요.");
			System.out.println("1.목록 확인	2.목록 추가	3.목록 삭제	4.목록 수정	5.종료");
			int num = scanner.nextInt();
			scanner.nextLine(); // 버퍼 비우기

			if (num == 1) {
				tc.selectAll();

			} else if (num == 2) {
				System.out.print("가고싶은 대륙을 입력하세요: ");
				String continent = scanner.nextLine();

				System.out.print("가고싶은 나라를 입력하세요: ");
				String country = scanner.nextLine();

				System.out.print("가고싶은 도시를 입력하세요: ");
				String city = scanner.nextLine();

				Trip trip = Trip.builder().continent(continent).country(country).city(city).build();

				tc.insertTrip(trip);
				tc.selectAll();
			} 
			else if (num == 3) {
				tc.selectAll();
				System.out.print("삭제하고 싶은 목록의 번호를 입력하세요: ");
				
				int deleteId = scanner.nextInt();

				tc.deleteTrip(deleteId);
				tc.selectAll();
			} 
			else if (num == 4) {
				
				tc.selectAll();
				System.out.print("수정하고 싶은 목록의 번호를 입력하세요: ");
	               int updateId = scanner.nextInt();
	                scanner.nextLine();

	                System.out.print("수정할 대륙을 입력하세요: ");
	                String continent = scanner.nextLine();

	                System.out.print("수정할 나라를 입력하세요: ");
	                String country = scanner.nextLine();

	                System.out.print("수정할 도시를 입력하세요: ");
	                String city = scanner.nextLine();
	                
	                Trip trip = Trip.builder().continent(continent).country(country).city(city).build(); // 수정된 부분
	                
	                tc.updateTrip(trip, updateId);
	                
	                tc.selectAll();
			} else if (num == 5) {
				System.out.println("작업을 종료합니다.");
				buf = false;
			} else {
				System.out.println("잘 못 입력했습니다.");
			}

		}
		scanner.close();
	}

}
