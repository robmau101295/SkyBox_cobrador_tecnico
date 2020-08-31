package skybox.com.scmtv.Facturas;

public class Factura {
    private String numerofactura;
    private String descripcion;
    private String vencimiento;
    private String importe;

    public Factura(String numerofactura, String descripcion, String vencimiento, String importe) {
        this.numerofactura = numerofactura;
        this.descripcion = descripcion;
        this.vencimiento = vencimiento;
        this.importe = importe;
    }

    public String getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(String numerofactura) {
        this.numerofactura = numerofactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }
}
