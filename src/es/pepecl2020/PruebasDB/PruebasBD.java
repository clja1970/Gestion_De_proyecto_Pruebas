package es.pepecl2020.PruebasDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebasBD
{

	public static void main(String[] args)
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Gestion_de_Proyecto_fi?serverTimezone=UTC";
		String login = "root";
		String password = "Studium2020;";
		String sentencia = "";
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			sentencia="SELECT * FROM clientes";
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				System.out.println();
				System.out.println(rs.getInt("idClientes") + "-" + rs.getString("nombreCliente")+"-"+ rs.getString("apellidoCliente")+"-"+ rs.getString("dniCliente")+"-"+rs.getString("telefono")+"-"+rs.getString("correoElectronico"));
				}
			sentencia="SELECT * FROM proyectos";
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				System.out.println();
				System.out.println(rs.getInt("idProyectos") + "-" + rs.getString("nombreProyecto")+"-"+ rs.getString("contenidoProyecto")+"-"+rs.getString("idClientesFK8"));
			}
			
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}

	}

}
