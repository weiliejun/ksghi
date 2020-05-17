package com.itech.ups.app.components.message.mail;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service("mailSenderService")
public class MailSenderServiceImp implements MailSenderService {
    private Logger logger = Logger.getLogger(MailSenderServiceImp.class);
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TaskExecutor taskExecutor;// 注入Spring封装的异步执行器

    private String fromMail; // 定义发送邮箱地址

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean sendMailBySynchronizationMode(MailEntity mailEntity) {
        Boolean isSuccess = false; // 表示发送状态
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(fromMail, "微金客");
            helper.setTo(mailEntity.getTo());
            helper.setSubject(mailEntity.getSubject());
            helper.setText(mailEntity.getText(), true);
            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
            CommandMap.setDefaultCommandMap(mc);
            mailSender.send(helper.getMimeMessage());
            isSuccess = true;
        } catch (MessagingException e) {
            e.printStackTrace();
            isSuccess = false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    /**
     * 异步发送
     *
     * @see com.zhangjihao.service.MailService#sendMailByAsynchronousMode(com.zha
     * ngjihao.bean.Email)
     */
    public void sendMailWithPureText(final MailEntity mailEntity) {
        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    sendMailBySynchronizationMode(mailEntity);
                } catch (Exception e) {
                    logger.info(e);
                }
            }
        });
    }

    /**
     * 发送带附件的邮件
     *
     * @param sender 邮件发送器
     * @throws Exception
     */
    public boolean sendMimeMessage(final MailEntity mailEntity) {
        Boolean isSuccess = false; // 表示发送状态
        try {
            // 附件文件集合
            final List<String> files = new ArrayList<String>();
            MimeMessagePreparator mimeMail = new MimeMessagePreparator() {
                public void prepare(MimeMessage mimeMessage) throws MessagingException {
                    mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailEntity.getTo()));
                    mimeMessage.setFrom(new InternetAddress(fromMail));
                    mimeMessage.setSubject(mailEntity.getSubject(), "UTF-8");

                    Multipart mp = new MimeMultipart();

                    // 设置邮件内容，创建存放能容的BodyPart对象
                    BodyPart mdp = new MimeBodyPart();
                    mdp.setContent(mailEntity.getText(), "text/html;charset=UTF-8");

                    mp.addBodyPart(mdp);
                    String[] filePaths = mailEntity.getFilePath().split(",");
                    for (String filePath : filePaths) {
                        files.add(filePath);
                    }
                    //files.add(mailEntity.getFilePath());


                    // 向Multipart添加附件
                    Iterator<String> it = files.iterator();
                    while (it.hasNext()) {
                        MimeBodyPart attachFile = new MimeBodyPart();
                        String filename = it.next().toString();

                        FileDataSource fds = new FileDataSource(filename);
                        attachFile.setDataHandler(new DataHandler(fds));
                        try {
                            int pos = filename.lastIndexOf(File.separator);
                            filename = filename.substring(pos + 1);
                            attachFile.setFileName(MimeUtility.encodeWord(filename, "GBK", null));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        mp.addBodyPart(attachFile);
                    }

                    files.clear();

                    mimeMessage.setContent(mp);
                    mimeMessage.setSentDate(new Date());
                }
            };
            mailSender.send(mimeMail);

            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        return isSuccess;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }
}