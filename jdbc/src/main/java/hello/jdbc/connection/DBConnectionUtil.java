package hello.jdbc.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.slf4j.Slf4j;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DBConnectionUtil {

    public static Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={},class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            log.error("Failed to connect to the database: {}", e.getMessage());
            return null; // 또는 다른 적절한 처리를 수행할 수 있음
        }
    }
}
