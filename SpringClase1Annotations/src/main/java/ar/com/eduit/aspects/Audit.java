package ar.com.eduit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audit {

	// Before
//	@Pointcut(value = "execution( public * ar.com.eduit.dao.*.delete(..))")
//	public void pointCut() {
//	}
//
//	@Before(value = "pointCut()")
//	public void logParameters(JoinPoint joinPoint) {
//		System.out.println("before delete...");
//		Object firstArg = joinPoint.getArgs()[0];
//		if (firstArg == null) {
//			System.out.println("no se puede eliminar un objeto null...");
//		}
//	}
	
	@Around("execution( public * ar.com.eduit.dao.*.delete(..))")
	public Object isNotNull(ProceedingJoinPoint joinpoint) {
		Object firstArg = joinpoint.getArgs()[0];
		if (firstArg != null) {
			try {
				System.out.println("ok continuar");
				return joinpoint.proceed(joinpoint.getArgs());
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("no se puede eliminar un objeto null...");
		}
		return null;
	}
	
	
}
