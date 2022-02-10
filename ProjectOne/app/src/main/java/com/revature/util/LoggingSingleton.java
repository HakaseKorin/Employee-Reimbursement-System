package com.revature.util;


import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggingSingleton {

    public final static Logger logger = Logger.getLogger(LoggingSingleton.class);

}
