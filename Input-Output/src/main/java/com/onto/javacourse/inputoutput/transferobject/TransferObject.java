package com.onto.javacourse.inputoutput.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The TransferObject class facilitates the transfer of data from an InputStream to an OutputStream,
 * with the ability to skip a specified number of bytes (offset) before starting the transfer.
 */
public class TransferObject {

  private InputStream inputStream;
  private OutputStream outputStream;

  /**
   * Constructs a TransferObject with the given InputStream and OutputStream.
   *
   * @param inputStream the InputStream from which data will be read
   * @param outputStream the OutputStream to which data will be written
   */
  public TransferObject(InputStream inputStream, OutputStream outputStream) {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
  }

  /**
   * Transfers a specified number of bytes from the InputStream to the OutputStream,
   * starting after skipping a specified number of bytes (offset).
   *
   * @param numberOfBytes the number of bytes to transfer
   * @param offset the number of bytes to skip from the start of the input stream
   * @return the total number of bytes successfully transferred
   * @throws IOException if an I/O error occurs, including a negative offset
   */
  public int transfer(int numberOfBytes, int offset) throws IOException {
    if (offset >= 0) {
      inputStream.skip(offset);
    } else {
      throw new IOException(String.format("Offset is negative, offset: %d", offset));
    }

    byte[] buffer = new byte[1024];
    int totalBytesTransferred = 0;

    int bytesRead;
    while (totalBytesTransferred < numberOfBytes && (bytesRead = inputStream.read(buffer)) != -1) {
      int bytesToWrite = Math.min(bytesRead, numberOfBytes - totalBytesTransferred);
      outputStream.write(buffer, 0, bytesToWrite);
      totalBytesTransferred += bytesToWrite;
    }

    return totalBytesTransferred;
  }

  /**
   * Closes both the InputStream and OutputStream associated with this TransferObject.
   *
   * @throws IOException if an I/O error occurs during closing
   */
  public void close() throws IOException {
    inputStream.close();
    outputStream.close();
  }
}
