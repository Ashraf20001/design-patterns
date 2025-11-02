package org.dp.behavioural;

public class ChainOfResponsibility {
    public static void main(String[] args) {

        Request easyRequest = new Request(Type.EASY);
        Request mediumRequest = new Request(Type.MEDIUM);
        Request advancedRequest = new Request(Type.ADVANCED);
        Level3Process level3Process = new Level3Process(null);
        Level2Process level2Process = new Level2Process(level3Process);
        Level1Process level1Process = new Level1Process(level2Process);
        level1Process.handleRequest(mediumRequest);
    }
}

abstract class Support{
    public Support supportProcessors;

    public Support(Support supportProcessors){
        this.supportProcessors = supportProcessors;
    }

    protected abstract void handleRequest(Request request);
}

enum Type{
    EASY, MEDIUM , ADVANCED
}

class Request {
    private Type requestType;

    public Request(Type requestType) {
        this.requestType = requestType;
    }

    public Type getRequestType() {
        return requestType;
    }

    public void setRequestType(Type requestType) {
        this.requestType = requestType;
    }
}

class Level1Process extends Support{
    public Level1Process(Support nextProcess){
        super(nextProcess);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getRequestType() == Type.EASY){
            System.out.println("Level 1 support is processing ..");
        }else if (supportProcessors !=null) {
            supportProcessors.handleRequest(request);
        }
    }


}

class Level2Process extends Support{
    public Level2Process(Support nextProcess){
        super(nextProcess);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getRequestType() == Type.MEDIUM){
            System.out.println("Level 2 support is processing ..");
        }else if (supportProcessors !=null) {
            supportProcessors.handleRequest(request);
        }
    }
}

class Level3Process extends Support{
    public Level3Process(Support nextProcess){
        super(nextProcess);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.getRequestType() == Type.ADVANCED){
            System.out.println("Level 3 support is processing ..");
        } else if (supportProcessors !=null) {
        supportProcessors.handleRequest(request);
        }
    }
}

