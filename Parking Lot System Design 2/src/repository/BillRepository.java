package repository;

import model.Bill;

import java.util.HashMap;

public class BillRepository {
    HashMap<String, Bill> BillHashMap = new HashMap<>();
    public void saveBill(Bill bill) {
        BillHashMap.put(bill.getBillNo(), bill);
        return;
    }
}
