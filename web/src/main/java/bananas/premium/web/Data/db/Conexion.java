package bananas.premium.web.Data.db;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexion {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost/bananas_premium";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "0510";
    DataSource source = getDataSource();
   public JdbcTemplate jdbcTemplate = new JdbcTemplate(source);

    private static DataSource getDataSource(){
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
