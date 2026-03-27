public abstract class Envio {
    protected String cliente;
    protected String codigo;
    protected double peso;
    protected double distancia;

    public Envio(String cliente, String codigo, double peso, double distancia) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.peso = peso;
        this.distancia = distancia;
    }

    public abstract double calcularTarifa();

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente +
               ", Código: " + codigo +
               ", Peso: " + peso +
               ", Distancia: " + distancia +
               ", Tarifa: " + calcularTarifa();
    }
}