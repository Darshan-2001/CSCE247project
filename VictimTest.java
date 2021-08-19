//Darshan Patel
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VictimTest {
	@BeforeEach
	public void setup() {
	}

	@AfterEach
	public void test() {
	}


	@Test
	void testVictim() {
		Victim test = new Victim("firstName",  "lastName", 1,  "gender",  "occupation",  "phoneNum",  "desc",  true);
		assertEquals(test.getFirstName(), "firstName");
	}

	@Test
	void testToString() {
		Victim test = new Victim("firstName",  "lastName", 1,  "gender",  "occupation",  "phoneNum",  "desc",  true);
        assertEquals(test.getAliveStatus(), true);
    }
}