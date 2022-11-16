package sl.miftha.test.drones.types;

public enum DroneStatus {
    IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING;
    private static final DroneStatus [] status = values();

    public static DroneStatus get(int ordinal) {
        if (ordinal < status.length)
            return status[ordinal];

        throw new IllegalArgumentException();
    }
}
