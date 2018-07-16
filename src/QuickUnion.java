/**
 * The type Quick union.
 */
public class QuickUnion {
  private int idN;
  private int[] id;
  private int[] sizeOfRoot;

  /**
   * Instantiates a new Quick union.
   *
   * @param N the n
   */
  public QuickUnion(int N) {
    idN = N;
    id = new int[idN];
    sizeOfRoot = new int[idN];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sizeOfRoot[i] = 1;
    }
  }

  /**
   * Root int.
   *
   * @param i the
   * @return the int
   */
  public int root(int i) {
    while (id[i] != i) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }

  /**
   * Connected boolean.
   *
   * @param p the p
   * @param q the q
   * @return the boolean
   */
  public boolean connected (int p, int q) {
    return root(p) == root(q);
  }

  /**
   * Union.
   *
   * @param p the p
   * @param q the q
   */
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);

    if (sizeOfRoot[i] < sizeOfRoot[j]) {
      id[i] = j;
      sizeOfRoot[j] += sizeOfRoot[i];
    } else {
      id[j] = i;
      sizeOfRoot[i] += sizeOfRoot[j];
    }
  }

  /**
   * printArray.
   */
  public void printArray() {
    for(int i = 0; i < idN; i++) {
      System.out.println("site " + i + " : " + id[i]);
    }
  }


  /**
   * getSize int.
   */
  public int getSize(int i) {
    return sizeOfRoot[root(i)];
  }
}
