package com.example.boardporject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boardporject.common.CONST;
import com.example.boardporject.model.BoardDO;
import com.example.boardporject.network.BoardRequest;
import com.example.boardporject.util.PreferenceManager;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardDetailActivity extends AppCompatActivity {

    private static final String TAG = "BoardDetailActivity";

    private MaterialToolbar topAppBar;
    private TextView text_board_seq, text_board_writer, text_update_time, text_board_subject, text_board_content;
    private BoardRequest boardRequest;
    private BoardDO board;

    private String login_user_id, login_user_name;
    private int board_seq;
    private boolean isEditing = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_detail);
        topAppBar = findViewById(R.id.top_app_bar_board_detail);
        text_board_seq = findViewById(R.id.text_board_seq);
        text_board_writer = findViewById(R.id.text_board_writer);
        text_update_time = findViewById(R.id.text_update_time);
        text_board_subject = findViewById(R.id.text_board_subject);
        text_board_content = findViewById(R.id.text_board_content);

        setSupportActionBar(topAppBar);
        topAppBar.setNavigationOnClickListener(this::onBackClick);
        topAppBar.setOnMenuItemClickListener(this::onMenuItemClick);

        login_user_id = PreferenceManager.getString(this, CONST.USER_ID);
        login_user_name = PreferenceManager.getString(this, CONST.USER_NAME);
        board_seq = getIntent().getIntExtra("board_seq", -1);

        boardRequest = new BoardRequest();

        reqDeleteBoard();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//    }

    private void reqBoardDetail() {
        boardRequest.getBoardDetail(board_seq).enqueue(new Callback<BoardDO>() {
            @Override
            public void onResponse(Call<BoardDO> call, Response<BoardDO> response) {
                board = response.body();

                if (board != null) {
                    text_board_seq.setText(String.format(Locale.getDefault(), "No.%d", board.getBoard_seq()));
                    text_board_writer.setText(String.format("%s(%s)", board.getBoard_writer(), board.getUpd_user_id()));
                    text_update_time.setText(board.getUpd_date());
                    text_board_subject.setText(board.getBoard_subject());
                    text_board_content.setText(board.getBoard_content());

                    if (login_user_id.equals(board.getIns_user_id())) {
                        isEditing = true;
                        invalidateOptionsMenu();
                    }
                } else {
                    // TODO board data is null
                }
            }

            @Override
            public void onFailure(Call<BoardDO> call, Throwable t) {
            }
        });
    }

    private void onBackClick(View view) {
        finish();
    }

    private void reqDeleteBoard() {
        boardRequest.deleteBoard(board_seq).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                //
            }
        });
    }

    private boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemDeleteText:
                // TODO: 삭제 확인 다이얼로그 생성 할 것
                reqDeleteBoard();
                break;
            case R.id.menuItemModifyText:
                Intent intent = new Intent(BoardDetailActivity.this, BoardWriteActivity.class);
                intent.putExtra(CONST.BOARD_DO, board);
                startActivity(intent);
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar_board_detail, menu);
        MenuItem item1 = menu.findItem(R.id.menuItemDeleteText);
        MenuItem item2 = menu.findItem(R.id.menuItemModifyText);
        item1.setVisible(isEditing);
        item2.setVisible(isEditing);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        reqBoardDetail();

    }
}
