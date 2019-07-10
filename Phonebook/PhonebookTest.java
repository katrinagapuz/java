package myphonebook;

import java.util.Scanner;

public class PhonebookTest {

	static Scanner sc;
	static Phonebook pb;
	
	public static void main(String args[]) {
		sc = new Scanner(System.in);

		pb = new Phonebook();
		boolean flag = true;
		int option = 0;

		System.out.println("*************************");
		System.out.println("* Welcome to Phonebook! *");
		System.out.println("*************************");
		printMenu();

		while(flag) {
			System.out.println("Enter command: ");
			option = sc.nextInt();
			sc.nextLine();

			switch(option) {
				case 0:
					flag = false;
					break;
				case 1:
					printMenu();
					break;
				case 2:
					handleAddContact();
					break;
				case 3:
					handleSearchContact();
					break;
				case 4:
					handleUpdateContact();
					break;
				case 5:
					handleDeleteContact();
					break;
				case 6:
					handleListContacts();
					break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("[0] Quit");
		System.out.println("[1] Print Menu");
		System.out.println("[2] Add New Contact");
		System.out.println("[3] Search Contact");
		System.out.println("[4] Update Contact");
		System.out.println("[5] Delete Contact");
		System.out.println("[6] Show All Contacts");
	}

	public static void handleAddContact() {
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter number: ");
		String number = sc.nextLine();

		pb.addContact(name, number);
		System.out.println("Successfully added new contact");
	}

	public static void handleSearchContact() {
		System.out.println("Enter contact's name: ");
		String name = sc.nextLine();

		String number = pb.getContact(name);
		if(number == null)
			System.out.println("Contact " + name + " not found.");
		else
			System.out.println(name + ": " + number);
	}

	public static void handleUpdateContact() {
		System.out.println("Enter contact's name: ");
		String oldName = sc.nextLine();

		System.out.println("Enter contact's new name: ");
		String newName = sc.nextLine();

		System.out.println("Enter contact's new number: ");
		String newNumber = sc.nextLine();

		boolean res = pb.updateContact(oldName, newName, newNumber);
		if(res == true)
			System.out.println("Successfully updated contact");
		else
			System.out.println("Contact " + oldName + " not found.");
	}

	public static void handleDeleteContact() {
		System.out.println("Enter contact's name: ");
		String name = sc.nextLine();

		boolean res = pb.deleteContact(name);
		if(res == true)
			System.out.println("Successfully deleted contact");
		else
			System.out.println("Contact " + name + " not found.");
	}

	public static void handleListContacts(){
		pb.printContacts();
	}
}