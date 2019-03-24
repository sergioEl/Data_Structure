import java.util.*;

public class Beetle{

	//add ArrayList
	ArrayList<Integer> rollHistory = new ArrayList<>();

	//public int count = 0;
	private int noOfRolls;

	private boolean body;
	private int eyes;
	private int feelers;
	private boolean head;
	private int legs;
	private boolean tail;

	public Beetle(){
	  body = false;
	  eyes = 0;
	  feelers = 0;
	  head = false;
	  legs = 0;
	  tail = false;
	  noOfRolls = 0;
}

//add history
	public void addHistory(int die){
	  rollHistory.add(die);
}

	public void getHistory(){
	  System.out.println("Roll History: "+rollHistory);
}

	public void getNoOfDie(){
          System.out.println("No. of 1s: "+Collections.frequency(rollHistory,1)+", 2s: " +Collections.frequency(rollHistory,2)+", 3s: "+Collections.frequency(rollHistory,3)+", 4s: " +Collections.frequency(rollHistory,4)+", 5s: " +Collections.frequency(rollHistory,5)+", 6s: " +Collections.frequency(rollHistory,6));
        }
//history end

	public int getNoOfRolls(){
	  return noOfRolls;
}

	public void incrementNoOfRolls(){
	  noOfRolls++;
}

	public boolean addBody(){
		if(body){
		  return false;
}		else{
		  body = true;
		  return true;
}
}

	public boolean addEye(){
	  if(head && (eyes < 2)){
	    eyes++;
	    return true;
	  } else{
	    return false;
	  }
	}

	public boolean addHead(){
	  if(body && !head){
	    head = true;
	    return true;
	  } else{
	    return false;
	  }
	}

	public boolean addFeeler(){
	  if(head && (feelers < 2)){
	    feelers++;
	    return true;
	  } else{
	    return false;
	  }
	}

	public boolean addLeg(){
	  if(body && (legs < 6)){
	    legs++;
	    return true;
	  } else{
	    return false;
	  }
	}

	public boolean addTail(){
	  if(body && !tail){
	    tail = true;
	    return true;
	  } else{
	    return false;
	  }
	}

	public boolean isComplete(){
	  return body && (eyes == 2) && (feelers ==2)&&head && (legs ==6) && tail;
	}

	public String toString(){
	  if(body){
	    String result = "";
	    if(feelers > 0){
	      result +="\\";
	      if(feelers ==2){
	        result += " /";
	      }
	      result += "\n";
	    }
	    if(head){
	      if(eyes > 0){
	        result += "o";
	      }else{
	       result += " ";
	      }
	      result += "O";
	      if(eyes == 2){result += "o";}
	      result += "\n";
	    }
	    if(legs > 0){
	      result += "-";
	    }else {
	     result += " ";
	    }
	    result += "#";
	    if(legs > 1){
	      result += "-";
	    }
	    result += "\n";
	    if (legs > 2){
	      result += "-";
	    } else{
	      result += " ";
	    }
	    result += "#";
	    if (legs > 3) {
	      result += "-";
	    }
	    result += "\n";
	    if (legs > 4){
	      result += "-";
	    } else{
	      result += " ";
	    }
	    result += "#";
	    if(legs > 5) {
	      result += "-";
	    }
	    if(tail){
	      result += "\n v";
	    }
	    return result;
	} else{
	  return "(no parts yet)";
	}
}
}
