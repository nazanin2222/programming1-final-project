import org.example.Assignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignmentTest {

    @Test
    void testCalcAssignmentAvg() {
        Assignment assignment = new Assignment("Test", 50);
        assignment.getScores().add(80);
        assignment.getScores().add(90);
        assignment.getScores().add(70);

        double avg = assignment.calcAssignmentAvg();
        assertEquals(80.0, avg, 0.001);
    }

    @Test
    void testGenerateRandomScore() {
        Assignment assignment = new Assignment("Test", 50);
        assignment.getScores().add(0);
        assignment.getScores().add(0);
        assignment.getScores().add(0);

        assignment.generateRandomScore();
        for (Integer score : assignment.getScores()) {
            assertTrue(score >= 0 && score <= 100);
        }
    }
}
