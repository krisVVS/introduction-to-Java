package com.onto.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic class to handle pagination of a list of items.
 * The items are divided into pages, with a specified number of items per page.
 *
 * @param <T> the type of items in the list
 */
public class PageBean<T> {

  private List<T> items;
  private int pageSize;
  private int currentPage;

  /**
   * Constructs a new PageBean with the specified list of items and page size.
   *
   * @param items    the list of items to be paginated
   * @param pageSize the number of items per page
   */
  public PageBean(List<T> items, int pageSize) {
    this.items = items;
    this.pageSize = pageSize;
    this.currentPage = 1;
  }

  /**
   * Returns a sublist of items representing the current page.
   *
   * @return a list of items on the current page
   */
  private List<T> getCurrentPageItems() {
    int startIndex = (currentPage - 1) * pageSize;
    int endIndex = Math.min(startIndex + pageSize, items.size());
    return items.subList(startIndex, endIndex);
  }

  /**
   * Moves to the next page and returns the items on that page.
   *
   * @return a list of items on the next page, or an empty list if already on the last page
   */
  public List<T> next() {
    if (hasNext()) {
      System.out.println("This is page " + (currentPage + 1));
      currentPage++;
      return getCurrentPageItems();
    } else {
      System.out.println("You are already on the last page.");
      return new ArrayList<>();
    }
  }

  /**
   * Moves to the previous page and returns the items on that page.
   *
   * @return a list of items on the previous page, or an empty list if already on the first page
   */
  public List<T> previous() {
    if (hasPrevious()) {
      System.out.println("This is page " + (currentPage - 1));
      currentPage--;
      return getCurrentPageItems();
    } else {
      System.out.println("You are already on the first page.");
      return new ArrayList<>();
    }
  }

  /**
   * Checks if there is a next page.
   *
   * @return true if there are more pages, false otherwise
   */
  public boolean hasNext() {
    return currentPage * pageSize < items.size();
  }

  /**
   * Checks if there is a previous page.
   *
   * @return true if there is a previous page, false otherwise
   */
  public boolean hasPrevious() {
    return currentPage > 1;
  }

  /**
   * Returns the first page of items.
   *
   * @return a list of items on the first page
   */
  public List<T> firstPage() {
    currentPage = 1;
    System.out.println("This is page " + currentPage);
    return getCurrentPageItems();
  }

  /**
   * Returns the last page of items.
   *
   * @return a list of items on the last page
   */
  public List<T> lastPage() {
    currentPage = (int) Math.ceil((double) items.size() / pageSize);
    System.out.println("This is page " + currentPage);
    return getCurrentPageItems();
  }

  /**
   * Returns the current page number.
   *
   * @return the current page number
   */
  public int getCurrentPageNumber() {
    return currentPage;
  }
}
