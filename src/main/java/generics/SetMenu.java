package generics;

import java.util.Scanner;

public class SetMenu {

	private Set<GenericClass<?>> set;

	public SetMenu(Set<GenericClass<?>> set) {
		this.set = set;
	}

	public void run() {
		Scanner input = new Scanner(System.in);
		String choice;
		do {
			System.out.println("Please choose an operation:");
			System.out.println("1. Add an element");
			System.out.println("2. Remove an element");
			System.out.println("3. Peek");
			System.out.println("4. Size of set");
			System.out.println("5. Display all elements");
			System.out.println("6. Check equality of sets");
			System.out.println("7. Exit");
			System.out.print("Choice: ");
			choice = input.nextLine();
			switch (choice) {
			case "1":
				addItem(input);
				break;
			case "2":
				removeItem(input);
				break;
			case "3":
				checkItem(input);
				break;
			case "4":
				getSize();
				break;
			case "5":
				displaySet();
				break;
			case "6":
				checkEqualSets(input);
				break;
			case "7":
				System.out.println("Exiting program...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
			System.out.println();
		} while (!choice.equals("7"));
		input.close();
	}

	private void addItem(Scanner input) {

		System.out.print("Enter the id: ");
		int id = input.nextInt();
		input.nextLine();

		System.out.print("Enter the element: ");
		String item = input.nextLine();

		GenericClass<String> genericItem = new GenericClass<>();
		genericItem.setData(item);
		genericItem.id = id;
		set.push(genericItem);

	}

	private void removeItem(Scanner input) {
		System.out.print("Enter the element ID: ");
		int id = input.nextInt();
		input.nextLine();
		if (set.peek(id)) {
			GenericClass<?> item = set.pop(id);
			System.out.println("Item " + item.getData() + " removed from set.");
		} else {
			System.out.println("Element not found in set.");
		}
	}

	private void checkItem(Scanner input) {
		System.out.print("Enter the element ID: ");
		int id = input.nextInt();
		input.nextLine();
		if (set.peek(id)) {
			System.out.println("Element exists in set.");
		} else {
			System.out.println("Element not found in set.");
		}
	}

	private void getSize() {
		System.out.println("Size of set: " + set.getSize());
	}

	private void displaySet() {
		set.display();
	}

	private void checkEqualSets(Scanner input) {
		Set<GenericClass<?>> otherSet = new Set<>();
		System.out.print("Enter the number of elements in the other set: ");
		int numItems = input.nextInt();
		input.nextLine();
		for (int i = 0; i < numItems; i++) {
			System.out.print("Enter ID " + (i + 1) + ": ");
			int id = input.nextInt();
			input.nextLine();
			GenericClass<String> genericItem = new GenericClass<>();
			genericItem.id = id;
			otherSet.push(genericItem);
		}
		if (set.equals(otherSet)) {
			System.out.println("The sets are equal.");
		} else {
			System.out.println("The sets are not equal.");
		}
	}

}
