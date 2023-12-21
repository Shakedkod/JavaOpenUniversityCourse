/**
 * This class represent a date object.
 *
 * @author Shaked Kodman Kolran
 * @version 21-12-23
 */
public class Date
{
    private int _day;
    private int _month;
    private int _year;

    private static final int MIN_YEAR = 1000;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int DEFAULT_DAY = 1;
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_YEAR = 2000;
    private static final int LAST_DAY_IN_31_DAY_MONTH = 31;
    private static final int LAST_DAY_IN_30_DAY_MONTH = 30;
    private static final int LAST_DAY_IN_SEPTEMBER_NORM = 28;
    private static final int LAST_DAY_IN_SEPTEMBER_LEAP = 29;
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    // constructors

    /**
     * constructs a date object with the given parameters.
     * @param day the day of the date.
     * @param month the month of the date.
     * @param year the year of the date.
     */
    public Date(int day, int month, int year)
    {
        if (!isDateValid(day, month, year))
        {
            _year = DEFAULT_YEAR;
            _month = DEFAULT_MONTH;
            _day = DEFAULT_DAY;
        }
        else
        {
            _year = year;
            _month = month;
            _day = day;
        }
    }

    /**
     * constructs a date object from another date object
     * @param other the date object to copy from
     */
    public Date(Date other)
    {
        _year = other._year;
        _month = other._month;
        _day = other._day;
    }

    // private methods
    private boolean isDateValid(int day, int month, int year)
    {
        if (year < MIN_YEAR || (month < MIN_MONTH || month > MAX_MONTH))
            return false;

        switch (month)
        {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                return !(day < MIN_DAY || day > LAST_DAY_IN_31_DAY_MONTH);

            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return !(day < MIN_DAY || day > LAST_DAY_IN_30_DAY_MONTH);

            case FEBRUARY:
                if (isLeapYear(year))
                    return !(day < MIN_DAY || day > LAST_DAY_IN_SEPTEMBER_LEAP);
                else
                    return !(day < MIN_DAY || day > LAST_DAY_IN_SEPTEMBER_NORM);
        }

        return false;
    }

    private boolean isLeapYear(int y)
    {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    private boolean isLastDayOfSeptember()
    {
        if (isLeapYear(_year))
            return (_month == FEBRUARY) && (_day == LAST_DAY_IN_SEPTEMBER_LEAP);
        else
            return (_month == FEBRUARY) && (_day == LAST_DAY_IN_SEPTEMBER_NORM);
    }

    private int calculateDate(int day, int month, int year)
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

    // public methods

    /**
     * checks if this date object is equal to another date object
     * @param other the date object to compare to
     * @return true if the objects are equal, false if not
     */
    public boolean equals(Date other)
    {
        return (_year == other._year) && (_month == other._month) && (_day == other._day);
    }

    /**
     * checks if this date is before another date.
     * @param other the date to compare to
     * @return true if this date is before, false if otherwise
     */
    public boolean before(Date other)
    {
        if (_day < other._day)
        {
            if (_month <= other._month)
                return _year <= other._year;
            else
                return _year < other._year;
        }
        else
        {
            if (_month < other._month)
                return _year <= other._year;
            else
                return _year < other._year;
        }
    }

    /**
     * checks if this date is after another date.
     * @param other the date to compare to
     * @return true if this date is after, false if otherwise
     */
    public boolean after(Date other)
    {
        return other.before(this);
    }

    /**
     * calculate the difference between this date and another date
     * @param other the date to calculate the difference with
     * @return the difference in days
     */
    public int difference(Date other)
    {
        int dateInDays = calculateDate(_day, _month, _year);
        int otherDateInDays = calculateDate(other._day, other._month, other._year);

        return Math.abs(dateInDays - otherDateInDays);
    }

    /**
     * adds a number of years to this date
     * @param num the number of years to add
     * @return a new date witch is like this date but with the years added
     */
    public Date addYearsToDate(int num)
    {
        Date result = new Date(this);

        // if this year is a leap year
        if (isLeapYear(_year) && isLastDayOfSeptember())
        {
            if (isLeapYear(_year + num))
            {
                result._year += num;
            }
            else
            {
                result._year += num;
                result._day = LAST_DAY_IN_SEPTEMBER_NORM;
            }

        }
        // if the next year is a leap year
        else if (isLeapYear(_year + num) && isLastDayOfSeptember())
        {
            result._year += num;
            result._day = LAST_DAY_IN_SEPTEMBER_LEAP;
        }
        // if none of the years are leap years
        else
        {
            result._year += num;
        }

        return result;
    }

    // overrides

    /**
     * create a string representation of the Date object
     * @return a string representation of this Date object
     */
    public String toString()
    {
        if (_day < 10 && _month < 10)
            return "0" + _day + "/" + "0" + _month + "/" + _year;
        else if (_day < 10)
            return "0" + _day + "/" + _month + "/" + _year;
        else if (_month < 10)
            return _day + "/" + "0" + _month + "/" + _year;

        return _day + "/" + _month + "/" + _year;
    }

    // getters

    /**
     * Gets the date's day
     * @return the day of the date
     */
    public int getDay()
    {
        return _day;
    }

    /**
     * Gets the date's month
     * @return the month of the date
     */
    public int getMonth()
    {
        return _month;
    }

    /**
     * Gets the date's year
     * @return the year of the date
     */
    public int getYear()
    {
        return _year;
    }

    // setters
    /**
     * Sets the day of this date
     * @param dayToSet the day to set
     */
    public void setDay(int dayToSet)
    {
        if (isDateValid(dayToSet, _month, _year))
            _day = dayToSet;
    }

    /**
     * Sets the month of this date
     * @param monthToSet the month to set
     */
    public void setMonth(int monthToSet)
    {
        if (isDateValid(_day, monthToSet, _year))
            _month = monthToSet;
    }

    /**
     * Sets the year of this date
     * @param yearToSet the year to set
     */
    public void setYear(int yearToSet)
    {
        if (isDateValid(_day, _month, yearToSet))
            _year = yearToSet;
    }
}
