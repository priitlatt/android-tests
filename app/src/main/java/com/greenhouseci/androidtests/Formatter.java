package com.greenhouseci.androidtests;

/**
 * Created by priit on 20.09.16.
 */

public class Formatter {

    public String stripMiddle(String s) {
        return s.replaceAll("\\s+", " ");
    }

    public String stripLeft(String s) {
        return s.replaceAll("^\\s+", "");
    }

    public String stripRight(String s) {
        return s.replaceAll("\\s+$", "");
    }

    public String strip(String s) {
        return stripLeft(stripRight(stripMiddle(s)));
    }
}