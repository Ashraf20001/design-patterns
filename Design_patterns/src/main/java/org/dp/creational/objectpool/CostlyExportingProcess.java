package org.dp.creational.objectpool;

public class CostlyExportingProcess {
    private Long processNo;

    public CostlyExportingProcess(Long processNo) {
        this.processNo = processNo;


        System.out.println("Object with process no. " + processNo + " was created");
    }

    public Long getProcessNo() {
        return processNo;
    }

    public void setProcessNo(Long processNo) {
        this.processNo = processNo;
    }
}
