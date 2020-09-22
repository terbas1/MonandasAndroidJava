package edwinbaltazar.example.monadasglamour.Model;

import com.google.gson.annotations.SerializedName;

public class ListaDeVentas {
    @SerializedName("id")
    private Integer id;
    @SerializedName("id_usuario")
    private Integer id_Usuario;
    @SerializedName("id_producto")
    private Integer id_Producto;
    @SerializedName("envio")
    private Integer envio;
    @SerializedName("metodo")
    private String metodo;
    @SerializedName("email")
    private String email;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("pais")
    private String pais;
    @SerializedName("cantidad")
    private Integer cantidad;
    @SerializedName("detalle")
    private String detalle;
    @SerializedName("pago")
    private String pago;
    @SerializedName("fecha")
    private String fecha;

    public ListaDeVentas(Integer id, Integer id_Usuario, Integer id_Producto, Integer envio, String metodo, String email, String direccion, String pais, Integer cantidad, String detalle, String pago, String fecha) {
        this.id = id;
        this.id_Usuario = id_Usuario;
        this.id_Producto = id_Producto;
        this.envio = envio;
        this.metodo = metodo;
        this.email = email;
        this.direccion = direccion;
        this.pais = pais;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.pago = pago;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public Integer getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Integer id_Producto) {
        this.id_Producto = id_Producto;
    }

    public Integer getEnvio() {
        return envio;
    }

    public void setEnvio(Integer envio) {
        this.envio = envio;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
