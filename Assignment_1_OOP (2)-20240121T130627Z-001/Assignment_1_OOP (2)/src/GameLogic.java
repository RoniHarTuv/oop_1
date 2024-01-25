import java.util.*;

public class GameLogic implements PlayableLogic {
    //all the fields that are used in a game of "viking chess":
    private ArrayList<ConcretePiece> _piecesPlayer1 = new ArrayList<>();
    private ArrayList<ConcretePiece> _piecesPlayer2 = new ArrayList<>();
    public final ConcretePiece[][] _MAP;
    private boolean _isPlayer2Turn;
    private final ConcretePlayer _PLAYER1;
    private final ConcretePlayer _PLAYER2;
    private boolean _isGameFinished;
    private boolean _wasEaten = false; //useful for the undo part of the code.
    private Stack<Map.Entry<Position, ConcretePiece>> _stackForUndo = new Stack<>(); //useful for the undo part of the code.
    private Stack<ConcretePiece> _stackForEatenUndo = new Stack<>(); //useful for the undo part of the code.
    private int numberOfTurn = 0; //useful for the undo part of the code.
    private static int _whoWon; //useful for part2 - is static because used in other class with call "Gamelogic".
    Position[][] _mapForQ4 = new Position[11][11]; //useful for p2q4
    private ArrayList<ConcretePiece> _piecesWasEaten1 = new ArrayList<>();
    private ArrayList<ConcretePiece> _piecesWasEaten2 = new ArrayList<>();

    /**
     * our constructor will:
     * 1.determine the position map for part2q4-will run threw the map
     * and will set new positions.
     * 2.set the "_isPlayer2Turn" field to be true as in the start of the jar.
     * 3.will create two new players "player1" and "player2".
     * 4.will set the _Map of the game field of the class and will determine
     * all the pieces that suppose to be as in the jar file.
     * 5.lastly, will set all the initial values of the positions for p2q4.
     */
    public GameLogic() {
        for (int i = 0; i < 11; i++) {  //@@@@@@@
            for (int j = 0; j < 11; j++) {
                _mapForQ4[i][j] = new Position(i, j);
            }
        }
        this._isPlayer2Turn = true;
        this._PLAYER1 = new ConcretePlayer(1);
        this._PLAYER2 = new ConcretePlayer(2);
        this._MAP = new ConcretePiece[11][11];
        Pawn pawn1_player2 = new Pawn(new Position(3, 0), 1, _PLAYER2, "♟");
        _MAP[3][0] = pawn1_player2;
        _piecesPlayer2.add(pawn1_player2);
        Pawn pawn2_player2 = new Pawn(new Position(4, 0), 2, _PLAYER2, "♟");
        _piecesPlayer2.add(pawn2_player2);
        _MAP[4][0] = pawn2_player2;
        Pawn pawn3_player2 = new Pawn(new Position(5, 0), 3, _PLAYER2, "♟");
        _piecesPlayer2.add(pawn3_player2);
        _MAP[5][0] = pawn3_player2;
        Pawn pawn4_player2 = new Pawn(new Position(6, 0), 4, _PLAYER2, "♟");
        _piecesPlayer2.add(pawn4_player2);
        _MAP[6][0] = pawn4_player2;
        Pawn pawn5_player2 = new Pawn(new Position(7, 0), 5, _PLAYER2, "♟");
        _MAP[7][0] = pawn5_player2;
        _piecesPlayer2.add(pawn5_player2);
        Pawn pawn6_player2 = new Pawn(new Position(1, 5), 6, _PLAYER2, "♟");
        _MAP[5][1] = pawn6_player2;
        _piecesPlayer2.add(pawn6_player2);
        Pawn pawn7_player2 = new Pawn(new Position(0, 3), 7, _PLAYER2, "♟");
        _MAP[0][3] = pawn7_player2;
        _piecesPlayer2.add(pawn7_player2);
        Pawn pawn8_player2 = new Pawn(new Position(10, 3), 8, _PLAYER2, "♟");
        _MAP[10][3] = pawn8_player2;
        _piecesPlayer2.add(pawn8_player2);
        Pawn pawn9_player2 = new Pawn(new Position(0, 4), 9, _PLAYER2, "♟");
        _MAP[0][4] = pawn9_player2;
        _piecesPlayer2.add(pawn9_player2);
        Pawn pawn10_player2 = new Pawn(new Position(10, 4), 10, _PLAYER2, "♟");
        _MAP[10][4] = pawn10_player2;
        _piecesPlayer2.add(pawn10_player2);
        Pawn pawn11_player2 = new Pawn(new Position(0, 5), 11, _PLAYER2, "♟");
        _MAP[0][5] = pawn11_player2;
        _piecesPlayer2.add(pawn11_player2);
        Pawn pawn12_player2 = new Pawn(new Position(1, 5), 12, _PLAYER2, "♟");
        _MAP[1][5] = pawn12_player2;
        _piecesPlayer2.add(pawn12_player2);
        Pawn pawn13_player2 = new Pawn(new Position(9, 5), 13, _PLAYER2, "♟");
        _MAP[9][5] = pawn13_player2;
        _piecesPlayer2.add(pawn13_player2);
        Pawn pawn14_player2 = new Pawn(new Position(10, 5), 14, _PLAYER2, "♟");
        _MAP[10][5] = pawn14_player2;
        _piecesPlayer2.add(pawn14_player2);
        Pawn pawn15_player2 = new Pawn(new Position(0, 6), 15, _PLAYER2, "♟");
        _MAP[0][6] = pawn15_player2;
        _piecesPlayer2.add(pawn15_player2);
        Pawn pawn16_player2 = new Pawn(new Position(10, 6), 16, _PLAYER2, "♟");
        _MAP[10][6] = pawn16_player2;
        _piecesPlayer2.add(pawn16_player2);
        Pawn pawn17_player2 = new Pawn(new Position(0, 7), 17, _PLAYER2, "♟");
        _MAP[0][7] = pawn17_player2;
        _piecesPlayer2.add(pawn17_player2);
        Pawn pawn18_player2 = new Pawn(new Position(10, 7), 18, _PLAYER2, "♟");
        _MAP[10][7] = pawn18_player2;
        _piecesPlayer2.add(pawn18_player2);
        Pawn pawn19_player2 = new Pawn(new Position(5, 9), 19, _PLAYER2, "♟");
        _MAP[5][9] = pawn19_player2;
        _piecesPlayer2.add(pawn19_player2);
        Pawn pawn20_player2 = new Pawn(new Position(3, 10), 20, _PLAYER2, "♟");
        _MAP[3][10] = pawn20_player2;
        _piecesPlayer2.add(pawn20_player2);
        Pawn pawn21_player2 = new Pawn(new Position(4, 10), 21, _PLAYER2, "♟");
        _MAP[4][10] = pawn21_player2;
        _piecesPlayer2.add(pawn21_player2);
        Pawn pawn22_player2 = new Pawn(new Position(5, 10), 22, _PLAYER2, "♟");
        _MAP[5][10] = pawn22_player2;
        _piecesPlayer2.add(pawn22_player2);
        Pawn pawn23_player2 = new Pawn(new Position(6, 10), 23, _PLAYER2, "♟");
        _MAP[6][10] = pawn23_player2;
        _piecesPlayer2.add(pawn23_player2);
        Pawn pawn24_player2 = new Pawn(new Position(7, 10), 24, _PLAYER2, "♟");
        _MAP[7][10] = pawn24_player2;
        _piecesPlayer2.add(pawn24_player2);
        King king_player1 = new King(new Position(5, 5), 7, _PLAYER1, "♔");
        _MAP[5][5] = king_player1;
        _piecesPlayer1.add(king_player1);
        Pawn pawn1_player1 = new Pawn(new Position(5, 3), 1, _PLAYER1, "♙");
        _MAP[5][3] = pawn1_player1;
        _piecesPlayer1.add(pawn1_player1);
        Pawn pawn2_player1 = new Pawn(new Position(4, 4), 2, _PLAYER1, "♙");
        _MAP[4][4] = pawn2_player1;
        _piecesPlayer1.add(pawn2_player1);
        Pawn pawn3_player1 = new Pawn(new Position(5, 4), 3, _PLAYER1, "♙");
        _MAP[5][4] = pawn3_player1;
        _piecesPlayer1.add(pawn3_player1);
        Pawn pawn4_player1 = new Pawn(new Position(6, 2), 4, _PLAYER1, "♙");
        _MAP[6][4] = pawn4_player1;
        _piecesPlayer1.add(pawn4_player1);
        Pawn pawn5_player1 = new Pawn(new Position(3, 5), 5, _PLAYER1, "♙");
        _MAP[3][5] = pawn5_player1;
        _piecesPlayer1.add(pawn5_player1);
        Pawn pawn6_player1 = new Pawn(new Position(4, 5), 6, _PLAYER1, "♙");
        _MAP[4][5] = pawn6_player1;
        _piecesPlayer1.add(pawn6_player1);
        Pawn pawn8_player1 = new Pawn(new Position(6, 5), 8, _PLAYER1, "♙");
        _MAP[6][5] = pawn8_player1;
        _piecesPlayer1.add(pawn8_player1);
        Pawn pawn9_player1 = new Pawn(new Position(7, 5), 9, _PLAYER1, "♙");
        _MAP[7][5] = pawn9_player1;
        _piecesPlayer1.add(pawn9_player1);
        Pawn pawn10_player1 = new Pawn(new Position(4, 6), 10, _PLAYER1, "♙");
        _MAP[4][6] = pawn10_player1;
        _piecesPlayer1.add(pawn10_player1);
        Pawn pawn11_player1 = new Pawn(new Position(5, 6), 11, _PLAYER1, "♙");
        _MAP[5][6] = pawn11_player1;
        _piecesPlayer1.add(pawn11_player1);
        Pawn pawn12_player1 = new Pawn(new Position(6, 6), 12, _PLAYER1, "♙");
        _MAP[6][6] = pawn12_player1;
        _piecesPlayer1.add(pawn12_player1);
        Pawn pawn13_player1 = new Pawn(new Position(5, 7), 13, _PLAYER1, "♙");
        _MAP[5][7] = pawn13_player1;
        _piecesPlayer1.add(pawn13_player1);
        for (int i = 0; i < _piecesPlayer1.size(); i++) {
            _piecesPlayer1.get(i).addStep(_piecesPlayer1.get(i)._position);
        }
        for (int i = 0; i < _piecesPlayer2.size(); i++) {
            _piecesPlayer2.get(i).addStep(_piecesPlayer2.get(i)._position);
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (_MAP[i][j] != null) {
                    _mapForQ4[i][j].setNumberOfP(_MAP[i][j]);
                }
            }
        }
        for (int i = 0; i < _piecesPlayer1.size(); i++) {
            setNeighbors(_piecesPlayer1.get(i));
        }
        for (int i = 0; i < _piecesPlayer2.size(); i++) {
            setNeighbors(_piecesPlayer2.get(i));
        }
    }

    /**
     * aim: this function will set all the neighbors of a piece.
     * <p>
     * why its necessary:the isEaten function both for the king and pawn value is determined by the neighbors of a piece.
     * <p>
     * method:this function will check all the positions that are around the piece on the game map and will fill the array "_n" with the type of the piece.
     * <p>
     * important:
     * 1.the _n array is a String array that holds only the type of the piece because we want to allow the options of the wall and the corner as neighbor.
     * 2.the firs cell of "_n" is for the upper neighbor, the second for downer the third is the right one and forth is for the left one.
     * 3.optional neighbors can be: "n"-for null cell, "w"- for the wall, "c"- for the corner, "♔"-for the king, "♙"-for blue piece, "♟"-for red piece.
     */
    public void setNeighbors(ConcretePiece p) {
        int x = p._position._x;
        int y = p._position._y;
        if (p.getType().equals("♔") && kingIsONCorner()) {
            return;
        }
        String u = "n";
        String d = "n";
        String r = "n";
        String l = "n";
        if (x != 0 && y != 0 && x != 10 && y != 10) {
            if (_MAP[x][y - 1] == null) {
                u = "n";
            } else {
                u = _MAP[x][y - 1].getType();
                this._MAP[x][y - 1].set_n(this._MAP[x][y - 1].get_n()[0], this._MAP[x][y].getType(), this._MAP[x][y - 1].get_n()[2], this._MAP[x][y - 1].get_n()[3]);
            }
            if (_MAP[x][y + 1] == null) {
                d = "n";
            } else {
                d = _MAP[x][y + 1].getType();
                this._MAP[x][y + 1].set_n(this._MAP[x][y].getType(), this._MAP[x][y + 1].get_n()[1], this._MAP[x][y + 1].get_n()[2], this._MAP[x][y + 1].get_n()[3]);
            }
            if (_MAP[x + 1][y] == null) {
                r = "n";
            } else {
                r = _MAP[x + 1][y].getType();
                this._MAP[x + 1][y].set_n(this._MAP[x + 1][y].get_n()[0], this._MAP[x + 1][y].get_n()[1], this._MAP[x + 1][y].get_n()[2], this._MAP[x][y].getType());
            }
            if (_MAP[x - 1][y] == null) {
                l = "n";
            } else {
                l = _MAP[x - 1][y].getType();
                this._MAP[x - 1][y].set_n(this._MAP[x - 1][y].get_n()[0], this._MAP[x - 1][y].get_n()[1], this._MAP[x][y].getType(), this._MAP[x - 1][y].get_n()[3]);
            }
        }
        if (x == 0) {
            l = "w";
            if (_MAP[x][y - 1] == null) {
                u = "n";
            } else {
                u = _MAP[x][y - 1].getType();
                _MAP[x][y - 1].set_n(_MAP[x][y - 1].get_n()[0], this._MAP[x][y].getType(), _MAP[x][y - 1].get_n()[2], _MAP[x][y - 1].get_n()[3]);
            }
            if (_MAP[x][y + 1] == null) {
                d = "n";
            } else {
                d = _MAP[x][y + 1].getType();
                _MAP[x][y + 1].set_n(this._MAP[x][y].getType(), _MAP[x][y + 1].get_n()[1], _MAP[x][y + 1].get_n()[2], _MAP[x][y + 1].get_n()[3]);
            }
            if (_MAP[x + 1][y] == null) {
                r = "n";
            } else {
                r = _MAP[x + 1][y].getType();
                _MAP[x + 1][y].set_n(_MAP[x + 1][y].get_n()[0], _MAP[x + 1][y].get_n()[1], _MAP[x + 1][y].get_n()[2], this._MAP[x][y].getType());
            }
        }
        if (y == 0) {
            u = "w";
            if (_MAP[x][y + 1] == null) {
                d = "n";
            } else {
                d = _MAP[x][y + 1].getType();
                _MAP[x][y + 1].set_n(this._MAP[x][y].getType(), _MAP[x][y + 1].get_n()[1], _MAP[x][y + 1].get_n()[2], _MAP[x][y + 1].get_n()[3]);
            }
            if (_MAP[x + 1][y] == null) {
                r = "n";
            } else {
                r = _MAP[x + 1][y].getType();
                _MAP[x + 1][y].set_n(_MAP[x + 1][y].get_n()[0], _MAP[x + 1][y].get_n()[1], _MAP[x + 1][y].get_n()[2], this._MAP[x][y].getType());
            }
            if (_MAP[x - 1][y] == null) {
                l = "n";
            } else {
                l = _MAP[x - 1][y].getType();
                _MAP[x - 1][y].set_n(_MAP[x - 1][y].get_n()[0], _MAP[x - 1][y].get_n()[1], this._MAP[x][y].getType(), _MAP[x - 1][y].get_n()[3]);
            }
        }
        if (x == 10) {
            r = "w";
            if (_MAP[x][y - 1] == null) {
                u = "n";
            } else {
                u = _MAP[x][y - 1].getType();
                _MAP[x][y - 1].set_n(this._MAP[x][y].getType(), _MAP[x][y - 1].get_n()[1], _MAP[x][y - 1].get_n()[2], _MAP[x][y - 1].get_n()[3]);
            }
            if (_MAP[x][y + 1] == null) {
                d = "n";
            } else {
                d = _MAP[x][y + 1].getType();
                _MAP[x][y + 1].set_n(this._MAP[x][y].getType(), _MAP[x][y + 1].get_n()[1], _MAP[x][y + 1].get_n()[2], _MAP[x][y + 1].get_n()[3]);
            }
            if (_MAP[x - 1][y] == null) {
                l = "n";
            } else {
                l = _MAP[x - 1][y].getType();
                _MAP[x - 1][y].set_n(_MAP[x - 1][y].get_n()[0], _MAP[x - 1][y].get_n()[1], this._MAP[x][y].getType(), _MAP[x - 1][y].get_n()[3]);
            }
        }
        if (y == 10) {
            d = "w";
            if (_MAP[x][y - 1] == null) {
                u = "n";
            } else {
                u = _MAP[x][y - 1].getType();
                _MAP[x][y - 1].set_n(this._MAP[x][y].getType(), _MAP[x][y - 1].get_n()[1], _MAP[x][y - 1].get_n()[2], _MAP[x][y - 1].get_n()[3]);
            }
            if (_MAP[x + 1][y] == null) {
                r = "n";
            } else {
                r = _MAP[x + 1][y].getType();
                _MAP[x + 1][y].set_n(_MAP[x + 1][y].get_n()[0], _MAP[x + 1][y].get_n()[1], _MAP[x + 1][y].get_n()[2], this._MAP[x][y].getType());
            }
            if (_MAP[x - 1][y] == null) {
                l = "n";
            } else {
                l = _MAP[x - 1][y].getType();
                _MAP[x - 1][y].set_n(_MAP[x - 1][y].get_n()[0], _MAP[x - 1][y].get_n()[1], this._MAP[x][y].getType(), _MAP[x - 1][y].get_n()[3]);
            }
        }
        if (x == 9 && y == 10) {
            r = "c";
        }
        if (x == 1 && y == 10) {
            l = "c";
        }
        if (x == 0 && y == 9) {
            d = "c";
        }
        if (x == 0 && y == 1) {
            u = "c";
        }
        if (x == 1 && y == 0) {
            l = "c";
        }
        if (x == 9 && y == 0) {
            r = "c";
        }
        if (x == 10 && y == 1) {
            u = "c";
        }
        if (x == 10 && y == 9) {
            d = "c";
        }
        p.set_n(u, d, r, l);
    }

    /**
     * aim: to determine if a pawn should be eaten.
     * <p>
     * why its necessary: an auxiliary function for the eatPawn function.
     * <p>
     * method: will check the neighbor of the pawn, we want that the function will return true if:
     * 1.the pawn is surrounded from both upper cell+downer cell/ righter cell+lefter cell with a second type pawn.
     * 2. the pawn downer/upper/righter/lefter cell is a wall and upper/downer/lefter/righter cell is a second type pawn correspondingly.
     * 3. is near to a corner and  have a pawn from the second type next to him.
     * we want to allow a pawn from the first type be eaten just in the turn of the second player - for example if a blue
     * pawn will go between two red pawn in the first player turn it's not supposed to be eaten, thus, we split the function into 2 options.
     * if it's the second player turn and the piece that we check if supposed to be eaten is "♙" (important to check because we don't
     * want a _players2 piece will eat another players2 piece), and the piece neighbors are in one of the options that are mentioned above its suppose to
     * be eaten.
     * <p>
     * important to notice:
     * 1.when we check the neighbors we want to be sure that we don't go out of the limits of the board, thus, the first thing that we want to check
     * is that X/Y values are inside the board.
     * 2.we want to check if the piece that we check at a time is the one that we are checking.
     * 3. after a pawn is eaten:
     * a. the neighbors of the pawn that eat change to null in the place that the pawn was eaten.
     * b.the turn of the pawn what was eaten will fill the field with the turn. (important for the undo).
     * c.will push the pawn into the _stackForEatenUndo.
     * d.will mark the _wasEaten field as true.
     * e.will increase the number of kills of the pawn that was moved.
     * f.will return true.
     */
    public boolean isPawnEaten(ConcretePiece p1, ConcretePiece p2) {
        int x1 = p1._position._x;
        int y1 = p1._position._y;
        int x2 = p2._position._x;
        int y2 = p2._position._y;
        String u1 = p1.get_n()[0];
        String d1 = p1.get_n()[1];
        String r1 = p1.get_n()[2];
        String l1 = p1.get_n()[3];
        String u2 = p2.get_n()[0];
        String d2 = p2.get_n()[1];
        String r2 = p2.get_n()[2];
        String l2 = p2.get_n()[3];
        if (_isPlayer2Turn && p2.getType().equals("♙")) {
            if (y1 > 0 && _MAP[x1][y1 - 1] == p2 && x1 != y2 - 1 && u1.equals("♙") && (u2.equals("♟") || u2.equals("w") || u2.equals("c"))) {
                p1.set_n("n", d1, r1, l1);
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                //    _piecesWasEaten1.add(p2);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
            if (y1 < 10 && _MAP[x1][y1 + 1] == p2 && y1 != y2 + 1 && d1.equals("♙") && (d2.equals("♟") || d2.equals("w") || d2.equals("c"))) {
                p1.set_n(u1, "n", r1, l1);
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                //   _piecesWasEaten1.add(p2);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
            if (x1 < 10 && _MAP[x1 + 1][y1] == p2 && x1 != x2 + 1 && r1.equals("♙") && (r2.equals("♟") || r2.equals("w") || r2.equals("c"))) {
                p1.set_n(u1, d1, "n", l1);
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                //  _piecesWasEaten1.add(p2);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
            if (x1 > 0 && _MAP[x1 - 1][y1] == p2 && x1 != x2 - 1 && l1.equals("♙") && (l2.equals("♟") || l2.equals("w") || l2.equals("c"))) {
                p1.set_n(u1, d1, r1, "n");
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                //  _piecesWasEaten1.add(p2);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
        }
        if (!_isPlayer2Turn && p2.getType().equals("♟")) {
            if (y1 > 0 && _MAP[x1][y1 - 1] == p2 && y1 != y2 - 1 && u1.equals("♟") && (u2.equals("♙") || u2.equals("w") || u2.equals("c"))) {
                p1.set_n("n", d1, r1, l1);
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                //  _piecesWasEaten2.add(p2);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
            if (y1 < 10 && _MAP[x1][y1 + 1] == p2 && y1 != y2 + 1 && d1.equals("♟") && (d2.equals("♙") || d2.equals("w") || d2.equals("c"))) {
                p1.set_n(u1, "n", r1, l1);
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                //   _piecesWasEaten2.add(p2);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
            if (x1 < 10 && _MAP[x1 + 1][y1] == p2 && x1 != x2 + 1 && r1.equals("♟") && (r2.equals("♙") || r2.equals("w") || r2.equals("c"))) {
                p1.set_n(u1, d1, "n", l1);
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                //   _piecesWasEaten2.add(p2);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
            if (x1 > 0 && _MAP[x1 - 1][y1] == p2 && x1 != x2 - 1 && l1.equals("♟") && (l2.equals("♙") || l2.equals("w") || l2.equals("c"))) {
                p1.set_n(u1, d1, r1, "n");
                _MAP[p2._position._x][p2._position._y].setTurnWasEaten(numberOfTurn);
                //   _piecesWasEaten2.add(p2);
                _stackForEatenUndo.push(_MAP[p2._position._x][p2._position._y]);
                _wasEaten = true;
                p1.increaseNumberOfKills();
                return true;
            }
        }
        return false;
    }

    /**
     * aim: will do the action of the eating for a pawn.
     * <p>
     * why its necessary: to allow a pawn be eaten.
     * <p>
     * method: will get a position as input and after each move will check with the isPawnEaten function if the pawn that is around the
     * position that is the target of the piece at the current move.
     * <p>
     * important to notice:
     * 1.we want to check that the piece that do the move is not a king because the king cant eat another pawn.
     * 2. we want to check that the position that we are going to check if going to be eaten is not null to avoid null pointer exception.
     * 3. we want to check that we are not going out of the board walls.
     */
    public void eatPawn(Position b) {
        if (!_MAP[b._x][b._y].getType().equals("♔"))
            if ((b._x < 10 && _MAP[b._x + 1][b._y] != null) || (b._x > 0 && _MAP[b._x - 1][b._y] != null) || (b._y > 0 && _MAP[b._x][b._y - 1] != null) || (b._y < 10 && _MAP[b._x][b._y + 1] != null)) {
                if (b._x < 10 && _MAP[b._x + 1][b._y] != null && isPawnEaten(_MAP[b._x][b._y], _MAP[b._x + 1][b._y])) {
                    _MAP[b._x + 1][b._y] = null;
                }
                if (b._x > 0 && _MAP[b._x - 1][b._y] != null && isPawnEaten(_MAP[b._x][b._y], _MAP[b._x - 1][b._y])) {
                    _MAP[b._x - 1][b._y] = null;
                }
                if (b._y > 0 && _MAP[b._x][b._y - 1] != null && isPawnEaten(_MAP[b._x][b._y], _MAP[b._x][b._y - 1])) {
                    _MAP[b._x][b._y - 1] = null;
                }
                if (b._y < 10 && _MAP[b._x][b._y + 1] != null && isPawnEaten(_MAP[b._x][b._y], _MAP[b._x][b._y + 1])) {
                    _MAP[b._x][b._y + 1] = null;
                }
            }
    }


    /**
     * aim:this function checks if a position is empty.
     * <p>
     * why its necessary:we don't want to allow a piece to be able to go to
     * nonempty position.
     * <p>
     * method:will check the _MAP at the given position. if null will return true;
     */
    private boolean isEmpty(Position p) {
        return _MAP[p._x][p._y] == null;
    }

    /**
     * aim:this function checks if a position is in the same X or Y value as another position.
     * <p>
     * why its necessary:we don't want to allow a piece to be able to go to a position that is not
     * in the same x and y values as the current position.
     * <p>
     * method:will check if x and y values of 2 positions are different, if so will return false.;
     */
    private boolean isDiagonal(Position a, Position b) {
        return a._x != b._x && a._y != b._y;
    }

    /**
     * aim:the next 4 functions will check that in the map there no piece in the way from
     * position a to position b.
     * <p>
     * why its necessary:we don't want to allow a piece to be able to go to a position if the
     * "straight line" between position a and b is not empty.
     * <p>
     * method:will run a for loop for the direction that we check and check that the _MAP is empty
     * threw the line.
     */
    private boolean isLeftValid(Position a, Position b) {
        for (int i = a._x - 1; i >= b._x; i--) {
            if (_MAP[i][a._y] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightValid(Position a, Position b) {
        for (int i = a._x + 1; i <= b._x; i++) {
            if (_MAP[i][a._y] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isUpValid(Position a, Position b) {
        for (int i = a._y - 1; i >= b._y; i--) {
            if (_MAP[a._x][i] != null) {
                return false;
            }
        }
        return true;
    }

    private boolean isDownValid(Position a, Position b) {
        for (int i = a._y + 1; i <= b._y; i++) {
            if (_MAP[a._x][i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * aim:will return the direction that the player want to go.
     * <p>
     * why its necessary:we want to check the direction firs and thn check if the
     * "straight line" as mention above is valid
     */
    private int direction(Position a, Position b) {
        int ans = 0;
        //  b is on the right of a:
        if (b._x > a._x) {
            ans = 1;
        }//  b is on the left of a:
        if (b._x < a._x) {
            ans = 2;
        }//  b is upper than a:
        if (b._y < a._y) {
            ans = 3;
        }//  b is downer than a:
        if (b._y > a._y) {
            ans = 4;
        }
        return ans;
    }

    /**
     * aim: this function will check if it's the turn of the player that is moving the piece.
     * <p>
     * why its necessary: we don't want to allow a player to move if it's not his turn.
     * <p>
     * method:will get a position as an input, if the getPieceAtPosition function will return
     * a piece that is not belong to the player that it's his turn,will return false.
     */
    private boolean isValidTurn(Position p) {
        if (getPieceAtPosition(p).getType().equals("♙") || getPieceAtPosition(p).getType().equals("♔")) {
            if (_isPlayer2Turn) {
                return false;
            }
        }
        if (getPieceAtPosition(p).getType().equals("♟") && !_isPlayer2Turn) {
            return false;
        }
        return true;
    }

    /**
     * aim: this function will not allow the pawn to go to the corners of the board.
     * <p>
     * why its necessary: we don't want to allow pawn to do this action.
     * <p>
     * method:will return false(meaning that the move is not allowed) if the position
     * that the player tries to rich is a corner, and it's pawn.
     */
    private boolean pawnNotGoingToCorner(Position a, Position b) {
        int bx = b._x;
        int by = b._y;
        if (bx == 0 && by == 0 || bx == 10 && by == 0 || bx == 0 && by == 10 || bx == 10 && by == 10) {
            if (_MAP[a._x][a._y].getType().equals("♟") || _MAP[a._x][a._y].getType().equals("♙")) {
                return false;
            }
        }
        return true;
    }

    /**
     * aim: to check if the king is eaten.
     * <p>
     * king can be eaten by:
     * a.be surrounded with ♟ from the 4 sides.
     * b.surrounded from 3 sides and a wall.
     * <p>
     * why its necessary: we want to know if the king is eaten to know if the game is finished.
     * <p>
     * method: will check the neighbors of the king each turn.
     */
    private boolean kingIsEaten() {
        String s = Arrays.toString(this._piecesPlayer1.get(0).get_n());
        if (s.equals("[♟, ♟, ♟, ♟]")) {
            return true;
        }
        if (s.equals("[w, ♟, ♟, ♟]")) {
            return true;
        }
        if (s.equals("[♟, w, ♟, ♟]")) {
            return true;
        }
        if (s.equals("[♟, ♟, w, ♟]")) {
            return true;
        }
        if (s.equals("[♟, ♟, ♟, w]")) {
            return true;
        }
        return false;
    }

    /**
     * prints 75 '*' for part 2 questions.
     */
    private void print75() {
        for (int i = 0; i < 75; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * aim: to check if the king is on the one of the corners. if so will return true.
     * </p>
     * why its necessary: if the king is on the one of the corners than the game is
     * finished and player1 has won.
     * </p>
     * method: will just check if the king is on the corners of the bored.
     */
    private boolean kingIsONCorner() {
        int kingX = this._piecesPlayer1.get(0)._position._x;
        int kingY = this._piecesPlayer1.get(0)._position._y;
        if (kingX == 0 && kingY == 0) {
            _whoWon = 1;
            return true;
        }
        if (kingX == 10 && kingY == 0) {
            _whoWon = 1;
            return true;
        }
        if (kingX == 0 && kingY == 10) {
            _whoWon = 1;
            return true;
        }
        if (kingX == 10 && kingY == 10) {
            _whoWon = 1;
            return true;
        }
        return false;
    }

    /**
     * this function is for the first question of the second part.
     * after the game is finished we want to print the positions that the piece was on after sorting as asked.
     * 1.will print the player that won pieces first.
     * 2.will use the "get_steps" method of each piece in the game.
     * 3. will sort the arrays as asked.
     * 4.will print just the pieces that have moved.
     * notice: first we want to return the pieces that was eaten in the game.
     */
    public void p2q1() {
        //   _piecesPlayer1.addAll(_piecesWasEaten1);
        //   _piecesPlayer2.addAll(_piecesWasEaten2);
        _piecesPlayer1.sort(new ComparatorForQ1());
        _piecesPlayer1.sort(new ComparatorForQ12());
        _piecesPlayer2.sort(new ComparatorForQ1());
        _piecesPlayer2.sort(new ComparatorForQ12());
        if (_whoWon == 1) {
            for (int i = 0; i < _piecesPlayer1.size(); i++) {
                if (_piecesPlayer1.get(i).get_Steps().size() > 1) {
                    System.out.println(_piecesPlayer1.get(i).toString() + " " + _piecesPlayer1.get(i).get_Steps());
                }
            }
            for (int i = 0; i < _piecesPlayer2.size(); i++) {
                if (_piecesPlayer2.get(i).get_Steps().size() > 1) {
                    System.out.println(_piecesPlayer2.get(i).toString() + " " + _piecesPlayer2.get(i).get_Steps());
                }
            }
        } else {
            for (int i = 0; i < _piecesPlayer2.size(); i++) {
                if (_piecesPlayer2.get(i).get_Steps().size() > 1) {
                    System.out.println(_piecesPlayer2.get(i).toString() + " " + _piecesPlayer2.get(i).get_Steps());
                }
            }
            for (int i = 0; i < _piecesPlayer1.size(); i++) {
                if (_piecesPlayer1.get(i).get_Steps().size() > 1) {
                    System.out.println(_piecesPlayer1.get(i).toString() + " " + _piecesPlayer1.get(i).get_Steps());
                }
            }
        }
        print75();
    }

    /**
     * this function is for the second question of the second part.
     * after combining the 2 arrays of the pieces of player1 and player2 and the 2 eaten arrays we will
     * sort the combined array with the constructors that was build as asked for the question.
     * Then will print the pieces with respect to the number of kills that they did in the game.
     */
    public void p2q2() {
        ArrayList<ConcretePiece> helper = new ArrayList<>(this._piecesPlayer1);
        helper.addAll(this._piecesPlayer2);
        //   helper.addAll(this._piecesWasEaten1);
        ComparatorForQ2 c1 = new ComparatorForQ2();
        ComparatorForQ22 c2 = new ComparatorForQ22();
        ComparatorForQ23 c3 = new ComparatorForQ23();
        helper.sort(c1);
        helper.sort(c2);
        helper.sort(c3);
        for (int i = 0; i < helper.size(); i++) {
            if (helper.get(i).getNumberOfKills() > 0) {
                System.out.println(helper.get(i).toString() + " " + helper.get(i).getNumberOfKills() + " kills");
            }
        }
        print75();
    }

    /**
     * this function will first combine the 2 arrays of the pieces into one array.
     * will also combine the 2 eaten arrays with them.
     * after combine will use 3 comparators that was build for this question
     * and will sort the pieces by the number of squares that they did in the game.
     */
    public void p2q3() {
        ArrayList<ConcretePiece> helper = new ArrayList<>(this._piecesPlayer1);
        helper.addAll(this._piecesPlayer2);
        //   helper.addAll(this._piecesWasEaten1);
        //   helper.addAll(this._piecesWasEaten2);
        ComparatorForQ31 c1 = new ComparatorForQ31();
        ComparatorForQ32 c2 = new ComparatorForQ32();
        ComparatorForQ33 c3 = new ComparatorForQ33();
        helper.sort(c1);
        helper.sort(c2);
        helper.sort(c3);
        for (int i = 0; i < helper.size(); i++) {
            if (helper.get(i).get_numberOfSquares() > 0) {
                System.out.println(helper.get(i).toString() + " " + helper.get(i).get_numberOfSquares() + " squares");
            }
        }
        print75();
    }

    /**
     * this function will hold an array list with a pair like data structure.
     * the pair will hold the position that we check at a time. the function will run threw a
     * map that is build especially for this function. the map is a map of positions,
     * and after a new piece that visit the position for the first time the number of pieces
     * that was on the position is increased by one. after we run threw all the positions on the map
     * to push the positions that "numberOfP" there is bigger than 1 as asked into the array list.
     * after that we sort the array list with the comparators that was made for the question.
     */
    public void p2q4() {
        ArrayList<Map.Entry<Position, Integer>> helper = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (_mapForQ4[i][j].getNumberOfP() > 1) {
                    Map.Entry<Position, Integer> map = new AbstractMap.SimpleEntry<>(_mapForQ4[i][j], _mapForQ4[i][j].getNumberOfP());
                    helper.add(map);
                }
            }
        }
        ComparatorQ41 c1 = new ComparatorQ41();
        ComparatorQ42 c2 = new ComparatorQ42();
        ComparatorQ43 c3 = new ComparatorQ43();
        helper.sort(c1);
        helper.sort(c2);
        helper.sort(c3);
        for (int i = 0; i < helper.size(); i++) {
            System.out.println(helper.get(i).getKey().toString() + helper.get(i).getValue() + " pieces");
        }
        print75();
    }

    /**
     * aim:an auxiliary function for part 2 question 3, calculates and sets the number of the squares
     * that a piece have done.
     * method: wil use Math.abs for the calculation.
     */
    public void setNumberOfSquaresForP(Position a, Position b) {
        if (a._x == b._x) {
            _MAP[b._x][b._y].set_numberOfSquares(Math.abs(b._y - a._y));
        }
        if (b._y == a._y) {
            _MAP[b._x][b._y].set_numberOfSquares(Math.abs(b._x - a._x));
        }
    }

    /**
     * will use all the function in this class to move the piece.
     * after a move is allowed and finished we will do all the things that
     * we need for part 2 and for the undo function.
     * will check if a piece is eaten and if the game is finished.
     * will switch the turns after a move.
     */
    @Override
    public boolean move(Position a, Position b) {
        //check weather or not b position is valid:
        if (a.equals(b)) {
            return false;
        }
        if (!isEmpty(b)) {
            return false;
        }
        if (isDiagonal(a, b)) {
            return false;
        }
        int direction = direction(a, b);
        if (direction == 1 && !isRightValid(a, b)) {
            return false;
        }
        if (direction == 2 && !isLeftValid(a, b)) {
            return false;
        }
        if (direction == 3 && !isUpValid(a, b)) {
            return false;
        }
        if (direction == 4 && !isDownValid(a, b)) {
            return false;
        }
        if (!isValidTurn(a)) {
            return false;
        }
        if (!pawnNotGoingToCorner(a, b)) {
            return false;
        }
        //will move the pawn from a to b.
        _MAP[b._x][b._y] = _MAP[a._x][a._y];
        ////this line is for p2q1:
        _MAP[b._x][b._y].addStep(b);
        //will implement an auxiliary function for part2 question 4:
        _mapForQ4[b._x][b._y].setNumberOfP(_MAP[b._x][b._y]);
        //will set the position field of the pawn after a move to the new one:
        _MAP[b._x][b._y]._position._x = b._x;
        _MAP[b._x][b._y]._position._y = b._y;
        //will implement an auxiliary function for part2 question 3:
        setNumberOfSquaresForP(a, b);
        //will implement the eatPawn function:
        //eatPawn(a, b); //@@@@@@
        //will create a map and will connect the piece to his origin:
        Map.Entry<Position, ConcretePiece> map = new AbstractMap.SimpleEntry<>(a, _MAP[b._x][b._y]);
        //will push the map to the undo stack:
        _stackForUndo.push(map);
        //delete the piece from the origin position:
        _MAP[a._x][a._y] = null;
        setNeighbors(_MAP[b._x][b._y]);
        eatPawn(b);
        //_MAP[b._x][b._y].addStep(t);
        //if the king is on the corners the game is finished and player1 wins,
        //if the king is eaten than the game is finished and player2 wins:
        if (kingIsONCorner()) {
            _PLAYER1._wins++;
            _isGameFinished = true;
        } else if (kingIsEaten()) {
            _PLAYER2._wins++;
            _isGameFinished = true;
        }
        //changes the turn:
        if (this._isPlayer2Turn) {
            _isPlayer2Turn = false;
        } else {
            _isPlayer2Turn = true;
        }
        //will increase the number of the turn - used in the undo function:
        numberOfTurn++;
        //if the game is finished will implement all the functions for part 2:
        if (_isGameFinished) {
            p2q1(); // part 2 question 1
            p2q2(); // part 2 question 2
            p2q3(); // part 2 question 3
            p2q4(); // part 2 question 4
        }
        return true;
    }

    /**
     * will return a piece in a specific position that is given as input to the function.
     */
    @Override
    public Piece getPieceAtPosition(Position position) {
        return _MAP[position._x][position._y];
    }

    /**
     * return the first player -used in GUI class.
     */
    @Override
    public Player getFirstPlayer() {
        return this._PLAYER1;
    }

    /**
     * return the second player -used in GUI class.
     */
    @Override
    public Player getSecondPlayer() {
        return this._PLAYER2;
    }

    /**
     * returns if the game was finished. if so resets. - used in GUI class.
     */
    @Override
    public boolean isGameFinished() {
        return _isGameFinished;
    }

    /**
     * returns true if its second player turn - used in GUI class.
     */
    @Override
    public boolean isSecondPlayerTurn() {
        return _isPlayer2Turn;
    }

    /**
     * this function will start the game from the beginning, will reset all the fields of the
     * game logic and the pieces to their first determined values.
     */
    @Override
    public void reset() {
        this._isPlayer2Turn = true;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                _MAP[i][j] = null;
            }
        }
        _piecesPlayer1.clear();
        _piecesPlayer2.clear();
        _stackForEatenUndo.clear();
        _stackForUndo.clear();
        Pawn pawn1_player2 = new Pawn(new Position(3, 0), 1, _PLAYER2, "♟");
        _MAP[3][0] = pawn1_player2;
        _piecesPlayer2.add(pawn1_player2);
        Pawn pawn2_player2 = new Pawn(new Position(4, 0), 2, _PLAYER2, "♟");
        _piecesPlayer2.add(pawn2_player2);
        _MAP[4][0] = pawn2_player2;
        Pawn pawn3_player2 = new Pawn(new Position(5, 0), 3, _PLAYER2, "♟");
        _piecesPlayer2.add(pawn3_player2);
        _MAP[5][0] = pawn3_player2;
        Pawn pawn4_player2 = new Pawn(new Position(6, 0), 4, _PLAYER2, "♟");
        _piecesPlayer2.add(pawn4_player2);
        _MAP[6][0] = pawn4_player2;
        Pawn pawn5_player2 = new Pawn(new Position(7, 0), 5, _PLAYER2, "♟");
        _MAP[7][0] = pawn5_player2;
        _piecesPlayer2.add(pawn5_player2);
        Pawn pawn6_player2 = new Pawn(new Position(1, 5), 6, _PLAYER2, "♟");
        _MAP[5][1] = pawn6_player2;
        _piecesPlayer2.add(pawn5_player2);
        Pawn pawn7_player2 = new Pawn(new Position(0, 3), 7, _PLAYER2, "♟");
        _MAP[0][3] = pawn7_player2;
        _piecesPlayer2.add(pawn7_player2);
        Pawn pawn8_player2 = new Pawn(new Position(10, 3), 8, _PLAYER2, "♟");
        _MAP[10][3] = pawn8_player2;
        _piecesPlayer2.add(pawn8_player2);
        Pawn pawn9_player2 = new Pawn(new Position(0, 4), 9, _PLAYER2, "♟");
        _MAP[0][4] = pawn9_player2;
        _piecesPlayer2.add(pawn9_player2);
        Pawn pawn10_player2 = new Pawn(new Position(10, 4), 10, _PLAYER2, "♟");
        _MAP[10][4] = pawn10_player2;
        _piecesPlayer2.add(pawn10_player2);
        Pawn pawn11_player2 = new Pawn(new Position(0, 5), 11, _PLAYER2, "♟");
        _MAP[0][5] = pawn11_player2;
        _piecesPlayer2.add(pawn11_player2);
        Pawn pawn12_player2 = new Pawn(new Position(1, 5), 12, _PLAYER2, "♟");
        _MAP[1][5] = pawn12_player2;
        _piecesPlayer2.add(pawn12_player2);
        Pawn pawn13_player2 = new Pawn(new Position(9, 5), 13, _PLAYER2, "♟");
        _MAP[9][5] = pawn13_player2;
        _piecesPlayer2.add(pawn13_player2);
        Pawn pawn14_player2 = new Pawn(new Position(10, 5), 14, _PLAYER2, "♟");
        _MAP[10][5] = pawn14_player2;
        _piecesPlayer2.add(pawn14_player2);
        Pawn pawn15_player2 = new Pawn(new Position(0, 6), 15, _PLAYER2, "♟");
        _MAP[0][6] = pawn15_player2;
        _piecesPlayer2.add(pawn15_player2);
        Pawn pawn16_player2 = new Pawn(new Position(10, 6), 16, _PLAYER2, "♟");
        _MAP[10][6] = pawn16_player2;
        _piecesPlayer2.add(pawn16_player2);
        Pawn pawn17_player2 = new Pawn(new Position(0, 7), 17, _PLAYER2, "♟");
        _MAP[0][7] = pawn17_player2;
        _piecesPlayer2.add(pawn17_player2);
        Pawn pawn18_player2 = new Pawn(new Position(10, 7), 18, _PLAYER2, "♟");
        _MAP[10][7] = pawn18_player2;
        _piecesPlayer2.add(pawn18_player2);
        Pawn pawn19_player2 = new Pawn(new Position(5, 9), 19, _PLAYER2, "♟");
        _MAP[5][9] = pawn19_player2;
        _piecesPlayer2.add(pawn19_player2);
        Pawn pawn20_player2 = new Pawn(new Position(3, 10), 20, _PLAYER2, "♟");
        _MAP[3][10] = pawn20_player2;
        _piecesPlayer2.add(pawn20_player2);
        Pawn pawn21_player2 = new Pawn(new Position(4, 10), 21, _PLAYER2, "♟");
        _MAP[4][10] = pawn21_player2;
        _piecesPlayer2.add(pawn21_player2);
        Pawn pawn22_player2 = new Pawn(new Position(5, 10), 22, _PLAYER2, "♟");
        _MAP[5][10] = pawn22_player2;
        _piecesPlayer2.add(pawn22_player2);
        Pawn pawn23_player2 = new Pawn(new Position(6, 10), 23, _PLAYER2, "♟");
        _MAP[6][10] = pawn23_player2;
        _piecesPlayer2.add(pawn23_player2);
        Pawn pawn24_player2 = new Pawn(new Position(7, 10), 24, _PLAYER2, "♟");
        _MAP[7][10] = pawn24_player2;
        _piecesPlayer2.add(pawn24_player2);
        King king_player1 = new King(new Position(5, 5), 7, _PLAYER1, "♔");
        _MAP[5][5] = king_player1;
        _piecesPlayer1.add(king_player1);
        Pawn pawn1_player1 = new Pawn(new Position(5, 3), 1, _PLAYER1, "♙");
        _MAP[5][3] = pawn1_player1;
        _piecesPlayer1.add(pawn1_player1);
        Pawn pawn2_player1 = new Pawn(new Position(4, 4), 2, _PLAYER1, "♙");
        _MAP[4][4] = pawn2_player1;
        _piecesPlayer1.add(pawn2_player1);
        Pawn pawn3_player1 = new Pawn(new Position(5, 4), 3, _PLAYER1, "♙");
        _MAP[5][4] = pawn3_player1;
        _piecesPlayer1.add(pawn3_player1);
        Pawn pawn4_player1 = new Pawn(new Position(6, 2), 4, _PLAYER1, "♙");
        _MAP[6][4] = pawn4_player1;
        _piecesPlayer1.add(pawn4_player1);
        Pawn pawn5_player1 = new Pawn(new Position(3, 5), 5, _PLAYER1, "♙");
        _MAP[3][5] = pawn5_player1;
        _piecesPlayer1.add(pawn5_player1);
        Pawn pawn6_player1 = new Pawn(new Position(4, 5), 6, _PLAYER1, "♙");
        _MAP[4][5] = pawn6_player1;
        _piecesPlayer1.add(pawn6_player1);
        Pawn pawn8_player1 = new Pawn(new Position(6, 5), 8, _PLAYER1, "♙");
        _MAP[6][5] = pawn8_player1;
        _piecesPlayer1.add(pawn8_player1);
        Pawn pawn9_player1 = new Pawn(new Position(7, 5), 9, _PLAYER1, "♙");
        _MAP[7][5] = pawn9_player1;
        _piecesPlayer1.add(pawn9_player1);
        Pawn pawn10_player1 = new Pawn(new Position(4, 6), 10, _PLAYER1, "♙");
        _MAP[4][6] = pawn10_player1;
        _piecesPlayer1.add(pawn10_player1);
        Pawn pawn11_player1 = new Pawn(new Position(5, 6), 11, _PLAYER1, "♙");
        _MAP[5][6] = pawn11_player1;
        _piecesPlayer1.add(pawn11_player1);
        Pawn pawn12_player1 = new Pawn(new Position(6, 6), 12, _PLAYER1, "♙");
        _MAP[6][6] = pawn12_player1;
        _piecesPlayer1.add(pawn12_player1);
        Pawn pawn13_player1 = new Pawn(new Position(5, 7), 13, _PLAYER1, "♙");
        _MAP[5][7] = pawn13_player1;
        _piecesPlayer1.add(pawn13_player1);
        for (int i = 0; i < _piecesPlayer1.size(); i++) {
            setNeighbors(_piecesPlayer1.get(i));
        }
        for (int i = 0; i < _piecesPlayer2.size(); i++) {
            setNeighbors(_piecesPlayer2.get(i));
        }
        numberOfTurn = 0;
        for (int i = 0; i < 11; i++) {  //@@@@@@@
            for (int j = 0; j < 11; j++) {
                _mapForQ4[i][j] = new Position(i, j);
            }
        }
        _isGameFinished = false;
    }

    /**
     * will return _who won the game, used in part2 comparators as asked in q2,q3,thus static.
     */
    public static int getWhoWon() {
        return _whoWon;
    }

    /**
     * this function will be responsible for the "back" button in the game.
     * will use the stack for eaten and uneaten pieces stack that was determined as a fields
     * in this class. after press will return the piece that is hold in the map inse the stack
     * as a value to the position that is held as a key in the map.
     * this function will also give a respect to the second part of the assignment.
     */
    @Override
    public void undoLastMove() {
        if (!_stackForUndo.isEmpty()) {
            int x = _stackForUndo.peek().getKey()._x;
            int y = _stackForUndo.peek().getKey()._y;
            ConcretePiece p = _stackForUndo.peek().getValue();
            if (x == p._position._x) { //for p2q3
                p.undo_numberOfSquares(Math.abs(y - p._position._y));
            }
            if (y == p._position._y) {
                p.undo_numberOfSquares(Math.abs(x - p._position._x));
            }
            _MAP[p._position._x][p._position._y] = null;
            if (_mapForQ4[p._position._x][p._position._y].is_wasChangedFor4()) {//for p2q4
                _mapForQ4[p._position._x][p._position._y].removeFromHash(p);
            }
            _MAP[x][y] = p;
            p._position._x = x;
            p._position._y = y;
            p.get_Steps().remove(p.get_Steps().size() - 1); //for p2q1
            if (p.getNumberOfKills() > 0) {
                p.decreaseNumberOfKills(); //for p2q2
            }
            _stackForUndo.pop();
            numberOfTurn--;
            if (_wasEaten && _stackForEatenUndo != null && _stackForEatenUndo.peek().getTurnWasEaten() == numberOfTurn) {
                _MAP[_stackForEatenUndo.peek()._position._x][_stackForEatenUndo.peek()._position._y] = _stackForEatenUndo.peek();
                if (!_piecesWasEaten1.isEmpty() && _stackForEatenUndo.peek().getOwner() == _PLAYER1) {
                    _piecesWasEaten1.remove(_piecesWasEaten1.size() - 1);
                }
                if (!_piecesWasEaten2.isEmpty() && _stackForEatenUndo.peek().getOwner() == _PLAYER2) {
                    _piecesWasEaten2.remove(_piecesWasEaten2.size() - 1);
                }
                _stackForEatenUndo.pop();
                if (_stackForEatenUndo.size() == 0) {
                    _wasEaten = false;
                }
            }
            _isPlayer2Turn = !_isPlayer2Turn;
        }
    }

    /**
     * return the board size, returns 11 as in the jar file.
     */
    @Override
    public int getBoardSize() {
        return 11;
    }
}