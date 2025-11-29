package models.Users;
import java.util.Random;
public class createUser {
    private String documentoIdentidad;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String direccion;
    private String contrasena;
    private String rol;
    private String puesto;
    private String estado;

    public createUser(String documentoIdentidad, String nombreCompleto, String email, String telefono, String direccion, String contrasena, String rol, String puesto, String estado) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.rol = rol;
        this.puesto = puesto;
        this.estado = estado;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getEstado() {
        return estado;
    }
}
