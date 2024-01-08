package kr.co.seoulit.erp.logistic.sales.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OutputTO {
    private String outputNumber;
    private String contractNo;
    private String requestDate;
    private String customerName;
    private String warehouseCode;
    private String requestPerson;
    private String requestDeadline;
    private String description;

    private String outputDetailNumber;
    private String itemCode;
    private String itemName;
    private String standard;
    private String dueDate;
    private String expectedArrivalDate;
    private String unitOfStock;
    private String requestQuantity;
    private String inspection;
}
