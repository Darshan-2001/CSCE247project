//Darshan Patel
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EvidenceTest {
	@BeforeEach
	public void setup() {
        
	}

	@AfterEach
	public void test() {
	}


	@Test
	void testEvidence() {
		Evidence test = new Evidence( "location",  "type",  "date",  "time",  1);
		assertEquals(test.getID(), 1);
	}


}