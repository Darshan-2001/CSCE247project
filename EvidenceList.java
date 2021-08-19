import java.util.ArrayList;

public class EvidenceList {
    private static EvidenceList evidenceList = new EvidenceList();
    private ArrayList<Evidence> evidences;
    /*
     * Sets evidences variable by using DataLoader.getEvidence
     */
    private EvidenceList() {
    //    if(evidenceList == null) {
	//		evidenceList = new EvidenceList();
	//	}
        evidences = DataLoader.getEvidence();
    }
    /*
     * creates a new instance of EvidenceList
     * @return evidenceList
     */
    public static EvidenceList getInstance() {
        return evidenceList;
    }
    /*
     * adds new evidence to the current EvidenceList
     * @param Evidence evidence
     */
    public void addEvidence(Evidence evidence) {
        for(Evidence ev : evidences) {
            if(ev.getID() == evidence.getID()){
                System.out.println("This evidence is already in the system");
                return;
            }
        }

        evidences.add(evidence);
        System.out.println("Evidence has been added to the system");
    }
    /*
     * removes existing evidence from the EvidenceList by searching an ID
     * @param a randomly generated int for ID
     */
    public void removeEvidence(int ID) {
        for(Evidence ev: evidences) {
            if(ev.getID() == ID) {
                evidences.remove(ev);
                System.out.println("Witness has been successfully removed");
                return;
            }
        }

        System.out.println("This witness is not currently in the system");
    }
    /*
     * returns a specific piece of evidence from the EvidenceList
     * @return evidences
     */
    public ArrayList<Evidence> getEvidence(){
        return evidences;
    }
    /*
     * returns a specific piece of evidence from EvidenceList using an ID
     * @param a randomly generated int for id
     * @return Evidence ev or null
     */
    public Evidence getEvidence(int id) {
		for(Evidence ev : evidences) {
            if(ev.getID() == id) {
				return ev;
			}
        }
		return null;
	}
    /*
     * checks the ID entered and searches EvidenceList for the ID
     * @param a randomly generated int for ID
     * @return true or false
     */
    public boolean checkIds(int ID) {
        for(Evidence ev : evidences) {
            if(ev.getID() == ID) {
                return true;
            }
        }

        return false;
    }
    /*
     * Saves the evidence to the DataWriter class
     */
    public void saveEvidence() {
        DataWriter.saveEvidence();
    }
}