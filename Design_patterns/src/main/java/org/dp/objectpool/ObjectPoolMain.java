package org.dp.objectpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class ObjectPoolMain {

    private ObjectPool<CostlyExportingProcess> pool;
    private AtomicLong processNo=new AtomicLong(0);

    public void setup(){
      pool = new ObjectPool<CostlyExportingProcess>(4,10,5) {
            @Override
            protected CostlyExportingProcess construct() {
                return new CostlyExportingProcess(processNo.incrementAndGet());
            }
        };
    }

    public void testPool(){

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new ExportTask(pool,1));
        executorService.execute(new ExportTask(pool,2));
        executorService.execute(new ExportTask(pool,3));
        executorService.execute(new ExportTask(pool,4));

        executorService.shutdown();

        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void shutDown(){
        if(this.pool!=null){
            this.pool.shutDown();
        }
    }

    public static void main(String[] args) {
        ObjectPoolMain op=new ObjectPoolMain();
        op.setup();
        op.shutDown();
        op.testPool();
    }
}
