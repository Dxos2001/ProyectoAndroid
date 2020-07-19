package com.proyecto.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.proyecto.rest.entidades.Comprobante;
import com.proyecto.rest.entidades.Usuario;
import com.proyecto.rest.util.MySqlDBConexion;

public class ComprobanteModel {

	private static final Log log = LogFactory.getLog(ComprobanteModel.class);
	
	public List<Comprobante> listaComprobante(){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Comprobante> lista = new ArrayList<Comprobante>();
		try {
			String sql = "select * from comprobante";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Comprobante obj = null;
			while (rs.next()) {
				obj = new Comprobante();
				obj.setIdcomprobante(rs.getInt(1));
				obj.setFechaRegistro(rs.getString(2));
				obj.setFechaPago(rs.getString(3));
				obj.setEstado(rs.getString(4));
				obj.setIdpedido(rs.getInt(5));
				obj.setIdcliente(rs.getInt(6));
				obj.setIdusuario(rs.getInt(7));
				lista.add(obj);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}
	
	
	public int addComprobante(Comprobante com) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql="insert into comprobante values(null,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, com.getFechaRegistro());
			pstm.setString(2, com.getFechaPago());
			pstm.setString(3, com.getEstado());
			pstm.setInt(4, com.getIdpedido());
			pstm.setInt(5, com.getIdcliente());
			pstm.setInt(6, com.getIdusuario());
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	
	public int actualizaComprobante(Comprobante obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update comprobante set fecharegistro =?, fechapago =?, estado=?, idpedido=?, idcliente=?, idusuario=? where idcomprobante =? ";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getFechaRegistro());
			pstm.setString(2, obj.getFechaPago());
			pstm.setString(3, obj.getEstado());
			pstm.setInt(4, obj.getIdpedido());
			pstm.setInt(5, obj.getIdcliente());
			pstm.setInt(6, obj.getIdusuario());
			pstm.setInt(7, obj.getIdcomprobante());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) { 
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
	
	public int eliminaComprobante(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from comprobante where idComprobante=?";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
	
	
	
}
