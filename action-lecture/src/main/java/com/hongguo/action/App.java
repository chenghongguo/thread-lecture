package com.hongguo.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static Logger logger = LoggerFactory.getLogger("project_logger");

    public static void main(String[] args) {
        logger.warn("Hello world!");
        logger.warn("a {}, b {}", "hello", "world");
    }
}
