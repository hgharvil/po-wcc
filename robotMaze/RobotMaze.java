import java.util.Stack;

public class RobotMaze {

	/*
	 * In the maze matrix: 0 = open space, 1 = blocked space, 2 = robot, 3 = end.
	 */
	private int[][] maze;
	private Stack<Character> move = new Stack<Character>();

	RobotMaze() {
		this.maze = new int[4][4];
		this.maze[0][0] = 2;

		this.maze[0][3] = 1;
		this.maze[1][2] = 1;
		this.maze[2][3] = 1;

		this.maze[this.maze.length - 1][this.maze[0].length - 1] = 3;
	}

	public void render(int turn, boolean isDone) {
		if (!isDone) {
			System.out.println("~~~~~~~~~~~~Render Start: Turn " + turn + "~~~~~~~~~~~~");
			for (int i = 0; i < this.maze.length; i++) {
				for (int j = 0; j < this.maze[0].length; j++) {
					System.out.print(this.maze[i][j]);
				}
				System.out.println();
			}
			System.out.println("\nMovement: " + move.toString());
			System.out.println("~~~~Render End~~~~\n");
		} else {
			System.out.println("Final Movement: " + move.toString());
			System.out.println("~Render Done~\n");
		}
	}

	public void solve() throws InterruptedException {
		int turn = 0;
		int cursorRight = -1;
		boolean blockedRight = false;
		int cursorDown = -1;
		boolean blockedDown = false;
		int robotR = -1;
		int robotC = -1;
		boolean isDone = false;

		// finding the robot's position
		for (int i = 0; i < this.maze.length; i++) {
			for (int j = 0; j < this.maze[0].length; j++) {
				if (this.maze[i][j] == 2) {
					robotR = i;
					robotC = j;
					break;
				}
			}
		}

		System.out.println("Robot's position is (" + robotR + "," + robotC + ")");
		/*
		 * robot tries going right and when way is blocked, goes down. If both ways are
		 * blocked the previous move is deleted.
		 */
		while (!isDone) {
			turn++;
			if (robotC + 1 < this.maze[0].length && !blockedRight) {
				cursorRight = this.maze[robotR][robotC + 1];
			} else {
				cursorRight = 1;
			}
			if (robotR + 1 < this.maze.length && !blockedDown) {
				cursorDown = this.maze[robotR + 1][robotC];
			} else {
				cursorDown = 1;
			}

			blockedRight = false;
			blockedDown = false;

			if (cursorRight != 1) {
				this.move.add('r');
				this.maze[robotR][robotC] = 0;
				robotC++;
				this.maze[robotR][robotC] = 2;

				if (cursorRight == 3)
					isDone = true;

			} else if (cursorRight == 1) {
				if (cursorDown != 1) {
					this.move.add('d');
					this.maze[robotR][robotC] = 0;
					robotR++;
					this.maze[robotR][robotC] = 2;
					if (cursorDown == 3)
						isDone = true;

				} else if (cursorDown == 1) {
					if (!this.move.isEmpty()) {
						if (this.move.pop() == 'r') {
							this.maze[robotR][robotC] = 0;
							robotC--;
							this.maze[robotR][robotC] = 2;
							blockedRight = true;
						} else {
							this.maze[robotR][robotC] = 0;
							robotR--;
							this.maze[robotR][robotC] = 2;
							blockedDown = true;

						}
					} else {
						isDone = true;
						System.out.println("No solution!");
					}
				}
			}
			render(turn, isDone);
			Thread.sleep(200);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		RobotMaze rm = new RobotMaze();
		rm.render(0, false);
		rm.solve();
	}

}
