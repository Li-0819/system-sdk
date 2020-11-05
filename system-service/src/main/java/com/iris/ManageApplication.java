package com.iris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: izanagi
 * @Date: 2020-04-15 13:50
 * @Description: FrameworkApplication
 */

@SpringBootApplication
public class ManageApplication {

	public static void main(String[] args) throws UnknownHostException {

		ConfigurableApplicationContext application = SpringApplication.run(ManageApplication.class, args);
		Environment env = application.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("server.port");
		System.out.println("\n----------------------------------------------------------\n\t" +
				"Application ManageApplication is running! Access URLs:\n\t" +
				"Local: \t\thttp://localhost:" + port + "/\n\t" +
				"External: \thttp://" + ip + ":" + port + "/\n\t" +
				"swagger-ui: \thttp://" + ip + ":" + port  + "/swagger-ui/index.html\n\t" +
				"Doc: \t\thttp://" + ip + ":" + port + "/v2/api-docs\n" +
				"----------------------------------------------------------");
	}

}
