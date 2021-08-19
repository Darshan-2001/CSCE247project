import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 * central method of the class. holds all instances of the lists and scanner;
 */
public class SystemUI {
	CriminalList criminals = CriminalList.getInstance();
	VictimList victims = VictimList.getInstance();
	WitnessList witnesses = WitnessList.getInstance();
	SuspectList suspects = SuspectList.getInstance();
	UsersList users = UsersList.getInstance();
	EvidenceList evidences = EvidenceList.getInstance();
	CaseList crimes = CaseList.getInstance();
	//scanner at the beginning to avoid duplicates
	Scanner input = new Scanner(System.in);

	/**
	 * takes a username and password in as input and checks to see if they can log in
	 */
	public void login() {
		System.out.println("Welcome! Please enter your username and password to login.");
		while (true) {
		String username = input.nextLine();
		String password = input.nextLine();
		for (User u : users.getUsers()) {
			if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
				System.out.println("Welcome to the Criminal Database " + u.getFirstName() + " " + u.getLastName());
				return;
			}
		}
		System.out.println("Login information is invalid! Please try again.");
		}
	}

	/**
	 * method that takes in the users input and calls different methods based on the input
	 */
	public void run() {
		System.out.println("<<<<<Please Select an Option Below>>>>>\n");
		System.out.println("1.  List of all Persons, Cases, and Evidence");
		System.out.println("2.  Adding a Person, Case, or Evidence");
		System.out.println("3.  Removing a Person");
		System.out.println("4.  Search");
		System.out.println("5.  Log Out");
		System.out.println("\nWe encourage you to log out after each session!");
		System.out.println("What would you like to do?: ");
		int mainChoice = 0;
		do {
			mainChoice = input.nextInt();
			if (mainChoice > 5 || mainChoice < 1)
				System.out.println("This is not one of the options.  Please type a number from 1 to 4");
			
		} while (mainChoice < 1 || mainChoice > 5);
		switch (mainChoice) {
			case 1:
				list();
				break;
			case 2:
				add();
				break;
			case 3:
				remove();
				break;
			case 4:
				search();
				break;
			case 5:
				break;
			default:
				break;
		}
	}

	/**
	 * lists the name and id of all people in the system. lists the location and date of the cases.
	 */
	public void list() {
		System.out.println("Listing all Criminals");
		ArrayList<Criminal> criminalList = criminals.getCriminals();
		for(Criminal criminal : criminalList)
			System.out.println(criminal.getFirstName() + " " + criminal.getLastName() + " : " + criminal.getID());
		
		System.out.println("\nListing all Victims");
		ArrayList<Victim> victimList = victims.getVictims();
		for(Victim victim : victimList)
			System.out.println(victim.getFirstName() + " " + victim.getLastName() + " : " + victim.getID());
		
		System.out.println("\nListing all Witnesses");
		ArrayList<Witness> witnessList = witnesses.getWitnesses();
		for(Witness witness : witnessList)
			System.out.println(witness.getFirstName() + " " + witness.getLastName() + " : " + witness.getID());
		
		System.out.println("\nListing all Suspects");
		ArrayList<Suspect> suspectList = suspects.getSuspects();
		for(Suspect suspect : suspectList)
			System.out.println(suspect.getFirstName() + " " + suspect.getLastName() + " : " + suspect.getID());
		
		System.out.println("\nListing all Users");
		ArrayList<User> userList = users.getUsers();
		for(User user : userList)
			System.out.println(user.getFirstName() + " " + user.getLastName() + " : " + user.getUserID());
		
		System.out.println("\nListing all Evidence");
		ArrayList<Evidence> evidenceList = evidences.getEvidence();
		for(Evidence evidence : evidenceList)
			System.out.println(evidence.getLocation() + " " + evidence.getDate() + " : " + evidence.getID());

		System.out.println("\nListing all Cases");
		ArrayList<Case> caseList = crimes.getCases();
		for(Case crime : caseList)
			System.out.println(crime.getLocation() + " " + crime.getCity() + " : " + crime.getID());
		
		System.out.println("\nWhen you are finished, type finished");
		while (!input.nextLine().equalsIgnoreCase("finished")) {
			System.out.println("Please type \"finished\" if you're finished");
		}
		System.out.println("Okay, returning you to Main Menu");
		run();
	}

	/**
	 * calls different add method based on the entered input
	 */
	public void add() {
		System.out.println("\nThis is where you can add a person, a case, or evidence");
		System.out.println("\nAre they a criminal, victim, witness, suspect, user, evidence, or case?");
		String type = null;
		do {
			type = input.nextLine();
			if (!(type.equalsIgnoreCase("criminal") || type.equalsIgnoreCase("victim") || type.equalsIgnoreCase("witness") || type.equalsIgnoreCase("suspect") || type.equalsIgnoreCase("case") || type.equalsIgnoreCase("user") || type.equalsIgnoreCase("evidence")))
				System.out.println("Please enter whether this is a criminal, victim, witness, suspect, user, evidence, or case.");
		} while (!(type.equalsIgnoreCase("criminal") || type.equalsIgnoreCase("victim") || type.equalsIgnoreCase("witness") || type.equalsIgnoreCase("suspect") || type.equalsIgnoreCase("case") || type.equalsIgnoreCase("user") || type.equalsIgnoreCase("evidence")));
		switch (type.toLowerCase()) {
			case "criminal":
				addCriminal();
				break;
			case "victim":
				addVictim();
				break;
			case "witness":
				addWitness();
				break;
			case "suspect":
				addSuspect();
				break;
			case "user":
				addUser();
				break;
			case "evidence":
				addEvidence();
				break;
			case "case":
				addCase();
				break;
			default:
				break;
		}
	}

	/**
	 * adds criminal to the criminalList of the system
	 */
	public void addCriminal() {
		System.out.println("What is the criminal's last name?");
		String lastName = input.nextLine();
		System.out.println("What is the criminal's first name?");
		String firstName = input.nextLine();
		System.out.println("What is their gender? (Please enter m, f, or o)");
		String gender = null;
		do {
			gender = input.nextLine();
			if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")))
				System.out.println("This input is incorrect.  Please enter either m, f, or o");
		} while (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")));
		System.out.println("How old are they?");
		int age = 0;
		do {
			age = input.nextInt();
			if(age < 8 || age > 100)
				System.out.println("This input isn't correct. Please enter a valid number.");
		} while (age < 8 || age > 100);
		System.out.println("What is their occupation?");
		input.nextLine();
		String occupation = input.nextLine();
		System.out.println("What is the criminal's height?");
		String height = input.nextLine();
		System.out.println("What is the criminal's weight?");
		String weight = input.nextLine();
		System.out.println("What is the criminal's hair color?");
		String hairColor = input.nextLine();
		System.out.println("What is the criminal's eye color?");
		String eyeColor = input.nextLine();
		System.out.println("Does the criminal have any tattoos? If so please specify the tattoo. If not, write \"no tattoo\".");
		String tattoos = input.nextLine();
		System.out.println("What is their valid phone number? (Please enter it all in one number without symbols)");
		String phoneNumber = null;
		while (true) {
			phoneNumber = input.next();
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher phone = pattern.matcher(phoneNumber);
			if(phone.matches())
				break;
			System.out.println("This is not a valid entry. Please enter 10 numbers");
		}
		System.out.println("Would you please describe them for our records?");
		input.nextLine();
		String description = input.nextLine();
		System.out.println("Are they alive? (please enter true or false)");
		boolean isAlive = input.nextBoolean();
		System.out.println("Are they currently in jail? (please enter true or false)");
		boolean inJail = input.nextBoolean();
		System.out.println("How many crimes have they committed?");
		int numCrimes = input.nextInt();
		Criminal criminal = new Criminal(firstName, lastName, age, occupation, gender, phoneNumber, description, 
		isAlive, inJail, numCrimes, height, weight, hairColor, eyeColor, tattoos);
		criminals.addCriminal(criminal);
		System.out.println("\nSuccessfully added the criminal. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * adds victim to the victimList of the system
	 */
	public void addVictim() {
		System.out.println("What is the victims's last name?");
		String lastName = input.nextLine();
		System.out.println("What is the victims's first name?");
		String firstName = input.nextLine();
		System.out.println("What is their gender? (Please enter m, f, or o)");
		String gender = null;
		do {
			gender = input.nextLine();
			if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")))
				System.out.println("This input is incorrect.  Please enter either m, f, or o");
		} while (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")));
		System.out.println("How old are they?");
		int age = 0;
		do {
			age = input.nextInt();
			if(age < 8 || age > 100)
				System.out.println("This input isn't correct. Please enter a valid number.");
		} while (age < 8 || age > 100);
		System.out.println("What is their occupation?");
		input.nextLine();
		String occupation = input.nextLine();
		System.out.println("What is their valid phone number? (Please enter it all in one number without symbols)");
		String phoneNumber = null;
		while (true) {
			phoneNumber = input.next();
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher phone = pattern.matcher(phoneNumber);
			if(phone.matches())
				break;
			System.out.println("This is not a valid entry. Please enter 10 numbers");
		}
		System.out.println("Would you please describe them for our records?");
		input.nextLine();
		String description = input.nextLine();
		System.out.println("Are they still alive? (please enter true or false)");
		boolean alive = input.nextBoolean();
		Victim victim = new Victim(firstName, lastName, age, gender, occupation, phoneNumber, description, alive);
		victims.addVictim(victim);
		System.out.println("\nSuccessfully added the victim. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * adds witness to the witnessList of the system
	 */
	public void addWitness() {
		System.out.println("What is the witness's last name?");
		String lastName = input.nextLine();
		System.out.println("What is the witness's first name?");
		String firstName = input.nextLine();
		System.out.println("What is their gender? (Please enter m, f, or o)");
		String gender = null;
		do {
			gender = input.nextLine();
			if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")))
				System.out.println("This input is incorrect.  Please enter either m, f, or o");
		} while (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")));
		System.out.println("How old are they?");
		int age = 0;
		do {
			age = input.nextInt();
			if(age < 8 || age > 100)
				System.out.println("This input isn't correct. Please enter a valid number.");
		} while (age < 8 || age > 100);
		System.out.println("What is their occupation?");
		input.nextLine();
		String occupation = input.nextLine();
		System.out.println("What is their valid phone number? (Please enter it all in one number without symbols)");
		String phoneNumber = null;
		while (true) {
			phoneNumber = input.next();
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher phone = pattern.matcher(phoneNumber);
			if(phone.matches())
				break;
			System.out.println("This is not a valid entry. Please enter 10 numbers");
		}
		System.out.println("What is their address?");
		input.nextLine();
		String address = input.nextLine();
		System.out.println("What is the story they can provide?");
		String story = input.nextLine();
		Witness witness = new Witness(firstName, lastName, age, gender, occupation, phoneNumber, address, story);
		witnesses.addWitness(witness);
		System.out.println("\nSuccessfully added the witness. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * adds suspect to the suspectList of the system
	 */
	public void addSuspect() {
		System.out.println("What is the suspect's last name?");
		String lastName = input.nextLine();
		System.out.println("What is the suspect's first name?");
		String firstName = input.nextLine();
		System.out.println("What is their gender? (Please enter m, f, or o)");
		String gender = null;
		do {
			gender = input.nextLine();
			if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")))
				System.out.println("This input is incorrect. Please enter either m, f, or o");
		} while (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("o")));
		System.out.println("How old are they?");
		int age = 0;
		do {
			age = input.nextInt();
			if(age < 8 || age > 100)
				System.out.println("This input isn't correct. Please enter a valid number.");
		} while (age < 8 || age > 100);
		System.out.println("What is their occupation?");
		input.nextLine();
		String occupation = input.nextLine();
		System.out.println("What is the suspect's height?");
		String height = input.nextLine();
		System.out.println("What is the suspect's weight?");
		String weight = input.nextLine();
		System.out.println("What is the suspect's hair color?");
		String hairColor = input.nextLine();
		System.out.println("What is the suspect's eye color?");
		String eyeColor = input.nextLine();
		System.out.println("Does the suspect have any tattoos? If so please specify the tattoo. If not, write \"no tattoo\".");
		String tattoos = input.nextLine();
		System.out.println("What is their valid phone number? (Please enter it all in one number without symbols)");
		String phoneNumber = null;
		while (true) {
			phoneNumber = input.next();
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher phone = pattern.matcher(phoneNumber);
			if(phone.matches())
				break;
			System.out.println("This is not a valid entry. Please enter 10 numbers");
		}
		System.out.println("Would you please describe them for our records?");
		input.nextLine();
		String description = input.nextLine();
		System.out.println("Are they still alive? (please enter true or false)");
		boolean alive = input.nextBoolean();
		System.out.println("How many crimes have they committed already?");
		int numOfCrimes = input.nextInt();
		if (numOfCrimes < 0)
			numOfCrimes = 0; 
		Suspect suspect = new Suspect(firstName, lastName, age, occupation, gender, phoneNumber, description, 
		alive, numOfCrimes, height, weight, hairColor, eyeColor, tattoos);
		suspects.addSuspect(suspect);
		System.out.println("\nSuccessfully added the suspect. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * adds user to the userList of the system
	 */
	public void addUser() {
		System.out.println("What is the user's last name?");
		String lastName = input.nextLine();
		System.out.println("What is the user's first name?");
		String firstName = input.nextLine();
		System.out.println("What is the user's username?");
		String userName = input.nextLine();
		System.out.println("What is the user's password?");
		String password = input.nextLine();
		System.out.println("What is their valid phone number? (Please enter it all in one number without symbols)");
		String phoneNumber = null;
		while (true) {
			phoneNumber = input.next();
			String regex = "\\d{10}";
			Pattern pattern = Pattern.compile(regex);
			Matcher phone = pattern.matcher(phoneNumber);
			if(phone.matches())
				break;
			System.out.println("This is not a valid entry. Please enter 10 numbers");
		}
		System.out.println("Is this user an admin? (please enter true or false)");
		boolean isAdmin = input.nextBoolean();
		User user = new User(firstName, lastName, userName, password, phoneNumber, isAdmin);
		users.addUser(user);
		System.out.println("\nSuccessfully added the user. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * adds evidence to the evidenceList of the system
	 */
	public void addEvidence() {
		System.out.println("What is the location of this evidence?");
		String location = input.nextLine();
		System.out.println("What type of evidence is this?");
		String type = input.nextLine();
		System.out.println("What date did this happen? Please include day, month, and year.");
		String date = input.nextLine();
		System.out.println("What time of day did this happen?");
		String time = input.nextLine();
		
		Evidence evidence = new Evidence(location, type, date, time);
		evidences.addEvidence(evidence);
		System.out.println("\nSuccessfully added evidence. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * adds case to the caseList of the system
	 */
	public void addCase() {
		System.out.println("\nWho is entering this case?");
		String authorName = input.nextLine();
		System.out.println("What location did this case take place?");
		String location = input.nextLine();
		System.out.println("What city did this case take place in?");
		String city = input.nextLine();
		System.out.println("What zipcode did this case take place in?");
		int zipCode = input.nextInt();
		System.out.println("What type of case is this? (murder/theft/ect.)");
		input.nextLine();
		String typeOfCase = input.nextLine();
		System.out.println("Was a weapon used? If so, specify what type of weapon. If not, type \"no weapon\"");
		String weapon = input.nextLine();
		System.out.println("Describe the story of this case.");
		String story = input.nextLine();

		ArrayList<Criminal> casecriminals = new ArrayList<>();
		System.out.println("Listing all Criminals");
		ArrayList<Criminal> criminalList = criminals.getCriminals();
		for(Criminal criminal : criminalList)
			System.out.println(criminal.getFirstName() + " " + criminal.getLastName() + " : " + criminal.getID());
		while (true) {
			System.out.println("Would you like to add a criminal to the case? (true/false)");
			if (input.nextBoolean() == false) {
				break;
			}
			System.out.println("Please enter an ID from the displayed list.");
			int criminalID = input.nextInt();
			casecriminals.add(criminals.getCriminal(criminalID));
		}

		ArrayList<Victim> casevictims = new ArrayList<>();
		System.out.println("\nListing all Victims");
		ArrayList<Victim> victimList = victims.getVictims();
		for(Victim victim : victimList)
			System.out.println(victim.getFirstName() + " " + victim.getLastName() + " : " + victim.getID());
		while (true) {
			System.out.println("Would you like to add a victim to the case? (true/false)");
			if (input.nextBoolean() == false) {
				break;
			}
			System.out.println("Please enter an ID from the displayed list.");
			int victimID = input.nextInt();
			casevictims.add(victims.getVictim(victimID));
		}

		ArrayList<Witness> casewitnesses = new ArrayList<>();
		System.out.println("\nListing all Witnesses");
		ArrayList<Witness> witnessList = witnesses.getWitnesses();
		for(Witness witness : witnessList)
			System.out.println(witness.getFirstName() + " " + witness.getLastName() + " : " + witness.getID());
		while (true) {
			System.out.println("Would you like to add a witness to the case? (true/false)");
			if (input.nextBoolean() == false) {
				break;
			}
			System.out.println("Please enter an ID from the displayed list.");
			int witnessID = input.nextInt();
			casewitnesses.add(witnesses.getWitness(witnessID));
		}

		ArrayList<Suspect> casesuspects = new ArrayList<>();
		System.out.println("\nListing all Suspects");
		ArrayList<Suspect> suspectList = suspects.getSuspects();
		for(Suspect suspect : suspectList)
			System.out.println(suspect.getFirstName() + " " + suspect.getLastName() + " : " + suspect.getID());
		while (true) {
			System.out.println("Would you like to add a suspect to the case? (true/false)");
			if (input.nextBoolean() == false) {
				break;
			}
			System.out.println("Please enter an ID from the displayed list.");
			int suspectID = input.nextInt();
			casesuspects.add(suspects.getSuspect(suspectID));
		}

		ArrayList<User> caseusers = new ArrayList<>();
		System.out.println("\nListing all Users");
		ArrayList<User> userList = users.getUsers();
		for(User user : userList)
			System.out.println(user.getFirstName() + " " + user.getLastName() + " : " + user.getUserID());
		while (true) {
			System.out.println("Would you like to add a user to the case? (true/false)");
			if (input.nextBoolean() == false) {
				break;
			}
			System.out.println("Please enter an ID from the displayed list.");
			int userID = input.nextInt();
			caseusers.add(users.getUser(userID));
		}

		ArrayList<Evidence> caseevidence = new ArrayList<>();
		System.out.println("\nListing all Evidence");
		ArrayList<Evidence> evidenceList = evidences.getEvidence();
		for(Evidence evidence : evidenceList)
			System.out.println(evidence.getLocation() + " " + evidence.getDate() + " : " + evidence.getID());
		while (true) {
			System.out.println("Would you like to add evidence to the case? (true/false)");
			if (input.nextBoolean() == false) {
				break;
			}
			System.out.println("Please enter an ID from the displayed list.");
			int evidenceID = input.nextInt();
			caseevidence.add(evidences.getEvidence(evidenceID));
		}

		Case crime = new Case(authorName, location, city, zipCode, typeOfCase,
		weapon, story, casecriminals, casevictims, casewitnesses, casesuspects, caseusers, caseevidence);
		crimes.addCase(crime);
		System.out.println("\nSuccessfully added the case. Sending you back to starting menu.\n");
		run();
	}

	/**
	 * remove a person from their respective list
	 */
	public void remove() {
		System.out.println("\nThis is where you can delete someone from the database.");
		System.out.println("\nIs the person a criminal, victim, witness, or suspect?");
		String type = null;
		do {
			type = input.nextLine();
			if (!(type.equalsIgnoreCase("criminal") || type.equalsIgnoreCase("victim") || type.equalsIgnoreCase("witness") || type.equalsIgnoreCase("suspect")))
				System.out.println("Please enter whether this person is a criminal, victim, witness, or suspect.");
		} while (!(type.equalsIgnoreCase("criminal") || type.equalsIgnoreCase("victim") || type.equalsIgnoreCase("witness") || type.equalsIgnoreCase("suspect")));
		int remove;
		switch (type.toLowerCase()) {
			case "criminal":
				System.out.println("Please enter the Criminal's ID:");
				remove = input.nextInt();
				criminals.removeCriminal(remove);
				System.out.println("Thank you. If this ID is attached to a criminal, then they have been removed.\nReturning you to main menu.");
				run();
				break;
			case "victim":
				System.out.println("Please enter the Victim's ID");
				remove = input.nextInt();
				victims.removeVictim(remove);
				System.out.println("Thank you. If this ID is attached to a victim, then they have been removed.\nReturning you to main menu.");
				run();
				break;
			case "witness":
				System.out.println("Please enter the Witness's ID");
				remove = input.nextInt();
				witnesses.removeWitness(remove);
				System.out.println("Thank you. If this ID is attached to a witness, then they have been removed.\nReturning you to main menu.");
				run();
				break;
			case "suspect":
				System.out.println("Please enter the Suspect's ID");				
				remove = input.nextInt();
				suspects.removeSuspect(remove);
				System.out.println("Thank you. If this ID is attached to a suspect, then they have been removed.\nReturning you to main menu.");
				run();
				break;
			default:
				break;
		}
	}

	/**
	 * lets the user search for a person based on a certain parameter or for a case based on the case id
	 */
	public void search() {
		String type = null;
		System.out.println("Would you like to search for persons or for cases?");
		do {
			type = input.nextLine();
			if (!(type.equalsIgnoreCase("person") || type.equalsIgnoreCase("case")))
				System.out.println("Please enter \"person\" or \"case\"");
		} while (!(type.equalsIgnoreCase("person") || type.equalsIgnoreCase("case")));
		switch (type.toLowerCase()) {
			case "person":
			System.out.println("What parameter would you like to search?");
			String param = input.nextLine();
			System.out.println("What " + param + " would you like to search?");
			String search = input.nextLine();
			ArrayList<Criminal> findCrims = criminals.searchCriminalList(param, search);
			FileWriter f = null;
			String output = "";
			for(Criminal crim : findCrims) {
			output = output + crim.toString() + "\n\n";
			System.out.println(crim.toString());
			}				
			try {
				f = new FileWriter("crimeOutput.txt");
				f.write(output);
			}
			catch(IOException e)
			{
				System.out.println("an error has occurred");
			}
			try {
				if (f != null) {
					f.close();
				}
			}
			catch(IOException e) {}
			run();
			break;

			case "case":
			System.out.println("Please enter the Case ID");
			int id = input.nextInt();
			Case ca = crimes.searchCases(id);
			FileWriter f2 = null;
			try {
				f2 = new FileWriter("caseOutput.txt");
				f2.write(ca.toString());
			}
			catch(IOException e)
			{
				System.out.println("an error has occurred");
			}
			try {
				if (f2 != null) {
					f2.close();
				}
			}
			catch(IOException e) {}
			System.out.println(ca.toString());
			run();
			break;

			default:
			break;
		}
	}

	/**
	 * logs the user out of the system
	 */
	public void logOut() {
		System.out.println("Are you sure you're done with your session?");
		while (true) {
			String logOut = input.nextLine();
			if (logOut.equalsIgnoreCase("yes")) {
				System.out.println("\nThank you. Have a nice day.");
				break;
			}
			else if(logOut.equalsIgnoreCase("no")) {
				System.out.println("Okay, returning you to main menu\n4");
				run();
			}
			System.out.println("Please enter yes or no");
		}
	}

	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]) {
		SystemUI uI = new SystemUI();
		uI.login();
		uI.run();
		uI.logOut();
	}
}
