/*
 * @description Class that creates a victim.
 */
import java.util.Random;

public class Victim extends Persons{
	public boolean isAlive;
	Random r = new Random();
    VictimList victims = VictimList.getInstance();
	/*
	 * method that creates a person as a called super without ID
	 * @param desc		description of person
	 * @param isAlive	boolean if alive
	 */
	public Victim(String firstName, String lastName, int age, String gender, String occupation, String phoneNum, String desc, boolean isAlive)
	{
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		setID();
		this.desc = desc;
		this.isAlive = isAlive;
	}
	/*
	 * method that creates a person as a called super with ID
	 * @param desc		description of victim
	 * @param isAlive	boolean if alive
	 * @param id		sets id number
	 */
	public Victim(String firstName, String lastName, int id, int age, String gender, String occupation, String phoneNum, String desc, boolean isAlive)
	{
		super.createPerson(firstName, lastName, age, gender, occupation, phoneNum);
		this.id = id;
		this.desc = desc;
		this.isAlive = isAlive;
	}

	private void setID() {
        id = r.nextInt(5000);

        while (victims.checkIds(id)) {
            id = r.nextInt(5000);
        }
    }
	/*
	 * method returns each variables as a string
	 * @return String of the variables
	 */
	public String toString() {
		return super.toString() + "\nFirst name: "+ this.firstName+ "\n Last name: "+ this.lastName+ "\nId: "+this.id+ "\nAge: "+ this.age+
				"\nGender: "+this.gender+"\nOccupation: " +this.occupation+"\nPhone number: "+this.phoneNum +"\nDescription: "+this.desc+ "\nIs Alive?: " +this.isAlive;
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
}
