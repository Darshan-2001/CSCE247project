/*
 * @description Class that creates criminal.
 */
import java.util.Random;

public class Criminal extends Persons{
	public boolean isAlive;
	public boolean inJail;
	public int numCrimes;
	Random r = new Random();
    CriminalList criminals = CriminalList.getInstance();
	
    /*
	 * method that creates a criminal as a called super without ID
	 * @param desc		description of criminal
	 * @param isALive	boolean if alive
	 * @param inJail	boolean is in jail
	 * @param numCrimes	numbers of crimes committed
	 * @param height	height of criminal
	 * @param weight	weight of criminal
	 * @param hairColor	hair color of criminal
	 * @param eyeColor	eye color of criminal
	 * @param tattoos 	tattoos the criminal have
	 */
	public Criminal(String firstName, String lastName, int age, String occupation, String gender, String phoneNum, String desc, boolean isAlive, boolean inJail, int numCrimes,
					String height, String weight, String hairColor, String eyeColor, String tattoos)
	{
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		setID();
		this.desc = desc;
		this.isAlive = isAlive;
		this.inJail = inJail;
		this.numCrimes = numCrimes;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.tattoos = tattoos;
	}

    /*
	 * method that creates a criminal as a called super with ID
	 * @param id		sets id of criminal
	 * @param desc		description of criminal
	 * @param isALive	boolean if alive
	 * @param inJail	boolean is in jail
	 * @param numCrimes	numbers of crimes committed
	 * @param height	height of criminal
	 * @param weight	weight of criminal
	 * @param hairColor	hair color of criminal
	 * @param eyeColor	eye color of criminal
	 * @param tattoos 	tattoos the criminal have
	 */
	public Criminal(String firstName, String lastName, int id, int age, String gender, String occupation, String phoneNum, String desc, boolean isAlive, boolean inJail, int numCrimes,
					String height, String weight, String hairColor, String eyeColor, String tattoos)
	{
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		this.id = id;
		this.desc = desc;
		this.isAlive = isAlive;
		this.inJail = inJail;
		this.numCrimes = numCrimes;
		this.height = height;
		this.weight = weight;
		this.hairColor = hairColor;
		this.eyeColor = eyeColor;
		this.tattoos = tattoos;
	}
	/*
	 * method returns each variables as a string
	 * @return String of the variables
	 */
	@Override
	public String toString() {
		return super.toString() + "\nFirst name: " + this.firstName + "\nLast name: " + this.lastName + "\nId: "
				+ this.id + "\nAge: " + this.age + "\nGender: " + this.gender + "\nOccupation: " + this.occupation
				+ "\nPhone number: " + this.phoneNum + "\nDescription: " + this.desc + "\nIs Alive?: " + this.isAlive
				+ "\nIs in jail?: " + this.inJail + "\nNumber of crimes: " + this.numCrimes + "\nHeight: " + this.height
				+ "\nWeight: " + this.weight + "\nHair color: " + this.hairColor + "\nEye color: " + this.eyeColor
				+ "\nTattoos: " + this.tattoos;
	} 

	private void setID() {
        id = r.nextInt(5000);

        while (criminals.checkIds(id)) {
            id = r.nextInt(5000);
        }
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
		this.isAlive = isAlive;
	}
	/*
	 *method gets the jail status
	 *@return inJail boolean
	 */
	public boolean getJailStatus() {
		return inJail;
	}
	/*
	 * method gets number of crimes
	 * @return integer of crimes 
	 */
	public int getNumCrimes()
	{
		return numCrimes;
	}
	/*
	 * method sets number of crimes
	 * @param numCrimes numbers of crimes committed
	 */
	public void setNumCrimes(int numCrimes) {
		this.numCrimes = numCrimes;
	}

}
