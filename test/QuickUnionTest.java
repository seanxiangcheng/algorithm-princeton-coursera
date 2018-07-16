import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class QuickUnionTest {
  private int N;
  private QuickUnion tester;

  @Before
  public void setUp() {
    N = 10;
    tester = new QuickUnion(N);
  }

  @After
  public void tearDown() {
  }

  @Test
  public void connect2pairs() {
    tester.union(3, 4);
    tester.union(3, 5);

    // assert statements
    // connected
    assertFalse(tester.connected(1, 2));
    assertTrue(tester.connected(3, 4));
    assertTrue(tester.connected(4, 5));
    assertFalse(tester.connected(1, 9));
    assertFalse(tester.connected(3, 8));
    assertFalse(tester.connected(4, 8));
    assertFalse(tester.connected(5, 8));

    // root
    assertEquals(tester.root(3), 3);
    assertEquals(tester.root(4), 3);
    assertEquals(tester.root(5), 3);
  }

  @Test
  public void flatRoot() {
    tester.union(3,4);
    tester.union(4,5);
    tester.union(5,6);
    tester.union(6,7);
    tester.union(7,8);
    tester.union(8,9);

    // assert statements
    // connected
    assertFalse(tester.connected(1, 2));
    assertTrue(tester.connected(3, 4));
    assertTrue(tester.connected(4, 5));
    assertFalse(tester.connected(1, 9));
    assertTrue(tester.connected(3, 8));
    assertTrue(tester.connected(4, 8));
    assertTrue(tester.connected(5, 8));

    // root
    assertEquals(tester.root(3), 3);
    assertEquals(tester.root(4), 3);
    assertEquals(tester.root(5), 3);
    assertEquals(tester.root(9), 3);

    // size
    assertEquals(tester.getSize(2), 1);
    assertEquals(tester.getSize(3), 7);
  }

  @Test
  public void mergeOf2Roots() {
    tester.union(2,3);
    tester.union(3,4);
    tester.union(4,5);
    tester.union(6,7);
    tester.union(7,8);
    tester.union(8,9);

    tester.union(2, 9);

    // assert statements
    // connected
    assertFalse(tester.connected(1, 2));
    assertTrue(tester.connected(3, 4));
    assertTrue(tester.connected(4, 5));
    assertFalse(tester.connected(1, 9));
    assertTrue(tester.connected(3, 8));
    assertTrue(tester.connected(4, 8));
    assertTrue(tester.connected(5, 8));

    // root
    assertEquals(tester.root(3), 2);
    assertEquals(tester.root(4), 2);
    assertEquals(tester.root(5), 2);
    assertEquals(tester.root(6), 2);
    assertEquals(tester.root(9), 2);

    // size
    assertEquals(tester.getSize(2), 8);
    assertEquals(tester.getSize(6), 8);
    assertEquals(tester.getSize(1), 1);
  }

  @Test
  public void mergeOf3Roots() {
    tester.union(1,9);
    tester.union(2,8);
    tester.union(3,7);
    tester.union(1,2);
    tester.union(2,3);


    // assert statements
    // connected
    assertTrue(tester.connected(1, 2));
    assertTrue(tester.connected(1, 3));
    assertTrue(tester.connected(1, 9));
    assertTrue(tester.connected(1, 8));
    assertTrue(tester.connected(1, 7));

    // root
    assertEquals(tester.root(2), 1);
    assertEquals(tester.root(3), 1);
    assertEquals(tester.root(4), 4);
    assertEquals(tester.root(7), 1);
    assertEquals(tester.root(8), 1);
    assertEquals(tester.root(9), 1);

    // size
    assertEquals(tester.getSize(1), 6);
    assertEquals(tester.getSize(2), 6);
    assertEquals(tester.getSize(8), 6);
  }
}