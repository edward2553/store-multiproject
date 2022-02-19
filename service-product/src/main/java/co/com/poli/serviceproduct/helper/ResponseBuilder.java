package co.com.poli.serviceproduct.helper;

import static org.springframework.http.HttpStatus.*;
import co.com.poli.serviceproduct.model.Response;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public Response success(){
        return Response.builder()
                .code(OK.value())
                .data(OK.value())
                .build();
    }

    public Response success(Object data){
        return Response.builder()
                .code(OK.value())
                .data(data)
                .build();
    }

    public Response failed(Object data){
        return Response.builder()
                .code(INTERNAL_SERVER_ERROR.value())
                .data(data)
                .build();
    }

}
