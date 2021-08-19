/**
 * Doug Stokes
 * Tests the UsersList class methods.
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersListTest {
    private UsersList users = UsersList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new User("Alice", "Test", "atest", "AAAA", 1, "1111111111", true));
		userList.add(new User("Bob", "Test", "btest", "BBBB", 2, "9999999999", false));
    }

    @AfterEach
    public void done() {
        UsersList.getInstance().getUsers().clear();
    }
    
    //Test case for adding a user with an ID that already exists
    @Test
    public void UserListIDDuplicate() {
        users.addUser(new User("Johnny", "Test", "jtest", "JJJJ", 1, "2222222222", false));
        assertEquals(2, userList.size());
    }

    //Test case for adding a user with an ID that does not exist
    @Test
    public void UserListIDNonDuplicate() {
        users.addUser(new User("Johnny", "Test", "jtest", "JJJJ", 3, "2222222222", false));
        assertEquals(3, userList.size());
    }

    //Test case for removing a user with an ID that does exist
    @Test
    public void UserListRemoveIDValid() {
        users.removeUser(1);
        assertEquals(1, userList.size());
    }
    
    //Test case for removing a user with an ID that does not exist
    @Test
    public void UserListRemoveIDInvalid() {
        users.removeUser(20);
        assertEquals(2, userList.size());
    }

    //Test case for checking an ID that does match a user's ID.
    @Test
    public void UserListCheckIDValid() {
        assertTrue(users.checkIds(1));
    }

    //Test case for checking an ID that does not match a user's ID.
    @Test
    public void UserListCheckIDInvalid() {
        assertFalse(users.checkIds(20));
    }
}
