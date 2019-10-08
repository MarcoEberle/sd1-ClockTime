import java.time.Clock;

/**
 * This class represents a clock time with its hours, minutes and seconds.
 */
public class ClockTime {

    /**
     * Variable with the amount of seconds per day. 86400 seconds.
     */
    private final static int SECONDS_PER_DAY = 24 * 60 * 60;

    /**
     * Variable with the amount of how many seconds this Clock has.
     * All hours and minutes are calculated into seconds.
     */
    private int timeInSeconds;

    /**
     * Default Constructor that creates a new clock time with 0 hours, 0 minutes and 0 seconds.
     */
    public ClockTime() {
        this(0, 0, 0);
    }

    /**
     * Constructor that creates a new clock time with hours, 0 minutes and 0 seconds.
     *
     * @param hours - How many hours are added to the clock/time.
     */
    public ClockTime(int hours) {
        this(hours, 0, 0);
    }

    /**
     * Constructor that creates a new clock time with hours, minutes and 0 seconds.
     *
     * @param hours   - How many hours are added to the clock/time.
     * @param minutes How many minutes are added to the clock/time.
     */
    public ClockTime(int hours, int minutes) {
        new ClockTime(hours, minutes, 0);
    }

    /**
     * Constructor that creates a clock time with hours, minutes and seconds.
     *
     * @param hours   - How many hours are added to the clock/time.
     * @param minutes - How many minutes are added to the clock/time.
     * @param seconds - How many seconds are added to the clock/time.
     */
    public ClockTime(int hours, int minutes, int seconds) {

        /**
         * allSeconds is hours, minutes and seconds added together as seconds.
         * After that, method normalize is called.
         */
        int allSeconds = hours * 60 * 60 + minutes * 60 + seconds;
        normalize(allSeconds);

    }

    /**
     * Method to check if both objects have the same time.
     *
     * @param ct - Another ClockTime object
     * @return - Returns true if they have the same time. False if not.
     */
    public boolean isSame(ClockTime ct) {
        return ct.getTimeInSeconds() == this.getTimeInSeconds();
    }

    /**
     * Method to add seconds to variable timeInSeconds.
     *
     * @param seconds - How many seconds are added to the clock.
     */
    public void add(int seconds) {
        setTimeInSeconds(getTimeInSeconds() + seconds);
    }

    /**
     * Method to calculate the difference between two Clocks
     *
     * @param ct - Another ClockTime object
     * @return - Returns the difference between these two clock times. If the value is negative, an additional day gets added.
     */
    public int diff(ClockTime ct) {
        int difference = ct.getTimeInSeconds() - this.getTimeInSeconds();

        if (difference < 0) {
            difference += SECONDS_PER_DAY;
        }
        return difference;
    }

    /**
     * Getter to return all seconds on this clock.
     *
     * @return - Returns all seconds.
     */
    public int getTimeInSeconds() {
        return timeInSeconds;
    }

    /**
     * Setter to set the time on this clock.
     *
     * @param timeInSeconds - Sets the new time of this clock with this value.
     */
    private void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    /**
     * Getter that returns the hours.
     *
     * @return - Returns the hours on this clock.
     */
    public int getHours() {
        return timeInSeconds / 3600;
    }

    /**
     * Getter that returns the minutes.
     *
     * @return - Returns the minutes on this clock.
     */
    public int getMinutes() {
        return timeInSeconds % 3600 / 60;
    }

    /**
     * Getter that returns the seconds.
     *
     * @return - Returns the seconds on this clock.
     */
    public int getSeconds() {
        return timeInSeconds % 60;
    }

    /**
     * Method that normalizes the seconds. A day has a maximum of 86400 seconds. If the given value is to high,
     * we "jump" to the next day, so our further calculations get easier.
     * Also if the value is negative we add an additional day.
     *
     * @param seconds - Amount of seconds that will be normalized on a maximum of 86400 seconds.
     */
    private void normalize(int seconds) {
        timeInSeconds = seconds % SECONDS_PER_DAY;

        if (timeInSeconds < 0) {
            timeInSeconds += SECONDS_PER_DAY;
        }
    }

    /**
     * Method that returns a String in which the time is displayed like a clock.
     *
     * @return - Returns a String with the time of this clock.
     */
    @Override
    public String toString() {
        return "The time is: " + getHours() + ":" + getMinutes() + ":" + getSeconds();
    }
}
