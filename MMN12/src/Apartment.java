/**
 * This class represents an Apartment object
 *
 * @author Shaked Kodman Kolran
 * @version 17-12-2023
 */
public class Apartment
{
    int _noOfRooms;
    double _area;
    double _price;
    Person _tenant;
    Date _rentalStartDate;
    Date _rentalEndDate;

    private static final int MIN_NO_OF_ROOMS = 1;
    private static final int DEFAULT_NO_OF_ROOMS = 3;
    private static final double BELOW_MIN_AREA = 0;
    private static final double DEFAULT_AREA = 80;
    private static final double BELOW_MIN_PRICE = 0;
    private static final double DEFAULT_PRICE = 5000;
    private static final int MIN_YEARS_FOR_EXTENSION = 1;
    private static final int MAX_DAYS_FOR_RENTAL_REPLACEMENT = 90;

    // Constructors
    /**
     * creates an apartment object with the given parameters.
     * @param noOfRooms the number of rooms of the apartment.
     * @param area the area of the apartment.
     * @param price the price of the rental.
     * @param tenant the tenant of the apartment.
     * @param rentalStartDay the start day of the rental.
     * @param rentalStartMonth the start month of the rental.
     * @param rentalStartYear the start year of the rental.
     * @param rentalEndDay the end day of the rental.
     * @param rentalEndMonth the end month of the rental.
     * @param rentalEndYear the end year of the rental.
     */
    public Apartment(
            int noOfRooms,
            double area,
            double price,
            Person tenant,
            int rentalStartDay,
            int rentalStartMonth,
            int rentalStartYear,
            int rentalEndDay,
            int rentalEndMonth,
            int rentalEndYear
    )
    {
        if (noOfRooms < MIN_NO_OF_ROOMS)
            _noOfRooms = DEFAULT_NO_OF_ROOMS;
        else
            _noOfRooms = noOfRooms;

        if (area <= BELOW_MIN_AREA)
            _area = DEFAULT_AREA;
        else
            _area = area;

        if (price <= BELOW_MIN_PRICE)
            _price = DEFAULT_PRICE;
        else
            _price = price;

        _tenant = new Person(tenant);

        _rentalStartDate = new Date(rentalStartDay, rentalStartMonth, rentalStartYear);
        _rentalEndDate = new Date(rentalEndDay, rentalEndMonth, rentalEndYear);

        if (!_rentalStartDate.after(_rentalEndDate))
        {
            _rentalEndDate = new Date(_rentalStartDate);
            _rentalEndDate.addYearsToDate(1);
        }
    }

    /**
     * creates an apartment object from a given apartment object
     * @param other the apartment object to copy from
     */
    public Apartment(Apartment other)
    {
        _noOfRooms = other._noOfRooms;
        _area = other._area;
        _price = other._price;
        _tenant = new Person(other._tenant);
        _rentalStartDate = new Date(other._rentalStartDate);
        _rentalEndDate = new Date(other._rentalEndDate);
    }

    // Public methods
    /**
     * checks if this apartment object is equal to another apartment object
     * @param other the apartment object to compare to
     * @return true if the objects are equal, false if not
     */
    public boolean equals(Apartment other)
    {
        return _noOfRooms == other._noOfRooms
                && _area == other._area
                && _price == other._price
                && _tenant.equals(other._tenant)
                && _rentalStartDate.equals(other._rentalStartDate)
                && _rentalEndDate.equals(other._rentalEndDate);
    }

    /**
     * extend the rental time by number of years given
     * @param years the number of years to add
     */
    public void extendRentalPeriod(int years)
    {
        if (years >= MIN_YEARS_FOR_EXTENSION)
            setRentalEndDate(_rentalEndDate.addYearsToDate(years));
    }

    /**
     * calculates the number of days left for the rental
     * @param d the date to check from
     * @return the number of days left for the rental from the date d.
     */
    public int daysLeft(Date d)
    {
        if (d.after(_rentalEndDate))
            return -1;

        return d.difference(_rentalEndDate);
    }

    /**
     * checks if the current tenant can replace himself, if he can, replaces the tenant, the price and the end date
     * @param startDate the new start date of the new rental
     * @param p the new person to be the tenant
     * @param price the new price of the new rental
     * @return true if the tenant change and false if did not
     */
    public boolean changeTenant(Date startDate, Person p, double price)
    {
        if ((p.compareTo(_tenant) == -1)
                && (price >= _price)
                && (startDate.difference(_rentalEndDate) <= MAX_DAYS_FOR_RENTAL_REPLACEMENT)
        )
        {
            _rentalStartDate = new Date(startDate);
            _tenant = new Person(p);
            _price = price;

            _rentalEndDate = new Date(_rentalStartDate);
            _rentalEndDate.addYearsToDate(1);

            return true;
        }

        return false;
    }

    // Overrides
    /**
     * creates a string representation of an apartment
     * @return a string representation of this apartment
     */
    public String toString()
    {
        return "Number of rooms: " + _noOfRooms +
                "\nArea: " + _area +
                "\nPrice: " + _price + " NIS" +
                "\nTenant name: " + _tenant.getName() +
                "\nRental start date: " + _rentalStartDate +
                "\nRental end date: " + _rentalEndDate;
    }

    // Getters
    /**
     * Gets the apartment's number of rooms
     * @return the number of rooms of the apartment
     */
    int getNoOfRooms()
    {
        return _noOfRooms;
    }

    /**
     * Gets the apartment's area
     * @return the area of the apartment
     */
    double getArea()
    {
        return _area;
    }

    /**
     * Gets the apartment's price
     * @return the price of the apartment
     */
    double getPrice()
    {
        return _price;
    }

    /**
     * Gets the apartment's tenant
     * @return the tenant of the apartment
     */
    Person getTenant()
    {
        return new Person(_tenant);
    }

    /**
     * Gets the rental's start date
     * @return the start date of the rental
     */
    Date getRentalStartDate()
    {
        return new Date(_rentalStartDate);
    }

    /**
     * Gets the rental's end date
     * @return the end date of the rental
     */
    Date getRentalEndDate()
    {
        return new Date(_rentalEndDate);
    }

    // Setters
    /**
     * Sets the number of rooms of this apartment
     * @param num the number of rooms to set
     */
    void setNoOfRooms(int num)
    {
        if (num >= MIN_NO_OF_ROOMS)
            _noOfRooms = num;
    }

    /**
     * Sets the area of this apartment
     * @param area the area to set
     */
    void setArea(double area)
    {
        if (area > BELOW_MIN_AREA)
            _area = area;
    }

    /**
     * Sets the price of this apartment
     * @param price the price to set
     */
    void setPrice(double price)
    {
        if (price > BELOW_MIN_PRICE)
            _price = price;
    }

    /**
     * Sets the tenant of this apartment
     * @param p the person to set
     */
    void setTenant(Person p)
    {
        _tenant = new Person(p);
    }

    /**
     * Sets the start date of the rental
     * @param d the date to set
     */
    void setRentalStartDate(Date d)
    {
        if (d.before(_rentalEndDate))
            _rentalStartDate = new Date(d);
    }

    /**
     * Sets the end date of the rental
     * @param d the date to set
     */
    void setRentalEndDate(Date d)
    {
        if (d.after(_rentalStartDate))
            _rentalEndDate = new Date(d);
    }
}
