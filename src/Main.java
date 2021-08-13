//This program only focuses on the logic of solving a Sudoku puzzle.
class Main
{
	static int size = 9;
	
	
	public static void main(String[] args)
	{
		//Here is where u have to enter the Sudoku puzzle. 0 represents the blanks.
		int[][] board = {
				{5, 6, 0, 0, 2, 0, 0, 0, 0},
				{0, 0, 2, 0, 0, 0, 8, 0, 9},
				{8, 0, 0, 7, 0, 0, 0, 2, 0},
				{0, 1, 0, 5, 0, 0, 6, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 3, 0, 0, 6, 0, 1, 0},
				{0, 9, 0, 0, 0, 4, 0, 0, 5},
				{7, 0, 5, 0, 0, 0, 2, 0, 0},
				{0, 0, 0, 0, 3, 0, 0, 4, 8}
		};
		System.out.println("Sudoku Puzzle:");
		print(board);
		boolean z = solveBoard(board);
		
		if(z == true)
		{
			System.out.println("Solved Board:");
			print(board);
		}
		else
		{
			System.out.println("Board is unsolvable!");
		}
	}
	
	
	static void print(int[][] board)
	{
		for(int row = 0; row < size; row++)
		{
			for(int column = 0; column < size; column++)
			{
				System.out.print(board[row][column] + " ");
			}
			
			System.out.println();
		}
	}
	
	
	static boolean checkRow(int[][] board, int n, int row)
	{
		boolean z = false;
		
		for(int i = 0; i < size; i++)
		{
			if(board[row][i] == n)
			{
				z = true;
				break;
			}
		}
		
		return z;
	}
	
	
	static boolean checkColumn(int[][] board, int n, int column)
	{
		boolean z = false;
		
		for(int i = 0; i < size; i++)
		{
			if(board[i][column] == n)
			{
				z = true;
				break;
			}
		}
		
		return z;
	}
	
	
	static boolean checkBox(int[][] board, int n, int row, int column)
	{
		int boxRow = row - row % 3;
		int boxColumn = column - column % 3;
		boolean z = false;
		
		for(int i = boxRow; i < boxRow + 3; i++)
		{
			for(int j = boxColumn; j < boxColumn + 3; j++)
			{
				if(board[i][j] == n)
				{
					z = true;
				}
			}
		}
		
		return z;
	}
	
	
	static boolean checkPlacement(int[][] board, int n, int row, int column)
	{
		boolean z = false;
		
		if(checkRow(board, n, row) == false && 
				checkColumn(board, n, column) == false && 
				checkBox(board, n, row, column) == false)
		{
			z = true;
		}
		
		return z;
	}
	
	
	static boolean solveBoard(int[][] board)
	{
		for(int row = 0; row < size; row++)
		{
			for(int column = 0; column < size; column++)
			{
				if(board[row][column] == 0)
				{//x represents numbers between 1 to 9. 
					for(int x = 1; x <= size; x++)
					{
						if(checkPlacement(board, x, row, column) == true)
						{
							board[row][column] = x;
							
							if(solveBoard(board) == true)
							{
								return true;
							}
							else
							{
								board[row][column] = 0;
							}
						}
					}
					
					return false;
				}
			}
		}
		
		return true;
	}
}
