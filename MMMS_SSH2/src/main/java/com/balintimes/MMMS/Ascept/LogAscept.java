package com.balintimes.MMMS.Ascept;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAscept
{

	@Pointcut("execution(* com.balintimes.MMMS.Service.*.*(..)) and args(..)")
	// @Pointcut(value =
	// "execution(* com.balintimes.SpringJpa.*.*(..)) && args(id)",argNames="name")
	public void anyMethod()
	{

	}

	@Before("anyMethod()")
	public void doBefore(JoinPoint jp) // throws Throwable
	{
		System.out.println("===========进入before advice============ \n");
	}

	@After("anyMethod()")
	public void doAfter(JoinPoint jp) // throws Throwable
	{
		System.out.println("==========进入after advice=========== \n");
	}

}
