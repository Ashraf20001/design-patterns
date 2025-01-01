package org.dp.objectpool;

public class ExportTask implements Runnable{

    private ObjectPool<CostlyExportingProcess> pool;

    private int threadNo;

    public ExportTask(ObjectPool<CostlyExportingProcess> pool,int threadNo){ // Initializing the export task with pool object and thread no
        this.pool = pool;
        this.threadNo = threadNo;
    }
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        CostlyExportingProcess costlyExportingProcess = pool.borrowObject();
        System.out.println("Thread " + threadNo + ": Object with process no. "
                + costlyExportingProcess.getProcessNo() + " was borrowed");

        // After usage of the costly object, we are returning it back to the pool

        pool.returnObject(costlyExportingProcess);
        System.out.println("Thread " + threadNo +": Object with process no. "
                + costlyExportingProcess.getProcessNo() + " was returned");
    }
}
