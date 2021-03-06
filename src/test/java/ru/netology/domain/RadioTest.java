package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {


    @Test
    void setTotalStationNoDownMin() {
        Radio rad = new Radio(50);

        int expected = rad.getMaxStation() + 1;

        int actual = rad.getTotalStation();

        assertEquals(expected, actual);
    }

    @Test
    void setTotalStationDownMin() {
        Radio rad = new Radio(-5);


        int expected = rad.getTotalStation();

        int actual = rad.getTotalStation();

        assertEquals(expected, actual);
    }


    @Test
    void aboveMaxSetNextStation() {
        Radio rad = new Radio();

        rad.setCurrentStation(rad.getMaxStation());

        rad.setNext();
        int expected = 0;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }


    @Test
    void noAboveMaxSetNextStation() {
        Radio rad = new Radio();
        rad.setCurrentStation(rad.getMinStation());

        rad.setNext();
        int expected = 1;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotSetTempAboveMax() {
        Radio rad = new Radio();

        rad.setCurrentStation(rad.getMaxStation() + 10);

        int expected = rad.getCurrentStation();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test
    void shouldNotSetTempDownMin() {
        Radio rad = new Radio();

        rad.setCurrentStation(rad.getMinStation() - 10);

        int expected = rad.getCurrentStation();

        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);

    }

    @Test
    void aboveMinSetPrevStation() {
        Radio rad = new Radio();

        rad.setCurrentStation(rad.getMinStation());

        rad.setPrev();
        int expected = 9;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void noAboveMinSetPrevStation() {
        Radio rad = new Radio();

        rad.setCurrentStation(rad.getMaxStation());

        rad.setPrev();
        int expected = 8;
        int actual = rad.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void aboveMaxSetIncreaseVolume() {
        Radio rad = new Radio(100,0,100);

        rad.setCurrentVolume(rad.getMaxVolume());

        rad.setIncreaseVolume();
        int expected = 100;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void NoAboveMaxSetIncreaseVolume() {
        Radio rad = new Radio(100,0,0);

        rad.setCurrentVolume(rad.getMinVolume());

        rad.setIncreaseVolume();
        int expected = 1;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void downMinSetDecreaseVolume() {
        Radio rad = new Radio(100,0,0);

        rad.setCurrentVolume(rad.getMinVolume());

        rad.setDecreaseVolume();
        int expected = 0;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void noDownMinSetDecreaseVolume() {
        Radio rad = new Radio(100,0,100);

        rad.setCurrentVolume(rad.getMaxVolume());

        rad.setDecreaseVolume();
        int expected = 99;
        int actual = rad.getCurrentVolume();

        assertEquals(expected, actual);
    }

}
