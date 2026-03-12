import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MediScoreCalculatorTest {

    private final MediScoreCalculator calculator = new MediScoreCalculator();

    @Test
    void examplePatient1ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 95, 37.1);
        assertEquals(0, score);
    }

    @Test
    void examplePatient2ShouldScore4() {
        int score = calculator.calculateScore(2, 0, 17, 95, 37.1);
        assertEquals(4, score);
    }

    @Test
    void examplePatient3ShouldScore8() {
        int score = calculator.calculateScore(2, 1, 23, 88, 38.5);
        assertEquals(8, score);
    }

    @Test
    void respirationRate8ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 8, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void respirationRate9ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 9, 95, 37.1);
        assertEquals(1, score);
    }

    @Test
    void respirationRate12ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 12, 95, 37.1);
        assertEquals(0, score);
    }

    @Test
    void respirationRate21ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 21, 95, 37.1);
        assertEquals(2, score);
    }

    @Test
    void respirationRate25ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 25, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void oxygenSaturation93OnAirShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 93, 37.1);
        assertEquals(0, score);
    }

    @Test
    void oxygenSaturation93OnOxygenShouldScore3Total() {
        int score = calculator.calculateScore(2, 0, 15, 93, 37.1);
        assertEquals(3, score);
    }

    @Test
    void oxygenSaturation95OnOxygenShouldScore4Total() {
        int score = calculator.calculateScore(2, 0, 15, 95, 37.1);
        assertEquals(4, score);
    }

    @Test
    void oxygenSaturation97OnOxygenShouldScore5Total() {
        int score = calculator.calculateScore(2, 0, 15, 97, 37.1);
        assertEquals(5, score);
    }

    @Test
    void temperature35Point0ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 15, 95, 35.0);
        assertEquals(3, score);
    }

    @Test
    void temperature36Point1ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 95, 36.1);
        assertEquals(0, score);
    }

    @Test
    void temperature38Point1ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 95, 38.1);
        assertEquals(1, score);
    }

    @Test
    void temperature39Point1ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 15, 95, 39.1);
        assertEquals(2, score);
    }

    @Test
    void nonZeroConsciousnessShouldAdd3() {
        int score = calculator.calculateScore(0, 1, 15, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void temperatureShouldBeRoundedToOneDecimalPlace() {
        int score = calculator.calculateScore(0, 0, 15, 95, 38.04);
        assertEquals(0, score);
    }


}