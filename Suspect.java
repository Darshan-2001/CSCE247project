/*
 * @description Class that creates a suspect.
 */
import java.util.Random;

public class Suspect extends Persons{
	public boolean isAlive;
	public int numCrimes;
	Random r = new Random();
    SuspectList suspects = SuspectList.getInstance();
    /*
	 * method that creates a suspect as a called super without ID
	 * @param desc		description of suspect
	 * @param isALive	boolean if alive
	 * @param numCrimes	numbers of crimes committed
	 * @param height	height of suspect
	 * @param weight	weight of suspect
	 * @param hairColor	hair color of suspect
	 * @param eyeColor	eye color of suspect
	 * @param tattoos 	tattoos the suspect have
	 */
	public Suspect(String firstName, String lastName, int age, String occupation, String gender, String phoneNum, String desc, boolean isAlive, int numCrimes,
					String height, String weight, String hairColor, String eyeColor, String tattoos) {
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		setID();
		this.desc = desc;
		this.isAlive = isAlive;
		this.numCrimes = numCrimes;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.tattoos = tattoos;
	}
	/*
	 * method that creates a suspect as a called super with ID
	 * @param id		id of the suspect
	 * @param desc		description of suspect
	 * @param isALive	boolean if alive
	 * @param numCrimes	numbers of crimes committed
	 * @param height	height of suspect
	 * @param weight	weight of suspect
	 * @param hairColor	hair color of suspect
	 * @param eyeColor	eye color of suspect
	 * @param tattoos 	tattoos the suspect have
	 */
	public Suspect(String firstName, String lastName, int id, int age, String occupation, String gender, String phoneNum, String desc, boolean isAlive, int numCrimes,
					String height, String weight, String hairColor, String eyeColor, String tattoos) {
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		this.id = id;
		this.desc = desc;
		this.isAlive = isAlive;
		this.numCrimes = numCrimes;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.tattoos = tattoos;

	}

	private void setID() {
        id = r.nextInt(5000);

        while (suspects.checkIds(id)) {
            id = r.nextInt(5000);
        }
    }
	

	/*
	 * method returns each variables as a string
	 * @return String of the variables
	 */
	@Override
	public String toString() {
		return super.toString() + "\nFirst name: "+ this.firstName+ "\n Last name: "+ this.lastName+ "\nId: "+this.id+ "\nAge: "+ this.age+
				"\nGender: "+this.gender+"\nOccupation: " +this.occupation+"\nPhone number: "+this.phoneNum +"\nDescription: "+this.desc+ "\nIs Alive?: " +this.isAlive+
				"\nNumber of crimes: "+this.numCrimes;
	}
	
	/*
	 *method gets the alive status
	 *@return isAlive boolean
	 */
	public boolean getAliveStatus() {
		return isAlive;
	}
	/*
	 * method sets alive status
	 * @param isAlive boolean isAlive status of the person
	 */
	public void setAliveStatus(boolean isAlive) {
		this.isAlive= isAlive;
	}
	/*
	 * method gets number of crimes
	 * @return integer of crimes 
	 */
	public int getNumCrimes() {
		return numCrimes;
	}
	/*
	 * method sets number of crimes
	 * @param numCrimes numbers of crimes committed
	 */
	public void setNumCrimes(int numCrimes) {
		this.numCrimes= numCrimes;
	}
	
}
