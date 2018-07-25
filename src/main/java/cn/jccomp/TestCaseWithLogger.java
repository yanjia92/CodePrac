package cn.jccomp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bitbook on 3/20/18.
 */
public interface TestCaseWithLogger {
    Logger logger= LoggerFactory.getLogger(TestCaseWithLogger.class);
    void run() throws Exception;
}
