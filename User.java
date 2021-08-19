/*
 * @description class helps create user
 */
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int id;
    private String phoneNum;
    private boolean isAdmin;
    Random r = new Random();
    UsersList users = UsersList.getInstance();
    /*
     * method helps create user without id
     * @param firstName 	first name of the user
     * @param lastName		last name of the user
     * @param userName		username for user
     * @param password		password for user
     * @param phoneNum		phonenumber of user
     * @param isAdmin		boolean if admin
     */
    public User(String firstName, String lastName, String userName, String password, String phoneNum, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        setID();
        this.phoneNum = phoneNum;
        this.isAdmin = isAdmin;
    }
    /*
     * method helps create user with id
     * @param id			id of the user
     * @param firstName 	first name of the user
     * @param lastName		last name of the user
     * @param userName		username for user
     * @param password		password for user
     * @param phoneNum		phonenumber of user
     * @param isAdmin		boolean if admin
     */
    public User(String firstName, String lastName, String userName, String password, int id, String phoneNum, boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.phoneNum = phoneNum;
        this.isAdmin = isAdmin;
    }

    private void setID() {
        id = r.nextInt(5000);

        while (users.checkIds(id)) {
            id = r.nextInt(5000);
        }
    }

    @Override
	public String toString() {
		return super.toString() + "\nFirst name: "+ this.firstName+ "\nLast name: "+ this.lastName+  "\nUsername: "+ this.userName+ "\nPassword: "+ this.password+ 
        "\nId: "+this.id+ "\nPhone Number: "+ this.phoneNum+ "\nAdmin Status T/F: "+Boolean.toString(this.isAdmin);
	}
    /*
     * method get first name of user
     * @return String fristName 
     */
    public String getFirstName() {
        return firstName;
    }
    /*
     * method get last name of user
     * @return String lastName 
     */
    public String getLastName() {
        return lastName;
    }
    /*
     * method get username of user
     * @return String userName 
     */
    public String getUserName() {
        return userName;
    }
    /*
     * method get password for user
     * @return String password 
     */
    public String getPassword() {
        return password;
    }
    /*
     * method sets id of user
     */
    public void setUserId() {

    }
    /*
     * method get User id of user
     * @return integer id number
     */
    public int getUserID() {
        return id;
    }
    /*
     * method gets phone number
     * @return string of phoneNum
     */
    public String getPhone() {
        return phoneNum;
    }
    /*
	 *method checks if user is admin
	 *@return isAdmin boolean
	 */
    public boolean getIsAdmin() {
        return isAdmin;
    }
}
