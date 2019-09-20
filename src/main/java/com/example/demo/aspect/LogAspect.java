package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//AOPクラス
@Aspect
@Component
public class LogAspect {
	// AOPの実装で、JoinPointでタイミングをさす
	//@Before("execution(* com.example.demo.controller.BookController.index(..))")
	// すべてのメソッドにする場合は、BookController.*(..)にする
	@Before("execution(* *..*..*BookController.index(..))")
	public void startLog(JoinPoint jp) {
		System.out.println("indexページに飛びます：" + jp.getSignature());
	}

	@After("execution(* *..*..*BookController.index(..))")
	public void endLog(JoinPoint jp) {
		System.out.println("indexページに飛びました：" + jp.getSignature());
	}

}
