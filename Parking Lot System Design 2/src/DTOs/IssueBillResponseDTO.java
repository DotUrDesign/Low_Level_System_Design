package DTOs;

import model.Bill;
import model.enums.ResponseStatus;

public class IssueBillResponseDTO {
    private Bill bill;
    private ResponseStatus responseStatus;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
