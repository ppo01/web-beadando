package web.beadando.view.listener;



import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FlywayListener implements ServletContextListener {
    public static Flyway flyway;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        flyway = Flyway
                .configure()
                .dataSource("jdbc:sqlserver://localhost:1433;databaseName=Web_Adatb","sa","WebADAT123")
                .schemas("beadando")
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
