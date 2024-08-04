import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class CarRentalGUI extends JFrame {
    // GUI components
    private JComboBox<String> vehicleTypeComboBox;
    private JTextField rentalDaysTextField;
    private JTextField customerNameTextField;
    private JTextField customerLicenseTextField;
    private JTextField milesDrivenTextField;
    private CarRentalService carRentalService;

    public CarRentalGUI() {
        carRentalService = new CarRentalService(); // Initializes the car rental service

        // Set up the main frame
        setTitle("Prestige Car Rental Service");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Set a sophisticated color scheme
        Color bgColor = new Color(30, 30, 30);
        Color fgColor = new Color(240, 240, 240);
        Color accentColor = new Color(180, 0, 60);
        Color borderColor = new Color(70, 70, 70);

        // Main content pane with GridBagLayout
        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(bgColor);
        setContentPane(contentPane);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Custom Font
        Font labelFont = new Font("Georgia", Font.BOLD, 18);
        Font textFont = new Font("Georgia", Font.PLAIN, 16);

        // Title Label
        JLabel titleLabel = new JLabel("Prestige Car Rental Service", JLabel.CENTER);
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 24));
        titleLabel.setForeground(accentColor);
        titleLabel.setBorder(new EmptyBorder(10, 0, 20, 0));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(titleLabel, gbc);

        // Vehicle Type Label and ComboBox
        JLabel vehicleTypeLabel = new JLabel("Select Vehicle:");
        vehicleTypeLabel.setFont(labelFont);
        vehicleTypeLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        contentPane.add(vehicleTypeLabel, gbc);

        vehicleTypeComboBox = new JComboBox<>(new String[]{
            "Sedan", "SUV", "Truck", 
            "Luxury Sedan", "Luxury SUV", "Luxury Truck"
        });
        vehicleTypeComboBox.setFont(textFont);
        vehicleTypeComboBox.setBackground(bgColor);
        vehicleTypeComboBox.setForeground(fgColor);
        vehicleTypeComboBox.setBorder(new LineBorder(borderColor));
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(vehicleTypeComboBox, gbc);

        // Rental Days Label and TextField
        JLabel rentalDaysLabel = new JLabel("Rental Days:");
        rentalDaysLabel.setFont(labelFont);
        rentalDaysLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(rentalDaysLabel, gbc);

        rentalDaysTextField = new JTextField();
        rentalDaysTextField.setFont(textFont);
        rentalDaysTextField.setBackground(bgColor);
        rentalDaysTextField.setForeground(fgColor);
        rentalDaysTextField.setBorder(new LineBorder(borderColor));
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPane.add(rentalDaysTextField, gbc);

        // Miles Driven Label and TextField
        JLabel milesDrivenLabel = new JLabel("Expected Miles:");
        milesDrivenLabel.setFont(labelFont);
        milesDrivenLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(milesDrivenLabel, gbc);

        milesDrivenTextField = new JTextField();
        milesDrivenTextField.setFont(textFont);
        milesDrivenTextField.setBackground(bgColor);
        milesDrivenTextField.setForeground(fgColor);
        milesDrivenTextField.setBorder(new LineBorder(borderColor));
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPane.add(milesDrivenTextField, gbc);

        // Customer Name Label and TextField
        JLabel customerNameLabel = new JLabel("Customer Name:");
        customerNameLabel.setFont(labelFont);
        customerNameLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPane.add(customerNameLabel, gbc);

        customerNameTextField = new JTextField();
        customerNameTextField.setFont(textFont);
        customerNameTextField.setBackground(bgColor);
        customerNameTextField.setForeground(fgColor);
        customerNameTextField.setBorder(new LineBorder(borderColor));
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPane.add(customerNameTextField, gbc);

        // Customer License Label and TextField
        JLabel customerLicenseLabel = new JLabel("Customer License Number:");
        customerLicenseLabel.setFont(labelFont);
        customerLicenseLabel.setForeground(fgColor);
        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPane.add(customerLicenseLabel, gbc);

        customerLicenseTextField = new JTextField();
        customerLicenseTextField.setFont(textFont);
        customerLicenseTextField.setBackground(bgColor);
        customerLicenseTextField.setForeground(fgColor);
        customerLicenseTextField.setBorder(new LineBorder(borderColor));
        gbc.gridx = 1;
        gbc.gridy = 5;
        contentPane.add(customerLicenseTextField, gbc);

        // Rent Button with custom painting for rounded corners
        JButton rentButton = new JButton("Rent Vehicle") {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque() && getBorder() instanceof RoundedBorder) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(getBackground());
                    g2.fill(((RoundedBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
                    g2.dispose();
                }
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                setOpaque(false);
                super.updateUI();
            }
        };

        rentButton.setFont(labelFont);
        rentButton.setBackground(accentColor);
        rentButton.setForeground(fgColor);
        rentButton.setFocusPainted(false);
        rentButton.setBorder(new RoundedBorder(15));
        rentButton.addActionListener(new RentButtonListener()); // Add action listener for button click
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPane.add(rentButton, gbc);

        // Ensure the layout and components are displayed properly
        contentPane.revalidate();
        contentPane.repaint();
        setVisible(true);
    }

    // Action listener for the Rent button
    private class RentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String vehicleTypeString = (String) vehicleTypeComboBox.getSelectedItem();
                VehicleType vehicleType = VehicleType.valueOf(vehicleTypeString.replace(" ", "_").toUpperCase());

                int rentalDays = Integer.parseInt(rentalDaysTextField.getText());
                int milesDriven = Integer.parseInt(milesDrivenTextField.getText());

                // Check if rental days and miles driven are greater than 0
                if (rentalDays <= 0) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Rental days must be greater than 0.");
                    return;
                }
                if (milesDriven <= 0) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Miles driven must be greater than 0.");
                    return;
                }

                String customerName = customerNameTextField.getText();
                String customerLicense = customerLicenseTextField.getText();

                if (customerName.isEmpty() || customerLicense.isEmpty()) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Please enter all customer details.");
                    return;
                }

                double cost = carRentalService.calculateRentalCost(vehicleType, rentalDays, milesDriven);

                int confirm = JOptionPane.showConfirmDialog(
                        CarRentalGUI.this, 
                        String.format(
                            "Confirm Rental?\nCustomer: %s\nVehicle: %s\nDuration: %d days\nExpected Miles: %d\nTotal Cost: $%.2f",
                            customerName, vehicleTypeString, rentalDays, milesDriven, cost
                        ),
                        "Rental Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(CarRentalGUI.this, "Rental confirmed! Thank you, " + customerName + ".");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CarRentalGUI.this, "Please enter valid numbers for rental days and miles to be driven.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(CarRentalGUI.this, "An error occurred: " + ex.getMessage());
            }
        }
    }

    // Custom Rounded Border class for buttons
    private static class RoundedBorder extends LineBorder {
        private int radius;

        RoundedBorder(int radius) {
            super(new Color(180, 0, 60), 2, true);
            this.radius = radius;
        }

        public Shape getBorderShape(int x, int y, int w, int h) {
            return new RoundRectangle2D.Float(x, y, w, h, radius, radius);
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape border = getBorderShape(x, y, width - 1, height - 1);
            g2d.setPaint(lineColor);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(border);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius + thickness, radius + thickness, radius + thickness, radius + thickness);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = radius + thickness;
            insets.top = insets.bottom = radius + thickness;
            return insets;
        }
    }

    // Main method to start the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CarRentalGUI::new);
    }
}
