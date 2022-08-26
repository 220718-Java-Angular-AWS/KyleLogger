package com.revature;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class KyleLogger {
    private static List<KyleLogger> loggersList;
    private int threshold; //0=debug, 1=info, 2=warning, 3=error/severe, 4=fatal
    private int target; //0=console, 1=file, 2=datasource
    private String filePath;

    public KyleLogger(int threshold, int target) {
        this.threshold = threshold;
        this.target = target;
        loggersList = new LinkedList<>();
    }

    public void log(int level, String message, String content) throws SQLException {
        //TODO: Maybe include a stack trace from the thread?

        if(level < threshold) {
            return;
        }

        //do some setup
        switch(target) {
            case 0:
                //console, log to console.
                break;
            case 1:
                //file logging
                break;
            case 2:
                LocalDateTime timestamp = LocalDateTime.now();
                String formattedDateTime = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
                dataSourceLog(level, message, content, formattedDateTime);
                break;
        }

    }

    private void consoleLog(int level, String message, String content, String timestamp) {
        //TODO: implement me
    }

    private void fileLog(int level, String message, String content, String timestamp) {
        //TODO: implement me
    }

    private void dataSourceLog(int level, String message, String content, String timestamp) throws SQLException {
        String sql = "INSERT INTO logs (message, content, level, timestamp) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = DataSourceManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, message);
        pstmt.setString(2, content);
        pstmt.setInt(3, level);
        pstmt.setString(4, timestamp);
        pstmt.executeUpdate();
    }



}
