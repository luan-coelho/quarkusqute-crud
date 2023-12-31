package handle.exceptionhandle;

import exception.ErrorResponse;
import jakarta.ws.rs.NotFoundException;
import org.jboss.resteasy.reactive.RestResponse;

public class NotFoundExceptionHandler implements ExceptionHandler {

    @Override
    public void handleException(Exception exception, ErrorResponse errorResponse) {
        errorResponse.setTitle(getTitle());
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setStatus(getStatus());
    }

    @Override
    public Class<? extends Exception> getExceptionType() {
        return NotFoundException.class;
    }

    @Override
    public String getTitle() {
        return "Not Found";
    }

    @Override
    public int getStatus() {
        return RestResponse.StatusCode.NOT_FOUND;
    }
}
