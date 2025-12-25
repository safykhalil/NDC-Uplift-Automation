package utilities;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class GmailReaderUtil {

    // Connect to Gmail IMAP and get the latest email content as plain text
    public static String getLatestEmail(String email, String appPassword) {
        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imap");
            props.put("mail.imap.host", "imap.gmail.com");
            props.put("mail.imap.port", "993");
            props.put("mail.imap.ssl.enable", "true");
            props.put("mail.imap.ssl.trust", "imap.gmail.com");

            Session session = Session.getInstance(props);
            Store store = session.getStore("imap");
            store.connect("imap.gmail.com", email, appPassword);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            if (inbox.getMessageCount() == 0) return null;

            Message message = inbox.getMessage(inbox.getMessageCount());
            String body = getTextFromMessage(message);

            inbox.close(false);
            store.close();

            return body;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Extract OTP (4 digits) from text
    public static String extractOtp(String text) {
        if (text == null) return null;
        Pattern pattern = Pattern.compile("\\b\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? matcher.group() : null;
    }

    // Direct helper to get OTP from the latest email
    public static String getLatestOtp(String email, String appPassword) {
        String emailBody = getLatestEmail(email, appPassword);
        return extractOtp(emailBody);
    }

    // Utility to extract text from a Message (supports multipart)
    private static String getTextFromMessage(Message message) throws Exception {
        Object content = message.getContent();

        if (content instanceof String) {
            return (String) content;
        } else if (content instanceof Multipart) {
            return getTextFromMultipart((Multipart) content);
        } else {
            return content.toString();
        }
    }

    // Recursive extraction from Multipart
    private static String getTextFromMultipart(Multipart multipart) throws Exception {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart part = multipart.getBodyPart(i);
            Object content = part.getContent();

            if (part.isMimeType("text/plain")) {
                result.append(getTextFromInputStream(content));
            } else if (part.isMimeType("text/html")) {
                result.append(Jsoup.parse(getTextFromInputStream(content)).text());
            } else if (content instanceof Multipart) {
                result.append(getTextFromMultipart((Multipart) content));
            }
        }

        return result.toString().trim();
    }

    // Utility to convert BodyPart content to String safely
    private static String getTextFromInputStream(Object content) throws Exception {
        if (content instanceof String) return (String) content;
        if (content instanceof InputStream) {
            InputStream is = (InputStream) content;
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
        return content.toString();
    }
}
