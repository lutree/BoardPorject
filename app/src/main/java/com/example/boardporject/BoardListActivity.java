package com.example.boardporject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boardporject.adapter.BoardListAdapter;
import com.example.boardporject.model.BoardDO;
import com.example.boardporject.model.BoardsDO;
import com.example.boardporject.network.BoardRequest;
import com.google.android.material.appbar.MaterialToolbar;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardListActivity extends AppCompatActivity {

    private static final String TAG = "BoardListActivity";

    private MaterialToolbar topAppBar;
    private RecyclerView rcvBoardList;
    private BoardListAdapter boardListAdapter;
    private BoardRequest boardRequest;

    private BoardsDO boards;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_list);

        topAppBar = findViewById(R.id.top_app_bar_board_list);
        rcvBoardList = findViewById(R.id.rcv_board_list);

        boardRequest = new BoardRequest();
        topAppBar.setOnMenuItemClickListener(this::onMenuItemClick);

        boardListAdapter = new BoardListAdapter();
        boardListAdapter.setOnItemClickListener(this::onItemClick);
        rcvBoardList.setLayoutManager(new LinearLayoutManager(this));
        rcvBoardList.setAdapter(boardListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestBoardListData();
    }

    public void requestBoardListData() {
        boardRequest.getBoardList().enqueue(new Callback<BoardsDO>() {
            @Override
            public void onResponse(@NonNull Call<BoardsDO> call, @NonNull Response<BoardsDO> response) {
                Log.e(TAG, "onResponse: ");
                if (response.isSuccessful()) {
                    Log.e(TAG, "onResponse:response.isSuccessful()");
                    boards = response.body();
                    if (boards != null && boards.getBoards().size() > 0) {
                        boardListAdapter.set(boards.getBoards());
                        boardListAdapter.notifyDataSetChanged();
                    } else {
                        Log.e(TAG, "onResponse: 데이터가 정상적으로 수신되지 않음." );
                    }
                } else {
                    Log.e(TAG, "onResponse:response.fail ");
                }
            }

            @Override
            public void onFailure(@NonNull Call<BoardsDO> call, @NonNull Throwable t) {
                Log.e(TAG, "onResponse:response.isFail()");
            }
        });
    }

    private boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemEditIcon:
                Intent intent = new Intent(BoardListActivity.this, BoardWriteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            case R.id.menuItemSearchIcon:
//                        검색 기능 추가 예정
                return true;
            default:
                break;
        }
        return false;
    }

    private void onItemClick(int boardSeq) {
        Intent intent = new Intent(BoardListActivity.this, BoardDetailActivity.class);
        intent.putExtra("board_seq", boardSeq);
        startActivity(intent);
    }
}
