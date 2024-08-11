package com.zerobase.project5.common.aop;

import com.zerobase.project5.common.encrypt.Encrypt;
import com.zerobase.project5.common.encrypt.EncryptComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Optional;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class EncryptAspect {

    private final EncryptComponent encryptComponent;

    @Pointcut("execution(* com.zerobase.project5.domain.*.repository.*Repository.find*(..))")
    public void find() {
    }

    @Around("find()")
    public Object findDecrypt(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = joinPoint.proceed();

        if (proceed.getClass() == Optional.class) {

            Object o = ((Optional) proceed).orElse(null);

            if (o != null) {
                Field[] declaredFields = o.getClass().getDeclaredFields();
                for (Field f : declaredFields) {
                    Encrypt annotation = f.getAnnotation(Encrypt.class);
                    if (annotation != null) {
                        f.setAccessible(true);
                        Object o1 = f.get(o);
                        f.set(o, encryptComponent.decryptString(o1.toString()));

                    }
                }
            }
        }

        return proceed;
    }

    @Pointcut("execution(* com.zerobase.project5.domain.*.repository.*Repository.save*(..))")
    public void save() {
    }

    @Around("save()")
    public Object saveEncrypt(ProceedingJoinPoint joinPoint) throws Throwable {

        Object arg = joinPoint.getArgs()[0];

        Field[] declaredFields = arg.getClass().getDeclaredFields();

        for (Field f : declaredFields) {
            Encrypt annotation = f.getAnnotation(Encrypt.class);

            if (annotation != null) {

                        f.setAccessible(true);
                        Object o1 = f.get(arg);
                        f.set(arg, encryptComponent.encryptString(o1.toString()));

            }
        }

        return joinPoint.proceed();
    }
}
