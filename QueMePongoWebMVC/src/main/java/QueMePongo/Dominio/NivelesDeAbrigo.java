package QueMePongo.Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class NivelesDeAbrigo {
	
	public int obtenerNivelDeAbrigo(int temperaturaMinima, int temperaturaMaxima) throws SQLException{
		
		int temperaturaPromedio = (temperaturaMinima + temperaturaMaxima)/2;
		
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_OBTENER_NIVEL_ABRIGO(?,?)}");
		
		miSentencia.setInt(1, temperaturaPromedio);
		miSentencia.registerOutParameter(2, Types.INTEGER);
		miSentencia.execute();
		
		return miSentencia.getInt(2);
	
	}

}
