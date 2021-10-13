package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    Statistics statistics;
    float postAverage;
    float commentAverage;
    float commentPerPostAverage;

    public StatisticsCalculator(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        if (statistics.usersNames().size() == 0) {
            postAverage = 0;
            commentAverage = 0;
        } else {
            postAverage = (float) statistics.postsCount() / (float) statistics.usersNames().size();
            commentAverage = (float) statistics.commentsCount() / (float) statistics.usersNames().size();
        }
        if (statistics.postsCount() == 0) {
            commentPerPostAverage = 0;
        } else {
            commentPerPostAverage = (float) statistics.commentsCount() / (float) statistics.postsCount();
        }
    }

    public float getPostAverage() {
        return postAverage;
    }

    public float getCommentAverage() {
        return commentAverage;
    }

    public float getCommentPerPostAverage() {
        return commentPerPostAverage;
    }

    public String showStatistics(){
        return "Average post amount per user: "+postAverage
                +"Average comments amount per user: "+commentAverage
                +"Average comment amount per post: "+commentPerPostAverage;
    }
}
