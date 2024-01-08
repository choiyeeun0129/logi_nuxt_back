package kr.co.seoulit.erp.sys.to.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Failure implements Result{
    private String msg;
}
