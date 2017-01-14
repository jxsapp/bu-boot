package org.bu.spring.boot.rest;

import javax.annotation.Resource;

import org.bu.spring.boot.misc.BuAppInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
public class BuRestController {
	@Resource
	private BuAppInfo buAppInfo;

	@ApiOperation(value = "应用信息", notes = "")
	@RequestMapping("/app")
	@ResponseBody
	public Object app() {
		return buAppInfo;
	}

	@ApiOperation(value = "Hello", notes = "")
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@ApiOperation(value = "异常信息", notes = "")
	@RequestMapping("/ex")
	public String ex() throws Exception {
		throw new Exception("发生错误");
	}
}