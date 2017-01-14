package org.bu.spring.boot.misc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class BuAppInfo {

	@Value("${org.bu.boot.appname}")
	private String appname;
	@Value("${org.bu.boot.version}")
	private String version;

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
