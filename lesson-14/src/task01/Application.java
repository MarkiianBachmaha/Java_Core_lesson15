package task01;

import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println("�������� 1, ��� ������ �������� �����;");
		System.out.println("�������� 2, ��� ������ �������� �� �������� �����;");
		System.out.println("�������� 3, ��� �������� �������� � �������� �����;");
		System.out.println("�������� 4, ��� �������� �������� � �����;");
		System.out.println("�������� 5, ��� �������� ��������� �������� � ��� ��������;");
		System.out.println("�������� 6, ��� ������� �� ����� �������;");
		System.out.println("�������� 7, ��� ����� � ��������;");
	}

	public static void main(String[] args) {
		ZooClub zooClub = new ZooClub();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();

			switch (scanner.next()) {

			case "1": {

				zooClub.addClubMember();
				System.out.println();
				break;
			}
			case "2": {

				zooClub.addAnimal();
				System.out.println();
				break;
			}
			case "3": {

				zooClub.removeAnimal();
				System.out.println();
				break;
			}
			case "4": {

				zooClub.removeMember();
				System.out.println();
				break;
			}
			case "5": {

				zooClub.removeSpecificAnimal();
				System.out.println();
				break;
			}
			case "6": {

				zooClub.showClub();
				System.out.println();
				break;
			}

			case "7": {
				System.out.println("Exit the program.");
				System.exit(0);
				scanner.close();
			}

			}
		}
	}
}