package com.nadia.crackcode.gof.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern is used when there is one to many relationship between objects such as if
 * one object is modified, its depenedent objects are to be notified automatically. Observer pattern
 * falls under behavioral pattern category.
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new Subject() {{
            setObservers(new ArrayList<Observer>() {{
                add(new HexObserver());
                add(new OctalObserver());
                add(new BinaryObserver());
            }});
        }};
        System.out.println("C H A N G E   S T A T E : " + 10);
        subject.setState(10);
        System.out.println("C H A N G E   S T A T E : " + 16);
        subject.setState(16);
        System.out.println("C H A N G E   S T A T E : " + 210);
        subject.setState(210);
        System.out.println("C H A N G E   S T A T E : " + 0);
        subject.setState(0);
    }

    protected static class Subject {
        List<Observer> observers;
        Integer state;

        public Subject() {
            observers = new ArrayList<>();
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
            notifyAllWatchers();
        }

        public List<Observer> getObservers() {
            return observers;
        }

        public void setObservers(List<Observer> observers) {
            this.observers = observers;
        }

        public void notifyAllWatchers() {
            observers.forEach(obs ->
                    obs.update(this.state));
        }
    }

    private static abstract class Observer {
        private String state;

        public abstract void update(Integer state);
    }

    private static class HexObserver extends Observer {


        @Override
        public void update(Integer state) {
            System.out.println("HEX State changed : " + Integer.toHexString(state));
        }
    }

    private static class OctalObserver extends Observer {


        @Override
        public void update(Integer state) {
            System.out.println("OCTAL State changed : " + Integer.toOctalString(state));
        }
    }

    private static class BinaryObserver extends Observer {


        @Override
        public void update(Integer state) {
            System.out.println("BINARY State changed : " + Integer.toBinaryString(state));
        }
    }
}
