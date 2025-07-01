package com.onto.javacourse.mail;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MailTest {

  @Test
  public void testMailBuilderWithAllFields() {
    // Arrange
    List<String> cc = Arrays.asList("cc1@example.com", "cc2@example.com");
    List<String> attachments = Arrays.asList("file1.pdf", "file2.jpg");

    Mail mail = new Mail.Builder("sender@example.com")
        .to("recipient@example.com")
        .subject("Meeting Update")
        .content("Please find the attached meeting notes.")
        .cc(cc)
        .attachments(attachments)
        .build();

    assertNotNull(mail);
    assertEquals("sender@example.com", mail.getFrom());
    assertEquals("recipient@example.com", mail.getTo());
    assertEquals("Meeting Update", mail.getSubject());
    assertEquals("Please find the attached meeting notes.", mail.getContent());
    assertEquals(cc, mail.getCc());
    assertEquals(attachments, mail.getAttachments());
  }

  @Test
  public void testMailBuilderWithOnlyRequiredFields() {
    Mail mail = new Mail.Builder("sender@example.com")
        .build();

    assertNotNull(mail);
    assertEquals("sender@example.com", mail.getFrom());
    assertNull(mail.getTo());
    assertNull(mail.getSubject());
    assertNull(mail.getContent());
    assertNull(mail.getCc());
    assertNull(mail.getAttachments());
  }

  @Test
  public void testMailBuilderWithSomeOptionalFields() {
    List<String> cc = Arrays.asList("cc1@example.com");

    Mail mail = new Mail.Builder("sender@example.com")
        .to("recipient@example.com")
        .subject("Test Subject")
        .content("Test Content")
        .cc(cc)
        .build();

    assertNotNull(mail);
    assertEquals("sender@example.com", mail.getFrom());
    assertEquals("recipient@example.com", mail.getTo());
    assertEquals("Test Subject", mail.getSubject());
    assertEquals("Test Content", mail.getContent());
    assertEquals(cc, mail.getCc());
    assertNull(mail.getAttachments());
  }

  @Test
  public void testMailToStringMethod() {
    List<String> cc = Arrays.asList("cc1@example.com");
    List<String> attachments = Arrays.asList("file1.pdf");
    Mail mail = new Mail.Builder("sender@example.com")
        .to("recipient@example.com")
        .subject("Test Subject")
        .content("Test Content")
        .cc(cc)
        .attachments(attachments)
        .build();

    String mailString = mail.toString();

    assertTrue(mailString.contains("from='sender@example.com'"));
    assertTrue(mailString.contains("to='recipient@example.com'"));
    assertTrue(mailString.contains("subject='Test Subject'"));
    assertTrue(mailString.contains("content='Test Content'"));
    assertTrue(mailString.contains("cc=[cc1@example.com]"));
    assertTrue(mailString.contains("attachments=[file1.pdf]"));
  }
}
