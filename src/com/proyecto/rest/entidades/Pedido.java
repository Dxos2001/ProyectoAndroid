package com.proyecto.rest.entidades;

public class Pedido {

	private int idpedido;
	private String fecharegistro, fechaentrega, lugarentrega, estado;
	private int idcliente, idubigeo, idusuario;
	
	public int getIdpedido() {
		return idpedido;
	}
	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}
	public String getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public String getLugarentrega() {
		return lugarentrega;
	}
	public void setLugarentrega(String lugarentrega) {
		this.lugarentrega = lugarentrega;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getIdubigeo() {
		return idubigeo;
	}
	public void setIdubigeo(int idubigeo) {
		this.idubigeo = idubigeo;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
	
}
