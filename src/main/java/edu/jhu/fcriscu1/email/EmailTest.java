package edu.jhu.fcriscu1.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by fcriscuolo on 4/5/16.
 */
public class EmailTest {
    public static void main(String[] args) {
        try {
        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("sdrc1888@gmail.com", "password"));
        email.setSSLOnConnect(true);
            email.setFrom("sdrc1888@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("Testing sending mail from a Java application");
        email.addTo("fcriscuolo@nygenome.org");
        email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }
}
