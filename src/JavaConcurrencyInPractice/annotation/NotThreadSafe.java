package JavaConcurrencyInPractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解---非线程安全类
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {
}
