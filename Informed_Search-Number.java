//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Number
//
// Author:          Mudit Joshi
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.*;


/**
 	*In this problem, we are given two integers X and Y. Write 
 	*a program Number.java to count the least
 	*steps we need to convert X to Y use the following rules:
 	* Increase X by 1.
 	* Decrease X by 1.
 	* Multiply X by 3.
 	* Get the square of X.
 	* You may assume that 0 ≤ X < 100, 0 ≤ Y < 100, and X 6= Y .
 	*  During the transformation process,
	*all numbers can not be less than 0 or greater than 99. That is,
	* if the transformation is X− > X1− >
	*X2− > Xk...− > Y , we have 0 ≤ Xi < 100 and i = 1, ...k.
*
*/
class Node {
	int value;
	int steps;

	public Node(int value, int steps) {
		this.value = value;
		this.steps = steps;
	}
}

/**
 * 
 * @author Mudit Joshi
 *
 */
public class Number {
	
	
	

	/**
	 *In this problem, we are given two integers X and Y. Write 
 	*a program Number.java to count the least
 	*steps we need to convert X to Y use the following rules:
 	* Increase X by 1.
 	* Decrease X by 1.
 	* Multiply X by 3.
 	* Get the square of X.
 	* You may assume that 0 ≤ X < 100, 0 ≤ Y < 100, and X 6= Y .
 	*  During the transformation process,
	*all numbers can not be less than 0 or greater than 99. That is,
	* if the transformation is X− > X1− >
	*X2− > Xk...
	 * @param x Lower number
	 * @param y higher number
	 * @return least number of steps
	 */
	public static String getStep(int x, int y) {
		String minsteps = "";

		HashSet<Integer> visitedstep = new HashSet<>();
		ArrayDeque<Node> arrayqueue = new ArrayDeque<Node>();

		Node arraynode = new Node(x, 0);
		arrayqueue.offer(arraynode);
		// visited.add(node.value); 
                                                                                               
		while (!arrayqueue.isEmpty()) {
			Node tempnode = arrayqueue.poll();
			visitedstep.add(tempnode.value);

			if (tempnode.value == y) {
				minsteps = "" + tempnode.steps;
				break;
			}

			int firstnode = tempnode.value + 1;
			int secondnode = tempnode.value - 1;
			int thirdnode = tempnode.value * 3;
			int fourthnode = tempnode.value * tempnode.value;

			// given constraints
			if (firstnode > 0 && firstnode < 100 && !visitedstep.contains(firstnode)) {
				Node nodeFirstOp = new Node(firstnode, tempnode.steps + 1);
				arrayqueue.offer(nodeFirstOp);
			}
			if (secondnode > 0 && secondnode < 100 && !visitedstep.contains(secondnode)) {
				Node nodeSecondOp = new Node(secondnode, tempnode.steps + 1);
				arrayqueue.offer(nodeSecondOp);
			}
			if (thirdnode > 0 && thirdnode < 100 && !visitedstep.contains(thirdnode)) {
				Node nodeThirdOp = new Node(thirdnode, tempnode.steps + 1);
				arrayqueue.offer(nodeThirdOp);
				// result = result + temp.steps;
			}
			if (fourthnode > 0 && fourthnode < 100 && !visitedstep.contains(fourthnode)) {
				Node nodeFourthOp = new Node(fourthnode, tempnode.steps + 1);
				arrayqueue.offer(nodeFourthOp);
				// result = result + temp.steps;
			}
		}
		return minsteps;
	}
	
	/**
	* The input and output formats are as follow:
    *Input: two integers X Y
    * Output: one integer k. Indicate that the least number of steps is k to transform X to Y following the
    *above rules.
	 *
	 *Print the list of successor states reachable in one step from the
	 * The least number of steps is 3. 
	 * We can transform like 1− > 2− > 6− > 5, that needs three steps.
	 *However, we cannot do it in less than 3 steps.

	 * 
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			return;
		}

		System.out.println(getStep(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

	}
}