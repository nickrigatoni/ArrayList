import java.util.*;

public class ArrayList_Rigatti<E> extends AbstractList<E> implements List<E>{
  
  private int size = 0; 
  private E[] myArr;
  
  public ArrayList_Rigatti(){
    myArr=(E[])new Object[0];
  }
  
  public ArrayList_Rigatti(int initialCapacity){
    myArr=(E[])new Object[initialCapacity];
  }
  
  public ArrayList_Rigatti(Collection<? extends E>myCol){
    myArr=(E[])new Object[0];
    this.addAll(myCol);
    size = myCol.size();
  }

  //clears myArr

  public void clear(){
    myArr = (E[])new Object[0];
    size=0;
  }
  
  //returns size of myArr
  public int size(){
    return size;
  }
  
  //gets whatever is at this index in myArr

  public E get(int index){
    return myArr[index];
  }

  //increases capacity of the array
  
  public void ensureCapacity(int minCapacity){
    E[] myArr0 = (E[])new Object[minCapacity];
    for (int x=0; x<myArr.length; x++){
      myArr0[x] = myArr[x];
    }
    myArr = myArr0;
  }

  //adds variable e to the end of myArr

  public boolean add(E e){
    int aa = myArr.length;
    E[] myArr3 = (E[])new Object[aa+1];
    for (int y = 0; y<myArr.length; y++){
      myArr3[y]=myArr[y];
    }
    myArr3[aa]=e;
    myArr=myArr3;
    size++;
    return true;
  }

  //adds elem to the index in myArr
  
  public void add(int index, E elem){
    int l = myArr.length;
    E[] myArr2 = (E[])new Object[l+1];
    for (int r = 0; r<index; r++){
      myArr2[r] = myArr[r];
    }
    myArr2[index] = elem;
    for (int s = index+1; s<1; s++){
      myArr2[s+1] = myArr[s];
    }
    myArr = myArr2;
    size++;
  }

  //returns the index of o
  
  public int indexOf(Object o){
    for(int x = 0; x<myArr.length; x++){
      if (myArr[x].equals(o)){
        return x;
      }
    }
    return -1;
  }

  //checks if o is in the array

  public boolean contains(Object o){
    for (int x = 0; x<myArr.length; x++){
      if (myArr[x].equals(o)){
        return true;
      }
    }
    return false;
  }

  //sets index i to e
  
  public E set(int index, E thingamajig){
    E thing = myArr[index];
    myArr[index] = thingamajig;
    return thing;
  }

  //returns the last occurrence of o

  public int lastIndexOf(Object o){
    int x = -1;
    for (int y = 0; y<myArr.length; y++){
      if (myArr[y].equals(o))
        x=y;
    }
    return x;
  }

  //returns the array'
  
  public Object[] toArray(){
    return myArr;
  }

  //trims myArr to remove all empty spaces

  public void trimToSize(){
    int n = 0;
    for (int x = 0; x<myArr.length; x++){
      if (myArr[x] != null)
        n++;
    }
    E[] myArrAgain = (E[])new Object[n];
    int z = 0;
    for (int y = 0; y<myArrAgain.length; y++){
      if (myArr[y] != null){
        myArrAgain[y] = myArr[z];
        z++;
      }
    }
    myArr = myArrAgain;
  }

  //removes any appearance of o

  public boolean remove(Object o){
    E[] myArr2 = (E[])new Object[size-1];
    int j = 0;
    for(int i = 0; i < size; i++){
      myArr2[j] = myArr[i];
      j++;
      if(myArr[i].equals(o)){
        j--;
        }
      }
    if (myArr.length > myArr2.length){
      myArr = myArr2;
      return true;
    }
    return false;
  }

  //removes whatever is at index

  public E remove(int i){
    E e = myArr[i];
     E[] myArr2 = (E[])new Object[size-1];
    for (int j = 0; j<i; j++){
      myArr2[j] = myArr[j];
    }
    for (int j = i; j<size-1; j++){
      myArr2[j] = myArr[i+1];
      i++;
    }
    size--;
    myArr = myArr2;
    return e;
  }
 
  //removes the range between i and j

  protected void removeRange(int i, int j){
    int b = Math.abs(j-i);
    E[] myArr2 = (E[])new Object[myArr.length-b];
    for (int x = 0; x<i; x++){
      myArr2[x] = myArr[x];
    }
    for (int y = i; y<myArr2.length; y++){
      myArr2[y] = myArr[y+b];
    }
    myArr = myArr2;
    int sub = j-i;
    size-=sub;
  }

  //returns the sublist from i to j

  public List<E> subList(int i, int j){
    List<E> myArr2 = new ArrayList_Rigatti();
    for (int y = i; y<j; y++){
      myArr2.add(myArr[y]);
    }
    return myArr2;
  }
}