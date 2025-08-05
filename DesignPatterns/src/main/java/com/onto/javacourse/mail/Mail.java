package com.onto.javacourse.mail;

import java.util.List;

/**
 * Represents an email with optional fields such as recipient,
 * subject, content, CC, and attachments.
 */
public class Mail {
  private String from;
  private String to;
  private String subject;
  private String content;
  private List<String> cc;
  private List<String> attachments;

  /**
   * Private constructor to prevent direct instantiation.
   */
  private Mail() {}

  /**
   * Builder class for constructing a Mail object.
   */
  public static class Builder {
    private String from;
    private String to;
    private String subject;
    private String content;
    private List<String> cc;
    private List<String> attachments;

    /**
     * Initializes the builder with the required 'from' field.
     *
     * @param from the sender's email address
     */
    public Builder(String from) {
      this.from = from;
    }

    /**
     * Sets the recipient's email address.
     *
     * @param to the recipient's email address
     * @return the builder instance for chaining
     */
    public Builder to(String to) {
      this.to = to;
      return this;
    }

    /**
     * Sets the email subject.
     *
     * @param subject the subject of the email
     * @return the builder instance for chaining
     */
    public Builder subject(String subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Sets the email content.
     *
     * @param content the content of the email
     * @return the builder instance for chaining
     */
    public Builder content(String content) {
      this.content = content;
      return this;
    }

    /**
     * Sets the list of CC email addresses.
     *
     * @param cc the list of CC email addresses
     * @return the builder instance for chaining
     */
    public Builder cc(List<String> cc) {
      this.cc = cc;
      return this;
    }

    /**
     * Sets the list of attachments.
     *
     * @param attachments the list of attachment file names
     * @return the builder instance for chaining
     */
    public Builder attachments(List<String> attachments) {
      this.attachments = attachments;
      return this;
    }

    /**
     * Builds and returns the constructed Mail object.
     *
     * @return the constructed Mail object
     */
    public Mail build() {
      Mail mail = new Mail();
      mail.from = this.from;
      mail.to = this.to;
      mail.subject = this.subject;
      mail.content = this.content;
      mail.cc = this.cc;
      mail.attachments = this.attachments;
      return mail;
    }
  }

  /**
   * Gets the sender's email address.
   *
   * @return the sender's email address
   */
  public String getFrom() {
    return from;
  }

  /**
   * Gets the recipient's email address.
   *
   * @return the recipient's email address
   */
  public String getTo() {
    return to;
  }

  /**
   * Gets the email subject.
   *
   * @return the email subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Gets the email content.
   *
   * @return the email content
   */
  public String getContent() {
    return content;
  }

  /**
   * Gets the list of CC email addresses.
   *
   * @return the list of CC email addresses
   */
  public List<String> getCc() {
    return cc;
  }

  /**
   * Gets the list of attachment file names.
   *
   * @return the list of attachment file names
   */
  public List<String> getAttachments() {
    return attachments;
  }

  /**
   * Returns a string representation of the Mail object.
   *
   * @return string representation of the Mail object
   */
  @Override
  public String toString() {
    return "Mail{" + "from='" + from + '\'' + ", to='"
        + to + '\'' + ", subject='" + subject + '\''
        + ", content='" + content + '\'' + ", cc=" + cc
        + ", attachments=" + attachments + '}';
  }
}
