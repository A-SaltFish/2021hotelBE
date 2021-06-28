package com.rainng.coursesystem.config.themis;

import com.rainng.coursesystem.config.themis.annotation.*;
import com.rainng.coursesystem.model.constant.UserType;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
public class PermissionScanner {
    public Permission scan(Method method) {
        Admin annotation;
        if (getAnnotation(method, NoLimit.class) != null) {
            return new Permission(false);

        } else if (getAnnotation(method, Login.class) != null) {
            return new Permission(UserType.NO, 0);

        } else if (getAnnotation(method, Customer.class) != null) {
            return new Permission(UserType.CUSTOMER);

        } else if (getAnnotation(method, Manager.class) != null) {
            return new Permission(UserType.MANAGER);

        } else if ((annotation = getAnnotation(method, Admin.class)) != null) {
            return new Permission(UserType.ADMIN, annotation.value());
        }

        return new Permission(false);
    }

    private <T extends Annotation> T getAnnotation(Method method, Class<T> annotationClass) {
        T annotation = method.getDeclaredAnnotation(annotationClass);
        if (annotation == null) {
            annotation = method.getDeclaringClass().getDeclaredAnnotation(annotationClass);
        }

        return annotation;
    }
}
