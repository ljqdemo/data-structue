class Chair{
    public int i;
    public static int created = 0;
    public Chair() {
        i = ++created;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("第" + i +"个Chair调用finalize方法");
    }
}
public class Garbage{
    public static void main(String[] args) {
        for (int i = 0; i < 47; ++i) {
            new Chair();
            //System.out.println("runfinalize");
            System.gc();
            System.runFinalization(); 
           
        }
    }
}