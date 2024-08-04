public class Customer {
    /* The Customer class represent the traditional customer renting a vehicle within a rental agency. 
    The class gathers the customer personal information to identify them within its network gathering inputs
    such as name and drivers license.
     */
    private String name;
    private String license;

    public Customer(String name, String license) {
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public String getLicense() {
        return license;
    }
}
