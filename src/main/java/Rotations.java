public class Rotations {

    char temp;


    public void movesTranslate(String moves, Cube cube){
        char movesArray[] = moves.toCharArray();
        for (char move : movesArray) {
            if (move == 'L') {
                this.L(cube);
                continue;
            }
            if (move == 'l') {
                this.Lreverse(cube);
                continue;
            }
            if (move == 'R') {
                this.R(cube);
                continue;
            }
            if (move == 'r') {
                this.Rreverse(cube);
                continue;
            }
            if (move == 'U') {
                this.U(cube);
                continue;
            }
            if (move == 'u') {
                this.Ureverse(cube);
                continue;
            }
            if (move == 'D') {
                this.D(cube);
                continue;
            }
            if (move == 'd') {
                this.Dreverse(cube);
                continue;
            }
            if (move == 'F') {
                this.F(cube);
                continue;
            }
            if (move == 'f') {
                this.Freverse(cube);
                continue;
            }
            if (move == 'B') {
                this.B(cube);
                continue;
            }
            if (move == 'b') {
                this.Breverse(cube);
                continue;
            }
        }
    }

    public void R(Cube cube){
        temp = cube.getElement(38);
        cube.setElement(38, cube.getElement(11));
        cube.setElement(11, cube.getElement(47));
        cube.setElement(47, cube.getElement(33));
        cube.setElement(33, temp);
        temp = cube.getElement(41);
        cube.setElement(41, cube.getElement(14));
        cube.setElement(14, cube.getElement(50));
        cube.setElement(50, cube.getElement(30));
        cube.setElement(30, temp);
        temp = cube.getElement(44);
        cube.setElement(44, cube.getElement(17));
        cube.setElement(17, cube.getElement(53));
        cube.setElement(53, cube.getElement(27));
        cube.setElement(27, temp);

        temp = cube.getElement(20);
        cube.setElement(20, cube.getElement(18));
        cube.setElement(18, cube.getElement(24));
        cube.setElement(24, cube.getElement(26));
        cube.setElement(26, temp);
        temp = cube.getElement(19);
        cube.setElement(19, cube.getElement(21));
        cube.setElement(21, cube.getElement(25));
        cube.setElement(25, cube.getElement(23));
        cube.setElement(23, temp);
    }

    public void Rreverse(Cube cube){
        R(cube);
        R(cube);
        R(cube);
    }

    public void L(Cube cube){
        temp = cube.getElement(42);
        cube.setElement(42, cube.getElement(29));
        cube.setElement(29, cube.getElement(51));
        cube.setElement(51, cube.getElement(15));
        cube.setElement(15, temp);
        temp = cube.getElement(39);
        cube.setElement(39, cube.getElement(32));
        cube.setElement(32, cube.getElement(48));
        cube.setElement(48, cube.getElement(12));
        cube.setElement(12, temp);
        temp = cube.getElement(36);
        cube.setElement(36, cube.getElement(35));
        cube.setElement(35, cube.getElement(45));
        cube.setElement(45, cube.getElement(9));
        cube.setElement(9, temp);

        temp = cube.getElement(2);
        cube.setElement(2, cube.getElement(0));
        cube.setElement(0, cube.getElement(6));
        cube.setElement(6, cube.getElement(8));
        cube.setElement(8, temp);
        temp = cube.getElement(1);
        cube.setElement(1, cube.getElement(3));
        cube.setElement(3, cube.getElement(7));
        cube.setElement(7, cube.getElement(5));
        cube.setElement(5, temp);
    }

    public void Lreverse(Cube cube){
        L(cube);
        L(cube);
        L(cube);
    }

    public void B(Cube cube){
        temp = cube.getElement(36);
        cube.setElement(36, cube.getElement(20));
        cube.setElement(20, cube.getElement(53));
        cube.setElement(53, cube.getElement(6));
        cube.setElement(6, temp);
        temp = cube.getElement(37);
        cube.setElement(37, cube.getElement(23));
        cube.setElement(23, cube.getElement(52));
        cube.setElement(52, cube.getElement(3));
        cube.setElement(3, temp);
        temp = cube.getElement(38);
        cube.setElement(38, cube.getElement(26));
        cube.setElement(26, cube.getElement(51));
        cube.setElement(51, cube.getElement(0));
        cube.setElement(0, temp);

        temp = cube.getElement(29);
        cube.setElement(29, cube.getElement(27));
        cube.setElement(27, cube.getElement(33));
        cube.setElement(33, cube.getElement(35));
        cube.setElement(35, temp);
        temp = cube.getElement(28);
        cube.setElement(28, cube.getElement(30));
        cube.setElement(30, cube.getElement(34));
        cube.setElement(34, cube.getElement(32));
        cube.setElement(32, temp);
    }

    public void Breverse(Cube cube){
        B(cube);
        B(cube);
        B(cube);
    }

    public void F(Cube cube){
        temp = cube.getElement(44);
        cube.setElement(44, cube.getElement(2));
        cube.setElement(2, cube.getElement(45));
        cube.setElement(45, cube.getElement(24));
        cube.setElement(24, temp);
        temp = cube.getElement(43);
        cube.setElement(43, cube.getElement(5));
        cube.setElement(5, cube.getElement(46));
        cube.setElement(46, cube.getElement(21));
        cube.setElement(21, temp);
        temp = cube.getElement(42);
        cube.setElement(42, cube.getElement(8));
        cube.setElement(8, cube.getElement(47));
        cube.setElement(47, cube.getElement(18));
        cube.setElement(18, temp);

        temp = cube.getElement(11);
        cube.setElement(11, cube.getElement(9));
        cube.setElement(9, cube.getElement(15));
        cube.setElement(15, cube.getElement(17));
        cube.setElement(17, temp);
        temp = cube.getElement(10);
        cube.setElement(10, cube.getElement(12));
        cube.setElement(12, cube.getElement(16));
        cube.setElement(16, cube.getElement(14));
        cube.setElement(14, temp);
    }

    public void Freverse(Cube cube){
        F(cube);
        F(cube);
        F(cube);
    }

    public void D(Cube cube){
        temp = cube.getElement(17);
        cube.setElement(17, cube.getElement(8));
        cube.setElement(8, cube.getElement(35));
        cube.setElement(35, cube.getElement(26));
        cube.setElement(26, temp);
        temp = cube.getElement(16);
        cube.setElement(16, cube.getElement(7));
        cube.setElement(7, cube.getElement(34));
        cube.setElement(34, cube.getElement(25));
        cube.setElement(25, temp);
        temp = cube.getElement(15);
        cube.setElement(15, cube.getElement(6));
        cube.setElement(6, cube.getElement(33));
        cube.setElement(33, cube.getElement(24));
        cube.setElement(24, temp);

        temp = cube.getElement(47);
        cube.setElement(47, cube.getElement(45));
        cube.setElement(45, cube.getElement(51));
        cube.setElement(51, cube.getElement(53));
        cube.setElement(53, temp);
        temp = cube.getElement(46);
        cube.setElement(46, cube.getElement(48));
        cube.setElement(48, cube.getElement(52));
        cube.setElement(52, cube.getElement(50));
        cube.setElement(50, temp);
    }

    public void Dreverse(Cube cube){
        D(cube);
        D(cube);
        D(cube);
    }

    public void U(Cube cube){
        temp = cube.getElement(9);
        cube.setElement(9, cube.getElement(18));
        cube.setElement(18, cube.getElement(27));
        cube.setElement(27, cube.getElement(0));
        cube.setElement(0, temp);
        temp = cube.getElement(10);
        cube.setElement(10, cube.getElement(19));
        cube.setElement(19, cube.getElement(28));
        cube.setElement(28, cube.getElement(1));
        cube.setElement(1, temp);
        temp = cube.getElement(11);
        cube.setElement(11, cube.getElement(20));
        cube.setElement(20, cube.getElement(29));
        cube.setElement(29, cube.getElement(2));
        cube.setElement(2, temp);

        temp = cube.getElement(42);
        cube.setElement(42, cube.getElement(44));
        cube.setElement(44, cube.getElement(38));
        cube.setElement(38, cube.getElement(36));
        cube.setElement(36, temp);
        temp = cube.getElement(43);
        cube.setElement(43, cube.getElement(41));
        cube.setElement(41, cube.getElement(37));
        cube.setElement(37, cube.getElement(39));
        cube.setElement(39, temp);
    }

    public void Ureverse(Cube cube){
        U(cube);
        U(cube);
        U(cube);
    }


}
