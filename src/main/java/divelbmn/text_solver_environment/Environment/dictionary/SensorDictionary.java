package divelbmn.text_solver_environment.Environment.dictionary;

import lombok.Getter;

@Getter
public enum SensorDictionary {
    NEAR_ITEM ("nearItem"),
    HAS_ITEM ("hasItem"),
    NEAR_OWNER ("nearOwner"),
    OWNER_HAS_ITEM ("ownerHasItem");

    private String sensorType;


    SensorDictionary(String sensorType) {
        this.sensorType = sensorType;
    }


    public static SensorDictionary getSensorDictionary(String type) {

        for (SensorDictionary sensorDictionary : values()) {
            if (sensorDictionary.sensorType.equals(type)) {

                return sensorDictionary;
            }
        }

        return null;
    }
}
