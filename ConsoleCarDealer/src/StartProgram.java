

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListType;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a make: ");
			String make = in.nextLine();
			System.out.print("Enter an type: ");
			String type = in.nextLine();

			ListType toAdd = new ListType(make, type);
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the type to delete: ");
			String type = in.nextLine();

			ListType toDelete = new ListType(make, type);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Type");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListType> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the make name: ");
				String storeName = in.nextLine();
				foundItems = lih.searchForItemByStore(storeName);
			} else {
				System.out.print("Enter the type: ");
				String itemName = in.nextLine();
				foundItems = lih.searchForItemByItem(itemName);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListType l : foundItems) {
					System.out.println(l.getId() + " : " + l.returnTypeDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListType toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getType() + " from " + toEdit.getMake());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Type");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newStore = in.nextLine();
					toEdit.setMake(newStore);
				} else if (update == 2) {
					System.out.print("New Type: ");
					String newItem = in.nextLine();
					toEdit.setType(newItem);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListType> allItems = lih.showAllItems();
			for(ListType singleItem : allItems){
				System.out.println(singleItem.returnTypeDetails());
			}

		}

	}
