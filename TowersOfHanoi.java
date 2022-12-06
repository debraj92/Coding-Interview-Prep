package JavaLearn;

public class TowersOfHanoi {
	
	public static void main(String[]args) {
		int n = 5;
		move('A','C','B',n);
	}
	
	/**
	 1
	_A_ | _B_| _C_
	
	To move a single disk, the operation is : Move(A->C)
	
	For n disks, we have to move n-1 disks to B : Move*(A->B using C), Move (A->C), Move*(B->C using A).
	Move* : Implies move all disks (this is recursive call).
	
	For example (start from disk 10):
	
	
	
	 1  -> Goes to B                ----> Target tower B
	 2  -> [1]     A->B             ----> Target tower C
	 3  -> [1..2] A->C              ----> Target tower B
	 4  -> [1..3] A->B              ----> Target tower C
	 5  -> [1..4] A->C              ----> Target tower B
	 6  -> [1..5] A->B              ----> Target tower C
	 7  -> [1..6] A->C              ----> Target tower B
	 8  -> [1..7] Goes A to B       ----> Target tower C
	 9  -> [1..8] Goes A to C, 9 Goes A to B, [1..8] Goes C to B    ----> Target tower B
	10 ->  [1..9] Goes A to B, 10 Goes A to C, [1..9] Goes B to C   ----> Target tower C
	_A_ | _B_| _C_

	 */
	public static void move(char current, char target, char aux, int n) {
		if (n==1) {
			// to move a single disk from current to target we just move it directly
			System.out.println("Move disk 1 from "+current+" to "+target);
			return;
		}
		// for all other disks there are 3 operations
		// [1..n-1] current to aux, n current to target, [1...n-1] aux to target
		
		move(current, aux, target, n-1);
		System.out.println("Move disk "+n+" from "+current+" to "+target);
		move(aux, target, current, n-1);
	}
}
