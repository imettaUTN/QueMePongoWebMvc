package QueMePongo.Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class SugerenciasExcluidas {
	
	
	public boolean ejecutar(Usuario usuario, Sugerencia sugerencia) throws SQLException {
		
		boolean salida = false;
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_COMBINACION_PRENDA_EXCLUIDA(?,?,?,?,?,?,?,?,?,?,?,?)}");
		
		miSentencia.setString(1, usuario.getCodigoUsuario());
		miSentencia.setInt(1, sugerencia.getMaxCapaSuperior());
		miSentencia.setInt(1, sugerencia.getMaxCapaInferior());
		miSentencia.setInt(4, sugerencia.prendasSugeridas.get(11).getCodPrenda());
		miSentencia.setInt(5, sugerencia.prendasSugeridas.get(12).getCodPrenda());
		miSentencia.setInt(6, sugerencia.prendasSugeridas.get(13).getCodPrenda());
		miSentencia.setInt(7, sugerencia.prendasSugeridas.get(14).getCodPrenda());
		miSentencia.setInt(8, sugerencia.prendasSugeridas.get(21).getCodPrenda());
		miSentencia.setInt(9, sugerencia.prendasSugeridas.get(22).getCodPrenda());
		miSentencia.setInt(10, sugerencia.prendasSugeridas.get(31).getCodPrenda());
		miSentencia.setInt(11, sugerencia.prendasSugeridas.get(41).getCodPrenda());
		miSentencia.registerOutParameter(12, Types.BIT);
		
		miSentencia.execute();
		salida = miSentencia.getBoolean(12);
		
		return salida;
	}
}	
