package com.balintimes.MMMS.Ascept;
 

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ActionAscept
{
	private static Logger logger = org.slf4j.LoggerFactory
			.getLogger(ActionAscept.class.getSimpleName());

	@Pointcut("execution(* com.balintimes.MMMS.Controller.*.*(..)) and args(..) "
			+ " and !com.balintimes.MMMS.Controller.*.set*())"
			+ " and !com.balintimes.MMMS.Controller.*.get*())")
	// @Pointcut(value =
	// "execution(* com.balintimes.SpringJpa.*.*(..)) && args(id)",argNames="name")
	public void anyMethod()
	{

	}

	@Before("anyMethod()")
	public void doBefore(JoinPoint jp) // throws Throwable
	{
		System.out.println("===========进入 Controller before advice============ \n");

		System.out.println("===========进入 Controller before advice " + ActionAscept.class.getSimpleName() + "============ \n");

		MDC.put("Exception", "Exception");
		MDC.put("Action", "Action");
		MDC.put("Method", jp.getSignature().toString());
		MDC.put("ClientIp", "ClientIp");
		MDC.put("RequestUrl", ServletActionContext.getRequest().getServletPath());
		MDC.put("AppUid", "AppUid");
		MDC.put("AppName", "AppName");
		MDC.put("UserUid", "UserUid");
		MDC.put("UserName", "UserName");
		MDC.put("EmpUid", "EmpUid");
		MDC.put("EmpName", "EmpName");
		JSONObject jsonObject = new JSONObject();
		MDC.put("Params", jsonObject.accumulate("params", jp.getArgs()).toString());
 
		logger.info("message");

		MDC.clear();

	}

	@After("anyMethod()")
	public void doAfter(JoinPoint jp) // throws Throwable
	{
		System.out .println("==========进入 Controller after advice=========== \n");
	} 
	
	@AfterThrowing("anyMethod()")
	public void doThrowing(JoinPoint jp)
	{
		System.out .println("############# 出现异常 ############### \n");
	}
}
