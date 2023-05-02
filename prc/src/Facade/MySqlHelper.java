package Facade;

import java.sql.Connection;

public class MySqlHelper {
    public static Connection getMySqlDBConnection(){
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection con){
        // get data from table and generate pdf report
    }

    public void generateMySqlHTMLReport(String tableName, Connection con){
        // get data from table and generate and report
    }

}
