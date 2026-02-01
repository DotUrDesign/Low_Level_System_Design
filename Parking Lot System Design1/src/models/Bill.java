package models;

import java.util.List;

public class Bill extends BaseModel{
    private String billNo;
    private List<Payment> payments;
    private Gate gate;
    private Operator operator;
    private BillStatus billStatus;
    private int amount;
    private Long exitTime;
    private Ticket ticket;

}
