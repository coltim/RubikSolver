public class Goals {


    boolean solved;

    public boolean isSolved(Cube cube) {
        solved = true;
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
        solved = true;
        char center = cube.getElement(40);
        if (cube.getElement(37) != center ||
                cube.getElement(39) != center ||
                cube.getElement(41) != center ||
                cube.getElement(43) != center ||
                cube.getElement(1) != 'b' ||
                cube.getElement(10) != 'o' ||
                cube.getElement(19) != 'g' ||
                cube.getElement(28) != 'r') {
            solved = false;
        }
        return solved;
    }

    boolean firstLayerCorner1(Cube cube) {
        solved = true;
        if (cube.getElement(36) != 'w' ||
                cube.getElement(29) != 'r' ||
                cube.getElement(0) != 'b') {
            solved = false;
        }
        return solved;
    }

    boolean firstLayerCorner2(Cube cube) {
        solved = true;
        //boolean solved = true;
        if (cube.getElement(42) != 'w' ||
                cube.getElement(2) != 'b' ||
                cube.getElement(9) != 'o') {
            solved = false;
        }
        return solved;
    }

    boolean firstLayerCorner3(Cube cube) {
        solved = true;
        //boolean solved = true;
        if (cube.getElement(44) != 'w' ||
                cube.getElement(11) != 'o' ||
                cube.getElement(18) != 'g') {
            solved = false;
        }
        return solved;
    }

    boolean firstLayerCorner4(Cube cube) {
        solved = true;
        //boolean solved = true;
        if (cube.getElement(38) != 'w' ||
                cube.getElement(20) != 'g' ||
                cube.getElement(27) != 'r') {
            solved = false;
        }
        return solved;
    }

    boolean secondLayerEdge1(Cube cube) {
        solved = true;
        //boolean solved = true;
        if (cube.getElement(32) != 'r' ||
                cube.getElement(3) != 'b') {
            solved = false;
        }
        return solved;
    }

    boolean secondLayerEdge2(Cube cube) {
        solved = true;
       // boolean solved = true;
        if (cube.getElement(5) != 'b' ||
                cube.getElement(12) != 'o') {
            solved = false;
        }
        return solved;
    }

    boolean secondLayerEdge3(Cube cube) {
        solved = true;
       // boolean solved = true;
        if (cube.getElement(14) != 'o' ||
                cube.getElement(21) != 'g') {
            solved = false;
        }
        return solved;
    }

    boolean secondLayerEdge4(Cube cube) {
        solved = true;
        //boolean solved = true;
        if (cube.getElement(23) != 'g' ||
                cube.getElement(30) != 'r') {
            solved = false;
        }
        return solved;
    }


    boolean firstLayerIsSolved(Cube cube) {
        solved = true;
        //boolean solved = true;
        char center = cube.getElement(40);
        if (cube.getElement(36) != center ||
                cube.getElement(38) != center ||
                cube.getElement(42) != center ||
                cube.getElement(44) != center ||
                cube.getElement(0) != 'b' ||
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
}
