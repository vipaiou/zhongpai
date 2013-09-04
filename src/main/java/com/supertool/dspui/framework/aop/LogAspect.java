package com.supertool.dspui.framework.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/** 
 * 日志记录 前置增强 
 *  
 * @author zhouziqiang 
 *  
 */ 
@Aspect
public class LogAspect {
	private Logger logger = Logger.getLogger(this.getClass().getName()); 
	

	@Pointcut("execution(* com.supertool.dspui.service.user.*.*(..))&&@annotation(org.springframework.transaction.annotation.Transactional)")
	public void userServiceTrancision() {}
	
	@Pointcut("execution(* com.supertool.dspui.dao.mybatis.*.*(..))")
	public void dao() {}
	@Pointcut("execution(* com.supertool.dspui.service..*.*(..))")
	public void service() {}
	@Pointcut("execution(* com.supertool.dspui.controller.*.*(..))")
	public void controller(){}

	
	@Pointcut("execution(* com.supertool.dspui.service..*.* (. .))")
	public void serviceTranctonal(){}
	
	@Pointcut("execution(* com.supertool.dspui.security.*.* (. .))")
	public void security(){}
	@Pointcut("controller()||service()||dao()||security()")
	public void all(){}
	
   @Before("userServiceTrancision() && args(arg, . .)") 
    public void beforeExecute(JoinPoint thisJoinPoint,Object arg ){

                /*  System.out.println("连接点类型：" + thisJoinPoint.getKind());
                   System.out.println("代理类名：" + thisJoinPoint.getSourceLocation().getClass().getName());
                   System.out.println("目标类名：" + thisJoinPoint.getTarget().getClass().getName());
                   System.out.println("目标函数名：" + thisJoinPoint.getSignature().getName());
                   System.out.println("参数个数：" + thisJoinPoint.getArgs().length);

                    System.out.println("参数值：" + arg);
                   System.out.println("Before Advice!");*/
    }
   @Before("all() && args(arg, . .)") 
   public void beforeExecuteController(JoinPoint thisJoinPoint,Object arg ){

                /* System.out.println("连接点类型：" + thisJoinPoint.getKind());
                  System.out.println("代理类名：" + thisJoinPoint.getSourceLocation().getClass().getName());
                  System.out.println("目标类名：" + thisJoinPoint.getTarget().getClass().getName());
                  System.out.println("目标函数名：" + thisJoinPoint.getSignature().getName());
                  System.out.println("参数个数：" + thisJoinPoint.getArgs().length);

                   System.out.println("参数值：" + arg);
                  System.out.println("Before Advice!");*/
   }
    @AfterReturning(pointcut = "controller()", returning = "o")  

    public void afterExecuet(JoinPoint thisJoinPoint, Object o){
                // System.out.println("return " + o);
    }
    //(After Throwing Advice)
    @AfterThrowing(pointcut = "all()", throwing = "ex")  

    public void afterThrowing(JoinPoint thisJointPoint, Exception ex) throws Exception{
    	String concatName=thisJointPoint.getKind();
    	String proxyClassName=thisJointPoint.getSourceLocation().getClass().getName();
    	String targetClassName=thisJointPoint.getTarget().getClass().getName();
    	String targetFuncName=thisJointPoint.getSignature().getName();
    	int leng=thisJointPoint.getArgs().length;
    	/*System.out.println("连接点类型：" + thisJointPoint.getKind());
        System.out.println("代理类名：" + thisJointPoint.getSourceLocation().getClass().getName());
        System.out.println("目标类名：" + thisJointPoint.getTarget().getClass().getName());
        System.out.println("目标函数名：" + thisJointPoint.getSignature().getName());
        System.out.println("参数个数：" + thisJointPoint.getArgs().length);*/
    	System.out.println("\n\n********\n来自aop类"+this.getClass().getName()+"记录：\n类"+targetClassName+"的"+targetFuncName+"方法抛出异常:\n"+ex);
         logger.error("来自aop类"+this.getClass().getName()+"记录：类"+targetClassName+"的"+targetFuncName+"方法抛出异常，"+ex+"\n异常的详细信息:"+ex.fillInStackTrace()+"\n*******\n\n");
         throw new Exception(ex.getMessage());
    }
   // 后通知 (After Advice)
    @After("service()")        

   public void afterExecute(JoinPoint thisJoinPoint){
              // System.out.println("After Advice!");
    }

    //环绕通知（Around Advice）
       @Around("service()")

       public Object userOperate(ProceedingJoinPoint thisJoinPoint) throws Throwable{
              // System.out.println("Around Advice!");
                return thisJoinPoint.proceed();
     }
}
