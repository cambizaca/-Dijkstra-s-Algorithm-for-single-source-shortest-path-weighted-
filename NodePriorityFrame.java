package assignment5_f20;


public class NodePriorityFrame {
  public Node value;  // a hex string for an address block
  public int priority;  // a fequency counter, used as priority
  private int slot; // the subscript where this element is in the heap array

  public NodePriorityFrame(Node node, int ap) {
    this.value = node;
    this.priority = ap;
    this.slot = 0; // this will change as the array is manipulated
  }

  public Node getValue() { return this.value; }
  // no setValue... value will not change once set in constructor
  
  public int getPriority() { return this.priority; }
  public void setPriority(int p) { this.priority = p; }
  
  public int getSlot() { return this.slot; }
  public void setSlot(int s) { this.slot = s; }
   
  @Override
  public String toString() {
    return "(val: " + value + ", pri:"  + priority + ", slot: " + slot + ")";
  }
}
