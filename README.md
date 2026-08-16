# Car Rental Interface

A Java Swing rental quote application that calculates vehicle costs from the selected category, rental duration, and expected mileage.

This group coursework project demonstrates object-oriented design, separation of business logic from presentation, input validation, and event-driven desktop interfaces using only the Java standard library.

## Features

- Six vehicle categories with distinct daily rates and mileage allowances
- Automatic excess-mileage calculations
- Validation for rental duration, mileage, customer name, and licence number
- Itemized confirmation showing the customer, vehicle, duration, mileage, and total
- Clear separation between the Swing interface and pricing service

## Pricing model

| Vehicle | Daily rate | Included mileage |
| --- | ---: | ---: |
| Sedan | $60 | 2,000 miles |
| SUV | $100 | 3,500 miles |
| Truck | $150 | 3,000 miles |
| Luxury Sedan | $120 | 500 miles |
| Luxury SUV | $170 | 750 miles |
| Luxury Truck | $200 | 700 miles |

Mileage beyond the included allowance is billed at `$0.25` per mile.

```text
estimated total = daily rate * rental days
                + max(0, expected miles - included miles) * $0.25
```

## Design

The application keeps the main responsibilities separate:

- `CarRentalGUI` builds the Swing form, validates input, and manages confirmation dialogs.
- `CarRentalService` owns the rate table and cost calculation.
- `VehicleType` defines the supported vehicle categories.
- `Customer` models the renter's name and licence number.
- `CarRentalApp` provides the application entry point.

This structure allows the pricing rules to change without rebuilding the interface logic.

## Run locally

### Prerequisites

- A Java Development Kit (JDK)

### Setup

```bash
git clone https://github.com/HydraIsProgramming/Car-Rental-Interface.git
cd Car-Rental-Interface
javac CarRentalApp.java CarRentalGUI.java CarRentalService.java Customer.java VehicleType.java
java CarRentalApp
```

## Project structure

| Path | Purpose |
| --- | --- |
| `CarRentalApp.java` | Application entry point |
| `CarRentalGUI.java` | Swing form, validation, and confirmation workflow |
| `CarRentalService.java` | Vehicle rates and mileage calculations |
| `VehicleType.java` | Supported vehicle categories |
| `Customer.java` | Customer data model |
| `CP317 Report.docx` | Original project report |

## Scope

This is a coursework quote calculator, not a production reservation platform. It does not manage fleet inventory, persist customer records, process payments, calculate taxes or insurance, or create legally binding bookings.
