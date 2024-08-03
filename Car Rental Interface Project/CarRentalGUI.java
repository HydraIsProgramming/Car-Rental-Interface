import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CarRentalGUI extends JFrame {
    // Declare instance variables
    private JComboBox<String> vehicleTypeComboBox;
    private JTextField rentalDaysTextField;
    private JTextField customerNameTextField;
    private JTextField customerLicenseTextField;
    private JTextField milesDrivenTextField;
    private JLabel totalCostLabel;
    private CarRentalService carRentalService;

    // Constructor to set up the GUI
    public CarRentalGUI() {
        carRentalService = new CarRentalService();

        setTitle("Car Rental Service");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Initialize and add components to the frame
        JLabel vehicleTypeLabel = new JLabel("Select Vehicle:");
        vehicleTypeComboBox = new JComboBox<>(new String[]{
            "Sedan", "SUV", "Truck", 
            "Luxury Sedan", "Luxury SUV", "Luxury Truck"
        });

        JLabel rentalDaysLabel = new JLabel("Rental Days:");
        rentalDaysTextField = new JTextField();

        JLabel milesDrivenLabel = new JLabel("Miles Driven:");
        milesDrivenTextField = new JTextField();

        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameTextField = new JTextField();

        JLabel customerLicenseLabel = new JLabel("Customer License:");
        customerLicenseTextField = new JTextField();

        JButton rentButton = new JButton("Rent Vehicle");
        rentButton.addActionListener(new RentButtonListener());

        totalCostLabel = new JLabel("Total Cost: $0.00");

        add(vehicleTypeLabel);
        add(vehicleTypeComboBox);
        add(rentalDaysLabel);
        add(rentalDaysTextField);
        add(milesDrivenLabel);
        add(milesDrivenTextField);
        add(customerNameLabel);
        add(customerNameTextField);
        add(customerLicenseLabel);
        add(customerLicenseTextField);
        add(new JLabel()); // Empty cell
        add(rentButton);
        add(new JLabel()); // Empty cell
        add(totalCostLabel);

        setVisible(true);
    }

    // Inner class to handle button click events
    private class RentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Debugging: Check if the action is being triggered
                System.out.println("Rent Vehicle button clicked!");
    
                // Get the selected vehicle type
                String vehicleTypeString = (String) vehicleTypeComboBox.getSelectedItem();
                System.out.println("Selected Vehicle Type: " + vehicleTypeString);
    
                // Convert the vehicle type string to the corresponding enum
                VehicleType vehicleType = VehicleType.valueOf(vehicleTypeString.replace(" ", "_").toUpperCase());
                System.out.println("Converted VehicleType Enum: " + vehicleType);
    
                // Parse rental days and miles driven
                int rentalDays = Integer.parseInt(rentalDaysTextField.getText());
                System.out.println("Rental Days: " + rentalDays);
    
                int milesDriven = Integer.parseInt(milesDrivenTextField.getText());
                System.out.println("Miles Driven: " + milesDriven);

                if (rentalDays <= 0) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Rental days must be greater than 0.");
                    return;
                }
                if (milesDriven <= 0) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Miles driven must be greater than 0.");
                    return;
                }
    
                // Get customer details
                String customerName = customerNameTextField.getText();
                System.out.println("Customer Name: " + customerName);
    
                String customerLicense = customerLicenseTextField.getText();
                System.out.println("Customer License: " + customerLicense);
    
                // Check if customer details are filled in
                if (customerName.isEmpty() || customerLicense.isEmpty()) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Please enter all customer details.");
                    return;
                }
    
                // Calculate the rental cost
                double cost = carRentalService.calculateRentalCost(vehicleType, rentalDays, milesDriven);
                System.out.println("Calculated Cost: $" + cost);
    
                // Update the total cost label in the GUI
                totalCostLabel.setText(String.format("Total Cost: $%.2f", cost));
    
                // Confirm rental with the user
                int confirm = JOptionPane.showConfirmDialog(CarRentalGUI.this, 
                        "Confirm Rental?\n" + 
                        "Customer: " + customerName + "\n" +
                        "Vehicle: " + vehicleTypeString + "\n" +
                        "Duration: " + rentalDays + " days\n" +
                        "Miles Driven: " + milesDriven + "\n" +
                        "Total Cost: $" + String.format("%.2f", cost), 
                        "Rental Confirmation", 
                        JOptionPane.YES_NO_OPTION);
    
                // Show confirmation message if user confirms
                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Rental confirmed! Thank you, " + customerName + ".");
                }
    
            } catch (NumberFormatException ex) {
                // Handle input parsing errors
                JOptionPane.showMessageDialog(CarRentalGUI.this, "Please enter valid numbers for rental days and miles driven.");
                ex.printStackTrace();
            } catch (Exception ex) {
                // Handle all other errors
                ex.printStackTrace();
                JOptionPane.showMessageDialog(CarRentalGUI.this, "An error occurred: " + ex.getMessage());
            }
        }
    }
    
}  // Closing brace for CarRentalGUI class
