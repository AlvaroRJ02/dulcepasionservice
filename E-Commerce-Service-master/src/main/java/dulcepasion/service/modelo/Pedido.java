package dulcepasion.service.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaCompra;
    
    @ManyToOne
    private Cliente cliente;
    @Column
    private Double monto;
    @Column
    private int anularPedido;

    public Pedido() {
		
	}
    
    
    public Pedido(int id, Date fechaCompra, Cliente cliente, Double monto, int anularPedido) {
		super();
		this.id = id;
		this.fechaCompra = fechaCompra;
		this.cliente = cliente;
		this.monto = monto;
		this.anularPedido = anularPedido;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getFechaCompra() {
		return fechaCompra;
	}


	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Double getMonto() {
		return monto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}


	public int getAnularPedido() {
		return anularPedido;
	}


	public void setAnularPedido(int anularPedido) {
		this.anularPedido = anularPedido;
	}


	
}
