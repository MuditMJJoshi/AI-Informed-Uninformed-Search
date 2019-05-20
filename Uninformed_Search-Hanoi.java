//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Hanoi
//
// Author:          Mudit Joshi
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.*;

/**
 * 
 * Tower of Hanoi is a famous game. In this game, there
 *  are some disks and rods and disk can be placed on other
*rods based on some rules. The rule of this game can be found at 
* (https://en.wikipedia.org/wiki/Tower of Hanoi).
* In this problem, we consider a modified version of Tower of Hanoi game. 
* It has the following rules:
* CS 540 Spring 2019
* In each step, only one disk can be moved.
* In each step, a disk can only be moved to the adjacent rod(s).
* A disk can only be placed in an empty rod or on a larger disk.
* There can be more than three rods in this game. In the beginning, 
* all disk can be randomly placed on
* different rods
 * 
 * 
 * @author Mudit Joshi            
 *
 */
public class Hanoi {

    
	/*
	 * 
	 */
	public static List<String> getSuccessor(String[] hanoi) {

		// Check each peg, see what you can move, store it in a new array

		List<String> result = new ArrayList<>();

		String[] Stringcopy = new String[hanoi.length];

		String[] Stringchange = new String[hanoi.length];

		String comparable = "";
 
		boolean checkedLeft = false;

// For loop for every action check

		for (int i = 0; i < hanoi.length; i++) {

// Reset temp with hanoi to check for next value

			for (int j = 0; j < hanoi.length; j++) {

				Stringcopy[j] = hanoi[j];

			}

			comparable = "";

// Check to see if there are values to manipulate in current state

			if (!Stringcopy[i].equals("0")) {

// Split peg into separate string values

				Stringchange = hanoi[i].split("");

// Checking left most peg

				if (i == 0) {

// If the next peg has nothing

					if (Stringcopy[i + 1].equals("0")) {

// Put the ring from the left side peg onto current peg

						Stringcopy[i + 1] = Stringchange[0];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

																																																																																																																																																																																																																																																																																																			// Go to next 	

						continue;

					}

																																																																																																																													// If the left peg has something, compare to see if its greater

					if (Stringcopy[i + 1].compareTo(Stringchange[0]) > 0) {

						Stringcopy[i + 1] = Stringchange[0] + Stringcopy[i + 1];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

						// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next 

						continue;

					}

				}

				//Check middle peg(s)

				if (i > 0 && i < hanoi.length - 1) {

					// If left of peg has nothing

					if (hanoi[i - 1].equals("0") && !checkedLeft) {

						// Put the ring from the right side peg onto current peg

						Stringcopy[i - 1] = Stringchange[0];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

							// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next 

						i--;

						checkedLeft = true;

						continue;

					}

// If left peg has something, check if its greater

					if (Stringcopy[i - 1].substring(0, 1).compareTo(Stringchange[0]) > 0 && !checkedLeft) {

						if (Stringcopy[i - 1].equals("0"))

							Stringcopy[i - 1] = Stringchange[0];

						else

							Stringcopy[i - 1] = Stringchange[0] + Stringcopy[i - 1];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

						// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next

						i--;

						checkedLeft = true;

						continue;

					}

					checkedLeft = false;

					if (hanoi[i + 1].equals("0")) {
						
				// Put the ring from the left side peg onto current peg

						Stringcopy[i + 1] = Stringchange[0];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

						// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next 

						continue;

					}

					// If left peg has something, check to see if greater

					if (Stringcopy[i + 1].compareTo(Stringchange[0]) > 0) {

						Stringcopy[i + 1] = Stringchange[0];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

						// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next 

						continue;

					}

				}

				// Check ending peg

				if (i == hanoi.length - 1) {

					if (hanoi[hanoi.length - 2].equals("0")) {

// Put the ring from the left side peg onto current peg

						Stringcopy[i - 1] = Stringchange[0];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

						// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next 

						continue;

					}

					if (Stringcopy[i - 1].compareTo(Stringchange[0]) > 0) {

						Stringcopy[i - 1] = Stringchange[0];

						if (Stringcopy[i].length() > 1)

							Stringcopy[i] = Stringcopy[i].substring(1);

						else
							Stringcopy[i] = "0";

						// Save the string for results

						for (int j = 0; j < Stringcopy.length - 1; j++) {

							comparable = comparable + Stringcopy[j] + " ";

						}

						comparable += Stringcopy[Stringcopy.length - 1];

						result.add(comparable);

						// Go to next 

						continue;

					}

				}

			}

		}

		return result;

	}

	/*
	 * 
	 * Print the list of successor states reachable in one step 
	 * from the given input. Each line of
	 *output represents a state, the outputs follow the same format.
	 * The successors should not include the	
	 *initial state itself or duplicates.
	 * 
	 */
    public static void main(String[] args) {

        if (args.length < 3) {

        return;

    }


        List<String> sucessors = getSuccessor(args);

        for (int i = 0; i < sucessors.size(); i++) {

            System.out.println(sucessors.get(i));

        }    

    } 

}


