package pblog.util;

import org.springframework.stereotype.Component;
import pblog.entity.Visit;
import pblog.entity.Visitor;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

public class EmailSender {
    private static PropertiesReader propertiesReader = (PropertiesReader) SingleApplicationContext.getApplicationContext().getBean("propertiesReader");

    public static void sendEmail(String title,String content,String send_addr,String send_name) {
        try {
            // 1. 创建一封邮件
            Properties prop = propertiesReader.prop;                // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
            Session session = Session.getDefaultInstance(prop); // 根据参数配置，创建会话对象（为了发送邮件准备的）
            MimeMessage message = new MimeMessage(session);     // 创建邮件对象

            //开启session的调试模式，可以查看当前邮件发送状态
            session.setDebug(true);

            //2.通过session获取Transport对象（发送邮件的核心API）
            Transport ts = session.getTransport();

            //3.通过邮件用户名密码链接
            ts.connect(propertiesReader.email_um, propertiesReader.email_pw);
        /*
         * 也可以根据已有的eml邮件文件创建 MimeMessage 对象
         * MimeMessage message = new MimeMessage(session, new FileInputStream("MyEmail.eml"));
         */

            // 2. From: 发件人
            //    其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
            //    真正要发送时, 邮箱必须是真实有效的邮箱。
            message.setFrom(new InternetAddress(propertiesReader.email_addr, propertiesReader.email_send_name, "UTF-8"));

            // 3. To: 收件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(send_addr, send_name, "UTF-8"));
            //    To: 增加收件人（可选）
            //message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
            //    Cc: 抄送（可选）
            message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(propertiesReader.email_addr, propertiesReader.email_send_name, "UTF-8"));
            //    Bcc: 密送（可选）
            //message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));

            // 4. Subject: 邮件主题
            message.setSubject(title, "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）
            message.setContent(content, "text/html;charset=UTF-8");

            // 6. 设置显示的发件时间
            message.setSentDate(new Date());

            // 7. 保存前面的设置
            message.saveChanges();


            ts.sendMessage(message, message.getAllRecipients());
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void send_note_response(Visitor receiver,Visitor sender,Integer noteId){
        String pattern="^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+";
        if(Pattern.matches(pattern,receiver.getEmail())) {
            String url = propertiesReader.basic_url + "note/showNote";
            if(noteId!=null)
                url+="#"+noteId;
            String send_url = "<a href=\"" + url + "\">" + url + "</a>";
            String content = "\n" +
                    "<p>"+receiver.getName()+":</p>\n" +
                    "\n" +
                    "<p style=\"margin-left: 40px;\">您好，您收到了来自 &nbsp;"+sender.getName() +" &nbsp;的新回复。</p>\n" +
                    "\n" +
                    "<p style=\"margin-left: 40px;\">请访问："+send_url+"查看详情。</p>\n" +
                    "\n" +
                    "<p style=\"margin-left: 200px;\">from：caonuan&#39;s blog</p>";
            String title = "您有来自 caonuan的技术博客 新的回复";
            sendEmail(title, content, receiver.getEmail(), receiver.getName());
        }
    }
}
