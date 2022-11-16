package sl.miftha.test.drones.types;

public enum DroneModel {
    LIGHT_WEIGHT, MIDDLE_WEIGHT, CRUISER_WEIGHT, HEAVY_WEIGHT;

    private static final DroneModel [] models = values();

    public static DroneModel get(int ordinal) {
        if (ordinal < models.length)
            return models[ordinal];

        throw new IllegalArgumentException();
    }
}
