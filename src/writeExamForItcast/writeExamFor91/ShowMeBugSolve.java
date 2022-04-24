package writeExamForItcast.writeExamFor91;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//原题题干---考察【动态代理可以修改方法行为；反射能创建一个类使用类中所有属性和方法】
/*
interface IA {
    String getHelloName();
}

public class ShowMeBug {
    public static void main(String[] arges) throws Exception{
        IA ia = (IA) createObject(IA.class.getName()+"$getHelloName=Abc");
        System.out.println(ia.getHelloName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName()+"$getTest=Bcd");
        System.out.println(ia.getHelloName()); //方法名不匹配的时候，输出null
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断
    public static Object createObject(String str) throws Exception {
        return null;
    }
}
*/

interface IA {
    String getHelloName();
}

//自己实现一个IA接口的实现类
class IAL implements IA{
    @Override
    public String getHelloName() {
        return "Hello World";
    }
}

//自己书写通用的---动态代理类【基于JDKProxy-底层基于接口】
class ProxyHandler implements InvocationHandler{

    private Object targetObject; //目标对象
    private String methodName; //需代理方法名
    private String returnResult;  //方法返回值

    /**
     * 获得代理对象
     * @param targetObject  被代理对象【利用-接口的全类名-无法创建接口的代理类-已测试】
     * @param methodName 需代理方法名
     * @param returnResult  方法返回值
     * @return
     */
    public Object newProxyInstance(Object targetObject, String methodName, String returnResult)
            throws Exception {

        this.targetObject = targetObject;
        this.methodName = methodName;
        this.returnResult = returnResult;

        //将被代理的对象【类加载器 && 实现接口】 作为Proxy.newProxyInstance方法的参数。
        //this 当前对象，该对象实现了InvocationHandler接口的invoke方法：通过invoke方法可以调用被代理对象的方法
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object methodReturn = method.invoke(targetObject, args);

        // 类似AOP的后增强处理
        if (method.getName().equals(methodName)){
            methodReturn = returnResult;
        }else{
            methodReturn = null;
        }
        return methodReturn;
    }
}

public class ShowMeBugSolve {

    public static void main(String[] arges) throws Exception{
        IA ia = (IA) createObject(IA.class.getName()+"$getHelloName=Abc");
        System.out.println(ia.getHelloName()); //方法名匹配的时候，输出“Abc”
        ia = (IA) createObject(IA.class.getName()+"$getTest=Bcd");
        System.out.println(ia.getHelloName()); //方法名不匹配的时候，输出null
    }

    //请实现方法createObject，接口中"getName()"方法名仅仅是个示例，不能写死判断
    public static Object createObject(String str) throws Exception {
        // 解析str
        String[] strs = str.split("\\$");
        String className = strs[0];
        String methodNameAndReturnResult = strs[1];
        String[] splits = methodNameAndReturnResult.split("=");
        String methodName = splits[0];
        String returnesult = splits[1];

        ProxyHandler proxyHandler = new ProxyHandler();
        IA ia = (IA)proxyHandler.newProxyInstance(new IAL(), methodName, returnesult);
        return ia;
    }
}