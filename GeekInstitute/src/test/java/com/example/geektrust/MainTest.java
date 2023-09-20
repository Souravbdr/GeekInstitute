package com.example.geektrust;

import org.junit.jupiter.api.Test;

public class MainTest {
	@Test
    public void Application_Test() throws Exception{
    	Main.main(new String[] {"sample_input/input1.txt"});
    }
    @Test
    public void Application_Test2() throws Exception{
    	Main.main(new String[] {"sample_input/input2.txt"});
    }
    @Test
    public void Application_Tes3() throws Exception{
    	Main.main(new String[] {"sample_input/input3.txt"});
    }
    @Test
    public void Application_Tes4() throws Exception{
    	Main.main(new String[] {"sample_input/input4.txt"});
    }
}