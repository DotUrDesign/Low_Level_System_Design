package repository;

import models.Bill;

import java.util.HashMap;

public class BillRepository {
    private HashMap<String, Bill> billHashMap = new HashMap<>();
    public void saveBill(Bill bill) {
        billHashMap.put(bill.getBillNo(), bill);
        return;
    }
}
