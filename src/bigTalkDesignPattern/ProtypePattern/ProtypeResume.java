package bigTalkDesignPattern.ProtypePattern;

import java.lang.reflect.Field;

/**
 * 原型模式---Jaden猜想验证实现
 * 利用Java反射，实现Resume简历类的原型复制。
 */
public class ProtypeResume implements Cloneable{

    private String name;
    private String sex;
    private Integer age;
    private String major;  //专业

    public ProtypeResume() {
    }

    public ProtypeResume(String name, String sex, Integer age, String major) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.major = major;
    }

    @Override
    public Object clone() {

        ProtypeResume result = null;
        try{
            // 1.反射-创建新对象
            Class cls = this.getClass();
            Object newResume = cls.newInstance();

            // 2.将当前对象this的属性值，复制到新对象中
            copyPerperties(this, newResume);

            result = (ProtypeResume)newResume;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


    /**
     * 将对象objA中的属性值，拷贝到对象objB中
     * 注意：objA和objB对应的是同一个类
     * @param objA
     * @param objB
     * @throws Exception
     */
    private void copyPerperties(Object objA, Object objB)
            throws Exception {
        Class sameCls = objA.getClass();
        Field[] fields = sameCls.getDeclaredFields();

        //根据属性列表，循环设置即可【无选择设置一遍】
        for (Field field: fields){
            Object value = field.get(objA);
            field.set(objB, value);
        }
    }


    //所有属性的get-set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "ProtypeResume{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}
