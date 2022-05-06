package bigTalkDesignPattern.ObserverPatternImplByEventHandler.event;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * 事件对象
 * 注意：重写hashCode和equals方法
 */
public class Event {
    private Object object;  //观察者对象
    private String methodName;  //方法名
    private Object[] params;   //方法参数列表
    private Class[] paramTypes;  //方法参数列表类型


    // 根据参数列表，生成参数列表类型数组
    private void convertParamsToParamsTypes(Object[] params){
        if (null != params){
            this.paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++) {
                this.paramTypes[i] = params[i].getClass();
            }
        }
    }

    // 校验构造Event的参数
    private void validateEventConstructorParms(Object object, String methodName, Object... params){

        //将参数转换为参数类型列表
        convertParamsToParamsTypes(params);

        if (null == object){
            throw new IllegalArgumentException("object must be not null");
        }

        if (null == methodName || methodName.trim().length()==0){
            throw new IllegalArgumentException("methodName must be not null or empty string");
        }

        //反射机制---根据Object和String methodName获取对应的执行方法Method
        try {
            Method method = object.getClass().getMethod(methodName, this.paramTypes);
        } catch (NoSuchMethodException e) {
            try {
                Method method = object.getClass().getDeclaredMethod(methodName, this.paramTypes);
            } catch (NoSuchMethodException e1) {
                throw new RuntimeException(String.format("对象%s没有参数类型为%s的方法%s,异常:%s",object.toString(), Arrays.toString(paramTypes),methodName,e));
            }
            throw new RuntimeException(String.format("对象%s参数类型为%s的%s方法为private私有的-不可访问,异常:%s",object.toString(),Arrays.toString(paramTypes),methodName,e));
        }
    }

    // 构造方法
    public Event(Object object, String methodName, Object... params) {
        validateEventConstructorParms(object, methodName, params);

        this.object = object;
        this.methodName = methodName;
        this.params = params;
    }

    //执行事件方法调用
    public void invoke() throws Exception {
        Method method = object.getClass().getMethod(methodName, this.paramTypes);
        method.invoke(this.object, this.params);
    }

    //重写hashCode和equals方法，方便后续移除Event
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(object, event.object) &&
                Objects.equals(methodName, event.methodName) &&
                Arrays.equals(params, event.params) &&
                Arrays.equals(paramTypes, event.paramTypes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(object, methodName);
        result = 31 * result + Arrays.hashCode(params);
        result = 31 * result + Arrays.hashCode(paramTypes);
        return result;
    }
}
