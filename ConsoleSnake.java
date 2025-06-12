import java.util.*;

public class ConsoleSnake {
    public static void main(String[] args) throws InterruptedException {
        int width = 20, height = 10;
        int x = width / 2, y = height / 2;
        int fruitX = new Random().nextInt(width);
        int fruitY = new Random().nextInt(height);
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            // Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Draw
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == y && j == x)
                        System.out.print("O");
                    else if (i == fruitY && j == fruitX)
                        System.out.print("F");
                    else
                        System.out.print(".");
                }
                System.out.println();
            }

            System.out.println("Move (WASD): ");
            char dir = sc.next().charAt(0);

            switch (dir) {
                case 'w': y--; break;
                case 's': y++; break;
                case 'a': x--; break;
                case 'd': x++; break;
            }

            if (x < 0 || x >= width || y < 0 || y >= height)
                gameOver = true;
            if (x == fruitX && y == fruitY) {
                fruitX = new Random().nextInt(width);
                fruitY = new Random().nextInt(height);
            }

            Thread.sleep(300);
        }

        System.out.println("Game Over!");
    }
}
