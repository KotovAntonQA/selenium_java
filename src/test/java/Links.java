public class Links {
    private String homePage = "http://185.227.108.248:8902";
    public String getHomePage(){
        return homePage;
    }

    private String tradePage = homePage + "/trade";
    public String getTradePage(){
        return tradePage;
    }

    private String marketsPage = homePage + "/markets";
    public String getMarketsPage(){
        return marketsPage;
    }

    private String promotionsPage = homePage + "/promotions";
    public String getPromotionsPage(){
        return promotionsPage;
    }

    private String affiiliatePage = homePage + "/affiliate_page";
    public String getAffiiliatePage(){
        return affiiliatePage;
    }

    private  String leaderboardPage = homePage + "/leaderboard";
    public String getLeaderboardPage(){
        return leaderboardPage;
    }

    private String historicalDataPage = homePage + "/historical_data";
    public String getHistoricalDataPage(){
        return historicalDataPage;
    }


}
