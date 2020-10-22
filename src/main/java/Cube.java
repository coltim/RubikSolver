
public class Cube {
    private char element[] = new char[54];

    public Cube() {

        for (int i = 0; i <= 8; i++) {
            this.element[i] = 'b';
        }
        for (int i = 9; i <= 17; i++) {
            this.element[i] = 'o';
        }
        for (int i = 18; i <= 26; i++) {
            this.element[i] = 'g';
        }
        for (int i = 27; i <= 35; i++) {
            this.element[i] = 'r';
        }
        for (int i = 36; i <= 44; i++) {
            this.element[i] = 'w';
        }
        for (int i = 45; i <= 53; i++) {
            this.element[i] = 'y';
        }
    }

    public Cube(Cube cube) {
        for (int i = 0; i <=53; i++) {
            this.element[i] = cube.element[i];
        }
    }

    public char getElement(int index) {
        return element[index];
    }

    public void setElement(int index, char element) {
        this.element[index] = element;
    }

    public void set(char inputElement[]) {
        for (int i = 0; i < inputElement.length; i++) {
            element[i] = inputElement[i];
        }
    }

    public boolean isSolved(Cube cube) {
        boolean solved = true;
        for (int j = 0; j <= 45; j += 9) {
            for (int i = 0; i <= 8; i++) {
                if (cube.getElement(i + j) != cube.getElement(4 + j)) {
                    solved = false;
                    break;
                }
            }
        }
        return solved;
    }

    boolean whiteCrossIsSolved(Cube cube) {
        boolean solved = true;
        char center = cube.getElement(40);
        if (cube.getElement(37) != center ||
                cube.getElement(39) != center ||
                cube.getElement(41) != center ||
                cube.getElement(43) != center) {
            solved = false;
        } else if (cube.getElement(1) != 'b' ||
                cube.getElement(10) != 'o' ||
                cube.getElement(19) != 'g' ||
                cube.getElement(28) != 'r') {
            solved = false;
        }
        return solved;
    }

    boolean firstLayerIsSolved(Cube cube) {
        boolean solved = true;
        char center = cube.getElement(40);
        if (cube.getElement(36) != center ||
                cube.getElement(38) != center ||
                cube.getElement(42) != center ||
                cube.getElement(44) != center) {
            solved = false;
        } else if (cube.getElement(0) != 'b' ||
                cube.getElement(2) != 'b' ||
                cube.getElement(9) != 'o' ||
                cube.getElement(11) != 'o' ||
                cube.getElement(18) != 'g' ||
                cube.getElement(20) != 'g' ||
                cube.getElement(27) != 'r' ||
                cube.getElement(29) != 'r') {
            solved = false;
        }
        return solved;
    }

    public void print() {
        System.out.println("         |" + "-------|");
        System.out.println(
                "         | " + element[36] + " " + element[37] + " " + element[38] + " |");
        System.out.println(
                "         | " + element[39] + " " + element[40] + " " + element[41] + " |");
        System.out.println(
                "         | " + element[42] + " " + element[43] + " " + element[44] + " |");
        System.out.println(" |-------|" + "-------|" + "-------|" + "-------|");
        System.out.println(" | " + element[0] + " " + element[1] + " " + element[2] + " | "
                + element[9] + " " + element[10] + " " + element[11] + " | "
                + element[18] + " " + element[19] + " " + element[20] + " | "
                + element[27] + " " + element[28] + " " + element[29] + " | ");
        System.out.println(" | " + element[3] + " " + element[4] + " " + element[5] + " | "
                + element[12] + " " + element[13] + " " + element[14] + " | "
                + element[21] + " " + element[22] + " " + element[23] + " | "
                + element[30] + " " + element[31] + " " + element[32] + " | ");
        System.out.println(" | " + element[6] + " " + element[7] + " " + element[8] + " | "
                + element[15] + " " + element[16] + " " + element[17] + " | "
                + element[24] + " " + element[25] + " " + element[26] + " | "
                + element[33] + " " + element[34] + " " + element[35] + " | ");
        System.out.println(" |-------|" + "-------|" + "-------|" + "-------|");
        System.out.println(
                "         | " + element[45] + " " + element[46] + " " + element[47] + " |");
        System.out.println(
                "         | " + element[48] + " " + element[49] + " " + element[50] + " |");
        System.out.println(
                "         | " + element[51] + " " + element[52] + " " + element[53] + " |");
        System.out.println("         |" + "-------|\n");
    }

}