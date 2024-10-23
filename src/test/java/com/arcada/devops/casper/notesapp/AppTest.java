package com.arcada.devops.casper.notesapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

	private App app;

    @BeforeEach
    public void setUp() {
        // Instantiate the App class before each test
    	app = new App();
    }
 // Performance test for valid profile link with friends
    @Test
    public void testGetFriendsList_Performance_ValidProfile() {
        long startTime = System.nanoTime();
        app.getFriendsList("profile");
        long endTime = System.nanoTime();
        double durationInMs = (endTime - startTime) / 1_000_000.0;

        // Print the time taken for the test in Ms
        System.out.printf("Time taken for valid profile: %.3f ms%n", durationInMs);
    }

    // Performance test for valid profile link with no friends
    @Test
    public void testGetFriendsList_Performance_NoFriends() {
        long startTime = System.nanoTime();
        app.getFriendsList("no_friends_profile");
        long endTime = System.nanoTime();
        double durationInMs = (endTime - startTime) / 1_000_000.0;

        // Print the time taken for the test in Ms
        System.out.printf("Time taken for valid profile: %.3f ms%n", durationInMs);
    }
    
    // Positive test: Valid link with friends
    @Test
    public void testGetFriendsList_ValidProfile() {
        String[] friends = app.getFriendsList("profile");
        assertNotNull(friends);
        assertEquals(3, friends.length);
        assertArrayEquals(new String[] {"Casper", "Ronald", "Gerald"}, friends);
    }

    // Negative test: empty link
    @Test
    public void testGetFriendsList_InvalidProfile_EmptyLink() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	app.getFriendsList("");
        });
        assertEquals("Profile link is invalid", exception.getMessage());
    }

    // Negative test: Null link
    @Test
    public void testGetFriendsList_NullProfile() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        	app.getFriendsList(null);
        });
        assertEquals("Profile link is invalid", exception.getMessage());
    }

    // Edge case: Valid link with no friends
    @Test
    public void testGetFriendsList_ValidProfile_NoFriends() {
        String[] friends = app.getFriendsList("no_friends_profile");
        assertNotNull(friends);
        assertEquals(0, friends.length);
    }
}