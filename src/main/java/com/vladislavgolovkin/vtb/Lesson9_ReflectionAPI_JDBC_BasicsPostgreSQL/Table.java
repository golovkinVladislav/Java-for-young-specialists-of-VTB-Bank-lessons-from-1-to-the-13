package com.vladislavgolovkin.vtb.Lesson9_ReflectionAPI_JDBC_BasicsPostgreSQL;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String title();
}
