package org.stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
