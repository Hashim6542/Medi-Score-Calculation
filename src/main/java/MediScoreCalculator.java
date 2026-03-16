/**
 * Calculates a patient's Medi score from physiological observations.
 */
public class MediScoreCalculator {

    private static final int AIR = 0;
    private static final int OXYGEN = 2;
    private static final int ALERT = 0;

    /**
     * Returns the total Medi score for the supplied patient observations.
     */
    public int calculateScore(
            int airOrOxygen,
            int consciousness,
            int respirationRate,
            int oxygenSaturation,
            double temperature
    ) {
        validateInputs(airOrOxygen, respirationRate, oxygenSaturation, temperature);

        double roundedTemperature = roundTemperatureToOneDecimalPlace(temperature);

        return scoreAirOrOxygen(airOrOxygen)
                + scoreConsciousness(consciousness)
                + scoreRespiration(respirationRate)
                + scoreOxygenSaturation(airOrOxygen, oxygenSaturation)
                + scoreTemperature(roundedTemperature);
    }

    /**
     * Validates input values before calculating the score.
     */
    private void validateInputs(int airOrOxygen, int respirationRate, int oxygenSaturation, double temperature) {
        if (airOrOxygen != AIR && airOrOxygen != OXYGEN) {
            throw new IllegalArgumentException("airOrOxygen must be 0 (air) or 2 (oxygen)");
        }
        if (respirationRate < 0) {
            throw new IllegalArgumentException("respirationRate must not be negative");
        }
        if (oxygenSaturation < 0 || oxygenSaturation > 100) {
            throw new IllegalArgumentException("oxygenSaturation must be between 0 and 100");
        }
        if (Double.isNaN(temperature) || Double.isInfinite(temperature)) {
            throw new IllegalArgumentException("temperature must be a valid number");
        }
    }

    private double roundTemperatureToOneDecimalPlace(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    private int scoreAirOrOxygen(int airOrOxygen) {
        return airOrOxygen == OXYGEN ? 2 : 0;
    }

    private int scoreConsciousness(int consciousness) {
        return consciousness == ALERT ? 0 : 3;
    }

    private int scoreRespiration(int respirationRate) {
        if (respirationRate <= 8) {
            return 3;
        }
        if (respirationRate <= 11) {
            return 1;
        }
        if (respirationRate <= 20) {
            return 0;
        }
        if (respirationRate <= 24) {
            return 2;
        }
        return 3;
    }

    /**
     * Scores oxygen saturation, taking into account whether the patient is on air or oxygen.
     */
    private int scoreOxygenSaturation(int airOrOxygen, int oxygenSaturation) {
        if (oxygenSaturation <= 83) {
            return 3;
        }
        if (oxygenSaturation <= 85) {
            return 2;
        }
        if (oxygenSaturation <= 87) {
            return 1;
        }
        if (oxygenSaturation <= 92) {
            return 0;
        }
        if (airOrOxygen == AIR) {
            return 0;
        }
        if (oxygenSaturation <= 94) {
            return 1;
        }
        if (oxygenSaturation <= 96) {
            return 2;
        }
        return 3;
    }

    private int scoreTemperature(double temperature) {
        if (temperature <= 35.0) {
            return 3;
        }
        if (temperature <= 36.0) {
            return 1;
        }
        if (temperature <= 38.0) {
            return 0;
        }
        if (temperature <= 39.0) {
            return 1;
        }
        return 2;
    }
}
