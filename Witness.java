/*
 * @description Class that creates a witness.
 */
import java.util.Random;

public class Witness extends Persons{
	private String address;
	private String story;
	Random r = new Random();
    WitnessList witnesses = WitnessList.getInstance();
    /*
	 * method that creates a witness as a called super 
	 * @param address	address of witness
	 * @param story		story of witness
	 */
	public Witness(String firstName, String lastName, int age, String gender, String occupation, String phoneNum, String address, String story) {
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		setID();
		this.address = address;
		this.story = story;
	}
	/*
	 * method that creates a witness as a called super with ID
	 * @param address	address of witness
	 * @param story		story of witness
	 * @param id		sets id number

	 */
	public Witness(String firstName, String lastName, int id, int age, String gender, String occupation, String phoneNum, String address, String story) {
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		this.id = id;
		this.address = address;
		this.story = story;
	}

	private void setID() {
        id = r.nextInt(5000);

        while (witnesses.checkIds(id)) {
            id = r.nextInt(5000);
        }
    }
	/*
	 * method returns each variables as a string
	 * @return String of the variables
	 */
	public String toString() {
		return super.toString() + "\nFirst name: "+ this.firstName+ "\n Last name: "+ this.lastName+ "\nId: "+this.id+ "\nAge: "+ this.age+
				"\nGender: "+this.gender+"\nOccupation: " +this.occupation+"\nPhone number: "+this.phoneNum;
	}
	/*
	 *method gets the address
	 *@return string address 
	 */
	public String getAddress() {
		return address;
	}
	/*
	 * method gets the story
	 * @return string story
	 */
	public String getStory() {
		return story;
	}
	
}
