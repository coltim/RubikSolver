import java.util.Random;

public class Scramble {

    Rotations rotation = new Rotations();
    Cube cube = new Cube();
    int selectedRotation;
    int numberOfRotations;
    private String randomMoves = "";
    int count = 0;

    public String getRandomMoves() {
        return this.randomMoves;
    }

    public Scramble() {

    }

    public Scramble(int numberOfRotations, Cube cube) {

        do {
            randomMoves = "";
            count++;
            for (int i = 0; i < numberOfRotations; i++) {
                int selectedRotation = (int) (Math.random() * (12 - 1 + 1) + 1);

                if (selectedRotation == 1) {
                    rotation.L(cube);
                    randomMoves = randomMoves.concat("L");
                }
                if (selectedRotation == 2) {
                    rotation.Lreverse(cube);
                    randomMoves = randomMoves.concat("l");
                }
                if (selectedRotation == 3) {
                    rotation.R(cube);
                    randomMoves = randomMoves.concat("R");
                }
                if (selectedRotation == 4) {
                    rotation.Rreverse(cube);
                    randomMoves = randomMoves.concat("r");
                }
                if (selectedRotation == 5) {
                    rotation.U(cube);
                    randomMoves = randomMoves.concat("U");
                }
                if (selectedRotation == 6) {
                    rotation.Ureverse(cube);
                    randomMoves = randomMoves.concat("u");
                }
                if (selectedRotation == 7) {
                    rotation.D(cube);
                    randomMoves = randomMoves.concat("D");
                }
                if (selectedRotation == 8) {
                    rotation.Dreverse(cube);
                    randomMoves = randomMoves.concat("d");
                }
                if (selectedRotation == 9) {
                    rotation.F(cube);
                    randomMoves = randomMoves.concat("F");
                }
                if (selectedRotation == 10) {
                    rotation.Freverse(cube);
                    randomMoves = randomMoves.concat("f");
                }
                if (selectedRotation == 11) {
                    rotation.B(cube);
                    randomMoves = randomMoves.concat("B");
                }
                if (selectedRotation == 12) {
                    rotation.Breverse(cube);
                    randomMoves = randomMoves.concat("b");
                }

            }
        } while (scrambleChecker(randomMoves));


        System.out.println("keverés: " + randomMoves);

    }

    public boolean scrambleChecker(String moves) {
        Character c1;
        Character c2;
        boolean temp = true;
        if (moves.length() > 1) {
            for (int i = 0; i < moves.length() - 1; i++) {
                c1 = moves.charAt(i);
                c2 = Character.isUpperCase(moves.charAt(i + 1)) ? Character.toLowerCase(moves.charAt(i + 1)) : Character.toUpperCase(moves.charAt(i + 1));
                if (c1 == c2) {
                    temp = false;
                }
            }
        }
        if (moves.length() > 3) {
            for (int i = 0; i < moves.length() - 3; i++) {
                if (moves.charAt(i) == (moves.charAt(i + 1) & moves.charAt(i + 2) & moves.charAt(i + 3))) {
                    temp = false;
                }
            }
        }
        return temp;
    }

}
