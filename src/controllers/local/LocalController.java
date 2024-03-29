package controllers.local;

import models.Color;
import models.Coordinate;
import models.Game;
import models.State;

public abstract class LocalController {

    private Game game;

    protected LocalController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected int numPlayers() {
        return game.getNumPlayers();
    }

    protected State getState(){
        return game.getState();
    }

    public void setState(State state){
        assert state != null;
        game.setState(state);
    }

    public Color take() {
        return game.take();
    }

    public void put(Coordinate target) {
        assert target != null;
        game.put(target);
        if (game.existTicTacToe()) {
            game.setState(State.FINAL);
        } else {
            game.change();
        }
    }

    public void remove(Coordinate origin) {
        assert origin != null;
        game.remove(origin);
    }

    public void clear() {
        game.clear();
    }

    public boolean empty(Coordinate coordinate) {
        assert coordinate != null;
        return game.empty(coordinate);
    }

    public boolean full(Coordinate coordinate) {
        assert coordinate != null;
        return game.full(coordinate);
    }

    public boolean existTicTacToe() {
        return game.existTicTacToe();
    }

    public Color getColor(Coordinate coordinate){
        assert coordinate != null;
        return game.getColor(coordinate);
    }

}
