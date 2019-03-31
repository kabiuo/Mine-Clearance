package com.kabiuo.Entity;

public class RankingListEntity {
    private String Option;
    private String RankingId;
    private String GameName;
    private String CompletionTime;

    public RankingListEntity() {

    }

    public RankingListEntity(String option, String rankingId, String gameName, String completionTime) {
        Option = option;
        RankingId = rankingId;
        GameName = gameName;
        CompletionTime = completionTime;
    }

    public String getRankingId() {
        return RankingId;
    }

    public void setRankingId(String rankingId) {
        RankingId = rankingId;
    }

    public String getOption() {
        return Option;
    }

    public void setOption(String option) {
        Option = option;
    }

    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }

    public String getCompletionTime() {
        return CompletionTime;
    }

    public void setCompletionTime(String completionTime) {
        CompletionTime = completionTime;
    }
}
