package com.example.boardporject.network;

import com.example.boardporject.model.BoardDO;
import com.example.boardporject.model.BoardsDO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BoardService {
    @GET("board")
    Call<BoardsDO> getBoardList();  // 게시글 목록 조회

    @GET("board/{board_seq}")
    Call<BoardDO> getBoardDetail(@Path("board_seq") Integer board_seq);     // 게시글 상세 조회

    @POST("board")
    Call<Void> writeBoard(@Body BoardDO boardData);     // 게시글 작성

    @PUT("board/{board_seq}")
    Call<Void> modifyBoard(@Path("board_seq") Integer board_seq, @Body BoardDO board_data);     // 게시글 수정

    @DELETE("board/{board_seq}")
    Call<Void> deleteBoard(@Path("board_seq") Integer board_seq);       // 게시글 삭ㄱ제
}
