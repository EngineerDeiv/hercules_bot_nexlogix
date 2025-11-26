package models.Areas;

public class createArea {
    private String nombreArea;
    private String descripcionArea;

    public createArea(String nombreArea, String descripcionArea) {
        this.nombreArea = nombreArea;
        this.descripcionArea = descripcionArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public String getDescripcionArea() {
        return descripcionArea;
    }
}
