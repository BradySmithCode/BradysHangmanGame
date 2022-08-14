public class LivesDrawer {
    public static String livesOutput(int lives) {
        if (lives == 5) {
            return "|------|\n" +
                    "|      |\n" +
                    "|      \n" +
                    "|\n" +
                    "|\n" +
                    "|_______\n";

        } else if (lives == 4) {
            return "|------|\n" +
                    "|      |\n" +
                    "|      o\n" +
                    "|\n" +
                    "|\n" +
                    "|_______";
        } else if(lives == 3) {
            return "|------|\n" +
                    "|      |\n" +
                    "|      o\n" +
                    "|     \\|\n" +
                    "|\n" +
                    "|_______";
        } else if (lives == 2) {
            return "|------|\n" +
                    "|      |\n" +
                    "|      o\n" +
                    "|     \\|/\n" +
                    "|      \n" +
                    "|_______";
        } else if (lives == 1) {
            return "|------|\n" +
                    "|      |\n" +
                    "|      o\n" +
                    "|     \\|/\n" +
                    "|     / \n" +
                    "|_______";
        } else {
            return "|------|\n" +
                    "|      |\n" +
                    "|      o\n" +
                    "|     \\|/\n" +
                    "|     / \\\n" +
                    "|_______";
        }

    }

}
