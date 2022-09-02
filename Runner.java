import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import lista.GuestsList;
import lista.Guest;


public class Runner implements Serializable {

	private static final long serialVersionUID = 1L;

	static final void afisareMeniu() {
		System.out.println("help - Afiseaza aceasta lista de comenzi");
		System.out.println("add - Adauga o noua persoana (inscriere)");
		System.out.println("check - Verifica daca o persoana este inscrisa la eveniment");
		System.out.println("remove - Sterge o persoana existenta din lista");
		System.out.println("update - Actualizeaza detaliile unei persoane");
		System.out.println("guests - Lista de persoane care participa la eveniment");
		System.out.println("waitlist - Persoanele din lista de asteptare");
		System.out.println("available - Numarul de locuri libere");
		System.out.println("guests_no - Numarul de persoane care participa la eveniment");
		System.out.println("waitlist_no - Numarul de persoane din lista de asteptare");
		System.out.println("subscribe_no - Numarul total de persoane inscrise");
		System.out.println("search - Cauta toti invitatii conform sirului de caractere introdus");
		System.out.println("IO - Cauta toti invitatii in fisierul binar");
		System.out.println("writeBinary - salveaza tot in fisier binar");
		System.out.println("quit - Inchide aplicatia");

	}

	public static void main(String[] args) throws IOException {
		String commandLine;
		Scanner sc = new Scanner(System.in);
		System.out.println("Bun venit, introduceti numarul de locuri disponibile: ");
		int nrOfPart = sc.nextInt();
		GuestsList list = new GuestsList(nrOfPart);
		Guest g1;
		String[] data = new String[4];
		System.out.println("Pentru a afisa comenzile disponibile scrie \"help\" ");
		String helpCommand = sc.next();

		if (helpCommand.equals("help")) {
			afisareMeniu();
			System.out.println();
			System.out.println("Pentru a incepe apasa oricare tasta");
			System.out.println();
			commandLine = sc.next();
			while (!commandLine.equals("quit")) {
				try {

					commandLine = sc.next();
					if (commandLine.equals("help")) {
						afisareMeniu();
					}
					if (commandLine.equals("add")) {
						System.out.println("Enter firstName: ");
						data[0] = sc.next();
						System.out.println("Enter lastname: ");
						data[1] = sc.next();
						System.out.println("Enter email: ");
						data[2] = sc.next();
						System.out.println("Enter phoneNumber: ");
						data[3] = sc.next();
						g1 = new Guest(data[0], data[1], data[2], data[3]);
						list.addParticipants(g1);

					} else if (commandLine.equals("check")) {
						System.out.println();
						System.out.println("Dupa ce criteriu vrei sa faci check-ul?");
						System.out.println();
						System.out.println("1.lastName si firstName");
						System.out.println("2.email");
						System.out.println("3.phoneNumber");
						System.out.println("4.exit");
						int y = sc.nextInt();
						switch (y) {
						case 1: {
							System.out.println("Enter firstName: ");
							data[0] = sc.next();
							System.out.println("Enter lastname: ");
							data[1] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							list.signUpByName(g1);
							break;
						}
						case 2: {
							System.out.println("Enter email: ");
							data[2] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							list.signUpByEmail(g1);
							break;
						}
						case 3: {
							System.out.println("Enter phone number: ");
							data[3] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							list.signUpByPhone(g1);
							break;
						}
						case 4: {
							break;
						}
						}
					} else if (commandLine.equals("remove")) {
						System.out.println();
						System.out.println("Dupa ce criteriu vrei sa stergi persoana?");
						System.out.println();
						System.out.println("1.lastName si firstName");
						System.out.println("2.email");
						System.out.println("3.phoneNumber");
						System.out.println("4.exit");
						int y = sc.nextInt();
						switch (y) {
						case 1: {
							System.out.println("Enter firstName: ");
							data[0] = sc.next();
							System.out.println("Enter lastname: ");
							data[1] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							list.deleteParticipantsByName(g1);
							break;
						}
						case 2: {
							System.out.println("Enter email: ");
							data[2] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							list.deleteParticipantsByEmail(g1);
							break;
						}
						case 3: {
							System.out.println("Enter phone number: ");
							data[3] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							list.deleteParticipantsByPhoneNumber(g1);
							break;
						}
						case 4: {
							break;
						}
						}
					} else if (commandLine.equals("update")) {
						System.out.println();
						System.out.println("Dupa ce criteriu vrei sa faci update ?");
						System.out.println();
						System.out.println("1.lastName si firstName");
						System.out.println("2.email");
						System.out.println("3.phoneNumber");
						int y = sc.nextInt();
						switch (y) {

						case 1: {
							System.out.println("Enter firstName: ");
							data[0] = sc.next();
							System.out.println("Enter lastname: ");
							data[1] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);

							if (list.signUpByName(g1)) {
								System.out.println();
								System.out.println("Ce anume vrei sa actualizezi?");
								System.out.println();
								System.out.println("1.first name");
								System.out.println("2.last name");
								System.out.println("3.email");
								System.out.println("4.phone number");
								System.out.println();
								int z = sc.nextInt();
								switch (z) {
								case 1: {
									System.out.println("Introduceti noul first name: ");
									data[0] = sc.next();
									list.dataUpdateByLastName3(g1, data[0]);
									break;
								}
								case 2: {
									System.out.println("Introduceti noul last name: ");
									data[1] = sc.next();
									list.dataUpdateByFirstName3(g1, data[1]);
									break;
								}
								case 3: {
									System.out.println("Introduceti noul email: ");
									data[2] = sc.next();
									list.dataUpdateByEmail3(g1, data[2]);
									break;
								}
								case 4: {
									System.out.println("Introduceti noul phone number: ");
									data[3] = sc.next();
									list.dataUpdateByPhoneNumber3(g1, data[3]);

									break;
								}
								}
							} else {
								break;
							}
							break;
						}
						case 2: {
							System.out.println("Enter email: ");
							data[2] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							if (list.signUpByEmail(g1)) {
								System.out.println();
								System.out.println("Ce anume vrei sa actualizezi?");
								System.out.println();
								System.out.println("1.first name");
								System.out.println("2.last name");
								System.out.println("3.email");
								System.out.println("4.phone number");
								System.out.println();
								int z = sc.nextInt();
								switch (z) {
								case 1: {
									System.out.println("Introduceti noul first name: ");
									data[0] = sc.next();
									list.dataUpdateByLastName2(g1, data[0]);

									break;
								}
								case 2: {
									System.out.println("Introduceti noul last name: ");
									data[1] = sc.next();
									list.dataUpdateByFirstName2(g1, data[1]);
									break;
								}
								case 3: {
									System.out.println("Introduceti noul email: ");
									data[2] = sc.next();
									System.out.println(data[2]);
									list.dataUpdateByEmail2(g1, data[2]);
									break;
								}
								case 4: {
									System.out.println("Introduceti noul phone number: ");
									data[3] = sc.next();
									list.dataUpdateByPhoneNumber2(g1, data[3]);
									break;
								}
								}
							} else {
								break;
							}
							break;
						}
						case 3: {
							System.out.println("Enter PhoneNumber: ");
							data[3] = sc.next();
							g1 = new Guest(data[0], data[1], data[2], data[3]);
							if (list.signUpByPhone(g1)) {
								System.out.println();
								System.out.println("Ce anume vrei sa actualizezi?");
								System.out.println();
								System.out.println("1.first name");
								System.out.println("2.last name");
								System.out.println("3.email");
								System.out.println("4.phone number");
								System.out.println();
								int z = sc.nextInt();
								switch (z) {
								case 1: {
									System.out.println("Introduceti noul first name: ");
									data[0] = sc.next();
									list.dataUpdateByLastName(g1, data[0]);

									break;
								}
								case 2: {
									System.out.println("Introduceti noul last name: ");
									data[1] = sc.next();
									list.dataUpdateByFirstName(g1, data[1]);
									break;
								}
								case 3: {
									System.out.println("Introduceti noul email: ");
									data[2] = sc.next();
									list.dataUpdateByEmail(g1, data[2]);
									break;
								}
								case 4: {
									System.out.println("Introduceti noul phone number: ");
									data[3] = sc.next();
									list.dataUpdateByPhoneNumber(g1, data[3]);
									break;
								}
								case 5: {
									break;
								}
								}
							} else {
								break;
							}
							break;
						}

						}

					} else if (commandLine.equals("guests")) {
						System.out.println();
						ArrayList<Guest> listP = list.listOfParticipants();
						for (int i = 0; i < listP.size(); i++) {
							System.out.print("P" + (i + 1) + ": " + "[" + listP.get(i).getLastName() + ", "
									+ listP.get(i).getFirstName() + ", " + listP.get(i).getEmail() + ", "
									+ listP.get(i).getPhoneNumber() + "]");
							System.out.println();
						}
					} else if (commandLine.equals("waitlist")) {
						System.out.println();
						ArrayList<Guest> listW = list.listOfWaiting();
						for (int i = 0; i < listW.size(); i++) {
							System.out.print("P" + (i + 1) + ": " + "[" + listW.get(i).getLastName() + ", "
									+ listW.get(i).getFirstName() + ", " + listW.get(i).getEmail() + ", "
									+ listW.get(i).getPhoneNumber() + "]");
							System.out.println();
						}
					} else if (commandLine.equals("available")) {
						int x = list.noOfAvailablePl();
						System.out.println(x);

					} else if (commandLine.equals("guests_no")) {
						int x = list.noOfParticipants();
						System.out.println(x);

					} else if (commandLine.equals("waitlist_no")) {
						int x = list.noOfWait();
						System.out.println(x);

					} else if (commandLine.equals("subscribe_no")) {
						int x = list.noOfAll();
						System.out.println(x);
					} else if (commandLine.equals("search")) {

						System.out.println("introduceti sirul de caractere dorit: ");

						String x = sc.next();
						list.subStringSearchFirst(list, x);
						list.subStringSearchLast(list, x);
						list.subStringSearchEmail(list, x);
						list.subStringSearchPhone(list, x);

					}

					else if (commandLine.equals("IO")) {
						for (int i = 0; i < GuestsList.readFromBinaryFile().size(); i++) {
							g1 = GuestsList.readFromBinaryFile().get(i);
							list.addParticipants(g1);
						}

					} else if (commandLine.equals("writeBinary")) {
						GuestsList.writeToBinaryFile(list.listOfParticipants());
					}

					else if (commandLine.equals("quit") || commandLine.equals("exit")) {
						System.exit(0);
					}

				} catch (EOFException e) {
					System.out.println("End of file reached!");
					break;
				}
			}
		} else {
			System.exit(0);
		}

		sc.close();

	}

}
