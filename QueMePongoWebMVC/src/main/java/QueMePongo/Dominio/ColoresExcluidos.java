package QueMePongo.Dominio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ColoresExcluidos {
	
	public boolean ejecutar(Usuario username,Prenda p1, Prenda p2) throws SQLException {
		
		boolean salida;
		Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QUEMEPONGO","ROMERO","Cris01");
		CallableStatement miSentencia = cn.prepareCall("{call SP_COMBINACION_COLORES_EXCLUIDA(?,?,?,?,?,?)}");
		
		miSentencia.setString(1, username.getCodigoUsuario());
		miSentencia.setString(2, p1.getColorPrimario());
		miSentencia.setString(3, p1.getColorSecundario());
		miSentencia.setString(4, p2.getColorPrimario());
		miSentencia.setString(5, p2.getColorSecundario());
		miSentencia.registerOutParameter(6, Types.BIT);
		miSentencia.execute();
		
		salida = miSentencia.getBoolean(6);
	
		return salida;
	}
}	
	



