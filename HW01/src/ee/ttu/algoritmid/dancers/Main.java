package ee.ttu.algoritmid.dancers;

import java.awt.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*BinaryTree tree = new BinaryTree();
		Node d1 = new Node(new DancerImpl(1, true, 189));
		Node d2 = new Node(new DancerImpl(2, true, 179));
		Node d3 = new Node(new DancerImpl(3, true, 178));
		
		Node f = new Node(new DancerImpl(4, false, 181));
		f.setValue(181);
		
		tree.insertToTree(d1);
		tree.insertToTree(d3);
		tree.insertToTree(d2);
		//System.out.println(tree.root.getLeft().getRight().getValue());
		
		System.out.println(tree.getFemalePartner(f.getValue()).getValue());
		System.out.println(tree.getFemalePartner(f.getValue()).getValue());
		System.out.println(tree.getFemalePartner(f.getValue()).getValue());*/
		
		HW01 test = new HW01();
		/*Dancer m1 = new DancerImpl(1, true, 180);
		Dancer m2 = new DancerImpl(2, true, 190);
		Dancer m3 = new DancerImpl(3, true, 170);
		Dancer m4 = new DancerImpl(4, true, 150);
		
		Dancer n1 = new DancerImpl(5, false, 169);
		Dancer n2 = new DancerImpl(6, false, 179);
		Dancer n3 = new DancerImpl(7, false, 200);
		Dancer n4 = new DancerImpl(8, false, 170);

		System.out.println(test.findPartnerFor(n1));
		System.out.println(test.findPartnerFor(n2));
		System.out.println(test.findPartnerFor(n3));
		System.out.println(test.findPartnerFor(n4));
		/*System.out.println(test.findPartnerFor(m1));
		System.out.println(test.findPartnerFor(m3));
		System.out.println(n1);
		System.out.println(test.findPartnerFor(m1));
		System.out.println(test.findPartnerFor(m4));*/
		/*for (int i = 0; i < 100; i++) {
			test.findPartnerFor(new DancerImpl(1, false, 189-i));
		}
		for (int i = 0; i < 50; i++) {
			test.findPartnerFor(new DancerImpl(1, true, 190-i));
		}*/
		DancerImpl d = new DancerImpl(1, true, 189);
		DancerImpl d2 = new DancerImpl(2, true, 190);
		DancerImpl m1 = new DancerImpl(3, true, 188);
		DancerImpl m2 = new DancerImpl(3, false, 189);
		System.out.println("Tantsijad");
		System.out.println("Naine1: " + d);
		System.out.println("Naine2: " + d2);
		System.out.println("Mees1: " + m1);
		System.out.println("Mees2: " + m2);
		System.out.println(test.findPartnerFor(d));
		System.out.println(test.findPartnerFor(d2));
		//System.out.println(test.returnWaitingList());
		System.out.println(test.findPartnerFor(m1));
		//System.out.println(test.returnWaitingList());
		System.out.println(test.findPartnerFor(m2));
		//test.findPartnerFor(new DancerImpl(4, false, 187));
		System.out.println(test.returnWaitingList());
	}

}
