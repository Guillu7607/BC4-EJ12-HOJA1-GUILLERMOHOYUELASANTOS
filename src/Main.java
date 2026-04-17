import java.sql.*;

public class Main {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "RIBERA";
    private static final String PASS = "ribera";

    public static void main(String[] args) {
        String sql = "SELECT COUNT(*) AS total FROM empleado WHERE salaio > 3000";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                int cantidad = rs.getInt("total");
                System.out.println("======================================");
                System.out.println(" RESULTADO DEL FILTRO (> 3000€)");
                System.out.println("======================================");
                System.out.println("Número de empleados encontrados: " + cantidad);
            }

        } catch (SQLException e) {
            System.err.println("Error al contar registros: " + e.getMessage());
        }
    }
}