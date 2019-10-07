import org.junit.Test;

import java.time.Clock;

import static org.junit.Assert.*;

public class ClockTimeTest {

    @Test
    public void getHoursPositive() {
        //Arrange
        final ClockTime sut = new ClockTime(0,0,10000);
        final int want = 2;
        //Act
        final int have = sut.getHours();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void getMinutesPositive() {
        //Arrange
        final ClockTime sut = new ClockTime(0,0,10000);
        final int want = 46;
        //Act
        final int have = sut.getMinutes();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void getSecondsPositive() {
        //Arrange
        final ClockTime sut = new ClockTime(0,0,10000);
        final int want = 40;
        //Act
        final int have = sut.getSeconds();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void getHoursNegative(){
        //Arrange
        final ClockTime sut = new ClockTime(0,0,-10000);
        final int want = 21;
        //Act
        final int have = sut.getHours();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void getMinutesNegative(){
        //Arrange
        final ClockTime sut = new ClockTime(0,0,-10000);
        final int want = 13;
        //Act
        final int have = sut.getMinutes();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void getSecondsNegative(){
        //Arrange
        final ClockTime sut = new ClockTime(0,0,-10000);
        final int want = 20;
        //Act
        final int have = sut.getSeconds();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void isSameTrue(){
        //Arrange
        final ClockTime sut = new ClockTime(10,20,30);
        final ClockTime that = new ClockTime(10,20,30);
        final boolean want = true;
        //Act
        final boolean have = sut.isSame(that);
        //Arrange
        assertEquals(want, have);
    }

    @Test
    public void isSameFalse(){
        //Arrange
        final ClockTime sut = new ClockTime(10,20,30);
        final ClockTime that = new ClockTime(10,21,30);
        final boolean want = false;
        //Act
        final boolean have = sut.isSame(that);
        //Arrange
        assertEquals(want, have);
    }

    @Test
    public void add(){
        //Arrange
        final ClockTime sut = new ClockTime(1,1,10);
        final int want = 3680;
        //Act
        sut.add(10);
        final int have = sut.getTimeInSeconds();
        //Assert
        assertEquals(want, have);
    }

    @Test
    public void diffPositive(){
        //Arrange
        final ClockTime sut = new ClockTime(0,0,0);
        final ClockTime that = new ClockTime(0,0,1);
        final int want = 1;
        //Act
        final int have = sut.diff(that);
        //Arrange
        assertEquals(want, have);
    }

    @Test
    public void diffNegative(){
        //Arrange
        final ClockTime sut = new ClockTime(0,0,1);
        final ClockTime that = new ClockTime(0,0,0);
        final int want = 86399;
        //Act
        final int have = sut.diff(that);
        //Arrange
        assertEquals(want, have);
    }
}