package kr.co.seoulit.erp.sys.to.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)   // null 값을 가지는 필드는 JSON 응답에 포함되지 않도록 함
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Response {

    private boolean success;
    private int code;
    private Result result;

    //요청은 성공했으나 응답해야할 별다른 데이터가 없을 때 사용
    public static Response success(){
        return new Response(true, 0, null);
    }

    //성공했을 때는 응답 데이터 반환
    public static <T> Response success(T data){
        return new Response(true, 0, new Success<>(data));
    }

    //실패했을 때는 실패 메시지도 반환
    public static Response failure(int code,String msg){
        return new Response(false, code, new Failure(msg));
    }
}
