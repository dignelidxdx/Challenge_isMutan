package ar.com.mutan.xmen.models.response;

public class GenericResponse {
    
    public boolean isOk = false;
    public String message = "";

    public GenericResponse(boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }
}
