package com.onto.javacourse.objectpool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObjectPoolTest {

  private ObjectPool<DatabaseConnection> pool;

  @BeforeEach
  void setUp() {
    pool = new ObjectPool<>(DatabaseConnection.class, 3);
  }

  @Test
  void testAcquireNewInstanceWhenPoolIsEmpty() throws Exception {
    DatabaseConnection conn = pool.acquire();
    assertNotNull(conn);
  }

  @Test
  void testAcquireMultipleInstances() throws Exception {
    DatabaseConnection conn1 = pool.acquire();
    DatabaseConnection conn2 = pool.acquire();
    DatabaseConnection conn3 = pool.acquire();

    assertNotNull(conn1);
    assertNotNull(conn2);
    assertNotNull(conn3);
  }

  @Test
  void testAcquireWhenPoolIsFull() {
    try {
      DatabaseConnection conn1 = pool.acquire();
      DatabaseConnection conn2 = pool.acquire();
      DatabaseConnection conn3 = pool.acquire();
      pool.acquire();
    } catch (Exception e) {
      assertEquals("No free resources available in the pool", e.getMessage());
    }
  }

  @Test
  void testReleaseObjectBackToPool() throws Exception {
    DatabaseConnection conn1 = pool.acquire();
    pool.release(conn1);

    DatabaseConnection conn2 = pool.acquire();
    assertSame(conn1, conn2);
  }

  @Test
  void testReleaseWhenPoolIsFull() throws Exception {
    DatabaseConnection conn1 = pool.acquire();
    DatabaseConnection conn2 = pool.acquire();
    DatabaseConnection conn3 = pool.acquire();

    pool.release(conn1);

    DatabaseConnection conn4 = pool.acquire();
    assertSame(conn1, conn4);
  }

  @Test
  void testAcquireAfterRelease() throws Exception {
    DatabaseConnection conn1 = pool.acquire();
    pool.release(conn1);

    DatabaseConnection conn2 = pool.acquire();
    assertSame(conn1, conn2);
  }

  @Test
  void testReleaseAfterMaxCapacity() throws Exception {
    DatabaseConnection conn1 = pool.acquire();
    DatabaseConnection conn2 = pool.acquire();
    DatabaseConnection conn3 = pool.acquire();

    pool.release(conn1);

    DatabaseConnection conn4 = pool.acquire();
    assertSame(conn1, conn4);
  }

  @Test
  void testAcquireAndReleaseCycle() throws Exception {
    DatabaseConnection conn1 = pool.acquire();
    pool.release(conn1);

    DatabaseConnection conn2 = pool.acquire();
    assertSame(conn1, conn2);
  }
}
