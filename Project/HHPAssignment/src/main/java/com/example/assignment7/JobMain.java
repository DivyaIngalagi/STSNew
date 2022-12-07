package com.example.assignment7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JobMain {
    static ArrayList<Job> newJobs = new ArrayList<>();

    static ArrayList<Job> jobChoosenList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        newJobs.add(new Job(1, 900, 1030, 100));
        newJobs.add(new Job(2, 1000, 1200, 500));
        newJobs.add(new Job(3, 1100, 1200, 300));

        jobMenu();

    }

    public static Job checkJobs(int jobChoice) {
        Job b = null;
        for (Job totaljob : newJobs) {
            if (totaljob.getJob_Id() == jobChoice) {
                b = totaljob;
            }
        }
        return b;
    }

    public static void checkIsExistedJob(Job selectedJob) {

        for (Job job : jobChoosenList) {
            if (job.getJob_Id() != selectedJob.getJob_Id()) {
                if (job.getStart_Time() == selectedJob.getStart_Time()
                        || job.getEnd_Time() == selectedJob.getEnd_Time()
                        || job.getEnd_Time() >= selectedJob.getStart_Time()) {
                    System.out.println("Overlapping Job Please Select Another Job");
                    jobMenu();
                }
                else {
                    jobChoosenList.add(selectedJob);
                    System.out.println("Hlo Job");
                    jobMenu();
                }
            }
            else {
                System.out.println("Job is already selected");
                jobMenu();
            }

        }
    }

    public static void jobMenu() {
        int choice = 0;
        int jobChoice = 0;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("---MENU---");
            System.out.println("1.Select Job\n0.Exit");
            System.out.println("------------------");
            System.out.println("Enter your choice");

            choice = scan.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Jobs are:");
                Iterator<Job> itr = newJobs.iterator();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }

                System.out.println("Enter Jobs Id to do:");
                jobChoice = scan.nextInt();

                Job selectedJob = checkJobs(jobChoice);

                if (jobChoosenList.isEmpty()) {
                    jobChoosenList.add(selectedJob);
                    System.out.println("Choosen Job Profit is:" + selectedJob.getProfit());
                }
                else {

                    checkIsExistedJob(selectedJob);
                }

                int count = 0, totalProfit = 0;
                // System.out.println("Choosen Job Profit is:" +
                // selectedJob.getProfit());
                for (Job job1 : newJobs) {
                    for (Job job2 : jobChoosenList) {
                        if (job2.getJob_Id() != job1.getJob_Id()) {
                            count++;
                            totalProfit += job1.getProfit();
                        }
                    }
                }
                System.out.println(
                        "The Remaining no. of jobs:" + count + " and Total Profit is:" + totalProfit);

            }
        } while (choice != 0);

    }
}
