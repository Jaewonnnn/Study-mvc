package dev.trip;

import java.util.Scanner;

import dev.trip.controller.TripController;
import dev.trip.model.Trip;
import dev.trip.view.TripView;

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


/*
 * 트러블슈팅 
 * 테이블 추가만 할 때는 괜찮지만 삭제 후 추가할 때 id번호가 자동으로 -되는것이 아니라 계속 +됨. AUTO_INCREMENT때문임
 *
 * 자동 증가 속성을 사용하는 경우에는 자동 증가 속성을 제거하고 수동 증가를 사용해야 순차적으로 id를 증가시킬 수 있습니다. 
 * 하지만 이러한 변경은 권장되지 않습니다.
 * 여러 행을 추가하거나 삭제해도 중복되지 않는 고유한 id를 만드는 자동 증가 속성을 계속 사용하는 것이 좋습니다.
 * 자동 증가를 사용하면 동시성 문제와 성능 저하를 방지할 수 있습니다. 
 * 순차적인 번호 규칙이 중요하지 않다면, 자동 증가 속성을 사용하는 것이 더 효율적인 선택이 될 것입니다.
 */
