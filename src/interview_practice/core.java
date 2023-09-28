package interview_practice;

class testA{
    public int a = 1;
    public testA(int a){
        System.out.println("testA"+a);
    }

    public int getA() {
        return a;
    }
}
class testB extends testA{
    public int b = 2;
    public testB(int a) {
        super(a);
        System.out.println("testB"+a);
    }

    public int getB() {
        return b;
    }
}
public class core {
    public static void main(String[] args) {

    }
}
