package org.bu.spring.boot.misc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class BuRandom {

	@Value("${org.bu.random.value}")
	private String value;
	@Value("${org.bu.random.number}")
	private int number;
	@Value("${org.bu.random.bignumber}")
	private long bignumber;
	@Value("${org.bu.random.int1}")
	private int int1;
	@Value("${org.bu.random.int2}")
	private int int2;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getBignumber() {
		return bignumber;
	}

	public void setBignumber(long bignumber) {
		this.bignumber = bignumber;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
