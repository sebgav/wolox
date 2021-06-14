package data;

public class Templates {
    public String createLogion(String correo, String pasword, String nombre, String apellido) {
        String request="{\n" +
                "   \"email\":\"%s\",\n" +
                "   \"password\":\"%s\",\n" +
                "   \"firstName\":\"%s\",\n" +
                "   \"lastName\":\"%s\"\n" +
                "}";
        return String.format(request, correo,pasword,nombre,apellido);
    }

    public String logiin(String correo, String pasword) {
         String request="{ \"email\": \"%s\", \"password\": \"%s\" }";
         return String.format(request, correo,pasword);
    }
}
