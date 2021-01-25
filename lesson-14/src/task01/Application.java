package task01;

import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println("Натисніть 1, щоб додати учасника клубу;");
		System.out.println("Натисніть 2, щоб додати тваринку до учасника клубу;");
		System.out.println("Натисніть 3, щоб видалити тваринку з учасника клубу;");
		System.out.println("Натисніть 4, щоб видалити учасника з клубу;");
		System.out.println("Натисніть 5, щоб видалити конкретну тваринку зі всіх власників;");
		System.out.println("Натисніть 6, щоб вивести на екран зооклуб;");
		System.out.println("Натисніть 7, щоб вийти з програми;");
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