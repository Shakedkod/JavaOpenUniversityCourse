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

    final int MIN_NO_OF_ROOMS = 1;
    final int DEFAULT_NO_OF_ROOMS = 3;
    final double BELOW_MIN_AREA = 0;
    final double DEFAULT_AREA = 80;
    final double BELOW_MIN_PRICE = 0;
    final double DEFAULT_PRICE = 5000;
    final int MIN_YEARS_FOR_EXTENSION = 1;
    final int MAX_DAYS_FOR_RENTAL_REPLACEMENT = 90;

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
    public boolean equals(Apartment other)
    {
        return _noOfRooms == other._noOfRooms
                && _area == other._area
                && _price == other._price
                && _tenant.equals(other._tenant)
                && _rentalStartDate.equals(other._rentalStartDate)
                && _rentalEndDate.equals(other._rentalEndDate);
    }

    public void extendRentalPeriod(int years)
    {
        if (years >= MIN_YEARS_FOR_EXTENSION)
            setRentalEndDate(_rentalEndDate.addYearsToDate(years));
    }

    public int daysLeft(Date d)
    {
        if (d.after(_rentalEndDate))
            return -1;

        return d.difference(_rentalEndDate);
    }

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
    int getNoOfRooms()
    {
        return _noOfRooms;
    }

    double getArea()
    {
        return _area;
    }

    double getPrice()
    {
        return _price;
    }

    Person getTenant()
    {
        return new Person(_tenant);
    }

    Date getRentalStartDate()
    {
        return new Date(_rentalStartDate);
    }

    Date getRentalEndDate()
    {
        return new Date(_rentalEndDate);
    }

    // Setters
    void setNoOfRooms(int num)
    {
        if (num >= MIN_NO_OF_ROOMS)
            _noOfRooms = num;
    }

    void setArea(double area)
    {
        if (area > BELOW_MIN_AREA)
            _area = area;
    }

    void setPrice(double price)
    {
        if (price > BELOW_MIN_PRICE)
            _price = price;
    }

    void setTenant(Person p)
    {
        _tenant = new Person(p);
    }

    void setRentalStartDate(Date d)
    {
        if (d.before(_rentalEndDate))
            _rentalStartDate = new Date(d);
    }

    void setRentalEndDate(Date d)
    {
        if (d.after(_rentalStartDate))
            _rentalEndDate = new Date(d);
    }
}
