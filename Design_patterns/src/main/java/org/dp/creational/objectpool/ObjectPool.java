package org.dp.creational.objectpool;

import java.util.concurrent.*;

public abstract class ObjectPool<T> {

    private ConcurrentLinkedQueue<T> poolOfObjects;

    private ScheduledExecutorService executorService;

    public ObjectPool(int minObjects){
        initialize(minObjects);
    }

    public ObjectPool(int minObjects,int maxObjects,int scheduleInterval){
        initialize(minObjects);

        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(() -> {
         if(poolOfObjects.size()<minObjects){
             int sizeToBeAdded = minObjects + poolOfObjects.size();
             for(int i=0;i<sizeToBeAdded;i++){
                 poolOfObjects.add(construct());
             }
         }

         if(poolOfObjects.size()>maxObjects){
             int sizeToBeReduced =poolOfObjects.size() - maxObjects ;
             for(int i=0;i<sizeToBeReduced;i++){
                 poolOfObjects.poll() ;
             }
         }
        },scheduleInterval,scheduleInterval, TimeUnit.SECONDS);
    }


    public void initialize(int minObject){
        poolOfObjects = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < minObject; i++) {
            poolOfObjects.add(construct());
        }

    }

    public void shutDown(){
        if (executorService!= null){
            executorService.shutdown();
        }
    }

    public T borrowObject(){
        if(poolOfObjects.poll()==null){
            return construct();
        }
        return poolOfObjects.poll();
    }

    public void returnObject(T object){
        if(poolOfObjects!=null){
            this.poolOfObjects.offer(object);
        }
    }

    protected abstract T construct();
}
