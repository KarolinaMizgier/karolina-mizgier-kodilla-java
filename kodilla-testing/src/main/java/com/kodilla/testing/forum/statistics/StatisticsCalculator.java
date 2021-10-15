package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    Statistics statistics;
    double postAverage;
    double commentAverage;
    double commentPerPostAverage;

    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics.usersNames().size() == 0) {
            postAverage = 0;
            commentAverage = 0;
        } else {
            postAverage = (double) statistics.postsCount() / (double) statistics.usersNames().size();
            commentAverage = (double) statistics.commentsCount() / (double) statistics.usersNames().size();
        }
        if (statistics.postsCount() == 0) {
            commentPerPostAverage = 0;
        } else {
            commentPerPostAverage = (double) statistics.commentsCount() / (double) statistics.postsCount();
        }
    }

    public double getPostAverage() {
        return postAverage;
    }

    public double getCommentAverage() {
        return commentAverage;
    }

    public double getCommentPerPostAverage() {
        return commentPerPostAverage;
    }

    public String showStatistics(){
        return "Average post amount per user: "+postAverage
                +"Average comments amount per user: "+commentAverage
                +"Average comment amount per post: "+commentPerPostAverage;
    }
}
