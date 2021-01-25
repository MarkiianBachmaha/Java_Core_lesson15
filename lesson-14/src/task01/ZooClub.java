package task01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ZooClub {

	Scanner scanner;
	Map<Person, ArrayList<Animal>> map = new HashMap<Person, ArrayList<Animal>>();

	public void addClubMember() {
		System.out.println("Adding a member to the club;");

		System.out.println("Enter name:");
		scanner = new Scanner(System.in);
		String name = scanner.next();

		System.out.println("Enter age:");
		scanner = new Scanner(System.in);
		int age = scanner.nextInt();

		Person zooClubMember = new Person(name, age);
		map.put(zooClubMember, new ArrayList<Animal>());
		System.out.println(map.toString() + " now in the club;");
	}

	public void addAnimal() {
		System.out.println("Adding an animal to the club member in the club;");

		System.out.println("Enter name:");
		scanner = new Scanner(System.in);
		String name = scanner.next();

		System.out.println("Enter age:");
		scanner = new Scanner(System.in);
		int age = scanner.nextInt();

		boolean check = isZooClubMemberPresent(map, name, age);

		if (check) {
			System.out.println("Enter type of animal:");
			scanner = new Scanner(System.in);
			String animalType = scanner.next();

			System.out.println("Enter animal name:");
			scanner = new Scanner(System.in);
			String animalName = scanner.next();

			Animal newAnimal = new Animal(animalType, animalName);

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();

				if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
					ArrayList<Animal> list = next.getValue();

					list.add(newAnimal);
					System.out.println("Animal " + newAnimal.toString() + "now is on " + next.getKey() + ".");
				}
			}
		} else {
			System.out.println("This member isn't at club!");
		}
	}

	public void removeAnimal() {
		System.out.println("Removing animal from club member;");

		System.out.println("Enter name:");
		scanner = new Scanner(System.in);
		String name = scanner.next();

		System.out.println("Enter age:");
		scanner = new Scanner(System.in);
		int age = scanner.nextInt();

		boolean check = isZooClubMemberPresent(map, name, age);

		if (check) {
			System.out.println("Enter type of animal:");
			scanner = new Scanner(System.in);
			String animalType = scanner.next();

			System.out.println("Enter animal name:");
			scanner = new Scanner(System.in);
			String animalName = scanner.next();

			boolean check2 = isZooClubMemberAnimalPresent(map, name, age, animalType, animalName);

			if (check2) {
				Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> next = iterator.next();

					if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
						ArrayList<Animal> list = next.getValue();

						Iterator<Animal> iterator2 = list.iterator();

						while (iterator2.hasNext()) {
							Animal next2 = iterator2.next();

							if (next2.getAnimalType().equalsIgnoreCase(animalType)
									&& next2.getAnimalName().equalsIgnoreCase(name)) {
								iterator2.remove();
								System.out.println("Animal" + next2.toString() + " was deleted from "
										+ next.getKey().getName() + ".");
							}
						}
					}
				}
			}
		} else {
			System.out.println("This animal is missing;");
		}
	}

	public void removeMember() {
		System.out.println("Removing member from club;");

		System.out.println("Enter name:");
		scanner = new Scanner(System.in);
		String name = scanner.next();

		System.out.println("Enter age:");
		scanner = new Scanner(System.in);
		int age = scanner.nextInt();

		boolean check = isZooClubMemberPresent(map, name, age);

		if (check) {
			Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> next = iterator.next();

				if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
					iterator.remove();
					System.out.println(next.getKey().toString() + " was deleted;");
				}
			}
		} else {
			System.out.println("This member is missing;");
		}
	}

	public void removeSpecificAnimal() {
		System.out.println("Removing all animals");

		System.out.println("Enter animal type:");
		scanner = new Scanner(System.in);
		String animalType = scanner.next();

		Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> next = iterator.next();
			ArrayList<Animal> list = next.getValue();
			Iterator<Animal> iterator2 = list.iterator();

			while (iterator2.hasNext()) {
				Animal next2 = iterator2.next();

				if (next2.getAnimalType().equalsIgnoreCase(animalType)) {
					iterator2.remove();
					System.out.println("Animal" + next2.toString() + " was deleted;");
				}
			}
		}
	}

	public void showClub() {
		System.out.println("All club:");
		Set<Entry<Person, ArrayList<Animal>>> list = map.entrySet();

		for (Entry<Person, ArrayList<Animal>> entry : list) {
			System.out.println("Member" + entry.getKey() + " have " + entry.getValue() + ";");
		}
	}

	static boolean isZooClubMemberPresent(Map<Person, ArrayList<Animal>> zooClub, String name, int age) {
		boolean flag = false;

		Set<Entry<Person, ArrayList<Animal>>> zooClubMembers = zooClub.entrySet();

		for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
			if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
				flag = true;
			}
		}

		return flag;
	}

	static boolean isZooClubMemberAnimalPresent(Map<Person, ArrayList<Animal>> map, String name, int age,
			String animalType, String animalName) {
		boolean flag = false;

		Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> next = iterator.next();

			if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age) {
				ArrayList<Animal> list = next.getValue();

				Iterator<Animal> iterator2 = list.iterator();

				while (iterator2.hasNext()) {
					Animal next2 = iterator2.next();

					if (next2.getAnimalType().equalsIgnoreCase(animalType)
							&& next2.getAnimalName().equalsIgnoreCase(animalName)) {
						flag = true;
					}
				}
			}
		}
		return flag;
	}

}