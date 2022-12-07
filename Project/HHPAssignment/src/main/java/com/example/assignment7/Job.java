package com.example.assignment7;

public class Job {

    private int job_Id;

    private int start_Time;

    private int end_Time;

    private int profit;

    public int getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(int start_Time) {
        this.start_Time = start_Time;
    }

    public int getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(int end_Time) {
        this.end_Time = end_Time;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getJob_Id() {
        return job_Id;
    }

    public void setJob_Id(int job_Id) {
        this.job_Id = job_Id;
    }

    @Override
    public String toString() {
        return "Job [job_Id=" + job_Id + ", start_Time=" + start_Time + ", end_Time=" + end_Time + ", profit="
                + profit + "]";
    }

    public Job() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Job(int job_Id, int start_Time, int end_Time, int profit) {
        super();
        this.job_Id = job_Id;
        this.start_Time = start_Time;
        this.end_Time = end_Time;
        this.profit = profit;
    }

}
