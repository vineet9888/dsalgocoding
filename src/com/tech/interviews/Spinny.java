package com.tech.interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Spinny {

    public static final String USER1 = "U1";
    public static final String USER2 = "U2";
    public static final String LOGGED_IN = "logged_in";
    public static final String LOGGED_OUT = "logged_out";
    public static final Double DAY_END_TIME = 23.59;

    public static void main(String[] args) {
        Event event1 = new Event("U1" , 0.2 , "logged_in");
        Event event2 = new Event("U2" , 0.4 , "logged_in");
        Event event3 = new Event("U1" , 1.4 , "logged_out");
        Event event4 = new Event("U1" , 4.0 , "logged_in");
        Event event5 = new Event("U2" , 5.0 , "logged_out");
        List<Event> events = new LinkedList<>();
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        events.add(event5);
        List<StartEndPair> ans = getOverlappingIntervals(events);
        for (StartEndPair item: ans) {
            System.out.println(item.startTime + " -> " + item.endTime);
        }
    }

    public static List<StartEndPair> getOverlappingIntervals(List<Event> events) {
        List<StartEndPair> ans = new LinkedList<>();
        List<StartEndPair> user1Pairs = new ArrayList<>();
        List<StartEndPair> user2Pairs = new ArrayList<>();

        for(Event event : events) {
            if(event.user.equals(USER1)) {
                addUserEventToList(user1Pairs , event);
            } else {
                addUserEventToList(user2Pairs , event);
            }
        }

        for(int i = 0 ; i < user1Pairs.size();i++) {
            StartEndPair event1 = user1Pairs.get(i);
            for(int j = 0 ; j < user2Pairs.size();j++) {
                if(doesOverlap(event1 , user2Pairs.get(j))) {
                    ans.add(mergeInterval(event1 , user2Pairs.get(j)));
                }
            }
        }
        return ans;
    }

    public static StartEndPair mergeInterval(StartEndPair first , StartEndPair second) {
        StartEndPair startEndPair = new StartEndPair(Math.max(first.startTime , second.startTime) , Math.min(second.endTime , first.endTime));
        return startEndPair;
    }

    public static boolean doesOverlap(StartEndPair first , StartEndPair second) {
        if(second.startTime <= first.endTime && second.endTime >= first.startTime) {
            return true;
        } else if(second.endTime >= first.startTime && second.endTime <= first.endTime) {
            return true;
        }
        return false;
    }

    public static void addUserEventToList(List<StartEndPair> list , Event event) {
        if(event.eventType.equals(LOGGED_IN)) {
            list.add(new StartEndPair(event.time , DAY_END_TIME));
        } else {
            if(!list.isEmpty()) {
                list.get(list.size()-1).endTime = event.time;
            }
        }
    }

}

class StartEndPair {
    Double startTime;
    Double endTime;
    StartEndPair(Double startTime , Double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Event {
    String user;
    Double time;
    String eventType;
    Event(String user , Double time , String eventType) {
        this.user = user;
        this.time = time;
        this.eventType = eventType;
    }
}
