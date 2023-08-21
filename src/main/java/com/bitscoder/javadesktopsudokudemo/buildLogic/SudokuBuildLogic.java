package com.bitscoder.javadesktopsudokudemo.buildLogic;

import com.bitscoder.javadesktopsudokudemo.computationalLogic.GameLogic;
import com.bitscoder.javadesktopsudokudemo.persistence.LocalStorageImpl;
import com.bitscoder.javadesktopsudokudemo.problemdomain.IStorage;
import com.bitscoder.javadesktopsudokudemo.problemdomain.SudokuGame;
import com.bitscoder.javadesktopsudokudemo.userInterface.IUserInterfaceContract;
import com.bitscoder.javadesktopsudokudemo.userInterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
