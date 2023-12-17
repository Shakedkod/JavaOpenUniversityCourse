/**
 * This class represents a Person object
 *
 * @author Shaked Kodman Kolran
 * @version 17-12-2023
 */
public class Person
{
    String _name;
    String _id;
    Date _dateOfBirth;

    final String DEFAULT_NAME = "Someone";
    final String DEFAULT_ID = "000000000";

    // Constructors
    /**
     * constructs a person object with the given parameters.
     * @param name the name of the person
     * @param day the day of birth of the person
     * @param month the month of birth of the person
     * @param year the year of birth of the person
     * @param id the ID of the person
     */
    public Person(String name, int day, int month, int year, String id)
    {
        if (name.equals(""))
            _name = DEFAULT_NAME;
        else
            _name = name;

        _dateOfBirth = new Date(day, month, year);

        if (id.length() == 9)
            _id = id;
        else
            _id = DEFAULT_ID;
    }

    /**
     * constructs a person object from another person object
     * @param other the person object to copy from
     */
    public Person(Person other)
    {
        _name = other._name;
        _dateOfBirth = new Date(other._dateOfBirth);
        _id = other._id;
    }

    // Public methods
    /**
     * checks if this person object is equal to another person object
     * @param other the person object to compare to
     * @return true if the objects are equals, false if not
     */
    public boolean equals(Person other)
    {
        if (_name.equals(other._name)
                && _id.equals(other._id)
                && _dateOfBirth.equals(other._dateOfBirth)
        )
            return true;

        return false;
    }

    /**
     * Checks which person is older
     * @param other the person object to compare to
     * @return 1 if this person is older, 0 if they are at an equal age, and -1 if this person is younger
     */
    public int compareTo(Person other)
    {
        if (_dateOfBirth.before(other._dateOfBirth))
            return 1;
        else if (_dateOfBirth.after(other._dateOfBirth))
            return -1;

        return 0;
    }

    // Overrides
    /**
     * returns a string representation of the person object.
     * @return a string representing this person object.
     */
    public String toString()
    {
        return "Name: " + _name
                + "\nID: " + _id
                + "\nDate of birth: " + _dateOfBirth;
    }

    // Getters
    /**
     * Gets the person's name
     * @return the name of the person
     */
    String getName()
    {
        return _name;
    }

    /**
     * Gets the person's id
     * @return the id of the person
     */
    String getId()
    {
        return _id;
    }

    /**
     * Gets the person's date of birth
     * @return the date of birth of the person
     */
    Date getDateOfBirth()
    {
        return new Date(_dateOfBirth);
    }

    // Setters
    /**
     * Sets the name of this person
     * @param name the name to set
     */
    void setName(String name)
    {
        if (!name.equals(""))
            _name = name;
    }

    /**
     * Sets the id of this person
     * @param id the id to set
     */
    void setId(String id)
    {
        if (id.length() == 9)
            _id = id;
    }

    /**
     * Sets the date of birth of this person
     * @param d the date to set
     */
    void setDateOfBirth(Date d)
    {
        _dateOfBirth = new Date(d);
    }
}
