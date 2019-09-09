package ee.ttu.algoritmid.dancers;


import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class HW01 implements Dancers {
	
	private BinaryTree maleTree = new BinaryTree();
	private BinaryTree femaleTree = new BinaryTree();

	@Override
	
	public SimpleEntry<Dancer, Dancer> findPartnerFor(Dancer d)
	
	       	throws IllegalArgumentException {
		
						if (d == null) {throw new IllegalArgumentException();}
		
						else if (d.isMale() == true) {
		                	   Node partner = femaleTree.getFemalePartner(d.getHeight());
		                	   if (partner == null) {
		                		   maleTree.insertToTree(new Node(d));
		                		   return null;
		                	   } else {
		                		   return new SimpleEntry<Dancer, Dancer> (d, partner.getDancer());
		                	   }
						} else {
		                	   Node partner = maleTree.getMalePartner(d.getHeight());
		                	   if (partner == null) {
		                		   femaleTree.insertToTree(new Node(d));
		                		   return null;
		                	   } else {
		                		   return new SimpleEntry<Dancer, Dancer> (d, partner.getDancer());
		                	   }
						}
	
	}

	@Override
	
	public List<Dancer> returnWaitingList() {
	
	                   List<Dancer> waitingList = new ArrayList<Dancer>();
	                   List<Dancer> maleList = maleTree.getAllDancers();
	                   List<Dancer> femaleList = femaleTree.getAllDancers();
	                   while (femaleList != null && maleList != null
	                		   && !femaleList.isEmpty() && !maleList.isEmpty()) {
	                	  Dancer male = maleList.get(0);
	                	  Dancer female = femaleList.get(0);
	                	  
	                	  if (female.getHeight() >= male.getHeight()) {
	                		  waitingList.add(male);
	                		  maleList.remove(0);
	                	  } else {
	                		  waitingList.add(female);
	                		  femaleList.remove(0);
	                	  }
	                   }

	                   if (maleList != null) waitingList.addAll(maleList);
	                   if (femaleList != null) waitingList.addAll(femaleList);
	
	                   return waitingList ;
	
	}

}