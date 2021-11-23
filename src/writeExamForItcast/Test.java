package writeExamForItcast;

public class Test {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        operate(a,b);

        System.out.println(a + "." + b);

    }

    static void operate(StringBuffer x, StringBuffer y){
        x = x.append(y);
        y = x;
    }
}
