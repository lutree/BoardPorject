package com.example.boardporject.network;

import com.example.boardporject.model.BoardDO;
import com.example.boardporject.model.BoardsDO;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class BoardRequest extends BaseRequest implements BoardService {

    private BoardService boardService;

    public BoardRequest() {
        boardService = retrofit.create(BoardService.class);
    }

    @Override
    public Call<BoardsDO> getBoardList() {
        return boardService.getBoardList();
    }

    @Override
    public Call<BoardDO> getBoardDetail(Integer board_seq) {
        return boardService.getBoardDetail(board_seq);
    }

    @Override
    public Call<Void> writeBoard(BoardDO boardData) {
        return boardService.writeBoard(boardData);
    }

    @Override
    public Call<Void> modifyBoard(Integer board_seq, BoardDO board_data) {
        return boardService.modifyBoard(board_seq, board_data);
    }

    @Override
    public Call<Void> deleteBoard(Integer board_seq) {
        return boardService.deleteBoard(board_seq);
    }
}
