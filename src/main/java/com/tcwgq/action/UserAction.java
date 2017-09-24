package com.tcwgq.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.tcwgq.model.User;
import com.tcwgq.service.UserService;

/**
 * @author tcwgq
 * @time 2017年8月27日上午10:29:59
 * @email tcwgq@outlook.com
 */
// @Namespace("/main/user")
// @ParentPackage(value="struts-default")
// @Results({
// @Result(name="success" , location="/main/desktop/desktop.jsp"),
// @Result(name="fail" , location="/main/user/login.jsp")
// })
@Controller(value = "userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1024720637524336625L;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAction.class);

	@Resource
	private UserService userService;

	@Override
	public String execute() throws Exception {
		LOGGER.info("welcome to struts2!");
		User user = new User();
		user.setUsername("wangWu");
		user.setPassword("12345");
		user.setMoney(1000000);
		userService.add(user);
		user = userService.getUserById(1);
		System.out.println(user);
		return NONE;
	}
}
