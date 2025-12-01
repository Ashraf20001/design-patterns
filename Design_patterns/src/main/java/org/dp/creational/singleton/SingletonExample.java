package org.dp.creational.singleton;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1+" "+singleton2);

    }
}

class Singleton{

    private static Singleton instance;

    private Singleton(){
        System.out.println("Singleton instance is created..");
    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

}


// Efficient approach
class EfficientSingleton{
    public static volatile EfficientSingleton instance;

    private EfficientSingleton(){
        System.out.println("EfficientSingleton instance is created");
    }

    public static EfficientSingleton getInstance(){
        if(instance == null){
            synchronized (EfficientSingleton.class){
                if(instance == null){
                    instance = new EfficientSingleton();
                }
            }
        }
        return instance;
    }
}

// BillPughSingleton Pattern for Singleton

class BillPughSingleton{

    private BillPughSingleton(){
        System.out.println("BillPughSingleton created");
    }

    private static class BillPughStaticInnerClass{
        private static final BillPughSingleton  BILLPUGHSINGLETON = new BillPughSingleton();
    }

   public BillPughSingleton getBillPughSingleton(){
        return BillPughStaticInnerClass.BILLPUGHSINGLETON;
   }
}
