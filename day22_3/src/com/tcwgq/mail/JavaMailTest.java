package com.tcwgq.mail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

import cn.itcast.mail.AttachBean;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

public class JavaMailTest {
	// 普通邮件
	@Test
	public void fun1() throws MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("itcwgq", "wgq681323668");
			}
		};

		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("itcwgq@163.com"));
		msg.setRecipients(RecipientType.TO, "770100361@qq.com");// 发送
		// outlook.com的邮箱不能抄送，一抄送就抛异常
		// msg.setRecipients(RecipientType.CC, "itcwgq@126.com");// 抄送
		msg.setRecipients(RecipientType.BCC, "tcwgq@yahoo.com");// 密送
		msg.setSubject("这是一封来自itcwgq的邮件");
		msg.setContent("这就是一封测试邮件，没什么用！", "text/html;charset=utf-8");
		Transport.send(msg);
	}

	// 带附件的邮件
	@Test
	public void fun2() throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("itcwgq", "wgq681323668");
			}
		};
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("itcwgq@163.com"));
		msg.setRecipients(RecipientType.TO, "770100361@qq.com");// 发送
		msg.setSubject("这是一封来自itcwgq的邮件，还带附件");
		MimeMultipart list = new MimeMultipart();
		MimeBodyPart part1 = new MimeBodyPart();
		part1.setContent("这就是一封测试邮件，没什么用！", "text/html;charset=utf-8");
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("d:/tomcat.png"));
		// 设置文件名称，并解决显示乱码问题
		part2.setFileName(MimeUtility.encodeText("小猫咪.png"));
		list.addBodyPart(part1);
		list.addBodyPart(part2);
		msg.setContent(list);
		Transport.send(msg);
	}

	// MailUtils的使用
	@Test
	public void fun3() throws AddressException, MessagingException, IOException {
		Session session = MailUtils.createSession("smtp.163.com", "itcwgq",
				"wgq681323668");
		Mail mail = new Mail("itcwgq@163.com", "770100361@qq.com",
				"不是垃圾邮件能是什么呢？", "这里是正文");
		AttachBean ab1 = new AttachBean(new File("d:/tomcat.png"), "小猫咪111.png");
		AttachBean ab2 = new AttachBean(new File("d:/tomcat.png"), "小猫咪222.png");
		mail.addAttach(ab1);
		mail.addAttach(ab2);
		MailUtils.send(session, mail);
	}

}
