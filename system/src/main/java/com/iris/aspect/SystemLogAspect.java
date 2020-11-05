package com.iris.aspect;

import com.iris.aspect.annotation.SystemLog;
import com.iris.model.entity.SysOperationLog;
import com.iris.model.mapper.SysOperationLogMapper;
import com.iris.utils.request.RequestUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author WindChaser
 * @createTime 2020-09-15 15:42
 * @description SystemLogAspect 日志切面
 */
@Aspect
@Component
public class SystemLogAspect {

    @Resource private SysOperationLogMapper sysOperationLogMapper;

    /**表示匹配带有自定义注解的方法*/
    @Pointcut("@annotation(com.iris.aspect.annotation.SystemLog)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        Object result = null;
        long beginTime = System.currentTimeMillis();

        try {

            result = point.proceed();
            long endTime = System.currentTimeMillis();
            insertLog(point,request,endTime-beginTime);
        } catch (BadCredentialsException | InternalAuthenticationServiceException e) {

            throw e;
        } catch (Throwable throwable) {

            throwable.printStackTrace();
        }

        return result;
    }

    private void insertLog(ProceedingJoinPoint point, HttpServletRequest request, long time) {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SystemLog systemLog = method.getAnnotation(SystemLog.class);

        SysOperationLog sysOperationLog = new SysOperationLog();
        if (systemLog != null) {
            // 注解上的描述
            sysOperationLog.setOperationTitle(systemLog.description());
        }

        StringBuffer url = request.getRequestURL();
        // 获取主域名 (url - uri) + projectName
        String domain = url.delete(url.length() - request.getRequestURI().length(), url.length())
                .append(request.getServletContext().getContextPath()).toString();

        sysOperationLog.setRequestIp(RequestUtil.getIpAddress(request));
        sysOperationLog.setExecutionTime((int) time);
        sysOperationLog.setDomain(domain);
        sysOperationLog.setRequestUri(request.getRequestURI());
        sysOperationLog.setRequestMethod(request.getMethod());
        sysOperationLog.setRequestParams(Arrays.toString(point.getArgs()));

        sysOperationLogMapper.insert(sysOperationLog);
    }
}
