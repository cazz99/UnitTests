package com.arcada.devops.casper.notesapp;

public class App {

    // Method to get a list of friends
    public String[] getFriendsList(String profileLink) {
        if (profileLink == null || profileLink.isEmpty()) {
            throw new IllegalArgumentException("Profile link is invalid");
        }
        //If profile exists returns the friends, else returns empty array
        if (profileLink.equals("profile")) {
            return new String[]{"Casper", "Ronald", "Gerald"};
        } else {
            return new String[]{};
        }
    }

    public static void main(String[] args) {
        App app = new App();
        String[] friends = app.getFriendsList("profile");
        System.out.println("Friends: ");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}