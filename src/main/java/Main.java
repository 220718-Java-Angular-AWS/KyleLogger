import com.revature.DataSourceManager;
import com.revature.KyleLogger;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = DataSourceManager.getConnection();

        KyleLogger logger = new KyleLogger(4, 2);

        //debug level 0
        try {
            //0=debug, 1=info, 2=warning, 3=severe, 4=fatal
            logger.log(0, "This is a debug log message", "This is how we might log breadcrumbs, assertions, and other info useful during the design/development process");
            logger.log(1, "This is an informational message", "This is how we might include information that might be useful for our users");
            logger.log(2, "This is a warning message", "This is where we might log info about a potential problem or issue, but not something that so severe that it would crash the program or require extra steps to recover");
            logger.log(3, "This is a severe message", "This is indicating a pretty big problem, one that we want to notice and take corrective action ASAP");
            logger.log(4, "This is a fatal message", "This message would indicate that the application has had a major problem, one that it probably cannot recover from and will terminate. This error is one we would need to address with by writing new code");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
