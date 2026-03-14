import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    void negativeAirOrOxygenShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateScore(-1, 0, 15, 95, 37.1));
    }

    @Test
    void invalidAirOrOxygenShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateScore(1, 0, 15, 95, 37.1));
    }

    @Test
    void respirationRate0ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 0, 95, 37.1);
        assertEquals(3, score);
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
    void respirationRate11ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 11, 95, 37.1);
        assertEquals(1, score);
    }

    @Test
    void respirationRate12ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 12, 95, 37.1);
        assertEquals(0, score);
    }

    @Test
    void respirationRate20ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 20, 95, 37.1);
        assertEquals(0, score);
    }

    @Test
    void respirationRate21ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 21, 95, 37.1);
        assertEquals(2, score);
    }

    @Test
    void respirationRate24ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 24, 95, 37.1);
        assertEquals(2, score);
    }

    @Test
    void respirationRate25ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 25, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void veryHighRespirationRateShouldScore3() {
        int score = calculator.calculateScore(0, 0, 40, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void negativeRespirationRateShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateScore(0, 0, -1, 95, 37.1));
    }

    @Test
    void oxygenSaturation83ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 15, 83, 37.1);
        assertEquals(3, score);
    }

    @Test
    void oxygenSaturation84ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 15, 84, 37.1);
        assertEquals(2, score);
    }

    @Test
    void oxygenSaturation85ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 15, 85, 37.1);
        assertEquals(2, score);
    }

    @Test
    void oxygenSaturation86ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 86, 37.1);
        assertEquals(1, score);
    }

    @Test
    void oxygenSaturation87ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 87, 37.1);
        assertEquals(1, score);
    }

    @Test
    void oxygenSaturation88ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 88, 37.1);
        assertEquals(0, score);
    }

    @Test
    void oxygenSaturation92ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 92, 37.1);
        assertEquals(0, score);
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
    void oxygenSaturation94OnOxygenShouldScore3Total() {
        int score = calculator.calculateScore(2, 0, 15, 94, 37.1);
        assertEquals(3, score);
    }

    @Test
    void oxygenSaturation95OnOxygenShouldScore4Total() {
        int score = calculator.calculateScore(2, 0, 15, 95, 37.1);
        assertEquals(4, score);
    }

    @Test
    void oxygenSaturation96OnOxygenShouldScore4Total() {
        int score = calculator.calculateScore(2, 0, 15, 96, 37.1);
        assertEquals(4, score);
    }

    @Test
    void oxygenSaturation97OnOxygenShouldScore5Total() {
        int score = calculator.calculateScore(2, 0, 15, 97, 37.1);
        assertEquals(5, score);
    }

    @Test
    void oxygenSaturation100OnOxygenShouldScore5Total() {
        int score = calculator.calculateScore(2, 0, 15, 100, 37.1);
        assertEquals(5, score);
    }

    @Test
    void oxygenSaturation100OnAirShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 100, 37.1);
        assertEquals(0, score);
    }

    @Test
    void oxygenSaturationAbove100ShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateScore(0, 0, 15, 101, 37.1));
    }

    @Test
    void negativeOxygenSaturationShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateScore(0, 0, 15, -1, 37.1));
    }

    @Test
    void temperature35Point0ShouldScore3() {
        int score = calculator.calculateScore(0, 0, 15, 95, 35.0);
        assertEquals(3, score);
    }

    @Test
    void temperature35Point1ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 95, 35.1);
        assertEquals(1, score);
    }

    @Test
    void temperature36Point0ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 95, 36.0);
        assertEquals(1, score);
    }

    @Test
    void temperature36Point1ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 95, 36.1);
        assertEquals(0, score);
    }

    @Test
    void temperature38Point0ShouldScore0() {
        int score = calculator.calculateScore(0, 0, 15, 95, 38.0);
        assertEquals(0, score);
    }

    @Test
    void temperature38Point1ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 95, 38.1);
        assertEquals(1, score);
    }

    @Test
    void temperature39Point0ShouldScore1() {
        int score = calculator.calculateScore(0, 0, 15, 95, 39.0);
        assertEquals(1, score);
    }

    @Test
    void temperature35Point05ShouldRoundTo35Point1AndScore1() {
        int score = calculator.calculateScore(0, 0, 15, 95, 35.05);
        assertEquals(1, score);
    }

    @Test
    void temperature39Point1ShouldScore2() {
        int score = calculator.calculateScore(0, 0, 15, 95, 39.1);
        assertEquals(2, score);
    }

    @Test
    void temperatureShouldBeRoundedToOneDecimalPlace() {
        int score = calculator.calculateScore(0, 0, 15, 95, 38.04);
        assertEquals(0, score);
    }

    @Test
    void zeroConsciousnessShouldAdd0() {
        int score = calculator.calculateScore(0, 0, 15, 95, 37.1);
        assertEquals(0, score);
    }

    @Test
    void consciousnessValue1ShouldAdd3() {
        int score = calculator.calculateScore(0, 1, 15, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void consciousnessValue2ShouldAdd3() {
        int score = calculator.calculateScore(0, 2, 15, 95, 37.1);
        assertEquals(3, score);
    }

    @Test
    void oxygenShouldAdd2EvenWhenSpO2IsInNormalBand() {
        int score = calculator.calculateScore(2, 0, 15, 88, 37.1);
        assertEquals(2, score);
    }

}
