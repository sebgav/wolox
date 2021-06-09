package data;

public class Templates {
    public String createLogion(String correo, String pasword, String nombre, String apellido) {
        String request="{\n" +
                "   \"email\":\"%s\",\n" +
                "   \"password\":\"%s\",\n" +
                "   \"first_name\":\"%s\",\n" +
                "   \"last_name\":\"%s\"\n" +
                "}";
        return String.format(request, correo,pasword,nombre,apellido);
    }
}
