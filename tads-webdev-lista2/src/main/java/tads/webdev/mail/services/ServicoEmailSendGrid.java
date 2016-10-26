
package tads.webdev.mail.services;

import java.io.IOException;

import com.sendgrid.*;

import tads.webdev.mail.*;


/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class ServicoEmailSendGrid implements IServicoEmail {

    @Override
    public void enviar(IMensagemEmail message)
        throws EnvioEmailException {

        Email from = new Email(message.getDe());
        Email to = new Email(message.getPara());

        String subject = message.getAssunto();
        Content content = new Content("text/plain", message.getTexto());

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getProperty("SENDGRID_API_KEY"));

        Request request = new Request();

        try {

            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();

            Response response = sg.api(request);

            System.out.println(response.statusCode);
            System.out.println(response.body);
            System.out.println(response.headers);

        } catch (IOException ex) {

            throw new EnvioEmailException(ex.getMessage(), ex);

        }

    }

}
