package handle;

import handle.exceptionhandle.ExceptionHandler;
import handle.exceptionhandle.GenericExceptionHandler;
import handle.exceptionhandle.IllegalArgumentExceptionHandler;
import handle.exceptionhandle.NotFoundExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandlerRegistry {

    private static final Map<Class<? extends Exception>, ExceptionHandler> handlers = new HashMap<>();

    static {
        registerHandler(new IllegalArgumentExceptionHandler());
        registerHandler(new NotFoundExceptionHandler());
        registerHandler(new GenericExceptionHandler());
    }

    public static void registerHandler(ExceptionHandler handler) {
        handlers.put(handler.getExceptionType(), handler);
    }

    public static ExceptionHandler getHandler(Class<? extends Exception> exceptionClass) {
        return handlers.getOrDefault(exceptionClass, handlers.get(Exception.class));
    }
}
