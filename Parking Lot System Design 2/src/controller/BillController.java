package controller;

import DTOs.IssueBillRequestDTO;
import DTOs.IssueBillResponseDTO;
import DTOs.IssueTicketResponseDTO;
import model.Bill;
import model.enums.ResponseStatus;
import service.BillService;

public class BillController {
    private BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }
    public IssueBillResponseDTO issueBill(IssueBillRequestDTO issueBillRequestDTO) {
        Bill bill = billService.issueBill(
                issueBillRequestDTO.getTicket(),
                issueBillRequestDTO.getPayments()
        );

        IssueBillResponseDTO issueBillResponseDTO = new IssueBillResponseDTO();
        issueBillResponseDTO.setBill(bill);
        issueBillResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return issueBillResponseDTO;
    }
}
