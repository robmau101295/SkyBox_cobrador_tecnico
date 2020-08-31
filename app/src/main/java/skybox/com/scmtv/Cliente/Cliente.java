package skybox.com.scmtv.Cliente;

public class Cliente {
    private String contrato;
    private String codigo;
    private String nombreyapellido;
    private String telefono;
    private String estado;

    public Cliente(String contrato, String codigo, String nombreyapellido, String telefono, String estado) {
        this.contrato = contrato;
        this.codigo = codigo;
        this.nombreyapellido = nombreyapellido;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreyapellido() {
        return nombreyapellido;
    }

    public void setNombreyapellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
