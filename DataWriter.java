import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveUsers() {
        UsersList users = UsersList.getInstance();
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJson(userList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * takes in a user and puts the contents of the user into a JSONObject
     * @param user the user that will be converted to json
     * @return returns the JSONObject of the user
     */
    public static JSONObject getUserJson(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(FIRST_NAME, user.getFirstName());
        userDetails.put(LAST_NAME, user.getLastName());
		userDetails.put(USER_NAME, user.getUserName());
        userDetails.put(PASSWORD, user.getPassword());
        userDetails.put(ID, user.getUserID());
		userDetails.put(PHONE_NUM, user.getPhone());
        userDetails.put(IS_ADMIN, user.getIsAdmin());
        
        return userDetails;
    }

    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveCases() {
        CaseList cases = CaseList.getInstance();
		ArrayList<Case> caseList = cases.getCases();
		JSONArray jsonCases = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< caseList.size(); i++) {
			jsonCases.add(getCaseJson(caseList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CASES_FILE_NAME)) {
 
            file.write(jsonCases.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * takes in a case and puts the contents of the user into a JSONObject
     * @param crime the case that will be converted to json
     * @return returns the JSONObject of the case
     */
    public static JSONObject getCaseJson(Case crime) {
        JSONObject caseDetails = new JSONObject();
        caseDetails.put(AUTHOR, crime.getAuthorUserName());
        caseDetails.put(ID, crime.getID());
		caseDetails.put(LOCATION, crime.getLocation());
        caseDetails.put(CITY, crime.getCity());
        caseDetails.put(ZIP_CODE, crime.getZipCode());
		caseDetails.put(TYPE_OF_CASE, crime.getCaseType());
        caseDetails.put(WEAPON, crime.getWeapon());
        caseDetails.put(STORY, crime.getStory());
        caseDetails.put(CRIMINALS, crime.getCriminals());
        caseDetails.put(VICTIMS, crime.getVictims());
        caseDetails.put(SUSPECTS, crime.getSuspects());
        caseDetails.put(WITNESSES, crime.getWitnesses());
        caseDetails.put(EVIDENCE, crime.getEvidence());
        caseDetails.put(ASSIGNED_USER, crime.getAssignUsers());
        
        return caseDetails;
    }

    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveCriminals() {
        CriminalList criminals = CriminalList.getInstance();
		ArrayList<Criminal> CriminalList = criminals.getCriminals();
		JSONArray jsonCriminals = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< CriminalList.size(); i++) {
			jsonCriminals.add(getCriminalJson(CriminalList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CRIMINALS_FILE_NAME)) {
 
            file.write(jsonCriminals.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * takes in a criminal and puts the contents of the user into a JSONObject
     * @param criminal the criminal that will be converted to json
     * @return returns the JSONObject of the criminal
     */
    public static JSONObject getCriminalJson(Criminal criminal) {
        JSONObject criminalDetails = new JSONObject();
        criminalDetails.put(FIRST_NAME, criminal.getFirstName());
        criminalDetails.put(LAST_NAME, criminal.getLastName());
		criminalDetails.put(ID, criminal.getID());
        criminalDetails.put(AGE, criminal.getAge());
        criminalDetails.put(GENDER, criminal.getGender());
        criminalDetails.put(OCCUPATION, criminal.getOcc());
		criminalDetails.put(PHONE_NUM, criminal.getPhone());
        criminalDetails.put(DESC, criminal.getDesc());
        criminalDetails.put(IS_ALIVE, criminal.getAliveStatus());
        criminalDetails.put(IN_JAIL, criminal.getJailStatus());
        criminalDetails.put(NUM_CRIMES, criminal.getNumCrimes());
        criminalDetails.put(HEIGHT, criminal.getHeight());
        criminalDetails.put(WEIGHT, criminal.getWeight());
        criminalDetails.put(HAIR_COLOR, criminal.getHairColor());
        criminalDetails.put(EYE_COLOR, criminal.getEyeColor());
        criminalDetails.put(TATTOOS, criminal.getTattoos());
        
        return criminalDetails;
    }

    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveVictims() {
        VictimList victims = VictimList.getInstance();
		ArrayList<Victim> VictimList = victims.getVictims();
		JSONArray jsonVictims = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< VictimList.size(); i++) {
			jsonVictims.add(getVictimJson(VictimList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(VICTIMS_FILE_NAME)) {
 
            file.write(jsonVictims.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * takes in a victim and puts the contents of the user into a JSONObject
     * @param victim the victim that will be converted to json
     * @return returns the JSONObject of the victim
     */
    public static JSONObject getVictimJson(Victim victim) {
        JSONObject victimDetails = new JSONObject();
        victimDetails.put(FIRST_NAME, victim.getFirstName());
        victimDetails.put(LAST_NAME, victim.getLastName());
		victimDetails.put(ID, victim.getID());
        victimDetails.put(AGE, victim.getAge());
        victimDetails.put(GENDER, victim.getGender());
        victimDetails.put(OCCUPATION, victim.getOcc());
		victimDetails.put(PHONE_NUM, victim.getPhone());
        victimDetails.put(DESC, victim.getDesc());
        victimDetails.put(IS_ALIVE, victim.getAliveStatus());
        
        return victimDetails;
    }

    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveSuspects() {
        SuspectList suspects = SuspectList.getInstance();
		ArrayList<Suspect> SuspectList = suspects.getSuspects();
		JSONArray jsonSuspects = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< SuspectList.size(); i++) {
			jsonSuspects.add(getSuspectJson(SuspectList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(SUSPECTS_FILE_NAME)) {
 
            file.write(jsonSuspects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * takes in a suspect and puts the contents of the user into a JSONObject
     * @param suspect the suspect that will be converted to json
     * @return returns the JSONObject of the suspect
     */
    public static JSONObject getSuspectJson(Suspect suspect) {
        JSONObject suspectDetails = new JSONObject();
        suspectDetails.put(FIRST_NAME, suspect.getFirstName());
        suspectDetails.put(LAST_NAME, suspect.getLastName());
		suspectDetails.put(ID, suspect.getID());
        suspectDetails.put(AGE, suspect.getAge());
        suspectDetails.put(GENDER, suspect.getGender());
        suspectDetails.put(OCCUPATION, suspect.getOcc());
		suspectDetails.put(PHONE_NUM, suspect.getPhone());
        suspectDetails.put(DESC, suspect.getDesc());
        suspectDetails.put(IS_ALIVE, suspect.getAliveStatus());
        suspectDetails.put(NUM_CRIMES, suspect.getNumCrimes());
        suspectDetails.put(HEIGHT, suspect.getHeight());
        suspectDetails.put(WEIGHT, suspect.getWeight());
        suspectDetails.put(HAIR_COLOR, suspect.getHairColor());
        suspectDetails.put(EYE_COLOR, suspect.getEyeColor());
        suspectDetails.put(TATTOOS, suspect.getTattoos());
        
        return suspectDetails;
    }

    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveWitnesses() {
        WitnessList witnesses = WitnessList.getInstance();
		ArrayList<Witness> WitnessList = witnesses.getWitnesses();
		JSONArray jsonWitnesses = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< WitnessList.size(); i++) {
			jsonWitnesses.add(getWitnessJson(WitnessList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(WITNESSES_FILE_NAME)) {
 
            file.write(jsonWitnesses.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * takes in a witness and puts the contents of the user into a JSONObject
     * @param witness the witness that will be converted to json
     * @return returns the JSONObject of the user
     */
    public static JSONObject getWitnessJson(Witness witness) {
        JSONObject witnessDetails = new JSONObject();
        witnessDetails.put(FIRST_NAME, witness.getFirstName());
        witnessDetails.put(LAST_NAME, witness.getLastName());
		witnessDetails.put(ID, witness.getID());
        witnessDetails.put(AGE, witness.getAge());
        witnessDetails.put(GENDER, witness.getGender());
        witnessDetails.put(OCCUPATION, witness.getOcc());
		witnessDetails.put(PHONE_NUM, witness.getPhone());
        witnessDetails.put(ADDRESS, witness.getAddress());
        witnessDetails.put(STORY, witness.getStory());
        
        return witnessDetails;
    }

    /**
     * takes in the arrayList from the List file and calls getJson to get the JSONObjects.
     * Then writes the contents to a file
     */
    public static void saveEvidence() {
        EvidenceList evidences = EvidenceList.getInstance();
		ArrayList<Evidence> EvidenceList = evidences.getEvidence();
		JSONArray jsonEvidence = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< EvidenceList.size(); i++) {
			jsonEvidence.add(getEvidenceJson(EvidenceList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(EVIDENCE_FILE_NAME)) {
 
            file.write(jsonEvidence.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * takes in an evidence and puts the contents of the user into a JSONObject
     * @param evidence the evidence that will be converted to json
     * @return returns the JSONObject of the evidence
     */
    public static JSONObject getEvidenceJson(Evidence evidence) {
        JSONObject evidenceDetails = new JSONObject();
        evidenceDetails.put(LOCATION, evidence.getLocation());
        evidenceDetails.put(EVIDENCE_TYPE, evidence.getType());
        evidenceDetails.put(DATE, evidence.getDate());
        evidenceDetails.put(TIME, evidence.getTime());
        evidenceDetails.put(ID, evidence.getID());
        
        return evidenceDetails;
    }
}
