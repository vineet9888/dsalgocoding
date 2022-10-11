package com.ds.algo.problem.solving.Arrays;

import java.util.*;

public class JPMorgan {

    // rate limiter
    public static void main(String[] args) {
        Map<Integer , Integer> requestCache = new HashMap<>();

        requestCache.put(12 , 100);


    }


}



class RateLimiter {

    public static Map<Integer , Integer> requestCache = new HashMap<>();
    public static int NO_OF_REQUESTS = 100;


    public static void serveRequest(Integer userId) {
        if(requestCache.containsKey(userId)) {
            if(requestCache.get(userId) == 0) {
                // terminate the request
            } else {
                requestCache.put(userId , requestCache.get(userId) - 1);
            }
        } else {
            requestCache.put(userId  , NO_OF_REQUESTS);
            // run a cron job for this user ID after every 1 hour....

        }


        // epoch(key) , value(no of requests ath that instance o f time)
        Map<Integer , Integer> map;


    }

    public static void resetUserRequests() {

    }

}