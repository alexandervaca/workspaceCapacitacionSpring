package ar.com.eduit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

	//expression(<method scope> <return type> <fully qualified class name>.*(parametes))
   //execution(public int DemoClass.*(int, int))
    /*
    within(com.aspects.blog.package.*) : This will match all the methods in all classes of com.aspects.blog.package.
    within(com.aspects.blog.package..*) : This will match all the methods in all classes of com.aspects.blog.package and its sub packages. The only difference is the extra dot(.) after package.
    within(com.aspects.blog.package.DemoClass) : This will match all the methods in the DemoClass.
    within(DemoClass) : Again, if the target class is located in the same package as this aspect, the package name can be omitted.
    within(DemoInterface+) : This will match all the methods which are in classes which implement DemoInterface.

    Pointcut expressions can be combined using && (and), ||(or), and !(not). For example,

      within(DemoInterface1+) || within(DemoInterface2+)

    */

	@Pointcut(value="execution( public * ar.com.eduit.dao.*.save(..))")
	public void pointCut() {
	}
	
	@Before(value="pointCut()")
	public void logParameters(JoinPoint joinPoint){
		System.out.print(joinPoint.getSignature().toShortString() +  "logging values ");
		Object[] args =  joinPoint.getArgs();
		for (Object arg : args) {
	      System.out.print(arg);			
		}
		System.out.println();
		
	}
	
	
	@AfterReturning(value="pointCut()",returning="retVal")
	public void logReturnValue(final JoinPoint joinPoint,Object retVal){
		System.out.println( joinPoint.getSignature().getName() +  " returning " + retVal);
	}
	
	@AfterThrowing(pointcut = "execution( public * ar.com.eduit.dao.*.save(..))", throwing = "ex")
	public void logException(Throwable ex){
		ex.printStackTrace();
	}

}
