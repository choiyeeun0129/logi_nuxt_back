package kr.co.seoulit.erp.logistic.sales.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ClientDeliveryTO {
    private String outputNumber;
    private String deliveryNumber;
    private String itemName;
    private String Name;
    private String Tel;
    private String deliveryDate;
    private String warehouseCode;
    private String endingRoute;
    private String deliveryStatus;
}
