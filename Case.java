/*
 * @description class helps create case
 */
import java.util.ArrayList;
import java.util.Random;

public class Case {
    private String authorName;
    private int id;
    private String location;
    private String city;
    private int zipCode;
    private String typeOfCase;
    private String weapon;
    private String story;
    private ArrayList<Criminal> criminals;
    private ArrayList<Victim> victims;
    private ArrayList<Witness> witnesses;
    private ArrayList<Suspect> suspects;
    private ArrayList<User> assignedUsers;
    private ArrayList<Evidence> evidences;
    Random r = new Random();
    CaseList cases = CaseList.getInstance();
    /*
	 * method that creates case without ID
	 * @param location		location of case
	 * @param city			city the case is in
	 * @param zipCode		zip cod of case
	 * @param typeOfCase 	type of case
	 * @param weapon		weapon used
	 * @param story			story in case
	 * @param criminals		criminals involved
	 * @param victims		victims involved
	 * @param witnesses		witnesses involved
	 * @param suspects		suspects involved
	 * @param assignedUsers assigned users in the case
	 * @param evidence		evidence found for the case
	 */
    public Case(String authorName, String location, String city, int zipCode, String typeOfCase, 
    String weapon, String story, ArrayList<Criminal> criminals, ArrayList<Victim> victims, ArrayList<Witness> witnesses, 
    ArrayList<Suspect> suspects, ArrayList<User> assignedUsers, ArrayList<Evidence> evidence) {
        this.authorName = authorName;
        setID();
        this.location = location;
        this.city = city;
        this.zipCode = zipCode;
        this.typeOfCase = typeOfCase;
        this. weapon = weapon;
        this.story = story;
        this.criminals = criminals;
        this.victims = victims;
        this.witnesses = witnesses;
        this.suspects = suspects;
        this.assignedUsers = assignedUsers;
        this.evidences = evidence;
    }
    /*
   	 * method that creates case with ID
   	 * @param id			case id
   	 * @param location		location of case
   	 * @param city			city the case is in
   	 * @param zipCode		zip cod of case
   	 * @param typeOfCase 	type of case
   	 * @param weapon		weapon used
   	 * @param story			story in case
   	 * @param criminals		criminals involved
   	 * @param victims		victims involved
   	 * @param witnesses		witnesses involved
   	 * @param suspects		suspects involved
   	 * @param assignedUsers assigned users in the case
   	 * @param evidence		evidence found for the case
   	 */
    public Case(String authorName, int id, String location, String city, int zipCode, String typeOfCase, String weapon, 
                String story, ArrayList<Criminal> criminals, ArrayList<Victim> victims, ArrayList<Witness> witnesses, 
                ArrayList<Suspect> suspects, ArrayList<User> assignedUsers, ArrayList<Evidence> evidence) {
                    this.authorName = authorName;
                    this.id = id;
                    this.location = location;
                    this.city = city;
                    this.zipCode = zipCode;
                    this.typeOfCase = typeOfCase;
                    this.weapon = weapon;
                    this.story = story;
                    this.criminals = criminals;
                    this.victims = victims;
                    this.witnesses = witnesses;
                    this.suspects = suspects;
                    this.assignedUsers = assignedUsers;
                    this.evidences = evidence;
    }
    /*
	 * method helps print details about the case
	 * @return print the details
	 */
    @Override
	public String toString() {
		String print = "\nCase Author: "+ this.authorName+ "\nID: "+ this.id+  "\nLocation: "+ this.location+ 
        "\nCity: "+ this.city+ "\nZip Code: "+this.zipCode+ "\nType of Case: "+ this.typeOfCase+ "\nWeapon Description: "+this.weapon+
        "\nStory: "+ this.story;

        String tab = "\n    ";

        print += "\nCriminals Involved in this Case: ";

        for(int i=0; i < criminals.size(); i++) {
            print += "\n    " + criminals.get(i).getFirstName() + " " + criminals.get(i).getLastName();
        }

        print += "\nVictims Involved in this Case: ";

        for(int i=0; i < victims.size(); i++) {
            print += "\n    " + victims.get(i).getFirstName() + " " + victims.get(i).getLastName();
        }

        print += "\nWitnesses on this Case: ";

        for(int i=0; i < witnesses.size(); i++) {
            print += "\n    " + witnesses.get(i).getFirstName() + " " + witnesses.get(i).getLastName();
        }

        print += "\nSuspects on this Case: ";

        for(int i=0; i < suspects.size(); i++) {
            print += "\n    " + suspects.get(i).getFirstName() + " " + suspects.get(i).getLastName();
        }

        print += "\nUsers on this Case: ";

        for(int i=0; i < assignedUsers.size(); i++) {
            print += "\n    " + assignedUsers.get(i).getFirstName() + " " + assignedUsers.get(i).getLastName();
        }

        print += "\nEvidence on this Case: ";

        for(int i=0; i < evidences.size(); i++) {
            print += "\n    " + evidences.get(i).getDate() + " " + evidences.get(i).getTime();
        }

        return print;
	}
    /*
     * method gets the authors name
     * @return String name of author
     */
    public String getAuthorUserName() {
        return authorName;
    }
    /*
     * method gets the location
     * @return stirng location of case
     */
    public String getLocation() {
        return location;
    }

    private void setID() {
        id = r.nextInt(5000);

        while (cases.checkIds(id)) {
            id = r.nextInt(5000);
        }
    }
    /*
     * method gets id
     * @return integer id of case
     */
    public int getID() {
        return id;
    }
    /*
     * method gets case city
     * @return string city of case
     */
    public String getCity() {
        return city;
    }
    /*
     * method gets zip code
     * @return integer zip code for case
     */
    public int getZipCode() {
        return zipCode;
    }
    /*
     * method gets type of case
     * @return Sring caseType of case
     */
    public String getCaseType() {
        return typeOfCase;
    }
    /*
     * method gets weapon 
     * @return string of weapon
     */
    public String getWeapon() {
        return weapon;
    }
    /*
     * method gets story
     * @return string of story
     */
    public String getStory() {
        return story;
    }
    /*
     * method gets list of criminals
     * @return ArrayList of criminals in the case
     */
    public ArrayList<Criminal> getCriminalList() {
        return criminals;
    }
    /*
     * method gets list of victims
     * @return ArrayList of victims in the case
     */
    public ArrayList<Victim> getVictimList() {
        return victims;
    }
    /*
     * method gets list of witness
     * @return ArrayList of witnesses in the case
     */
    public ArrayList<Witness> getWitnessList() {
        return witnesses;
    }
    /*
     * method gets list of suspects
     * @return ArrayList of suspects in the case
     */
    public ArrayList<Suspect> getSuspectList() {
        return suspects;
    }
    
    /*
     * method get list of assigned users
     * @return ArrayList of users assigned in the case
     */
    public ArrayList<User> getAssignedUsersList() {
        return assignedUsers;
    }
    /*
     * method get list of evidences
     * @return ArrayList of evidences found for the case
     */
    public ArrayList<Evidence> getEvidenceList() {
        return evidences;
    }
    
    /*
     * method helps add victim and get id
     */
    public void addVictim(Victim victim) {
        for(Victim vic : this.victims) {
            if(vic.getID() == victim.getID()){
                System.out.println("This victim is already assigned to this case");
                return;
            }
        }

        victims.add(victim);
        System.out.println("Victim has been added to the case");
    }
    /*
     * @return victimIds
     */
    public ArrayList<Integer> getVictims() {
        ArrayList<Integer> victimIds = new ArrayList<Integer>();

        for(Victim victim: this.victims) {
            victimIds.add(victim.getID());
        }

        return victimIds;
    }
    /*
     * method helps add criminal and get id
     */
    public void addCriminal(Criminal criminal) {
        for(Criminal crim : this.criminals) {
            if(crim.getID() == criminal.getID()){
                System.out.println("This criminal is already assigned to this case");
                return;
            }
        }

        criminals.add(criminal);
        System.out.println("Criminal has been added to the case");
    }
    /*
     * @return criminalIds
     */
    public ArrayList<Integer> getCriminals() {
        ArrayList<Integer> criminalIds = new ArrayList<Integer>();

        for(Criminal criminal: this.criminals) {
            criminalIds.add(criminal.getID());
        }

        return criminalIds;
    }
    /*
     * method helps add witness and get id
     */
    public void addWitness(Witness witness) {
        for(Witness wit : this.witnesses) {
            if(wit.getID() == witness.getID()){
                System.out.println("This witness is already assigned to this case");
                return;
            }
        }

        witnesses.add(witness);
        System.out.println("Witness has been added to the case");
    }
    /*
     * @return witnessIds
     */
    public ArrayList<Integer> getWitnesses() {
        ArrayList<Integer> witnessIds = new ArrayList<Integer>();

        for(Witness witness: this.witnesses) {
            witnessIds.add(witness.getID());
        }

        return witnessIds;
    }
    /*
     * method helps add suspect and gets id
     */
    public void addSuspect(Suspect suspect) {
        for(Suspect sus : this.suspects) {
            if(sus.getID() == suspect.getID()){
                System.out.println("This suspect is already assigned to this case");
                return;
            }
        }

        suspects.add(suspect);
        System.out.println("Suspect has been added to the case");
    }
    /*
     * @return suspectIds
     */
    public ArrayList<Integer> getSuspects() {
        ArrayList<Integer> suspectIds = new ArrayList<Integer>();

        for(Suspect suspect: this.suspects) {
            suspectIds.add(suspect.getID());
        }

        return suspectIds;
    }
    /*
     * method helps add assigned users and gets id
     */
    public void addAssignUser(User user) {
        for(User use : this.assignedUsers) {
            if(use.getUserID() == user.getUserID()){
                System.out.println("This user is already assigned to this case");
                return;
            }
        }

        assignedUsers.add(user);
        System.out.println("User has been added to the case");
    }
    /*
     * @return assignedUserIds
     */
    public ArrayList<Integer> getAssignUsers() {
        ArrayList<Integer> assignedUserIds = new ArrayList<Integer>();

        for(User user: this.assignedUsers) {
            assignedUserIds.add(user.getUserID());
        }

        return assignedUserIds;
    }
    /*
     * method helps add evidence and gets id
     */
    public void addEvidence(Evidence evidence) {
        for(Evidence ev : evidences) {
            if(ev.getID() == evidence.getID()){
                System.out.println("This evidence is already assigned to this case");
                return;
            }
        }

        evidences.add(evidence);
        System.out.println("Evidence has been added to the case");
    }
    /*
     * @return evidenceIds
     */
    public ArrayList<Integer> getEvidence() {
        ArrayList<Integer> evidenceIds = new ArrayList<Integer>();

        for(Evidence evidence: this.evidences) {
            evidenceIds.add(evidence.getID());
        }

        return evidenceIds;
    }
}
