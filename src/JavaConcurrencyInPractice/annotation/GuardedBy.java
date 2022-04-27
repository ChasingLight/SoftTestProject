package JavaConcurrencyInPractice.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解---并发锁对象
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})  //可以加载属【属性或方法】上
@Retention(RetentionPolicy.SOURCE)
public @interface GuardedBy {
    String value() default "this";
}
