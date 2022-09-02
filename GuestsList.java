package lista;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class GuestsList implements Serializable {

	private static final long serialVersionUID = 1L;

	private final int maxNoOfPart; // max number of inv.
	private ArrayList<Guest> listOfGuests;
	private ArrayList<Guest> waitingList = new ArrayList<Guest>();

	public GuestsList(int no) {
		// +waitinglist
		listOfGuests = new ArrayList<Guest>();
		this.maxNoOfPart = no;
	}

//1.ADD
	public int addParticipants(Guest guest) {
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).getFirstName().equals(guest.getFirstName())
					&& this.listOfGuests.get(i).getLastName().equals(guest.getLastName())
					|| this.listOfGuests.get(i).getEmail().equals(guest.getEmail())
					|| this.listOfGuests.get(i).getPhoneNumber().equals(guest.getPhoneNumber())) {
				System.out.println("You re already signed up");
				return -1;
			}
		}

		if (listOfGuests.size() < maxNoOfPart) {
			listOfGuests.addAll(Arrays.asList(guest));
			System.out.println("Congrats, we re waiting for you!");
			return 0;

		}

		waitingList.add(guest);
		System.out.println("You re on the wait list with the number "
				+ waitingList.size() + ". We ll notify you when a spot becomes available.");
		System.out.println();
		return waitingList.size();
	}


//2.CHECK
	public boolean signUpByName(Guest g1) {
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).firstName.equals(g1.firstName)
					&& this.listOfGuests.get(i).lastName.equals(g1.lastName)) {
				System.out.println("You re already signed up");

				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (this.waitingList.get(i).firstName.equals(g1.firstName)
					&& this.waitingList.get(i).lastName.equals(g1.lastName)) {
				System.out.println("You re already signed up");
				return true;
			}
		}
		System.out.println("You re not on the list!");
		return false;

	}

	public boolean signUpByEmail(Guest g1) {
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).email.equals(g1.email)) {
				System.out.println("You re already signed up");
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (this.waitingList.get(i).email.equals(g1.email)) {
				System.out.println("You re already signed up");
				return true;
			}
		}
		System.out.println("You re not on the list!");
		return false;
	}

	public boolean signUpByPhone(Guest g1) {
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).phoneNumber.equals(g1.phoneNumber)) {
				System.out.println("You re already signed up");
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (this.waitingList.get(i).phoneNumber.equals(g1.phoneNumber)) {
				System.out.println("You re already signed up");
				return true;
			}
		}
		System.out.println("You re not on the list!");
		return false;
	}

//3.DELETE_FROM_THE_LIST
	private void MESSAGE() {
		System.out.println();
		System.out.println("The person was succesfully deleted!");
		System.out.println();
	}

	public boolean deleteParticipantsByName(Guest g1) throws IndexOutOfBoundsException {
		int counter = 0;
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).firstName.equals(g1.firstName)
					&& this.listOfGuests.get(i).lastName.equals(g1.lastName)) {
				listOfGuests.remove(i);
				counter++;
				if (counter >= 1 && waitingList.size() > 0) {
					listOfGuests.add(i, waitingList.get(0));
					waitingList.remove(0);
					System.out.println("The person was succesfully deleted!");
					System.out.println("A new person has been added on the list!");
					return true;
				}
				MESSAGE();
				return true;

			}

		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (this.waitingList.get(i).firstName.equals(g1.firstName)
					&& this.waitingList.get(i).lastName.equals(g1.lastName)) {
				waitingList.remove(i);

				MESSAGE();
				return true;
			}
		}

		System.out.println("The person is not on the list!");
		return false;
	}

	public boolean deleteParticipantsByEmail(Guest g1) throws IndexOutOfBoundsException {
		int counter = 0;
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).email.equals(g1.email)) {
				listOfGuests.remove(i);
				counter++;
				if (counter >= 1 && waitingList.size() > 0) {
					listOfGuests.add(i, waitingList.get(0));
					waitingList.remove(0);
					System.out.println("The person was succesfully removed!");
					System.out.println("A new person had been added on the list!");

				}
				MESSAGE();
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (this.waitingList.get(i).email.equals(g1.email)) {
				waitingList.remove(i);
				MESSAGE();
				return true;
			}
		}
		System.out.println("The person is not signed up!");
		return false;
	}

	public boolean deleteParticipantsByPhoneNumber(Guest g1) throws IndexOutOfBoundsException {
		int counter = 0;
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).phoneNumber.equals(g1.phoneNumber)) {
				listOfGuests.remove(i);
				counter++;
				if (counter >= 1 && waitingList.size() > 0) {
					listOfGuests.add(i, waitingList.get(0));
					waitingList.remove(0);
					System.out.println("The person was succesfully removed!");
					System.out.println("A new person has been added on the list!");

				}
				MESSAGE();
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (this.waitingList.get(i).phoneNumber.equals(g1.phoneNumber)) {
				waitingList.remove(i);
				MESSAGE();
				return true;
			}
		}
		System.out.println("The person is not signed up!");
		return false;
	}

//4.DATA_UPDATE

	//// FOR_CASE_1
	public boolean dataUpdateByEmail3(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).firstName.contains(g1.firstName)) {
				this.listOfGuests.get(i).email = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByLastName3(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).firstName.contains(g1.firstName)) {
				this.listOfGuests.get(i).lastName = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByFirstName3(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).firstName.contains(g1.firstName)) {
				this.listOfGuests.get(i).firstName = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByPhoneNumber3(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).firstName.contains(g1.firstName)) {
				this.listOfGuests.get(i).phoneNumber = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	//// FOR_CASE_2
	public boolean dataUpdateByEmail2(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).email.contains(g1.email)) {
				this.listOfGuests.get(i).email = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByLastName2(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).email.contains(g1.email)) {
				this.listOfGuests.get(i).lastName = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByFirstName2(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).email.contains(g1.email)) {
				this.listOfGuests.get(i).firstName = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByPhoneNumber2(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).email.contains(g1.email)) {
				this.listOfGuests.get(i).phoneNumber = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	//// FOR_CASE_3
	public boolean dataUpdateByEmail(Guest g1, String g2) {

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).phoneNumber.contains(g1.phoneNumber)) {
				this.listOfGuests.get(i).email = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByLastName(Guest g1, String g2) throws NoSuchElementException {
		if (g2 == null) {
			throw new NoSuchElementException("There is no such element");
		}
		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).phoneNumber.contains(g1.phoneNumber)) {
				this.listOfGuests.get(i).lastName = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByFirstName(Guest g1, String g2) throws NoSuchElementException {
		if (g2 == null) {
			throw new NoSuchElementException("There is no such element");
		}

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).phoneNumber.contains(g1.phoneNumber)) {
				this.listOfGuests.get(i).firstName = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}

	public boolean dataUpdateByPhoneNumber(Guest g1, String g2) throws NoSuchElementException {
		if (g2 == null) {
			throw new NoSuchElementException("There is no such element");
		}

		for (int i = 0; i < listOfGuests.size(); i++) {
			if (this.listOfGuests.get(i).phoneNumber.contains(g1.phoneNumber)) {
				this.listOfGuests.get(i).phoneNumber = g2;
				System.out.println();
				System.out.println("Success!");
				System.out.println();
				return true;
			}
		}

		return false;
	}
//5 && 6.GET_LISTS

	///////
	/////// EXCEPTION
	///////
	public ArrayList<Guest> listOfParticipants() {

		if (listOfGuests == null) {
			throw new ArithmeticException("The list cannot be empty");
		}
		return listOfGuests;
	}

	public ArrayList<Guest> listOfWaiting() {
		return waitingList;
	}
//7 && 8 && 9 && 10.OBTAINS

	public int noOfAvailablePl() {
		int x = this.maxNoOfPart - this.listOfGuests.size();

		return x;
	}

	///////
	/////// EXCEPTION
	///////
	public int noOfParticipants() {
		if (listOfGuests.size() == 0) {
			throw new ArithmeticException("Can t exist 0 part ");
		}
		return listOfGuests.size();
	}

	public int noOfWait() {
		return waitingList.size();
	}

	public int noOfAll() {
		return this.listOfGuests.size() + this.waitingList.size();
	}

//11.SEARCH
	// primeste ca parametru un sir de caractere
	public void subStringSearchEmail(GuestsList x2, String x) {
		for (int i = 0; i < x2.listOfGuests.size(); i++) {
			if (x2.listOfGuests.get(i).email.contains(x)) {
				System.out.println(x2.listOfGuests.get(i).email);
				break;
			}
		}
	}

	public void subStringSearchFirst(GuestsList x2, String x) {
		for (int i = 0; i < x2.listOfGuests.size(); i++) {
			for (int j = 0; j < x2.listOfGuests.get(i).firstName.length(); j++) {
				if (x2.listOfGuests.get(i).firstName.contains(x)) {
					System.out.println(x2.listOfGuests.get(i).firstName);
					break;
				}
			}
		}
	}

	public void subStringSearchLast(GuestsList x2, String x) {
		for (int i = 0; i < x2.listOfGuests.size(); i++) {
			for (int j = 0; j < x2.listOfGuests.get(i).lastName.length(); j++) {
				if (x2.listOfGuests.get(i).lastName.contains(x)) {
					System.out.println(x2.listOfGuests.get(i).lastName);
					break;
				}
			}
		}
	}

	public void subStringSearchPhone(GuestsList x2, String x) {
		for (int i = 0; i < x2.listOfGuests.size(); i++) {
			for (int j = 0; j < x2.listOfGuests.get(i).phoneNumber.length(); j++) {
				if (x2.listOfGuests.get(i).phoneNumber.contains(x)) {
					System.out.println(x2.listOfGuests.get(i).phoneNumber);
					break;
				}
			}
		}
	}

	/// write
	public static void writeToBinaryFile(List<Guest> data) throws IOException {
		try (ObjectOutputStream binaryFileOut = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("person.dat")))) {
			for (Guest person : data) {
				binaryFileOut.writeObject(person);
			}
		}
	}

	// read
	public static List<Guest> readFromBinaryFile() throws IOException {
		List<Guest> data = new ArrayList<>();

		try (ObjectInputStream binaryFileIn = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("person.dat")))) {
			while (true) {
				try {
					Guest person = (Guest) binaryFileIn.readObject();
					System.out.println(person);
					data.add(person);
				} catch (EOFException e) {
					System.out.println("End of file reached!");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("A class not found exception: " + e.getMessage());
		}

		return data;
	}

}
