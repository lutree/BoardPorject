package com.example.boardporject.model;

import androidx.annotation.NonNull;

import java.util.List;

public class BoardsDO {

    private List<BoardDO> boards;
    private List<BoardFilesDO> boardFiles;

    public List<BoardDO> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardDO> boards) {
        this.boards = boards;
    }

    public List<BoardFilesDO> getBoardFiles() {
        return boardFiles;
    }

    public void setBoardFiles(List<BoardFilesDO> boardFiles) {
        this.boardFiles = boardFiles;
    }
}
