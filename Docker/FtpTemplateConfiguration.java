package br.com.patio.projeto.rest.api.utils;


import lombok.extern.log4j.Log4j2;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpRemoteFileTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;

@Log4j2
@Configuration
public class FtpTemplateConfiguration {
	
    @Bean
    public InitializingBean initializingBean(FtpRemoteFileTemplate template) {
        return () -> template
                .execute(session -> {
                    File file = new File(new File(System.getProperty("user.home")), "hello.txt");
                    try (FileOutputStream fout = new FileOutputStream(file)) {
                        session.read("hello.txt", fout);
                    }
                    log.info("read " + file.getAbsolutePath());
                    return null;
                });
    }

    @Bean
    DefaultFtpSessionFactory defaultFtpSessionFactory(
            @Value("${ftp.username}") String username,
            @Value("${ftp.password}") String pw,
            @Value("${ftp.host}") String host,
            @Value("${ftp.port}") int port) {
        DefaultFtpSessionFactory defaultFtpSessionFactory = new DefaultFtpSessionFactory();
        defaultFtpSessionFactory.setPassword(pw);
        defaultFtpSessionFactory.setUsername(username);
        defaultFtpSessionFactory.setHost(host);
        defaultFtpSessionFactory.setPort(port);
        return defaultFtpSessionFactory;
    }
    
    

    @Bean
    FtpRemoteFileTemplate ftpRemoteFileTemplate(DefaultFtpSessionFactory dsf) {
        return new FtpRemoteFileTemplate(dsf);
    }
}