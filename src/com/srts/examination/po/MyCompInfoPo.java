package com.srts.examination.po;

/**
 * 
 * 2014-07-11 09:57
 * @author wyw
 *
 */
public class MyCompInfoPo {
	private String myRankNow;
	private String myBestRank;
	private String myLastScore;
	private String myBestScore;
	
	public MyCompInfoPo(){};
	public MyCompInfoPo(String myRankNow, String myBestRank,
			String myLastScore, String myBestScore) {
		this.myRankNow = myRankNow;
		this.myBestRank = myBestRank;
		this.myLastScore = myLastScore;
		this.myBestScore = myBestScore;
	}
	public String getMyRankNow() {
		return myRankNow;
	}
	public void setMyRankNow(String myRankNow) {
		this.myRankNow = myRankNow;
	}
	public String getMyBestRank() {
		return myBestRank;
	}
	public void setMyBestRank(String myBestRank) {
		this.myBestRank = myBestRank;
	}
	public String getMyLastScore() {
		return myLastScore;
	}
	public void setMyLastScore(String myLastScore) {
		this.myLastScore = myLastScore;
	}
	public String getMyBestScore() {
		return myBestScore;
	}
	public void setMyBestScore(String myBestScore) {
		this.myBestScore = myBestScore;
	}
	
	public void setAll(String myRankNow, String myBestRank,
			String myLastScore, String myBestScore) {
		this.myRankNow = myRankNow;
		this.myBestRank = myBestRank;
		this.myLastScore = myLastScore;
		this.myBestScore = myBestScore;
	}
}
