package myphonebook;

import java.util.LinkedList;
import java.util.ListIterator;

public class Phonebook {
	
	private LinkedList<Contact> contacts;

	public Phonebook() {
		this.contacts = new LinkedList<Contact>();
	}

	public LinkedList<Contact> getContacts() {
		return this.contacts;
	}

	public void addContact(String name, String number) {
		Contact newContact = new Contact(name, number);
		contacts.add(newContact);
	}

	public String getContact(String name) {
		ListIterator<Contact> li = contacts.listIterator();
		while(li.hasNext()) {
			Contact curr = li.next();
			if(curr.getName().equals(name)) {
				return curr.getNumber();
			}
		}

		return null;
	}

	public boolean updateContact(String oldName, String newName, String newNumber) {
		ListIterator<Contact> li = contacts.listIterator();
		while(li.hasNext()) {
			Contact curr = li.next();
			if(curr.getName().equals(oldName)) {
				curr.setName(newName);
				curr.setNumber(newNumber);
				return true;
			}
		}

		return false;
	}

	public boolean deleteContact(String name) {
		ListIterator<Contact> li = contacts.listIterator();
		while(li.hasNext()) {
			if(li.next().getName().equals(name)) {
				li.remove();
				return true;
			}
		}

		return false;
	}

	public void printContacts() {
		ListIterator<Contact> li = contacts.listIterator();
		while(li.hasNext()) {
			Contact curr = li.next();
			System.out.println(curr.getName() + ": " + curr.getNumber());
		}
	}

}