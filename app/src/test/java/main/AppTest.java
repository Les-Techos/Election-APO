/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() throws Exception {
        System.out.println("Test A");
        try{
            App.main(new String[5]);
        }catch(Exception e){ throw e;}
    }

    @Test public void testNeg() throws Exception {
        System.out.println("Test B");
        try{
            App.main(new String[5]);
        }catch(Exception e){ throw e;}
        //fail("Tu es nul");
    }
}