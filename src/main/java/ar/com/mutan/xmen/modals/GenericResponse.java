package ar.com.mutan.xmen.modals;

public class GenericResponse {
    
    public Integer id;
    public boolean isOk;
    public String message;

    public GenericResponse(Integer id, boolean isOk, String message) {
        this.id = id;
        this.isOk = isOk;
        this.message = message;
    }
}
