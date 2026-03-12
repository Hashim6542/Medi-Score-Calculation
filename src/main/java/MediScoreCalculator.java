public class MediScoreCalculator {

    public int calculateScore(int airOrOxygen, int consciousness, int respirationRate, int oxygenSaturation,
                              double temperature) {


        // Temperature must be rounded to one decimal place before scoring
        double roundedTemperature = Math.round(temperature * 10.0) / 10.0;

        int totalScore = 0;

        totalScore += scoreAirOrOxygen(airOrOxygen);
        totalScore += scoreConsciousness(consciousness);
        totalScore += scoreRespiration(respirationRate);
        totalScore += scoreOxygenSaturation(airOrOxygen, oxygenSaturation);
        totalScore += scoreTemperature(roundedTemperature);


        return totalScore;
    }


    private int scoreAirOrOxygen(int airOrOxygen) {
        if (airOrOxygen == 2) {
            return 2;
        }
        return 0;
    }


    private int scoreConsciousness(int consciousness) {
        if (consciousness == 0) {
            return 0;
        }
        return 3;
    }


    private int scoreRespiration(int respirationRate) {
        if (respirationRate <= 8) {
            return 3;
        } else if (respirationRate <= 11) {
            return 1;
        } else if (respirationRate <= 20) {
            return 0;
        } else if (respirationRate <= 24) {
            return 2;
        } else {
            return 3;
        }
    }


    // For SpO2 above 92, the score depends on whether the patient is on air or oxygen
    private int scoreOxygenSaturation(int airOrOxygen, int oxygenSaturation) {
        if (oxygenSaturation <= 83) {
            return 3;
        } else if (oxygenSaturation <= 85) {
            return 2;
        } else if (oxygenSaturation <= 87) {
            return 1;
        } else if (oxygenSaturation <= 92) {
            return 0;
        } else {
            if (airOrOxygen == 2) {
                if (oxygenSaturation <= 94) {
                    return 1;
                } else if (oxygenSaturation <= 96) {
                    return 2;
                } else {
                    return 3;
                }
            } else {
                return 0;
            }
        }
    }


    private int scoreTemperature(double temperature) {
        if (temperature <= 35.0) {
            return 3;
        } else if (temperature <= 36.0) {
            return 1;
        } else if (temperature <= 38.0) {
            return 0;
        } else if (temperature <= 39.0) {
            return 1;
        } else {
            return 2;
        }
    }


}
