public class Date
{
    int _day;
    int _month;
    int _year;

    final int MIN_YEAR = 1000;
    final int MIN_MONTH = 1;
    final int MAX_MONTH = 12;
    final int MIN_DAY = 1;
    final int MAX_DAY_IN_31_DAY_MONTH = 31;
    final int MAX_DAY_IN_30_DAY_MONTH = 30;
    final int MAX_DAY_IN_SEPTEMBER_NORM = 28;
    final int MAX_DAY_IN_SEPTEMBER_LEAP = 29;

    // constructors
    public Date(int day, int month, int year)
    {
        if (!isDateValid(day, month, year))
        {
            _year = 2000;
            _month = 1;
            _day = 1;
        }
        else
        {
            _year = year;
            _month = month;
            _day = day;
        }
    }

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
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return !(day < MIN_DAY || day > MAX_DAY_IN_31_DAY_MONTH);

            case 4:
            case 6:
            case 9:
            case 11:
                return !(day < MIN_DAY || day > MAX_DAY_IN_30_DAY_MONTH);

            case 2:
                if (isLeapYear(year))
                    return !(day < MIN_DAY || day > MAX_DAY_IN_SEPTEMBER_LEAP);
                else
                    return !(day < MIN_DAY || day > MAX_DAY_IN_SEPTEMBER_NORM);
        }

        return false;
    }

    private boolean isLeapYear(int y)
    {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
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

    public boolean after(Date other)
    {
        return other.before(this);
    }

    public boolean equals(Date other)
    {
        return (_year == other._year) && (_month == other._month) && (_day == other._day);
    }

    // overrides


    // getters
    public int getDay()
    {
        return _day;
    }

    public int getMonth()
    {
        return _month;
    }

    public int getYear()
    {
        return _year;
    }

    // setters
    public void setDay(int dayToSet)
    {
        if (isDateValid(dayToSet, _month, _year))
            _day = dayToSet;
    }

    public void setMonth(int monthToSet)
    {
        if (isDateValid(_day, monthToSet, _year))
            _month = monthToSet;
    }

    public void setYear(int yearToSet)
    {
        if (isDateValid(_day, _month, yearToSet))
            _year = yearToSet;
    }
}
