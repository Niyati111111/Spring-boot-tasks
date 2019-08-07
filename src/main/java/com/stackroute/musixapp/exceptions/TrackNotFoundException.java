package com.stackroute.musixapp.exceptions;

public class TrackNotFoundException extends Exception{
    public TrackNotFoundException(String message)
    {
        // Call constructor of parent Exception
        super(message);

    }
}
