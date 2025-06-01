package com.onto.javacourse.collections.pagebean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PageBeanTest {

  private PageBean<String> pageBean;
  private List<String> items;

  @BeforeEach
  void setUp() {
    items = new ArrayList<>();
    for (int i = 1; i <= 15; i++) {
      items.add("Item " + i);
    }
    pageBean = new PageBean<>(items, 5);
  }

  @Test
  void testFirstPage() {
    List<String> firstPageItems = pageBean.firstPage();
    assertEquals(5, firstPageItems.size());
    assertTrue(firstPageItems.contains("Item 1"));
    assertTrue(firstPageItems.contains("Item 2"));
    assertTrue(firstPageItems.contains("Item 3"));
    assertTrue(firstPageItems.contains("Item 4"));
    assertTrue(firstPageItems.contains("Item 5"));
  }

  @Test
  void testNextPage() {
    pageBean.firstPage();
    List<String> nextPageItems = pageBean.next();
    assertEquals(5, nextPageItems.size());
    assertTrue(nextPageItems.contains("Item 6"));
    assertTrue(nextPageItems.contains("Item 7"));
    assertTrue(nextPageItems.contains("Item 8"));
    assertTrue(nextPageItems.contains("Item 9"));
    assertTrue(nextPageItems.contains("Item 10"));
  }

  @Test
  void testPreviousPage() {
    pageBean.firstPage();
    pageBean.next();
    List<String> previousPageItems = pageBean.previous();
    assertEquals(5, previousPageItems.size());
    assertTrue(previousPageItems.contains("Item 1"));
    assertTrue(previousPageItems.contains("Item 2"));
    assertTrue(previousPageItems.contains("Item 3"));
    assertTrue(previousPageItems.contains("Item 4"));
    assertTrue(previousPageItems.contains("Item 5"));
  }

  @Test
  void testHasNext() {
    pageBean.firstPage();
    assertTrue(pageBean.hasNext());
    pageBean.next();
    assertTrue(pageBean.hasNext());
    pageBean.next();
    assertFalse(pageBean.hasNext());
  }

  @Test
  void testHasPrevious() {
    pageBean.firstPage();
    assertFalse(pageBean.hasPrevious());
    pageBean.next();
    assertTrue(pageBean.hasPrevious());
  }

  @Test
  void testLastPage() {
    pageBean.firstPage();
    List<String> lastPageItems = pageBean.lastPage();
    assertEquals(5, lastPageItems.size());
    assertTrue(lastPageItems.contains("Item 11"));
    assertTrue(lastPageItems.contains("Item 12"));
    assertTrue(lastPageItems.contains("Item 13"));
    assertTrue(lastPageItems.contains("Item 14"));
    assertTrue(lastPageItems.contains("Item 15"));
  }

  @Test
  void testGetCurrentPageNumber() {
    pageBean.firstPage();
    assertEquals(1, pageBean.getCurrentPageNumber());
    pageBean.next();
    assertEquals(2, pageBean.getCurrentPageNumber());
    pageBean.next();
    assertEquals(3, pageBean.getCurrentPageNumber());
    pageBean.previous();
    assertEquals(2, pageBean.getCurrentPageNumber());
  }

  @Test
  void testEdgeCaseWithLastPage() {
    pageBean.firstPage();
    pageBean.next();
    pageBean.next();
    List<String> lastPageItems = pageBean.next();
    assertTrue(lastPageItems.isEmpty());
  }

  @Test
  void testEdgeCaseWithFirstPage() {
    pageBean.firstPage();
    List<String> firstPageItems = pageBean.previous();
    assertTrue(firstPageItems.isEmpty());
  }
}
