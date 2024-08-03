public class CarRentalService {
    private static final double SEDAN_RATE_PER_DAY = 60.0;
    private static final double SUV_RATE_PER_DAY = 100.0;
    private static final double TRUCK_RATE_PER_DAY = 150.0;

    private static final double LUXURY_SEDAN_RATE_PER_DAY = 120.0;
    private static final double LUXURY_SUV_RATE_PER_DAY = 170.0;
    private static final double LUXURY_TRUCK_RATE_PER_DAY = 200.0;

    private static final int SEDAN_BASE_MILEAGE = 2000;
    private static final int SUV_BASE_MILEAGE = 3500;
    private static final int TRUCK_BASE_MILEAGE = 3000;

    private static final int LUXURY_SEDAN_BASE_MILEAGE = 500;
    private static final int LUXURY_SUV_BASE_MILEAGE = 750;
    private static final int LUXURY_TRUCK_BASE_MILEAGE = 700;

    private static final double MILEAGE_RATE_PER_MILE = 0.25; // Rate per additional mile

    public double calculateRentalCost(VehicleType vehicleType, int rentalDays, int milesDriven) {
        double ratePerDay;
        int baseMileage;
    
        switch (vehicleType) {
            case SEDAN:
                ratePerDay = SEDAN_RATE_PER_DAY;
                baseMileage = SEDAN_BASE_MILEAGE;
                break;
            case SUV:
                ratePerDay = SUV_RATE_PER_DAY;
                baseMileage = SUV_BASE_MILEAGE;
                break;
            case TRUCK:
                ratePerDay = TRUCK_RATE_PER_DAY;
                baseMileage = TRUCK_BASE_MILEAGE;
                break;
            case LUXURY_SEDAN:
                ratePerDay = LUXURY_SEDAN_RATE_PER_DAY;
                baseMileage = LUXURY_SEDAN_BASE_MILEAGE;
                break;
            case LUXURY_SUV:
                ratePerDay = LUXURY_SUV_RATE_PER_DAY;
                baseMileage = LUXURY_SUV_BASE_MILEAGE;
                break;
            case LUXURY_TRUCK:
                ratePerDay = LUXURY_TRUCK_RATE_PER_DAY;
                baseMileage = LUXURY_TRUCK_BASE_MILEAGE;
                break;
            default:
                throw new IllegalArgumentException("Invalid vehicle type selected");
        }
    
        double baseCost = ratePerDay * rentalDays;
    
        int additionalMiles = Math.max(0, milesDriven - baseMileage);
        double mileageCost = additionalMiles * MILEAGE_RATE_PER_MILE;
    
        return baseCost + mileageCost;
    }
    
}