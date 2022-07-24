package com.example.boardporject;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boardporject.common.CONST;
import com.example.boardporject.model.BoardDO;
import com.example.boardporject.network.BoardRequest;
import com.example.boardporject.util.PreferenceManager;
import com.google.android.material.appbar.MaterialToolbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BoardWriteActivity extends AppCompatActivity {

    private static final String TAG = "BoardWriteActivity";

    private MaterialToolbar topAppBar;
    private EditText edit_board_subject, edit_board_content;
    private BoardRequest boardRequest;
    private BoardDO board;

    private String login_user_id, login_user_name;
    private boolean isEditing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);

        topAppBar = findViewById(R.id.top_app_bar_board_write);
        edit_board_subject = findViewById(R.id.edit_board_subject);
        edit_board_content = findViewById(R.id.edit_board_content);

        login_user_id = PreferenceManager.getString(this, CONST.USER_ID);
        login_user_name = PreferenceManager.getString(this, CONST.USER_NAME);

        board = (BoardDO) getIntent().getSerializableExtra(CONST.BOARD_DO);         // 수정일 경우 board 데이터를 getIntent 함
        if (board != null) { // board에 값이 있는 경우 수정
            isEditing = true;
            topAppBar.setTitle(getString(R.string.board_modify));
            edit_board_subject.setText(board.getBoard_subject());
            edit_board_content.setText(board.getBoard_content());
        } else {    // 값이 없으면 글쓰기
            isEditing = false;
            topAppBar.setTitle(getString(R.string.board_write));
            board = new BoardDO();
        }
        boardRequest = new BoardRequest();

        topAppBar.setNavigationOnClickListener(view -> finish());
        topAppBar.setOnMenuItemClickListener(this::onMenuItemClick);
    }

    private boolean onMenuItemClick(MenuItem menuItem) {
        String subject = edit_board_subject.getText().toString();
        String content = edit_board_content.getText().toString();

        board.setBoard_subject(subject);
        board.setBoard_content(content);
        board.setBoard_writer(login_user_name);
        board.setIns_user_id(login_user_id);
        board.setUpd_user_id(login_user_id);

        if (!subject.isEmpty() && !content.isEmpty()) {
            if (isEditing) {     // 수정
                boardRequest.modifyBoard(board.getBoard_seq(), board).enqueue(callback);
            } else {      // 글쓰기
                boardRequest.writeBoard(board).enqueue(callback);
            }
        } else {
            Toast.makeText(BoardWriteActivity.this, "작성해 주세요.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private final Callback<Void> callback = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            if (response.isSuccessful()) {
                Log.e(TAG, "onResponse: response.isSuccessful()");
                finish();
            } else {
                Log.e(TAG, "onResponse: fail");
            }
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            Log.e(TAG, "onFailure: ");
        }
    };
}