public class Die{

  private int topFace;

  public Die(){
    this.topFace = 1;
   }

  public String toString(){
    return "" + topFace;
  }

  public int getTopFace(){
	return this.topFace;
}

  public void setTopFace(int topFace){
	this.topFace = topFace;
}

  public void roll(){
	this.topFace = ((int)(Math.random() * 6)) + 1;
}

  public static void main(String[] args){
    Die d = new Die();
    System.out.println("Before rolling: "+d.getTopFace());
    d.roll();
    System.out.println("After rolling: "+d.getTopFace());
}

}
