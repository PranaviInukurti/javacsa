package com.nighthawk.spring_portfolio.mvc.person;

import java.util.HashMap;
import java.util.Map;

public class StepTracker {
    
    int activeDays;
    int days ;
    private int stepsGoal;
    private Map<Integer, Integer> dayStepsMap ;

    public StepTracker(){

        stepsGoal = 0;
        dayStepsMap = new HashMap<>();

    }
    public StepTracker(int steps){
        dayStepsMap = new HashMap<>();
        this.stepsGoal = steps;
    }

    public int activeDays(){
        return activeDays;
    }

    public double averageSteps(){

        double avgSteps = 0.0;
        long totalSteps = 0;
        for(int value: dayStepsMap.values()){
            totalSteps +=value ;
        }
        if(dayStepsMap.size() >0 ){
            avgSteps = totalSteps / dayStepsMap.size();
        }
        return avgSteps;
    }

    public void addDailySteps(int steps){
        days ++;
        dayStepsMap.put(days, steps);

        if(steps >= stepsGoal){
            activeDays ++;
        }

    }
    public static void main(String[] args) {

        StepTracker tr = new StepTracker(10000);
        System.out.println("ActiveDays :" + tr.activeDays);
        System.out.println("Average Steps  :" + tr.averageSteps());
        tr.addDailySteps(9000);
        System.out.println("Added 9000 daily steps");
        tr.addDailySteps(5000);
        System.out.println("Added 5000 daily steps");
        System.out.println("ActiveDays :" + tr.activeDays);

        System.out.println("Average Steps :" + tr.averageSteps());

        tr.addDailySteps(13000);
        System.out.println("Added 13000 daily steps");
        System.out.println("ActiveDays :" + tr.activeDays);
        System.out.println("Average Steps :" + tr.averageSteps());

        tr.addDailySteps(23000);
        System.out.println("Added 23000 daily steps");
        tr.addDailySteps(1111);
        System.out.println("Added 1111 daily steps");

        System.out.println("ActiveDays :" + tr.activeDays);
        System.out.println("Average Steps :" + tr.averageSteps());
    }
}
