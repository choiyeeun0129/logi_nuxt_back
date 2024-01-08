package kr.co.seoulit.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
@Component
@Aspect
@Slf4j
public class LoggerAspect {
	  //Logger log = LoggerFactory.getLogger(getClass());
	
	@Around("execution(* com..handler.*.*(..)) or execution(* com..service.*.*(..)) or execution(* com..dao.*.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();
		if (name.indexOf("Handler") > -1) {
			type = "handler  \t:  ";
		}
		else if (name.indexOf("Facade") > -1) {
			type = "ServiceFacadeImpl  \t:  ";
		}
		else if (name.indexOf("DAO") > -1) {
			type = "DAO  \t\t:  ";
		}
		else if (name.indexOf("Repository") > -1) {
			type = "Repository  \t\t:  ";
		}
		
		if(log.isInfoEnabled())
		log.info(type + name + "." + joinPoint.getSignature().getName() + "()");
		
		Object obj = joinPoint.proceed();
		
		return obj;
	}
}
 