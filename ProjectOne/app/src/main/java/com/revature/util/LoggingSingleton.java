package com.revature.util;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggingSingleton {

    /*
    private static final String FILE = "log.txt";
    private static StringBuffer sb;
    private BufferedWriter fileWriter;
    private boolean writeToFile = true;

    private static LoggingSingleton logger;

    private LoggingSingleton(){
        try{this.fileWriter = new BufferedWriter(new FileWriter(FILE, true));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static  LoggingSingleton getLogger(){
        if(logger == null) logger = new LoggingSingleton();
        return logger;
    }

    public void log(String logType, String message){
        sb = new StringBuffer();
        sb.append(logType);
        sb.append("- ");
        sb.append(LocalDateTime.now());
        sb.append(" - ");
        sb.append(message);
        if(writeToFile){
            try{
                fileWriter.write(sb.toString());
                fileWriter.newLine();
                fileWriter.flush();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }*/

}
