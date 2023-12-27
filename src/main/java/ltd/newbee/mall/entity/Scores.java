package ltd.newbee.mall.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Scores {
	private double average;
	private long total;
	private long score1;
	private long score2;
	private long score3;
	private long score4;
	private long score5;
	
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getScore1() {
		return score1;
	}
	public void setScore1(long score1) {
		this.score1 = score1;
	}
	public long getScore2() {
		return score2;
	}
	public void setScore2(long score2) {
		this.score2 = score2;
	}
	public long getScore3() {
		return score3;
	}
	public void setScore3(long score3) {
		this.score3 = score3;
	}
	public long getScore4() {
		return score4;
	}
	public void setScore4(long score4) {
		this.score4 = score4;
	}
	public long getScore5() {
		return score5;
	}
	public void setScore5(long score5) {
		this.score5 = score5;
	}
	
	@Override
	public String toString() {
		return "Scores [average=" + average + ", total=" + total + ", score1=" + score1 + ", score2=" + score2
				+ ", score3=" + score3 + ", score4=" + score4 + ", score5=" + score5 + "]";
	}
	

}
