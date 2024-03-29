package controllers.local;

import models.Game;
import utils.ClosedInterval;

class LocalCollocateControllerBuilder {

    private LocalCollocateController[][] colocateControllerArray;

    private Game game;

    LocalCollocateControllerBuilder(Game game) {
        this.game = game;
        colocateControllerArray = new LocalCollocateController[game.getNumPlayers()][2];
    }

    void build(int users) {
        assert new ClosedInterval(0, game.getNumPlayers()).includes(users);
        LocalCoordinateController[][] coordinateController = new LocalCoordinateController[2][2];
        for (int i = 0; i < game.getNumPlayers(); i++) {
            for (int j = 0; j < 2; j++) {
                if (i < users) {
                    coordinateController[i][j] = new LocalUserCoordinateController(game);
                } else {
                    coordinateController[i][j] = new LocalRandomCoordinateController(game);
                }
            }
        }
        for (int i = 0; i < game.getNumPlayers(); i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    colocateControllerArray[i][j] = new LocalPutController(game, coordinateController[i][j]);
                } else {
                    colocateControllerArray[i][j] = new LocalMoveController(game, coordinateController[i][j]);
                }
            }
        }
    }

    LocalCollocateController getCollocateController() {
        int player = game.take().ordinal();
        if (!game.complete()) {
            return colocateControllerArray[player][0];
        } else {
            return colocateControllerArray[player][1];
        }
    }
}
