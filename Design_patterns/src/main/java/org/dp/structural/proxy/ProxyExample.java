package org.dp.structural.proxy;

public class ProxyExample {
    public static void main(String[] args) {
        SubjectProxy subjectProxy = new SubjectProxy("Tamil");
        subjectProxy.display();
        subjectProxy.display();
    }
}

interface Subject{
    void display();
}

class SubjectImpl implements Subject{
    private final String name;
    public SubjectImpl(String name){
        this.name = name;
        initializeLoading();
    }

    private void initializeLoading(){
        System.out.println("SubjectImpl is loading ..");
    }

    @Override
    public void display() {
        System.out.println("SubjectImpl is displayed ..");
    }
}

class SubjectProxy implements Subject{
    private Subject subject;
    private final String name;

    public  SubjectProxy(String name){
        this.name = name;
    }

    @Override
    public void display() {
        if (subject == null){
            subject = new SubjectImpl(name);
        }
        subject.display();
    }
}
