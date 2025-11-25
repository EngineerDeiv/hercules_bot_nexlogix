package models.Users;

public class EditUsers {
    private String documentoIdentidad;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String direccion;
    private String rol;
    private String puesto;
    private String estado;

    public EditUsers(String documentoIdentidad, String nombreCompleto, String email, String telefono, String direccion, String rol, String puesto, String estado) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
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
