
package skybox.com.scmtv.peticiones.respuestadetalle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Contrato")
    @Expose
    private Integer contrato;
    @SerializedName("Cliente")
    @Expose
    private Integer cliente;
    @SerializedName("Empleado")
    @Expose
    private Integer empleado;
    @SerializedName("Documento")
    @Expose
    private String documento;
    @SerializedName("Fecha")
    @Expose
    private String fecha;
    @SerializedName("Fecha_Vencimiento")
    @Expose
    private String fechaVencimiento;
    @SerializedName("Condicion")
    @Expose
    private Integer condicion;
    @SerializedName("Periodo")
    @Expose
    private Integer periodo;
    @SerializedName("Tipo_NCF")
    @Expose
    private String tipoNCF;
    @SerializedName("NCF")
    @Expose
    private String nCF;
    @SerializedName("Cedula")
    @Expose
    private String cedula;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Moneda")
    @Expose
    private String moneda;
    @SerializedName("Debito")
    @Expose
    private String debito;
    @SerializedName("Credito")
    @Expose
    private String credito;
    @SerializedName("Saldo")
    @Expose
    private String saldo;
    @SerializedName("Descuento")
    @Expose
    private String descuento;
    @SerializedName("Balance")
    @Expose
    private String balance;
    @SerializedName("Balance_RD")
    @Expose
    private String balanceRD;
    @SerializedName("Balance_US")
    @Expose
    private String balanceUS;
    @SerializedName("Tasa_Cambio")
    @Expose
    private String tasaCambio;
    @SerializedName("Efectivo")
    @Expose
    private String efectivo;
    @SerializedName("Tarjeta")
    @Expose
    private String tarjeta;
    @SerializedName("Cheque")
    @Expose
    private String cheque;
    @SerializedName("Banco")
    @Expose
    private String banco;
    @SerializedName("Secuencia")
    @Expose
    private String secuencia;
    @SerializedName("Usuario")
    @Expose
    private String usuario;
    @SerializedName("Localidad")
    @Expose
    private Integer localidad;
    @SerializedName("Sector")
    @Expose
    private Integer sector;
    @SerializedName("Calle")
    @Expose
    private Integer calle;
    @SerializedName("Estatus")
    @Expose
    private Integer estatus;
    @SerializedName("Poste")
    @Expose
    private String poste;
    @SerializedName("Fecha_Pago")
    @Expose
    private String fechaPago;
    @SerializedName("Terminal")
    @Expose
    private String terminal;
    @SerializedName("Correo")
    @Expose
    private String correo;
    @SerializedName("Deposito")
    @Expose
    private String deposito;
    @SerializedName("Id_1")
    @Expose
    private Integer id1;
    @SerializedName("Contrato_1")
    @Expose
    private Integer contrato1;
    @SerializedName("Codigo")
    @Expose
    private Integer codigo;
    @SerializedName("Factura")
    @Expose
    private String factura;
    @SerializedName("Recibo")
    @Expose
    private String recibo;
    @SerializedName("Producto")
    @Expose
    private String producto;
    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Cantidad")
    @Expose
    private String cantidad;
    @SerializedName("Moneda_1")
    @Expose
    private String moneda1;
    @SerializedName("Costo")
    @Expose
    private String costo;
    @SerializedName("Precio")
    @Expose
    private String precio;
    @SerializedName("Itbis")
    @Expose
    private String itbis;
    @SerializedName("CDT")
    @Expose
    private String cDT;
    @SerializedName("ISC")
    @Expose
    private String iSC;
    @SerializedName("Ayuntamiento")
    @Expose
    private String ayuntamiento;
    @SerializedName("Importe")
    @Expose
    private String importe;
    @SerializedName("Impuestos")
    @Expose
    private String impuestos;
    @SerializedName("Total")
    @Expose
    private String total;
    @SerializedName("Saldo_1")
    @Expose
    private String saldo1;
    @SerializedName("Localidad_1")
    @Expose
    private Integer localidad1;
    @SerializedName("Sector_1")
    @Expose
    private Integer sector1;
    @SerializedName("Calle_1")
    @Expose
    private Integer calle1;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param descripcion
     * @param cedula
     * @param documento
     * @param balanceUS
     * @param factura
     * @param balance
     * @param correo
     * @param id
     * @param poste
     * @param sector
     * @param tipoNCF
     * @param recibo
     * @param codigo
     * @param contrato
     * @param banco
     * @param secuencia
     * @param deposito
     * @param importe
     * @param fechaPago
     * @param saldo1
     * @param cliente
     * @param fecha
     * @param cDT
     * @param calle1
     * @param estatus
     * @param usuario
     * @param cantidad
     * @param tasaCambio
     * @param periodo
     * @param producto
     * @param nombre
     * @param nCF
     * @param precio
     * @param total
     * @param localidad1
     * @param empleado
     * @param moneda
     * @param credito
     * @param localidad
     * @param tarjeta
     * @param debito
     * @param ayuntamiento
     * @param sector1
     * @param costo
     * @param fechaVencimiento
     * @param descuento
     * @param balanceRD
     * @param calle
     * @param saldo
     * @param terminal
     * @param condicion
     * @param moneda1
     * @param impuestos
     * @param id1
     * @param efectivo
     * @param contrato1
     * @param iSC
     * @param cheque
     * @param itbis
     */
    public Datum(Integer id, Integer contrato, Integer cliente, Integer empleado, String documento, String fecha, String fechaVencimiento, Integer condicion, Integer periodo, String tipoNCF, String nCF, String cedula, String nombre, String moneda, String debito, String credito, String saldo, String descuento, String balance, String balanceRD, String balanceUS, String tasaCambio, String efectivo, String tarjeta, String cheque, String banco, String secuencia, String usuario, Integer localidad, Integer sector, Integer calle, Integer estatus, String poste, String fechaPago, String terminal, String correo, String deposito, Integer id1, Integer contrato1, Integer codigo, String factura, String recibo, String producto, String descripcion, String cantidad, String moneda1, String costo, String precio, String itbis, String cDT, String iSC, String ayuntamiento, String importe, String impuestos, String total, String saldo1, Integer localidad1, Integer sector1, Integer calle1) {
        super();
        this.id = id;
        this.contrato = contrato;
        this.cliente = cliente;
        this.empleado = empleado;
        this.documento = documento;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.condicion = condicion;
        this.periodo = periodo;
        this.tipoNCF = tipoNCF;
        this.nCF = nCF;
        this.cedula = cedula;
        this.nombre = nombre;
        this.moneda = moneda;
        this.debito = debito;
        this.credito = credito;
        this.saldo = saldo;
        this.descuento = descuento;
        this.balance = balance;
        this.balanceRD = balanceRD;
        this.balanceUS = balanceUS;
        this.tasaCambio = tasaCambio;
        this.efectivo = efectivo;
        this.tarjeta = tarjeta;
        this.cheque = cheque;
        this.banco = banco;
        this.secuencia = secuencia;
        this.usuario = usuario;
        this.localidad = localidad;
        this.sector = sector;
        this.calle = calle;
        this.estatus = estatus;
        this.poste = poste;
        this.fechaPago = fechaPago;
        this.terminal = terminal;
        this.correo = correo;
        this.deposito = deposito;
        this.id1 = id1;
        this.contrato1 = contrato1;
        this.codigo = codigo;
        this.factura = factura;
        this.recibo = recibo;
        this.producto = producto;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.moneda1 = moneda1;
        this.costo = costo;
        this.precio = precio;
        this.itbis = itbis;
        this.cDT = cDT;
        this.iSC = iSC;
        this.ayuntamiento = ayuntamiento;
        this.importe = importe;
        this.impuestos = impuestos;
        this.total = total;
        this.saldo1 = saldo1;
        this.localidad1 = localidad1;
        this.sector1 = sector1;
        this.calle1 = calle1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getCondicion() {
        return condicion;
    }

    public void setCondicion(Integer condicion) {
        this.condicion = condicion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getTipoNCF() {
        return tipoNCF;
    }

    public void setTipoNCF(String tipoNCF) {
        this.tipoNCF = tipoNCF;
    }

    public String getNCF() {
        return nCF;
    }

    public void setNCF(String nCF) {
        this.nCF = nCF;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDebito() {
        return debito;
    }

    public void setDebito(String debito) {
        this.debito = debito;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBalanceRD() {
        return balanceRD;
    }

    public void setBalanceRD(String balanceRD) {
        this.balanceRD = balanceRD;
    }

    public String getBalanceUS() {
        return balanceUS;
    }

    public void setBalanceUS(String balanceUS) {
        this.balanceUS = balanceUS;
    }

    public String getTasaCambio() {
        return tasaCambio;
    }

    public void setTasaCambio(String tasaCambio) {
        this.tasaCambio = tasaCambio;
    }

    public String getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(String efectivo) {
        this.efectivo = efectivo;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }

    public Integer getSector() {
        return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }

    public Integer getCalle() {
        return calle;
    }

    public void setCalle(Integer calle) {
        this.calle = calle;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public Integer getContrato1() {
        return contrato1;
    }

    public void setContrato1(Integer contrato1) {
        this.contrato1 = contrato1;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getMoneda1() {
        return moneda1;
    }

    public void setMoneda1(String moneda1) {
        this.moneda1 = moneda1;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getItbis() {
        return itbis;
    }

    public void setItbis(String itbis) {
        this.itbis = itbis;
    }

    public String getCDT() {
        return cDT;
    }

    public void setCDT(String cDT) {
        this.cDT = cDT;
    }

    public String getISC() {
        return iSC;
    }

    public void setISC(String iSC) {
        this.iSC = iSC;
    }

    public String getAyuntamiento() {
        return ayuntamiento;
    }

    public void setAyuntamiento(String ayuntamiento) {
        this.ayuntamiento = ayuntamiento;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSaldo1() {
        return saldo1;
    }

    public void setSaldo1(String saldo1) {
        this.saldo1 = saldo1;
    }

    public Integer getLocalidad1() {
        return localidad1;
    }

    public void setLocalidad1(Integer localidad1) {
        this.localidad1 = localidad1;
    }

    public Integer getSector1() {
        return sector1;
    }

    public void setSector1(Integer sector1) {
        this.sector1 = sector1;
    }

    public Integer getCalle1() {
        return calle1;
    }

    public void setCalle1(Integer calle1) {
        this.calle1 = calle1;
    }

}
