package controllers;

import DTOs.IssueBillRequestDTO;
import DTOs.IssueBillResponseDTO;
import enums.ResponseStatus;
import models.Bill;
import models.Ticket;
import services.BillService;

public class BillController {
    private BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }

    public IssueBillResponseDTO issueBill(IssueBillRequestDTO issueBillRequestDTO) {
        IssueBillResponseDTO issueBillResponseDTO = new IssueBillResponseDTO();

        try {
            Bill bill = billService.issueBill(
                    issueBillRequestDTO.getTicket(),
                    issueBillRequestDTO.getExitGateId()
            );
            issueBillResponseDTO.setBill(bill);
            issueBillResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception e) {
            issueBillResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }

        return issueBillResponseDTO;
    }
}
