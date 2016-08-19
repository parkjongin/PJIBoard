package com.pji.util;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ChronometryImpl implements Chronometry{

	long startTime;
	
	@Override
	@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("start input");
	}

	@Override
	@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	@Before("@annotation(org.springframework.transaction.annotation.Transactional)")
	public void start_before(){
		startTime = System.currentTimeMillis();
	}
	
	@After("start()")
	public void start_after(){
		System.out.println("처리 시간 : " + (System.currentTimeMillis() - startTime)/1000.0 + "sec");	
	}
	
	
	
}
