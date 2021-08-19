import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants {
	    private static CriminalList criminalsList = CriminalList.getInstance();
        private static VictimList victimsList = VictimList.getInstance();
        private static WitnessList witnessesList = WitnessList.getInstance();
        private static SuspectList suspectsList = SuspectList.getInstance();
        private static UsersList usersList = UsersList.getInstance();
        private static EvidenceList evidenceList = EvidenceList.getInstance();

		/**
		 * gets the users from the json file and parses each element to return a list
		 */
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
		
		try {
			FileReader reader = new FileReader(USERS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i);
				String firstName = (String)userJSON.get(FIRST_NAME);
				String lastName = (String)userJSON.get(LAST_NAME);
				String userName = (String)userJSON.get(USER_NAME);
                String password = (String)userJSON.get(PASSWORD);
                int id = ((Long) userJSON.get(ID)).intValue();
                String phoneNum = (String)userJSON.get(PHONE_NUM);
                boolean isAdmin = (Boolean)userJSON.get(IS_ADMIN);
				
				users.add(new User(firstName, lastName, userName, password, id, phoneNum, isAdmin));
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

		/**
		 * gets the cases from the json file and parses each element to return a list
		 */
    public static ArrayList<Case> getCases() {
        ArrayList<Case> cases = new ArrayList<Case>();
        
		try {
			FileReader reader = new FileReader(CASES_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray casesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < casesJSON.size(); i++) {
				JSONObject caseJSON = (JSONObject)casesJSON.get(i);
				String authorUserName = (String)caseJSON.get(AUTHOR);
				int id = ((Long) caseJSON.get(ID)).intValue();
				String location = (String)caseJSON.get(LOCATION);
				String city = (String)caseJSON.get(CITY);
                int zipCode = ((Long) caseJSON.get(ZIP_CODE)).intValue();
                String typeOfCase = (String)caseJSON.get(TYPE_OF_CASE);
                String weapon = (String)caseJSON.get(WEAPON);
				String story = (String)caseJSON.get(STORY);
				ArrayList<Criminal> criminals = new ArrayList<Criminal>();
				ArrayList<Victim> victims = new ArrayList<Victim>();
				ArrayList<Suspect> suspects = new ArrayList<Suspect>();
				ArrayList<Witness> witnesses = new ArrayList<Witness>();
				ArrayList<Evidence> evidence = new ArrayList<Evidence>();
				ArrayList<User> assignedUser = new ArrayList<User>(); 
				getCaseArrays(caseJSON, criminals, victims, suspects, witnesses, evidence, assignedUser);

				
				cases.add(new Case(authorUserName, id, location, city, zipCode, typeOfCase, weapon, story,
				criminals, victims, witnesses, suspects, assignedUser, evidence));
			}
			
			return cases;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

		/**
		 * gets the criminals from the json file and parses each element to add to a list
		 */
    public static ArrayList<Criminal> getCriminals() {
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();
		
		try {
			FileReader reader = new FileReader(CRIMINALS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray criminalsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < criminalsJSON.size(); i++) {
				JSONObject criminalJSON = (JSONObject)criminalsJSON.get(i);
				String firstName = (String)criminalJSON.get(FIRST_NAME);
				String lastName = (String)criminalJSON.get(LAST_NAME);
                int id = ((Long) criminalJSON.get(ID)).intValue();
                int age = ((Long) criminalJSON.get(AGE)).intValue();
                String gender = (String)criminalJSON.get(GENDER);
                String occupation = (String)criminalJSON.get(OCCUPATION);
                String phoneNum = (String)criminalJSON.get(PHONE_NUM);
                String desc = (String)criminalJSON.get(DESC);
                boolean isAlive = (Boolean)criminalJSON.get(IS_ALIVE);
                boolean inJail = (Boolean)criminalJSON.get(IN_JAIL);
                int numCrimes = ((Long) criminalJSON.get(NUM_CRIMES)).intValue();
				String height = (String)criminalJSON.get(HEIGHT);
				String weight = (String)criminalJSON.get(WEIGHT);
				String hairColor = (String)criminalJSON.get(HAIR_COLOR);
				String eyeColor = (String)criminalJSON.get(EYE_COLOR);
				String tattoos = (String)criminalJSON.get(TATTOOS);
				
				criminals.add(new Criminal(firstName, lastName, id, age, gender, occupation, phoneNum, desc, isAlive, inJail, numCrimes, 
											height, weight, hairColor, eyeColor, tattoos));
			}
			
			return criminals;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

		/**
		 * gets the victims from the json file and parses each element to add to a list
		 */
    public static ArrayList<Victim> getVictims() {
        ArrayList<Victim> victims = new ArrayList<Victim>();
        
		try {
			FileReader reader = new FileReader(VICTIMS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray victimsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < victimsJSON.size(); i++) {
				JSONObject victimJSON = (JSONObject)victimsJSON.get(i);
				String firstName = (String)victimJSON.get(FIRST_NAME);
				String lastName = (String)victimJSON.get(LAST_NAME);
                int id = ((Long) victimJSON.get(ID)).intValue();
				int age = ((Long) victimJSON.get(AGE)).intValue();
                String gender = (String)victimJSON.get(GENDER);
                String occupation = (String)victimJSON.get(OCCUPATION);
                String phoneNum = (String)victimJSON.get(PHONE_NUM);
                String desc = (String)victimJSON.get(DESC);
                boolean isAlive = (Boolean)victimJSON.get(IS_ALIVE);
				
				victims.add(new Victim(firstName, lastName, id, age, gender, occupation, phoneNum, desc, isAlive));
			}
			
			return victims;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

		/**
		 * gets the suspects from the json file and parses each element to add to a list
		 */
    public static ArrayList<Suspect> getSuspects() {
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();
        
		try {
			FileReader reader = new FileReader(SUSPECTS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray suspectsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < suspectsJSON.size(); i++) {
				JSONObject suspectJSON = (JSONObject)suspectsJSON.get(i);
				String firstName = (String)suspectJSON.get(FIRST_NAME);
				String lastName = (String)suspectJSON.get(LAST_NAME);
                int id = ((Long) suspectJSON.get(ID)).intValue();
				int age = ((Long) suspectJSON.get(AGE)).intValue();
                String gender = (String)suspectJSON.get(GENDER);
                String occupation = (String)suspectJSON.get(OCCUPATION);
                String phoneNum = (String)suspectJSON.get(PHONE_NUM);
                String desc = (String)suspectJSON.get(DESC);
                boolean isAlive = (Boolean)suspectJSON.get(IS_ALIVE);
                int numCrimes = ((Long) suspectJSON.get(NUM_CRIMES)).intValue();
				String height = (String)suspectJSON.get(HEIGHT);
				String weight = (String)suspectJSON.get(WEIGHT);
				String hairColor = (String)suspectJSON.get(HAIR_COLOR);
				String eyeColor = (String)suspectJSON.get(EYE_COLOR);
				String tattoos = (String)suspectJSON.get(TATTOOS);
				
				suspects.add(new Suspect(firstName, lastName, id, age, gender, occupation, phoneNum, desc, isAlive, numCrimes,
										height, weight, hairColor, eyeColor, tattoos));
			}
			
			return suspects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

		/**
		 * gets the witnesses from the json file and parses each element to add to a list
		 */
    public static ArrayList<Witness> getWitnesses() {
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        
		try {
			FileReader reader = new FileReader(WITNESSES_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray witnessesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < witnessesJSON.size(); i++) {
				JSONObject witnessJSON = (JSONObject)witnessesJSON.get(i);
				String firstName = (String)witnessJSON.get(FIRST_NAME);
				String lastName = (String)witnessJSON.get(LAST_NAME);
                int id = ((Long) witnessJSON.get(ID)).intValue();
				int age = ((Long) witnessJSON.get(AGE)).intValue();
                String gender = (String)witnessJSON.get(GENDER);
                String occupation = (String)witnessJSON.get(OCCUPATION);
                String phoneNum = (String)witnessJSON.get(PHONE_NUM);
				String address = (String)witnessJSON.get(ADDRESS);
				String story = (String)witnessJSON.get(STORY);
				
				witnesses.add(new Witness(firstName, lastName, id, age, gender, occupation, phoneNum, address, story));
			}
			
			return witnesses;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

		/**
		 * gets the evidence from the json file and parses each element to add to a list
		 */
    public static ArrayList<Evidence> getEvidence() {
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        
		try {
			FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray evidencesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < evidencesJSON.size(); i++) {
				JSONObject evidenceJSON = (JSONObject)evidencesJSON.get(i);
				String location = (String)evidenceJSON.get(LOCATION);
                String type = (String)evidenceJSON.get(EVIDENCE_TYPE);
                String date = (String)evidenceJSON.get(DATE);
                String time = (String)evidenceJSON.get(TIME);
				int id = ((Long) evidenceJSON.get(ID)).intValue();
				
				evidence.add(new Evidence(location, type, date, time, id));
			}
			
			return evidence;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

	/**
	 * gets each array from the json and parses it to an array of the specified type
	 * @param caseJSON the JSONObject being worked on
	 * @param criminals the array of criminals that the case has
	 * @param victims the array of victims that the case has
	 * @param suspects the array of suspects that the case has
	 * @param witnesses the array of witnesses that the case has
	 * @param evidence the array of evidence that the case has
	 * @param assignedUser the array of users that the case has
	 */
	public static void getCaseArrays(JSONObject caseJSON, ArrayList<Criminal> criminals, ArrayList<Victim> victims, 
									ArrayList<Suspect> suspects, ArrayList<Witness> witnesses, ArrayList<Evidence> evidence, 
									ArrayList<User> assignedUser) {
		criminalsList = CriminalList.getInstance();

		JSONArray criminalIds = (JSONArray)caseJSON.get(CRIMINALS);
		for(int j = 0; j < criminalIds.size(); j++) {
			int criminalID = ((Long) criminalIds.get(j)).intValue();
			criminals.add(criminalsList.getCriminal(criminalID));
		}

		JSONArray victimIds = (JSONArray)caseJSON.get(VICTIMS);
		for(int j = 0; j < victimIds.size(); j++) {
			int victimID = ((Long) victimIds.get(j)).intValue();
			victims.add(victimsList.getVictim(victimID));
		}

		JSONArray suspectIds = (JSONArray)caseJSON.get(SUSPECTS);
		for(int j = 0; j < suspectIds.size(); j++) {
			int suspectID = ((Long) suspectIds.get(j)).intValue();
			suspects.add(suspectsList.getSuspect(suspectID));
		}

		JSONArray witnessIds = (JSONArray)caseJSON.get(WITNESSES);
		for(int j = 0; j < witnessIds.size(); j++) {
			int witnessID = ((Long) witnessIds.get(j)).intValue();
			witnesses.add(witnessesList.getWitness(witnessID));
		}

		JSONArray evidenceIds = (JSONArray)caseJSON.get(EVIDENCE);
		for(int j = 0; j < evidenceIds.size(); j++) {
			int evidenceID = ((Long) evidenceIds.get(j)).intValue();
			evidence.add(evidenceList.getEvidence(evidenceID));
		}

		JSONArray userIds = (JSONArray)caseJSON.get(ASSIGNED_USER);
		for(int j = 0; j < userIds.size(); j++) {
			int userID = ((Long) userIds.get(j)).intValue();
			assignedUser.add(usersList.getUser(userID));
		}
	}
}
