package com.onto.javacourse.timeouthashtable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeoutHashtableTest {

  private TimeoutHashtable table;

  @AfterEach
  void tearDown() {
    if (table != null) {
      table.shutdown();
    }
  }

  @Test
  void testPutAndGet() {
    table = new TimeoutHashtable(2000);
    table.put("alpha", "one");
    assertEquals("one", table.get("alpha"));
  }

  @Test
  void testRemove() {
    table = new TimeoutHashtable(2000);
    table.put("beta", "two");
    assertEquals("two", table.remove("beta"));
    assertNull(table.get("beta"));
  }

  @Test
  void testExpiration() throws InterruptedException {
    table = new TimeoutHashtable(500);
    table.put("gamma", "three");
    assertEquals("three", table.get("gamma"));
    Thread.sleep(1000);
    assertNull(table.get("gamma"));
  }

  @Test
  void testGetRefreshesTimeout() throws InterruptedException {
    table = new TimeoutHashtable(700);
    table.put("delta", "four");
    Thread.sleep(500);
    assertEquals("four", table.get("delta"));
    Thread.sleep(500);
    assertEquals("four", table.get("delta"));
  }
}
