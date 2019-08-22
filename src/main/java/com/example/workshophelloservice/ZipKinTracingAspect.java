package com.example.workshophelloservice;

import brave.ScopedSpan;
import brave.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Aspect
public class ZipKinTracingAspect {
    @Value("${spring.application.name}")
    private String appName;

    @Inject
    private Tracer tracer;

    private ScopedSpan startNewSpan(String serviceName, String methodSignature) {
        final StringBuilder spanNameBuilder = new StringBuilder("/").append(methodSignature);

        final ScopedSpan span = tracer.startScopedSpan(spanNameBuilder.toString());
        if(span != null) {
            span.tag("peer.service", serviceName);
        }

        return span;
    }

    private void addErrorDetailsToSpan(ScopedSpan span, Throwable throwable) {
        if (span == null) {
            return;
        }

        span.error(throwable);
    }

    private void closeSpan(ScopedSpan span) {
        if (span == null) {
            return;
        }

        span.finish();
    }

    @Around("execution(public * com.example.workshophelloservice..*(..))")
    public Object traceAllMethodCalls(ProceedingJoinPoint pJoinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature)pJoinPoint.getSignature();

        // We add local-ops after service name to signify that these spans are for internal method calls
        final String serviceName = appName + "-" + "local-ops";

        final String targetMethodSignature = methodSignature.toShortString();
        final ScopedSpan span = startNewSpan(serviceName, targetMethodSignature);
        try {
            return pJoinPoint.proceed();
        } catch (Exception exception) {
            addErrorDetailsToSpan(span, exception);
            throw exception;
        } finally {
            closeSpan(span);
        }
    }
}
