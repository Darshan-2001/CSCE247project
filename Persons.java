/*
 * @description class that helps create persons.
 */
public class Persons {
	protected String firstName;
	protected String lastName;
	protected int id;
	protected int age;
	protected String gender;
	protected String occupation;
	protected String phoneNum;
	protected String desc;
	protected String height;
	protected String weight;
	protected String hairColor;
	protected String eyeColor;
	protected String tattoos;
	/*
	 * method that creates person
	 * @param firstName		first name of the person
	 * @param lastName		last name of the person
	 * @param age			age of the person
	 * @param gender		gender of person
	 * @param ocupation		occupation of the person
	 * @param phonenum		phone number of the person
	 */
	public void createPerson(String firstName, String lastName, int age, String gender, String occupation, String phoneNum) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.phoneNum = phoneNum;
	}
	/*
	 * gets first name of person
	 * @return String firstName of person
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/*
	 * gets last name of person
	 * @return String lastName of person
	 */
	public String getLastName()
	{
		return lastName;
	}
	/*
	 * gets id of person
	 * @return integer id of person
	 */
	public int getID()
	{
		return id;
	}
	/*
	 * gets age of person
	 * @return integer age of person
	 */
	public int getAge()
	{
		return age;
	}
	/*
	 * gets gender of person
	 * @return String gender of person
	 */
	public String getGender()
	{
		return gender;
	}
	/*
	 * gets occupation of person
	 * @return String occupation of person
	 */
	public String getOcc()
	{
		return occupation;
	}
	/*
	 * gets phone number of person
	 * @return String phoneNum of person
	 */
	public String getPhone()
	{
		return phoneNum;
	}
	/*
	 * gets description of person
	 * @return String desc of person
	 */
	public String getDesc()
	{
		return desc;
	}
	/*
	 * gets height of person
	 * @return String height of person
	 */
	public String getHeight() {
		return height;
	}
	/*
	 * gets weight of person
	 * @return String weight of person
	 */
	public String getWeight() {
		return weight;
	}
	/*
	 * gets hair color of person
	 * @return String hairColor of person
	 */
	public String getHairColor() {
		return hairColor;
	}
	/*
	 * gets eye color of person
	 * @return String eyeColor of person
	 */
	public String getEyeColor() {
		return eyeColor;
	}
	/*
	 * gets tattoos person have
	 * @return String tattoos of person
	 */
	public String getTattoos() {
		return tattoos;
	}
}
