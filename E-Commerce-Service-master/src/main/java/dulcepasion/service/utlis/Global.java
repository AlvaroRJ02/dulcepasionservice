package dulcepasion.service.utlis;

public class Global {
    public enum Estado {
        A,
        I
    }

    public static final String TIPO_RESULT = "result";
    public static final String TIPO_DATA = "data";
    public static final String TIPO_AUTH = "auth";
    public static final int RPTA_OK = 1;
    public static final int RPTA_WARNING = 0;
    public static final int RPTA_ERROR = -1;
    public static final String OPERACION_CORRECTA = "Operación Exitosa";
    public static final String OPERACION_INCORRECTA = "Operación Incorrecta";
    public static final String OPERACION_ERRONEA = "Operacion Errónea";
    public static final String AUTH_SECRET = "serviciosweb2";
}
