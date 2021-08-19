import java.util.ArrayList;

public class UsersList {
    private static UsersList usersList = new UsersList();
    private ArrayList<User> users;
    /* 
     * sets users variable by using DataLoader.getUsers()
     */
    private UsersList() {
    //    if(usersList == null) {
	//		usersList = new UsersList();
	//	}

        users = DataLoader.getUsers();
    }
    /*
     * creates a new instance of UsersList
     * @return usersList
     */
    public static UsersList getInstance() {
        return usersList;
    }
    /*
     * adds a new user to the current UsersList
     * @param User user
     */
    public void addUser(User user) {
        for(User use : users) {
            if(use.getUserID() == user.getUserID()){
                System.out.println("This user is already in the system");
                return;
            }
        }

        users.add(user);
        System.out.println("User has been added to the system");
    }
    /*
     * removes an existing User from the UsersList by searching an ID
     * @param a randomly generated int for ID
     */
    public void removeUser(int ID) {
        for(User use : users) {
            if(use.getUserID() == ID){
                users.remove(use);
                System.out.println("User has been successfully removed");
                return;
            }
        }

        System.out.println("This user is not currently in the system");
    }
    /*
     * returns a specific user from the UsersList
     * @return users
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    /*
     * returns a specific user from UsersList using an ID
     * @param a randomly generated int for id
     * @return User use or null
     */
    public User getUser(int id) {
		for(User use : users) {
            if(use.getUserID() == id) {
				return use;
			}
        }
		return null;
	}
    /*
     * checks the ID entered and searches the UsersList for the ID
     * @param a randomly generated int for ID
     * @return true or false
     */
    public boolean checkIds(int ID) {
        for(User use: users) {
            if(use.getUserID() == ID) {
                return true;
            }
        }

        return false;
    }
    /*
     * Saves the witnesses to the DataWriter class
     */
    public void saveUsers() {
        DataWriter.saveUsers();
    }
}